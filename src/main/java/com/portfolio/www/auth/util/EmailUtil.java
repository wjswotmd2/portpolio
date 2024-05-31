package com.portfolio.www.auth.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.portfolio.www.auth.dto.EmailDto;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
	
	public String sendMail(EmailDto dto, boolean isHtml) {
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			helper.setTo(dto.getReceiver());
			helper.setFrom(dto.getFrom());
			helper.setSubject(dto.getSubject());
			helper.setText(dto.getText(), isHtml);
			
			mailSender.send(message);			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return "Error";
		}
		return "Sucess";
	}
}
