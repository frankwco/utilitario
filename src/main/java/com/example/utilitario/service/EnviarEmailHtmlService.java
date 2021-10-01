package com.example.utilitario.service;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class EnviarEmailHtmlService {

	@Autowired
	private JavaMailSender mailSender;

	public String enviar(String destinatario, String assunto, String mensagemCorpo) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mensagem = new MimeMessageHelper(mail);
			mensagem.setFrom("projetoTeste45@gmail.com");//remetente
			mensagem.setSubject(assunto);//assunto
			mensagem.setTo(destinatario);//destinatário
			mensagem.setText(mensagemCorpo,true); // mensagem
			mailSender.send(mail); //enviar
			return "E-mail enviado com sucesso!!"+new Date();
		} catch (Exception e) {
			e.printStackTrace();
			return "Deu ruim!!";
		}

	}
}
