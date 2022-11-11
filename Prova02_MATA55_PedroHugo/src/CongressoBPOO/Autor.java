package CongressoBPOO;

import java.util.LinkedList;

public class Autor extends Especialista {
	protected LinkedList<Artigo> artigos_a;
	
	
	public Autor(String nome_a, String cpf_a, String data_nascimento_a, String titulacao_acad_a, String instituicao_vinc_a, String senha_a, String area_conhecimento_a) {
		super(nome_a, cpf_a, data_nascimento_a, titulacao_acad_a, instituicao_vinc_a,senha_a, area_conhecimento_a);
		artigos_a = new LinkedList<Artigo>();
	}

	public Autor(Participante inscrito_a, String area_conhecimento_a) {
		super(inscrito_a, area_conhecimento_a);
		this.setInscrito(true);
		artigos_a = new LinkedList<Artigo>();
	}
	
	public boolean getInscricao() {
		return inscrito;
	}
	
	public static String getArea_conhecimento(String cpf) {
		int indice = 0; 
		for(int i = 0; i < Participante.participantes.size(); i++) {
			if(Participante.cpfs.get(i).equals(cpf)) {
				indice = i;
			}
		}
		return Participante.participantes.get(indice).autor.area_conhecimento;
	}
	
	public void avaliacaoArtigo() {
		for(int i = 0; i < artigos_a.size(); i++) {
			artigos_a.get(i).getAvalicao_revisor();
		} 
	}
	
	public void setArtigo(Artigo artigo) {
		this.artigos_a.add(artigo); 
	} 
	
	public void  listaArtigos() {
		for(int i = 0; i < artigos_a.size(); i++) {
			System.out.println(artigos_a.get(i).titulo + " - Identificador: " + artigos_a.get(i).identificador);
		}
	}

}
