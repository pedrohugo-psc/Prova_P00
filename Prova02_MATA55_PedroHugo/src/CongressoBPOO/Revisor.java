package CongressoBPOO;
public class Revisor extends Especialista {
	
	public Revisor(String nome_r, String cpf_r, String data_nascimento_r, String titulacao_acad_r, String instituicao_vinc_r, String senha_r,String area_conhecimento_r) {
		super(nome_r, cpf_r, data_nascimento_r, titulacao_acad_r, instituicao_vinc_r,senha_r, area_conhecimento_r);
	}
	
	public Revisor(Participante inscrito_r,String area_conhecimento_r) {
		super(inscrito_r,area_conhecimento_r);
		this.setInscrito(true);
	}
	
}

