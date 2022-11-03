package CongressoBPOO;
import java.util.ArrayList;
import java.util.Random;

public class Artigo {
	private ArrayList<Autor>autores;
	private ArrayList<Revisor>revisores;
	private int identificador;
	private String titulo;
	private String abstract_artigo;
	private String[] palavras_chaves;
	private int qtnd_paginas;
	private String data_submissao;
	private int valida;
	private boolean permite_submissao = false;
	
	public Artigo(Autor[] autores_ar,Revisor[] revisores_ar, String titulo_ar, String abstract_artigo_ar, String[] palavras_chaves_ar, int qtnd_paginas_ar,String data_submissao_ar) {
		
		for(int i = 0; i < autores_ar.length; i++) {
			if(autores_ar[i].getInscricao() == true) {
				permite_submissao = true;
			}
		}
		
		if(revisores_ar.length >= 2 && autores_ar.length >= 1 && permite_submissao == true) {
			autores = new ArrayList<Autor>(5);
			revisores = new ArrayList<Revisor>(5);
			for(int i = 0; i < autores_ar.length; i++) {
				autores.add(autores_ar[i]); 
			}
			for(int i = 0; i < autores_ar.length; i++) {
				revisores.add(revisores_ar[i]); 
			}
			Random rand = new Random();
			this.identificador = rand.nextInt(999999999);
			this.titulo = titulo_ar;
			this.abstract_artigo = abstract_artigo_ar;
			this.palavras_chaves = palavras_chaves_ar;
			this.qtnd_paginas = qtnd_paginas_ar;
			this.data_submissao = data_submissao_ar;
			
		}else {
			System.out.println("O artigo precisa ter no mínimo 1 autor e 2 revisores. E pelos menos 1 autor deve estar inscrito");
		}
	}
	
	public void setValida(int valida_ar) {
		this.valida = valida_ar;
	}
	

}
