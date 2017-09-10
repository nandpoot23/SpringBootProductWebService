package com.biscuit.product.service.rest.app;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.soap.exception.ProductExceptionSoapFaultResolver;
import com.biscuit.product.service.soap.exception.ProductSoapExceptionResolverMapper;
import com.biscuit.product.service.soap.mapping.PathAndPayloadRootAnnotationEndpointMapping;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@SuppressWarnings("deprecation")
@EnableWs
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = { "com.biscuit",
		"com.biscuit.soap.product.v1001.service" })
@EnableAutoConfiguration
@EnableSwagger2
@EnableAspectJAutoProxy
public class SpringBootProductWebServiceApplication extends WsConfigurerAdapter {

	@Autowired
	@Qualifier("MessageSource")
	private ResourceBundleMessageSource messageSource;

	// @Autowired SoapSecurityInterceptor soapSecurityInterceptor;

	// @Autowired SoapHeaderInterceptor soapHeaderInterceptor;

	// @Autowired SoapLoggingInterceptor soapLoggingInterceptor;

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(SpringBootProductWebServiceApplication.class,
				args);
		System.out.println("End");
	}

	@Bean
	public ExecutorService executorService() {
		return Executors.newFixedThreadPool(2);
	}

	/**
	 * This is the base URL which will be exposed for soap proxies.
	 *
	 * @param applicationContext
	 * @return
	 */

	/**
	 * this bean allow to bind the soap dispatcher servlet
	 * 
	 * @param context
	 *            A ApplicationContext
	 * @return DmService as ServletRegistrationBean
	 */

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ProductService/*");
	}

	/**
	 * This publishes the latest WSDL. The bean name is part of the path for the
	 * WSDL/endpoint.
	 * <p>
	 * The WSDL is set, and the WSDL file name becomes the final part of the
	 * URL.
	 * <p>
	 * Ex:
	 * <p>
	 * http://localhost:1234/(servlet registration bean path)/(THIS bean
	 * name).wsdl <BR>
	 * > Becomes > <BR>
	 * http://localhost:1234/Customer/CustomerService.wsdl
	 *
	 * @return
	 */

	/**
	 * This bean is use to bind the definition of 1000 wsdl version
	 * 
	 * @return def as SimpleWsdl11Definition
	 */

	@Bean(name = "10.01")
	public SimpleWsdl11Definition definition1001() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(
				"/wsdls/ProductService_10.01.wsdl"));
		return wsdl11Definition;
	}

	@Bean(name = "11.02")
	public SimpleWsdl11Definition definition1102() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(
				"/wsdls/ProductService_11.02.wsdl"));
		return wsdl11Definition;
	}

	@Bean(name = "12.03")
	public SimpleWsdl11Definition definition1203() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(
				"/wsdls/ProductService_12.03.wsdl"));
		return wsdl11Definition;
	}

	@Bean(name = "13.04")
	public SimpleWsdl11Definition definition1304() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(
				"/wsdls/ProductService_13.04.wsdl"));
		return wsdl11Definition;
	}

	@Bean(name = "14.05")
	public SimpleWsdl11Definition definition1405() {
		SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
		wsdl11Definition.setWsdl(new ClassPathResource(
				"/wsdls/ProductService_14.05.wsdl"));
		return wsdl11Definition;
	}

	@Bean
	public PathAndPayloadRootAnnotationEndpointMapping pathAndPayloadRootAnnotationEndpointMapping() {
		List<EndpointInterceptor> interceptors = new ArrayList<>();
		this.addInterceptors(interceptors);
		return PathAndPayloadRootAnnotationEndpointMapping
				.mapping(interceptors);
	}

	/**
	 * This bean use to resolve the product framework exception.
	 * 
	 * @return soapExceptionResolverMapper as SoapExceptionResolverMapper
	 */

	@Bean
	public ProductSoapExceptionResolverMapper frameworkExceptionResolver() {
		ProductSoapExceptionResolverMapper productSoapExceptionResolverMapper = new ProductSoapExceptionResolverMapper();
		productSoapExceptionResolverMapper.setOrder(Integer.MIN_VALUE);
		productSoapExceptionResolverMapper.registerResolver(
				ProductFrameworkError.class,
				new ProductExceptionSoapFaultResolver(messageSource));
		productSoapExceptionResolverMapper.registerResolver(
				RuntimeException.class, new ProductExceptionSoapFaultResolver(
						messageSource));
		return productSoapExceptionResolverMapper;
	}

	@SuppressWarnings("unused")
	private static void disableCertificateValidation() {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
			}
		} };

		// Ignore differences between given hostname and certificate hostname
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting trust manager
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
		} catch (Exception e) {
		}
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		// interceptors.add(soapSecurityInterceptor);
		// interceptors.add(soapHeaderInterceptor);
		// interceptors.add(soapLoggingInterceptor);

	}

	@Bean(name = "defaultValidator")
	public Validator defaultValidator() {
		return new LocalValidatorFactoryBean();
	}

}
