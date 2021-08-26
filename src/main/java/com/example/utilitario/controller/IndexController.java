package com.example.utilitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.utilitario.model.Recibo;
import com.example.utilitario.util.ValidaCPF;
import com.example.utilitario.util.ValorExtenso;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/vue")
	public String chamarVue(Model model) {
		return "exemplo-vue";
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
	public ModelAndView gerarRecibo(Recibo recibo) {
		
		ModelAndView paginaErro = new ModelAndView("erro");
	
	
		if (!ValidaCPF.isCPF(recibo.getCpfEmissor())) {
			paginaErro.addObject("mensagem", "CPF Inválido");
			return paginaErro;
		}
		
		ModelAndView paginaRecibo = new ModelAndView("recibo");
		//String valorExtenso=ValorExtenso.valorPorExtenso(recibo.getValorPagamento());
		//recibo.setValorExtenso(valorExtenso);
		paginaRecibo.addObject("recibo", recibo);

		return paginaRecibo;
	}
}
