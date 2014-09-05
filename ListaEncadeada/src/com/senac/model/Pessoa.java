package com.senac.model;

import com.senac.estrutura.Vetor;


public class Pessoa implements Comparable<Pessoa> {

	private String nome;
	private String endereco;
	private Vetor<String> telefones;

	public Pessoa() {
	}

	public Pessoa(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefones = new Vetor<String>();
		this.telefones.append(telefone);
	}

	public Pessoa(String nome) {
		this.nome = nome;
		this.endereco = null;
		this.telefones = new Vetor<String>();
	}

	public Pessoa(String[] dados) {
		this.nome = dados[0];
		this.endereco = dados[1];

		this.telefones = new Vetor<String>();
		for (int i = 2; i < dados.length; i++) {
			this.telefones.append(dados[i]);
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefones() {
		int length = this.telefones.getSize();
		if (length > 0) {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < length - 1; i++) {
				builder.append(this.telefones.getValueOf(i));
				builder.append(", ");
			}
			builder.append(this.telefones.getValueOf(length-1));

			return builder.toString();
		}
		return "";
	}

	public void setTelefone(String telefone) {
		this.telefones.append(telefone);
	}

	public void setTelefone(Vetor<String> telefones) {
		for (int i = 0; i < telefones.getSize(); i++) {
			this.telefones.append(telefones.getValueOf(i));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!((Pessoa) obj).getNome().equals(this.getNome())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.endereco + " - " + this.getTelefones();
	}

	@Override
	public int compareTo(Pessoa p) {
		return this.nome.compareToIgnoreCase(p.getNome());
	}
}
