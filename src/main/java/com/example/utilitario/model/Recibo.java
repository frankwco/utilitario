package com.example.utilitario.model;

import com.example.utilitario.util.ValorExtenso;

public class Recibo {
	

	private String nomeEmissor;
	private String cpfEmissor;
	private Double valorPagamento;

	public String getValorExtenso() {		
		return ValorExtenso.valorPorExtenso(valorPagamento);
	}

	public String getNomeEmissor() {
		return nomeEmissor;
	}

	public void setNomeEmissor(String nomeEmissor) {
		this.nomeEmissor = nomeEmissor;
	}

	public String getCpfEmissor() {
		return cpfEmissor;
	}

	public void setCpfEmissor(String cpfEmissor) {
		this.cpfEmissor = cpfEmissor;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

}
