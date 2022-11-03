package CongressoBPOO;

public class General_Chairs extends Organizadores{
	public General_Chairs(String nome_gc, String cpf_gc, String data_nascimento_gc, String titulacao_acad_gc, String instituicao_vinc_gc, String senha_gc) {
		super(nome_gc, cpf_gc, data_nascimento_gc, titulacao_acad_gc, instituicao_vinc_gc,senha_gc);
	}
	
	public void validaInscricao(Participante participante_gc, boolean valida_gc) {
		participante_gc.setValida(valida_gc);
	} 
}
