package com.senac;

import static java.lang.System.out;

import java.io.IOException;
import java.util.Scanner;

import com.senac.estrutura.ListaEncadeadaOrdenada;
import com.senac.estrutura.Nodo;
import com.senac.model.Pessoa;

public class App {
	public static void main(String[] args) {
		TextFile arquivo = new TextFile("data/dados.txt");
	    ListaEncadeadaOrdenada<Pessoa> lista = new ListaEncadeadaOrdenada<Pessoa>();
		Scanner teclado = new Scanner(System.in);

		try {
			arquivo.openTextFile();
			while (arquivo.next()) {
			    String Linha = arquivo.readLine();
			    String[] dados = Linha.split("[#]");

			    lista.insert(new Pessoa(dados));
			}
		} catch (IOException e) {
			out.println("ERRO: " + e);
		}

		do {
			System.out.println("Digite:");
			System.out.println("1 - Inserir na lista");
			System.out.println("2 - Exluir da lista");
			System.out.println("3 - Listar registros");
			System.out.println("S - Sair");

			switch (teclado.nextLine().toUpperCase()) {
				case "1":
					System.out.println("INSERIR");
					System.out.println("Digite o nome:");
					Pessoa p = new Pessoa(teclado.nextLine());

					System.out.println("Digite o endereço:");
					p.setEndereco(teclado.nextLine());

					System.out.println("Digite o telefone:(digite C para cancelar)");
					String entrada = teclado.nextLine();

					while (!entrada.equalsIgnoreCase("C")) {
						p.setTelefone(entrada);
						System.out.println("Digite o telefone:(digite C para cancelar)");
						entrada = teclado.nextLine();
					}
					lista.insert(p);
					break;

				case "2":
					System.out.println("EXCLUIR");
					System.out.println("Digite o nome:");
					lista.remove(new Pessoa(teclado.nextLine()));
					break;

				case "3":
					Nodo<Pessoa> nodo = lista.getHead();

					for (int i = 0; i < lista.size(); i++) {
						System.out.println(nodo.getElement().toString());
						nodo = nodo.getNext();
					}
					break;

				case "S":
					teclado.close();
					System.exit(0);

				default:
					System.out.println("Opção Inválida");
					break;
			}
		} while (true);
	}
}