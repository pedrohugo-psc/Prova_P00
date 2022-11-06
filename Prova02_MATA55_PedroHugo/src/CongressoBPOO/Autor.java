package CongressoBPOO;

public class Autor extends Especialista {
	
	public Autor(String nome_a, String cpf_a, String data_nascimento_a, String titulacao_acad_a, String instituicao_vinc_a, String senha_a, String area_conhecimento_a) {
		super(nome_a, cpf_a, data_nascimento_a, titulacao_acad_a, instituicao_vinc_a,senha_a, area_conhecimento_a);
	}

	public Autor(Participante inscrito_a, String area_conhecimento_a) {
		super(inscrito_a, area_conhecimento_a);
		this.setInscrito(true);
	}
	
	public boolean getInscricao() {
		return inscrito;
	}

}
