package com.example.utilitario.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.utilitario.service.EnviarEmailHtmlService;
import com.example.utilitario.service.EnviarEmailService;
import com.example.utilitario.service.EnviarEmailTemplateService;

@RestController
public class EnvioEmailController {

	@Autowired
	private EnviarEmailService enviarEmail;
	
	@Autowired
	private EnviarEmailHtmlService enviarHtmlEmail;
	
	@Autowired
	private EnviarEmailTemplateService enviarEmailTemplateService;

	@GetMapping("/enviar-email")
	public String enviar() {		
		return enviarEmail.enviar("frankwco@gmail.com", 
				"Recuperação de Senha", 
				"Sua senha é a seguinte: 123");
	}
	
	@GetMapping("/enviar-html")
	public String enviarHtml() {
		StringBuilder builder = new StringBuilder();
		builder.append("Olá, <b>Frank</b><br/><br/>");
		builder.append("Seu código de recuperação de senha é: <b>1234</b><br/>");
		builder.append("Muito obrigado!!");
		return enviarHtmlEmail.enviar("frankwco@gmail.com", 
				"Recuperação de Senha", 
				builder.toString());
	}
	
	@GetMapping("/enviar-email-template")
	public String enviarEmailHtml() {
		//Foi incluída uma classe de configuração com algumas informações referente ao processamento do template
		//no pacote .configs
		
		//Pode utilizar esta metodologia, com thymeleaf, em qualquer projeto spring, basta adicionar a
		//dependência do thymeleaf.
		
		//Propriedades que serão passadas para o arquivo html
		Map<String, Object> prop = new HashMap<String, Object>();
		prop.put("nome", "Frank");
		prop.put("codigo", "11250");
		
		//Parâmetros: Destinatário, Assunto, Nome do arquivo HTML e Propriedades.
		return enviarEmailTemplateService.enviar("frankwco@gmail.com", 
				"Recuperação de Senha", "emailRecuperacaoSenha", prop);
	}
	

}
