package com.biscuit.product.service.rest.util;

import org.apache.axis.encoding.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class DataEncryptor {

	private static final Log LOG = LogFactory.getLog(DataEncryptor.class);

	@Autowired
	private ProductHelper productHelper;

	public ProductHelper getProductHelper() {
		return productHelper;
	}

	public void setProductHelper(ProductHelper productHelper) {
		this.productHelper = productHelper;
	}

	public String encode(String data) {
		byte[] dataBytes = data.getBytes();
		String output = Base64.encode(dataBytes);
		LOG.trace("ENCODING: " + data + " > " + output);
		return output;
	}

	public String decode(String data) {
		byte[] dataBytes = Base64.decode(data);
		String output = new String(dataBytes);
		LOG.trace("DECODING: " + data + " > " + output);
		return output;
	}

	/**
	 * @param value
	 *            The value to obfuscate
	 * @param obfuscateFlag
	 *            <code>true</code> will obfuscate, <code>false</code>
	 *            unobfuscate.
	 * @return
	 */
	public String obfuscate(String value, boolean obfuscateFlag, boolean numeric) {
		String newId = null;
		if (value != null) {
			if (obfuscateFlag) {
				newId = encode(value);
			} else {
				if (numeric) {
					if (!productHelper.isLong(value)) {
						newId = decode(value);
					}
				}
			}
		}
		return newId;
	}

}
