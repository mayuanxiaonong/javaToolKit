package com.jtk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

/**
 * <p>
 * PropertiesUtil
 * <p>
 * Designed for common methods to load & store properties via a properties file.
 * <p>
 * This class does not provide a public constructor, you can get a
 * PropertiesUtil object as follow: <blockquote><code>
 * PropertiesUtil pUtil = PropertiesUtil.getInstance(propertiesName);
 * </code></blockquote>
 * 
 * @author Jason
 * @version 1.0
 */
public class PropertiesUtil {

	private String filename = "";
	private Properties p = new Properties();

	private PropertiesUtil(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			throw new FileNotFoundException("Properties file not found! "
					+ file.getAbsolutePath());
		}
		FileInputStream fis = new FileInputStream(file);
		p.load(fis);

		this.filename = filename;
	}

	/**
	 * Get an instance of PropertiesUtil by the properties file name.
	 * <p>
	 * Make sure the property file with the name <code>filename</code> exists.
	 * 
	 * @param filename
	 *            the name of a properties file and must not be null
	 * @return an instance of PropertiesUtil
	 * @throws IOException
	 *             when the property file does not exist or cannot be loaded
	 */
	public static PropertiesUtil getInstance(String filename)
			throws IOException {
		assert !StringUtil.isNull(filename, true) : "filename must not be null !";
		return new PropertiesUtil(filename);
	}

	/**
	 * Get the keys & values hashtable of the properties
	 * 
	 * @return the hashtable of properties
	 * @see PropertiesUtil#getValue(String)
	 * @see PropertiesUtil#getValue(String, String)
	 */
	public Hashtable<String, String> getValues() {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		for (Enumeration<?> e = p.keys(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			String value = getValue(key);
			hashtable.put(key, value);
		}
		return hashtable;
	}

	/**
	 * Get property value by key
	 * 
	 * @param key
	 *            the key of a property in hashtable
	 * @return the value of a property mapped by specified key
	 * @see PropertiesUtil#getValue(String, String)
	 * @see PropertiesUtil#getValues()
	 */
	public String getValue(String key) {
		return p.getProperty(key);
	}

	/**
	 * Get property value by key. If the value is null, return the specified
	 * default value.
	 * 
	 * @param key
	 *            the key of a property in hashtable
	 * @param defaultValue
	 *            the default value if the key not found in the hashtable
	 * @return the value of a property mapped by specified key or the default
	 *         value
	 * @see PropertiesUtil#getValue(String)
	 * @see PropertiesUtil#getValues()
	 */
	public String getValue(String key, String defaultValue) {
		return p.getProperty(key, defaultValue);
	}

	/**
	 * Set key & value of a property in hashtable
	 * 
	 * @param key
	 *            the key of a property in hashtable
	 * @param value
	 *            the value of a property mapped by specified key
	 */
	public void setValue(String key, String value) {
		p.setProperty(key, value);
	}

	/**
	 * Write the property hashtable with couples of key-value into the
	 * properties file
	 * 
	 * @throws IOException
	 *             when the property file does not exist or cannot be writen
	 */
	public void save() throws IOException {
		FileOutputStream fos = new FileOutputStream(filename);
		p.store(fos, null);
	}

	/*
	 * @test
	 */
	public static void main(String[] args) throws IOException {
		PropertiesUtil p = PropertiesUtil.getInstance(null);
		System.out.println(p.getValue("a"));
	}

}
