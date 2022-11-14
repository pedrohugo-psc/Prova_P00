package CongressoBPOO;
import java.util.LinkedList;
import java.util.Collections;

public abstract class Pessoa {
	// Declaração das variáveis
	protected String nome;
	protected String cpf;
	protected String data_nascimento;
	protected String titulacao_acad;
	protected String instituicao_vinc;
	protected String senha;
	protected static LinkedList<String> cpf_pessoas = new LinkedList<String>();
	protected static LinkedList<String> titulo_artigos = new LinkedList<String>();
	protected byte validador = 1;
	protected boolean inscrito = false; // true - inscrito; false - nao inscrito
	protected static LinkedList<Artigo> artigos = new LinkedList<Artigo>();
	
	// Construtor
	public Pessoa(String nome_p, String cpf_p, String data_nascimento_p, String titulacao_acad_p, String instituicao_vinc_p, String senha_p) {
		for (int i = 0; i < cpf_pessoas.size(); i++) {
			if(cpf_pessoas.get(i).equals(cpf_p)) {
				System.out.println("Esse CPF já foi cadastrado.");
				validador = 0;
			}
		}
		if (validador == 1) {
			this.nome = nome_p;
			this.cpf = cpf_p;
			this.data_nascimento = data_nascimento_p;
			this.titulacao_acad = titulacao_acad_p;
			this.instituicao_vinc = instituicao_vinc_p;
			this.senha = senha_p;
			cpf_pessoas.add(cpf_p);
		}
	}
	
	public Pessoa() {
		
	}

	public byte getValidador() {
		return validador;
	}
	
	public void setInscrito(boolean inscrito_p) {
		inscrito = inscrito_p;
	}
	
	public boolean getInscrito() {
		return inscrito;
	}
	public static void listaArtigos_aprovados() { // Lista artigos aprovados
		LinkedList<String> lista_temp = new LinkedList<String>();
		for(int i = 0; i < artigos.size(); i++) {
			if((artigos.get(i).valida == 1) && titulo_artigos.get(i).equals(artigos.get(i).titulo)) {
				lista_temp.add(titulo_artigos.get(i)); 
			}
		}
		System.out.println("Artigos aprovados:");
		Collections.sort(lista_temp);
		for(int i = 0; i < lista_temp.size(); i++) {
			System.out.println(lista_temp.get(i));
		}
	}
	
	public static void listaArtigos_reprovados() { // Lista artigos reprovados
		LinkedList<String> lista_temp = new LinkedList<String>();
		for(int i = 0; i < artigos.size(); i++) {
			if(artigos.get(i).valida == 0  && titulo_artigos.get(i).equals(artigos.get(i).titulo)) {
				lista_temp.add(titulo_artigos.get(i)); 
			}
		}
		System.out.println("Artigos reprovados:");
		Collections.sort(lista_temp);
		for(int i = 0; i < lista_temp.size(); i++) {
				System.out.println(lista_temp.get(i));
		}
	}
	
	public static void listaDadosArtigos() { // Lista todos os artigos com detalhes
		for(int i = 0; i < artigos.size(); i++) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Título: " + artigos.get(i).titulo);
			System.out.println("Identificador: " + artigos.get(i).identificador);
			System.out.println("Páginas: " + artigos.get(i).qtnd_paginas);
			System.out.println("Abstract: " + artigos.get(i).abstract_artigo);
			System.out.println("Data de submissão: " + artigos.get(i).data_submissao);
			System.out.println("Palavras-chaves:");
			artigos.get(i).getPalavrasChaves();
			System.out.println("-----------------------------------------------------------");
			System.out.println();
		}
	}
	
}
