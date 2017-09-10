package com.biscuit.product.service.soap.exception;

import static com.biscuit.product.service.soap.exception.ProductSoapFaultHelper.addServiceFaultMessage;
import static com.google.common.base.Joiner.on;
import static com.google.common.collect.ImmutableBiMap.of;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.server.endpoint.AbstractSoapFaultDefinitionExceptionResolver;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;

import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.error.ProductMessage;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductExceptionSoapFaultResolver extends
		AbstractSoapFaultDefinitionExceptionResolver {

	private ResourceBundleMessageSource messageSource;

	public ProductExceptionSoapFaultResolver(
			ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * This method is used for fetching fault definition.
	 * 
	 * @param endpoint
	 *            Object type
	 * @param ex
	 *            Exception type
	 * @return soapFaultDefinition SoapFaultDefinition type
	 */

	@Override
	public SoapFaultDefinition getFaultDefinition(Object endpoint, Exception ex) {

		Map<String, String> requestHeaders = new HashMap<>();
		SoapFaultDefinition soapFaultDefinition = new SoapFaultDefinition();
		soapFaultDefinition.setFaultCode(FaultCode.CLIENT.value());

		soapFaultDefinition
				.setFaultStringOrReason("An error occurred. Please check the detail section. [ASPECTS: ("
						+ on(",").withKeyValueSeparator("=").join(
								requestHeaders) + ")]");
		return soapFaultDefinition;
	}

	@Override
	public void customizeFault(Object endpoint, Exception ex, SoapFault fault) {

		if (ex instanceof ProductFrameworkError) {
			ProductFrameworkError error = (ProductFrameworkError) ex;
			String message = null;
			if (error.getErrorMessage() != null) {
				ProductMessage m = error.getErrorMessage();
				if (m.getText() != null) {
					message = m.getText();
				} else {
					message = messageSource.getMessage(error.getErrorMessage()
							.getCode(), m.getArgs(), Locale.getDefault());
				}
			}
			addServiceFaultMessage(fault,
					of(error.getErrorMessage().getCode(), message));
		} else if (ex instanceof RuntimeException) {
			if (ex.getCause() != null
					&& ex.getCause().getCause() instanceof ProductFrameworkError) {
				ProductFrameworkError error = (ProductFrameworkError) (ex
						.getCause().getCause());
				String message = null;
				if (error.getErrorMessage() != null) {
					ProductMessage m = error.getErrorMessage();
					if (m.getText() != null) {
						message = m.getText();
					} else {
						message = messageSource.getMessage(error
								.getErrorMessage().getCode(), m.getArgs(),
								Locale.getDefault());
					}
					addServiceFaultMessage(fault,
							of(error.getErrorMessage().getCode(), message));
				}
			}
		}

	}

	@Override
	public boolean equals(Object o) {
		return EqualsBuilder.reflectionEquals(this, o);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
