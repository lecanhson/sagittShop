/**
 * 
 */
package com.java.sagitt.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import com.java.sagitt.helper.ConstantManager;
import com.java.sagitt.model.UserSA;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



import freemarker.template.TemplateException;

/**
 * @author TIEN
 *
 */
public class BusinessUtility {
	
	public static HttpSession getSession(){
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(true);  
	}	
	
	public static String getLocale(){
		String sessionLocale = (String) getSession(ConstantManager.LOCALE_SESSION_KEY);
		if (!StringUtility.isNullOrEmpty(sessionLocale)) {
			return sessionLocale.toLowerCase();
		}
		return ConstantManager.DEFAULT_LOCALE_VALUE;
	}
	
	public static String getSessionToken(){
		if(getSession().getAttribute(ConstantManager.SESSION_TOKEN)!= null){
			return getSession().getAttribute(ConstantManager.SESSION_TOKEN).toString();
		}	
		return null;	
	}
	
	public static Object getSession(String key){
		return getSession().getAttribute(key);
	}
	
	public static void putSession(String key,Object value){
		getSession().setAttribute(key, value);
	}
	
	public static UserSA getSessionUser(){
		return (UserSA) getSession(ConstantManager.USER_SESSION_KEY);
	}
	
	public static void putSessionUser(UserSA userSA){
		putSession(ConstantManager.USER_SESSION_KEY,userSA);
	}
	
	/**
	 * Send mail active user
	 * @param user
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws TemplateException 
	 */
/*	public static void sendMailActiveUser(String dirPath,User user) throws MessagingException, TemplateException, IOException{
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());	
		dataModel.put("param", emailParam);
		
		String activeUrl = emailParam.getApp().getUrl() + "/account/pid/u/active/" + user.getHashCode() + "/" + user.getPlainPassword() + ConstantManager.URL_PATTERN;
		String subject = R.getResource("mail.active.account.subject", emailParam.getApp().getAppName());
		
		dataModel.put("activeUrl", activeUrl);
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.ACTIVE_USER.getValue(), dataModel);
		
		if(AppSetting.isActiveSendMail()){
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail().trim()), subject, body, null);
		}
	}*/
		
	/**
	 * Send Mail forgot Password
	 * @param user
	 * @param newPwd
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws TemplateException 
	 */
/*	public static void sendMailForgotPwd(String dirPath,User user,String newPwd) throws MessagingException, TemplateException, IOException{
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());
		dataModel.put("param", emailParam);
		
		dataModel.put("userName", user.getUserName());
		dataModel.put("newPwd", newPwd);
		
		String subject = R.getResource("mail.forgot.pwd.subject", emailParam.getApp().getAppName());
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.FORGOT_PASSWORD.getValue(), dataModel);
		
		if( AppSetting.isActiveSendMail() ) {
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail().trim()), subject, body, null);
		}		
	}*/
	
		
	/**
	 * 
	 * @param user
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	/*public static void sendMailCreatePartner(String dirPath,User user) throws MessagingException, TemplateException, IOException{
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());
		dataModel.put("param", emailParam);
		
		String subject = R.getResource("mail.allow.partner.subject",emailParam.getApp().getAppName());
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.REGISTER_PARTNER.getValue(), dataModel);
			
		if(AppSetting.isActiveSendMail()){
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail()), subject, body, null);
		}
	}*/
	
	/**
	 * Send mail approved partner
	 * @param user
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws TemplateException 
	 */
/*	public static void sendMailApprovePartnet(String dirPath,User user) throws MessagingException, TemplateException, IOException{
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());
		dataModel.put("param", emailParam);
		
		dataModel.put("partner", user);
		dataModel.put("defaultPassword", ConstantManager.SYS_PWD_PARTNER_DEFAULT);
		String subject = R.getResource("mail.active.partner.subject",emailParam.getApp().getAppName());
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.APPROVED_PARTNER.getValue(), dataModel);
		
		if(AppSetting.isActiveSendMail()){
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail()), subject, body, null);
		}
	}*/
	
	/**
	 * Send mail request payment
	 * @param user
	 * @throws MessagingException
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	/*
	public static void sendMailRequestPayment(String dirPath,User user) throws MessagingException, TemplateException, IOException{		
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());
		dataModel.put("param", emailParam);
		
		String subject = R.getResource("mail.send.request.payment.subject",emailParam.getApp().getAppName());		
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.REQUEST_PAYMENT.getValue(), dataModel);
		
		if(AppSetting.isActiveSendMail()){
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail()), subject, body, null);
		}
	}*/
	
	/**
	 * 
	 * @param user
	 * @throws MessagingException
	 * @throws TemplateException
	 * @throws IOException
	 */
	/*public static void sendMailCheckOutCartSuccess(String dirPath,UserVO user,String orderNumber,Integer totalQuantity,BigDecimal totalAmount,List<CartTokenVO> cartMail,BigDecimal totalRemain) throws MessagingException, TemplateException, IOException{
		
		Map<String, Object> dataModel = new HashMap<String, Object>();
		MailParamVO emailParam = new MailParamVO(user.getFullName());
		dataModel.put("param", emailParam);
		
		dataModel.put("totalTime", DateUtility.getHour(totalQuantity) + "h " +  DateUtility.getMinue(totalQuantity) + "'" );
		dataModel.put("totalAmount", StringUtility.bigDecimailFormat(totalAmount));
		dataModel.put("totalRemain", StringUtility.bigDecimailFormat(totalRemain));		
		dataModel.put("carts", cartMail);
		
		String subject = R.getResource("mail.send.checkout.cart.success.subject",emailParam.getApp().getAppName());
		String body = FreemarkerUtility.toString(dirPath,MailTemplateType.CHECK_OUT_CART.getValue(), dataModel);
		
		if(AppSetting.isActiveSendMail()){
			MailUtility mail = new MailUtility();
			mail.sendMail(Arrays.asList(user.getEmail()), subject, body, null);
		}
	}*/
}
