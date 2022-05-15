package br.com.joao.teste.itau;

import java.util.Scanner;

public class RotinaDeTeste {

	public static void main(String[] args) {

		Transferencia transferencia = new Transferencia();
		Conta emissor = new Conta("Joao", 001, 1234, "123.123.123-12");
		Conta receptor = new Conta("Maria", 002, 1335, "112.113.114-15");

		emissor.depositar(50000.0);
		receptor.depositar(50000.0);

		emissor.mostrarSaldo();
		receptor.mostrarSaldo();

		System.out.println("PIX");
		System.out.println("\nTentativa de transfer�ncia menor que R$5.000,00 reais com PIX:");
		transferencia.transferir(emissor, receptor, 500.0, TiposTransferencia.PIX);

		System.out.println("\nTentativa de transfer�ncia maior que R$5.000,00 reais com PIX:");
		transferencia.transferir(emissor, receptor, 7000.0, TiposTransferencia.PIX);

		System.out.println("\nTED");
		System.out.println("\nTentativa de transfer�ncia entre R$5.000,00 e R$10.000,00 reais com TED:");
		transferencia.transferir(emissor, receptor, 7000.0, TiposTransferencia.TED);

		System.out.println("\nTentativa de transfer�ncia menor que R$5.000,00 reais com TED:");
		transferencia.transferir(emissor, receptor, 500.0, TiposTransferencia.TED);

		System.out.println("\nTentativa de transfer�ncia maior que R$10.000,00 reais com TED:");
		transferencia.transferir(emissor, receptor, 11000.0, TiposTransferencia.TED);

		System.out.println("\nDOC");
		System.out.println("\nTentativa de transfer�ncia maior que R$10.000,00 reais com DOC:");
		transferencia.transferir(emissor, receptor, 11000.0, TiposTransferencia.DOC);

		System.out.println("\nTentativa de transfer�ncia menor que R$10.000,00 reais com DOC:");
		transferencia.transferir(emissor, receptor, 500.0, TiposTransferencia.DOC);

		System.out.println("\nTentativa de transfer�ncia de valor negativo com PIX, TED e DOC:");
		transferencia.transferir(emissor, receptor, -500.0, TiposTransferencia.PIX);
		transferencia.transferir(emissor, receptor, -500.0, TiposTransferencia.DOC);
		transferencia.transferir(emissor, receptor, -500.0, TiposTransferencia.TED);

		System.out.println("\nTentativa de transfer�ncia entre mesmas contas:");
		transferencia.transferir(emissor, emissor, 500.0, TiposTransferencia.PIX);

		Conta receptor2 = new Conta("Joao", 002, 1234, "123.123.123-12");
		receptor2.depositar(50000.0);
		System.out.println("\nTentativa de transfer�ncia entre contas diferentes do mesmo titular:");
		transferencia.transferir(emissor, receptor2, 500.0, TiposTransferencia.PIX);

		
	}

}
