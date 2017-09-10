package com.biscuit.product.service.rest.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.biscuit.product.service.rest.connector.BiscuitDatabaseConnector;
import com.biscuit.product.service.rest.connector.ProductDatabaseConnector;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Configuration
@EnableTransactionManagement
public class PropertiesConfiguration {

	private static final Logger LOG = LoggerFactory
			.getLogger(PropertiesConfiguration.class);

	@Autowired
	private Environment env;

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean(name = "MessageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource obj = new ResourceBundleMessageSource();
		obj.setBasenames("bundles/Messages");
		return obj;
	}

	@Bean(name = "executor")
	public ExecutorService executor() {
		return new ThreadPoolExecutor(Integer.parseInt(env.getProperty(
				"Thread.corePoolsize", "50")), Integer.parseInt(env
				.getProperty("Thread.MaxPoolsize", "200")), Long.parseLong(env
				.getProperty("Thread.timetolive", "300")), TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
	}

	@Bean(name = { "productDataSource" })
	@ConfigurationProperties(prefix = "datasource.product")
	public DataSource productDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "productJdbcTemplate")
	public JdbcOperations productJdbcTemplate(
			@Qualifier("productDataSource") DataSource ds) {
		LOG.info("\n\n\n\n jdbcTeamplateProduct BEAN " + ds + " \n\n\n");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		jdbcTemplate.setFetchSize(propInt("Default.fetchSize", 200));
		return jdbcTemplate;
	}

	@Bean(name = "productDao")
	@Autowired
	public ProductDatabaseConnector productDao(
			@Qualifier("productJdbcTemplate") JdbcOperations jop) {
		ProductDatabaseConnector obj = new ProductDatabaseConnector();
		obj.setJdbcTemplate(jop);
		try {
			obj.getJdbcTemplate().execute("select 1 from dual");
			LOG.info("ProductDatabaseConnector Database sucessfully connected. ");
		} catch (Exception e) {
			LOG.error(" Error while connecting to ProductDatabaseConnector.", e);
		}
		return obj;
	}

	/*
	 * Here we are creating two different database connector by using same
	 * database.
	 */

	@Bean(name = "biscuitDao")
	@Autowired
	public BiscuitDatabaseConnector biscuitDao(
			@Qualifier("productJdbcTemplate") JdbcOperations jop) {
		BiscuitDatabaseConnector obj = new BiscuitDatabaseConnector();
		obj.setJdbcTemplate(jop);
		try {
			obj.getJdbcTemplate().execute("select 1 from dual");
			LOG.info("BiscuitDatabaseConnector Database sucessfully connected. ");
		} catch (Exception e) {
			LOG.error(" Error while connecting to BiscuitDatabaseConnector.", e);
		}
		return obj;
	}

	protected Integer propInt(String property, int defaultVal) {
		return toInteger(env.getProperty(property), defaultVal);
	}

	protected Integer toInteger(String val, int defaultVal) {
		if (this.isNull(val)) {
			return defaultVal;
		} else
			return toInteger(val);
	}

	protected Integer toInteger(String val) {
		return Integer.valueOf(val);
	}

	/**
	 * Checks whether a string is <code>null</code>, empty, or contains a single
	 * space.
	 * 
	 * @param str
	 *            The string to check.
	 * @return <code>true</code> if the string is <code>null</code>, empty, or
	 *         contains whitespace. Otherwise, <code>false</code>.
	 */
	private boolean isNull(String str) {
		return !isNotNull(str);
	}

	/**
	 * Checks whether a string is <code>null</code>, empty, or contains a single
	 * space.
	 * 
	 * @param str
	 *            The string to check.
	 * @return <code>true</code> if the string is <i>not</i> <code>null</code>,
	 *         empty, or contains a single space. Otherwise, <code>false</code>.
	 */
	private boolean isNotNull(String str) {
		return StringUtils.isNotBlank(str);
	}

}
