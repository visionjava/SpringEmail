package com.visionjava.SpringEmail;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCaller {

  public static void main(String[] args) {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	EmailSender emailSender = (EmailSender)context.getBean("emailSender");
	
	emailSender.sendEmailAttachment("test@visionjava.com", "test@visionjava.com", "HTML EMAIL", "c:\\visionjavaemail\\htmlTemplate.html");
	
	emailSender.sendEmailPlainText("test@visionjava.com", "test@visionjava.com", "PLAIN TEXT EMAIL", "c:\\visionjavaemail\\plainTextTemplate.txt");
  }

}
