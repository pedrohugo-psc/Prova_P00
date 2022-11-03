package CongressoBPOO;

public class Autor extends Especialista {
	protected boolean inscrito = false; // true - inscrito; false - nao inscrito
	
	public Autor(String nome_a, String cpf_a, String data_nascimento_a, String titulacao_acad_a, String instituicao_vinc_a, String senha_a, String area_conhecimento_a) {
		super(nome_a, cpf_a, data_nascimento_a, titulacao_acad_a, instituicao_vinc_a,senha_a, area_conhecimento_a);
	}

	public Autor(Participante inscrito, String area_conhecimento_a) {
		super(inscrito.nome,inscrito.cpf,inscrito.data_nascimento,inscrito.titulacao_acad,inscrito.instituicao_vinc,inscrito.senha,area_conhecimento_a);
		this.inscrito = true;
	}
	
	public boolean getInscricao() {
		return inscrito;
	}

}
