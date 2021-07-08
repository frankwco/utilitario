package com.example.utilitario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/mostrar")
	public String mostrarNome(@RequestParam(name = "nome") Integer nome, Model model) {
		model.addAttribute("nn", nome);

		System.out.println("Nome: " + nome);
			asdf
		return "index";
	}
}
