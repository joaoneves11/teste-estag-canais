package br.com.joao.teste.itau;

import java.text.NumberFormat;
import java.util.Locale;

public class Conta {

	private String titular;
	private Integer agenciaConta;
	private Integer numConta;
	private String cpfTitular;
	private Double saldo;
	
	Locale localeBr = new Locale("pt","BR");
	NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBr);
	
	public void depositar(Double deposito) {
		this.saldo = this.getSaldo() + deposito;
	}
	
	public void sacar(Double saque) {
		this.saldo = this.getSaldo() - saque;
	}
	
	public void mostrarSaldo() {
		System.out.println("Saldo " + this.getAgenciaConta() + "-" + this.getNumConta() + "(" + this.getTitular() + "):" 
				+ dinheiro.format(this.getSaldo()));
	}
	
	public Conta() {
	}
	
	public Conta(String titular, Integer agenciaConta, Integer numConta, String cpfTitular) {
		this.titular = titular;
		this.numConta = numConta;
		this.agenciaConta = agenciaConta;
		this.cpfTitular = cpfTitular;
		this.saldo = 0.0;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Integer getNumConta() {
		return numConta;
	}
	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}
	public Integer getAgenciaConta() {
		return agenciaConta;
	}
	public void setAgenciaConta(Integer agenciaConta) {
		this.agenciaConta = agenciaConta;
	}
	public String getCpfTitular() {
		return cpfTitular;
	}
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	
	
}
