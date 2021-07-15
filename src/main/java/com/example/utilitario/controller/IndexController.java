package com.example.utilitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.utilitario.util.ValidaCPF;
import com.example.utilitario.util.ValorExtenso;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/validarCpf")
	public String validarCpf(@RequestParam(name = "cpf") String cpf, Model model) {
		Boolean cpfValido = false;
		if (ValidaCPF.isCPF(cpf)) {
			cpfValido = true;
		}
		model.addAttribute("cpfValido", cpfValido);
		return "index";
	}

	@PostMapping("/gerarRecibo")
	public ModelAndView gerarRecibo(@RequestParam(name = "cpfEmissor") String cpfEmissor,
			@RequestParam(name = "nomeEmissor") String nomeEmissor,
			@RequestParam(name = "valorPagamento", defaultValue = "0") Double valorPagamento) {
		
		ModelAndView paginaErro = new ModelAndView("erro");
	
		if (!ValidaCPF.isCPF(cpfEmissor)) {
			paginaErro.addObject("mensagem", "CPF Inválido");
			return paginaErro;
		}
		
		ModelAndView paginaRecibo = new ModelAndView("recibo");
		paginaRecibo.addObject("cpfEmissor", cpfEmissor);
		paginaRecibo.addObject("nomeEmissor", nomeEmissor);
		paginaRecibo.addObject("valorPagamento", valorPagamento);	
		String valor=ValorExtenso.valorPorExtenso(valorPagamento);
		paginaRecibo.addObject("valorPagamentoPorExtenso", valor);

		return paginaRecibo;
	}
}
