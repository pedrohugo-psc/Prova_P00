package CongressoBPOO;

import java.util.LinkedList;

public class Program_Chairs extends Organizadores{
	protected static LinkedList<Artigo> artigos_pc = new LinkedList<Artigo>();
	
	public Program_Chairs(String nome_pc, String cpf_pc, String data_nascimento_pc, String titulacao_acad_pc, String instituicao_vinc_pc, String senha_pc) {
		super(nome_pc, cpf_pc, data_nascimento_pc, titulacao_acad_pc, instituicao_vinc_pc,senha_pc);
	}
	
	public Program_Chairs(Participante inscrito_pc) {
		super();
		this.setInscrito(true);
	}
	
	public void listaEspecialista() {
		for(int i = 0; i < Especialista.especilistas.size(); i++) {
			System.out.println(Especialista.especilistas.get(i));
		}
	}
	
	// 1 - Aprova o artigo; 0 - Reprova o artigo
	public void validaArtigo(String titulo_pc, int valida) {
		int index = -1;
		for(int i = 0; i < artigos_pc.size();i++) {
			if(artigos_pc.get(i).getTitulo().equals(titulo_pc)) {
				index = i;
			}
		}
		if(index == -1) {
			System.out.println("Esse título não foi encontrado");
		}
		if((valida == 1 || valida == 0) && index != -1) {
			artigos_pc.get(index).setValida(valida);
		}else {
			System.out.println("É preciso inserir 1 ou 0");
		}
	}
	
	public static void listaArtigos() {
		for(int i = 0; i < artigos_pc.size(); i++) {
			artigos_pc.get(i).getTitulo();
		}
	}
	
	public static void verAvaliacao() {
		for(int i = 0; i < artigos_pc.size(); i++) {
			System.out.println("Titulo: " + artigos_pc.get(i).titulo + " - Avaliação: " + artigos_pc.get(i).avaliacao_revisor.get(i));
		}
	}
	
	public static void recebeArtigos(Artigo artigo_pc) {
		artigos_pc.add(artigo_pc);
	}
	
}
