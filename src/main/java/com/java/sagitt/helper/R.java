/**
 * 
 */
package com.java.sagitt.helper;

import java.util.Locale;
import java.util.ResourceBundle;

import com.java.sagitt.utils.BusinessUtility;

/**
 * @author TIEN
 *
 */
public class R extends ResourceBundle.Control {
	
	//public static final int FILE_VERSION_NUMBER = AppSetting.getIntegerValue("svn-revision-number");

	public R() {
		
	}

	/**
	 * Gets the resource bundle.
	 * 
	 * @param language
	 *            the language
	 * @return the resource bundle
	 */
	public static ResourceBundle getResourceBundle(String language) {
		return ResourceBundle.getBundle(null, new Locale(language), new UTF8Control());
	}
	
	/*public static String getStaticServerPath(String name){
		return AppSetting.getStringValue("static-server-path") + name + "?v=" + FILE_VERSION_NUMBER;
	}*/

	public static String getResource(String key,Object... params) {
		String language = BusinessUtility.getLocale();
		ResourceBundle rs = getResourceBundle(language);
		String text = rs.getString(key);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				if (params[i] != null) {
					text = text.replace("{" + i + "}", params[i].toString());
				}
			}
		}

		return text;
	}
	
	public static String SystemError(){
		return R.getResource("msg.common.system.error");
	}
	
	public static void main(String[] args) {
		System.out.println(R.getResource("title.full.name"));
	}
	
}
