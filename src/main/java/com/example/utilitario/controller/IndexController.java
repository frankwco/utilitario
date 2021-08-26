package com.example.utilitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.utilitario.util.ValidaCPF;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/validarCpf")
	public String validarCpf(@RequestParam(name = "cpf") String cpf, Model model) {
		Boolean cpfValido = false;
		if(ValidaCPF.isCPF(cpf)) {
			cpfValido=true;
		}		
		model.addAttribute("cpfValido", cpfValido);
		return "index";
	}
}
