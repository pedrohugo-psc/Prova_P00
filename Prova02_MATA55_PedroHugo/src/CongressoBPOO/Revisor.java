package CongressoBPOO;

import java.util.LinkedList;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class Revisor extends Especialista {
	protected LinkedList<String> avaliacao;
	protected LinkedList<Artigo> artigos_r;
	
	public Revisor(Participante inscrito_r,String area_conhecimento_r) {
		super(inscrito_r,area_conhecimento_r);
		this.setInscrito(true);
		artigos_r = new LinkedList<Artigo>();
		avaliacao = new LinkedList<String>();
	}
	
	
	public void avaliaArtigo(String titulo_r) {
		int verifica = 0;
		int index = -1;
		int index1 = -1;
		String avalia = "";
		for(int i = 0; i < artigos_r.size(); i++) {
			if(artigos_r.get(i).titulo.equals(titulo_r)) {
				index = i;
				verifica = 1;
			}
		}
		for(int i = 0; i < artigos.size(); i++) {
			if(artigos.get(i).titulo.equals(titulo_r)) {
				index1 = i;
			}
		}
		if(verifica == 0) {
			System.out.println("Título não encontrado");
		}else {
			System.out.println("Avalie o artigo " + artigos_r.get(index).getTitulo());
			Scanner scanner = new Scanner(System.in);
			avalia = scanner.nextLine();
			artigos_r.get(index).setAvalicao_revisor(avalia);
			Program_Chairs.recebeArtigos(artigos_r.get(index));
			this.avaliacao.add(avalia);
		}
	}
	
	public void verAvalicao() {
		try {
			for(int i = 0; i < artigos_r.size(); i++) {
				System.out.println("Título: " + artigos_r.get(i).titulo + " - Avaliação: " + avaliacao.get(i));
			}
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Não há avaliação");
		}
	}
	
	public void setArtigo(Artigo artigo) {
		this.artigos_r.add(artigo); 
	}
	
	public void  listaArtigos() {
		for(int i = 0; i < artigos_r.size(); i++) {
			System.out.println(artigos_r.get(i).titulo + " - Identificador: " + artigos_r.get(i).identificador);
		}
	}
}

