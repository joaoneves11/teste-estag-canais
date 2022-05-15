package br.com.joao.teste.itau;

import java.text.NumberFormat;
import java.util.Locale;

public class Transferencia {

	private Integer id_transferencia;
	private Conta emissor;
	private Conta receptor;
	private Double valor_transferencia;
	private TiposTransferencia tipo_transferencia;

	Locale localeBr = new Locale("pt","BR");
	NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBr);
	
	public void transferir(Conta emissor, Conta receptor, Double valor_transferencia,
			TiposTransferencia tipo_transferencia) {

		Boolean validacao = true;
		String agenciaEContaEmissor = "Ag " + emissor.getAgenciaConta() + " Cc " + emissor.getNumConta();
		String agenciaEContaReceptor = "Ag " + receptor.getAgenciaConta() + " Cc " + receptor.getNumConta();
		

		if (valor_transferencia <= 0) {
			validacao = false;
			System.out.println("Sua transfer�ncia n�o foi completada pois n�o � poss�vel transferir um valor negativo.");
		} else if (agenciaEContaEmissor.equals(agenciaEContaReceptor)) {
				System.out.println(agenciaEContaEmissor);
				System.out.println(agenciaEContaReceptor);
				System.out.println("Sua transfer�ncia n�o foi completada pois a conta do emissor n�o pode ser a mesma conta do receptor.");
				validacao = false;
		} else {

			if (tipo_transferencia.equals(TiposTransferencia.PIX) && valor_transferencia >= 5000) {
				System.out.println("Sua transfer�ncia n�o foi completada pois n�o � poss�vel fazer transfer�ncia PIX de valores maiores que R$5.000,00.");
				validacao = false;
			}

			if (tipo_transferencia.equals(TiposTransferencia.TED)
					&& (valor_transferencia < 5000 || valor_transferencia > 10000)) {
				System.out.println( "Sua transfer�ncia n�o foi completada pois n�o � poss�vel fazer transfer�ncia TED de valores menores que R$5.000,00 ou maiores que R$10.000,00.");
				validacao = false;
			}

			if (tipo_transferencia.equals(TiposTransferencia.DOC) && valor_transferencia <= 10000) {
				System.out.println("Sua transfer�ncia n�o foi completada pois n�o � poss�vel fazer transfer�ncia DOC de valores menores que R$10.000,00.");
				validacao = false;
			}
			
			if (validacao.equals(true)) {
				emissor.sacar(valor_transferencia);
				receptor.depositar(valor_transferencia);
				System.out.println("Transfer�ncia feita com sucesso.");
				System.out.println("SALDO");
				System.out.println("Saldo Emissor: " + dinheiro.format(emissor.getSaldo()));
				System.out.println("Saldo Receptor: " + dinheiro.format(receptor.getSaldo()));
			}

			if (emissor.getSaldo() < valor_transferencia) {
				System.out.println("Sua transfer�ncia n�o foi completada pois o emissor n�o tem saldo suficiente para esta transfer�ncia.");
			}
		}
	}

	public Transferencia() {
	}



	public Integer getId_transferencia() {
		return id_transferencia;
	}

	public void setId_transferencia(Integer id_transferencia) {
		this.id_transferencia = id_transferencia;
	}

	public Conta getEmissor() {
		return emissor;
	}

	public void setEmissor(Conta emissor) {
		this.emissor = emissor;
	}

	public Conta getReceptor() {
		return receptor;
	}

	public void setReceptor(Conta receptor) {
		this.receptor = receptor;
	}

	public Double getValor_transferencia() {
		return valor_transferencia;
	}

	public void setValor_transferencia(Double valor_transferencia) {
		this.valor_transferencia = valor_transferencia;
	}

	public TiposTransferencia getTipo_transferencia() {
		return tipo_transferencia;
	}

	public void setTipo_transferencia(TiposTransferencia tipo_transferencia) {
		this.tipo_transferencia = tipo_transferencia;
	}

}
