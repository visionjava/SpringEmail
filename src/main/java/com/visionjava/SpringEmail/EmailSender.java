package com.visionjava.SpringEmail;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component("emailSender")
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;	

	public void sendEmailAttachment(final String to, final String from, final String subject, final String path) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				byte[] encoded = Files.readAllBytes(Paths.get(path));
				String body =  new String(encoded, StandardCharsets.UTF_8);
				
				//Sending Message
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,	true);
				message.setTo(to);
				message.setFrom(from);
				message.setSubject(subject);				
				message.setText(body, true); //true sets the content to be of type html
				File file = new File("c:\\visionjavaemail\\htmlTemplate.html");
				message.addAttachment("attachment.html", file);
			}
		};
		this.mailSender.send(preparator);
	}
	
	public void sendEmailPlainText(final String to, final String from, final String subject, final String path) {

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				byte[] encoded = Files.readAllBytes(Paths.get(path));
				String body =  new String(encoded, StandardCharsets.UTF_8);
				
				//Sending Message
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,	true);
				message.setTo(to);
				message.setFrom(from);
				message.setSubject(subject);				
				message.setText(body, false); //false sets the content to be of type plain text
				File file = new File("c:\\visionjavaemail\\plainTextTemplate.txt");
			}
		};
		this.mailSender.send(preparator);
	}
}
