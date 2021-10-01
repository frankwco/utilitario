package com.example.utilitario.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class EnviarEmailService {

	@Autowired
	private JavaMailSender mailSender;

	public String enviar(String destinatario, String assunto, String mensagemCorpo) {
		try {
			SimpleMailMessage mensagem = new SimpleMailMessage();
			mensagem.setFrom("projetoTeste45@gmail.com");//remetente
			mensagem.setSubject(assunto);//assunto
			mensagem.setTo(destinatario);//destinatário
			mensagem.setText(mensagemCorpo); // mensagem
			mailSender.send(mensagem); //enviar
			return "E-mail enviado com sucesso!!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Deu ruim!!";
		}

	}
}
