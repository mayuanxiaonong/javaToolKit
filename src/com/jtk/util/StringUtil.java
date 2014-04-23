package com.jtk.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	/**
	 * Returns if s is null.
	 * 
	 * @param s
	 * @return <code>true</code> if s is null or empty, otherwise
	 *         <code>false</code>.
	 * @see StringUtil#isNull(String, boolean)
	 */
	public static boolean isNull(String s) {
		return s == null || s.isEmpty();
	}

	/**
	 * Returns if s is null.
	 * 
	 * @param s
	 * @param trim
	 *            if trim s or not
	 * @return <code>true</code> if s is null or empty or s.trim() is empty when
	 *         trim is true, otherwise <code>false</code>.
	 * @see StringUtil#isNull(String)
	 */
	public static boolean isNull(String s, boolean trim) {
		return isNull(s) || (trim && s.trim().isEmpty());
	}

	/**
	 * <p>
	 * Convert <code>List</code> to seperated <code>String</code> by specified
	 * seperator.
	 * 
	 * @param list
	 *            the <code>List</code> to convert
	 * @param seperator
	 *            the specified seperator
	 * @return the <code>String</code> seperated by specified seperator
	 */
	public static String list2String(List<?> list, String seperator) {
		StringBuilder sb = new StringBuilder("");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (i != 0) {
					sb.append(seperator);
				}
				sb.append(list.get(i));
			}
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * Convert seperated <code>String</code> by specified seperator to
	 * <code>List</code>.
	 * 
	 * @param string
	 *            the <code>String</code> to convert
	 * @param seperator
	 *            the specified seperator
	 * @return the <code>List</code>
	 */
	public static List<String> string2List(String string, String seperator) {
		List<String> list = new ArrayList<String>();
		if (string != null) {
			String[] strings = string.split(seperator);
			for (String s : strings) {
				list.add(s);
			}
		}
		return list;
	}

	/**
	 * <p>
	 * Prints all stack trace messages to a String.
	 * 
	 * @param t
	 *            any exception
	 * @return all stack trace messages
	 */
	public static String printStackTraceToString(Throwable t) {
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw, true));
		return sw.getBuffer().toString();
	}

}
