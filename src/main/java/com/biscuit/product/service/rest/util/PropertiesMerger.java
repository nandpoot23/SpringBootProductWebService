package com.biscuit.product.service.rest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class PropertiesMerger {

	public static void main(String[] args) throws Exception {
		
		Properties defaultProperties = readProperties(args[0]);
		System.out.printf("Read %d properties from default file: %s\n",
				defaultProperties.size(), args[0]);

		Properties overridingProperties = readProperties(args[1]);
		System.out.printf("Read %d properties from overriding file: %s\n",
				overridingProperties.size(), args[1]);

		Properties actualOverridingProperties = calculateDiff(
				defaultProperties, overridingProperties);
		System.out.printf("Located %d overriding properties\n",
				overridingProperties.size());

		actualOverridingProperties.store(new FileOutputStream(args[1]),
				new File(args[0]).getName());
		System.out.printf("Saved difference to %s\n", args[1]);
	}

	private static Properties readProperties(String fileName)
			throws IOException {
		FileInputStream defaultPropertiesStream = new FileInputStream(fileName);
		Properties properties = new Properties();
		properties.load(defaultPropertiesStream);
		return properties;
	}

	private static Properties calculateDiff(Properties original,
			Properties overriding) {
		Set<Map.Entry<Object, Object>> originalSet = original.entrySet();
		Set<Map.Entry<Object, Object>> overridingSet = overriding.entrySet();

		overridingSet.removeAll(originalSet);

		Properties result = new Properties();
		overridingSet.forEach(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}
}
