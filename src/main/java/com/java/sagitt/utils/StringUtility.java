package com.java.sagitt.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.RandomStringUtils;

import com.java.sagitt.helper.ConstantManager;



public class StringUtility {
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9\\._-]{1,64}@[A-Za-z0-9]{2,64}(\\.[A-Za-z0-9]{2,64})*(\\.[A-Za-z]{2,4})$";
	
	/**
	 * 
	 * @param emailAdress
	 * @return
	 */
	public static boolean validateEmail(String emailAdress) {
		if (StringUtility.isNullOrEmpty(emailAdress))
			return false;
		return emailAdress.trim().matches(EMAIL_REGEX);
	}
	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(final String s) {
		return (s == null || s.trim().length() == 0);
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * 
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmptyNotTrim(final String s) {
		return (s == null || s.length() == 0);
	}
	
	/**
	 * From null to emtpy string.
	 * 
	 * @param a
	 *            the a
	 * 
	 * @return the string
	 */
	public static String fromNullToEmtpyString(String a) {
		if (a == null) {
			return "";
		} else {
			return a;
		}
	}
		

}
