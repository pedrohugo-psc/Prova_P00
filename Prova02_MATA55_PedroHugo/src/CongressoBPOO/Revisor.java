package CongressoBPOO;
public class Revisor extends Especialista {
	private boolean inscrito = false; // true - inscrito; false - nao inscrito
	
	public Revisor(String nome_r, String cpf_r, String data_nascimento_r, String titulacao_acad_r, String instituicao_vinc_r, String senha_r,String area_conhecimento_r) {
		super(nome_r, cpf_r, data_nascimento_r, titulacao_acad_r, instituicao_vinc_r,senha_r, area_conhecimento_r);
	}
	
	public Revisor(Participante inscrito, String area_conhecimento_r) {
		super(inscrito.nome,inscrito.cpf,inscrito.data_nascimento,inscrito.titulacao_acad,inscrito.instituicao_vinc,inscrito.senha,area_conhecimento_r);
		this.inscrito = true;
	}
	
}

