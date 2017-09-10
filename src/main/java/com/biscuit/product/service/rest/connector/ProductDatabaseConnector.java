package com.biscuit.product.service.rest.connector;

import org.springframework.jdbc.core.JdbcOperations;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductDatabaseConnector {

	private JdbcOperations jdbcTemplate;

	public JdbcOperations getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
