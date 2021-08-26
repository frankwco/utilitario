package com.example.utilitario.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.utilitario.model.Calculadora;
import com.example.utilitario.model.Recibo;
import com.example.utilitario.util.ValidaCPF;
import com.example.utilitario.util.ValorExtenso;

@Controller
public class CalculadoraController {

	@GetMapping("/calculadora")
	public String index(Model model) {
		return "calculadora";
	}

	@RequestMapping(value = "/calcular", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Double calcular(@RequestBody(required = false) Calculadora calculadora) {
		System.out.println(calculadora.getValor1());
		System.out.println(calculadora.getValor2());
		calculadora.setResultado(calculadora.getValor1()+calculadora.getValor2());
		return calculadora.getResultado();
	}

}
