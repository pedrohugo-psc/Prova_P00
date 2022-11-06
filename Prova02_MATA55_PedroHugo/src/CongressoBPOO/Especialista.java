package CongressoBPOO;
import java.util.LinkedList;

public abstract class Especialista extends Pessoa {
	protected String area_conhecimento;
	protected static LinkedList<String> especilistas = new LinkedList<String>();
	
	public Especialista(String nome_e, String cpf_e, String data_nascimento_e, String titulacao_acad_e, String instituicao_vinc_e, String senha_e, String area_conhecimento_e) {
		super(nome_e, cpf_e, data_nascimento_e, titulacao_acad_e, instituicao_vinc_e,senha_e);
		this.area_conhecimento = area_conhecimento_e;
		especilistas.add(nome_e);
	}
	
	public Especialista(Participante inscrito_e,String area_conhecimento_e) {
		super();
		this.area_conhecimento = area_conhecimento_e;
		especilistas.add(inscrito_e.nome);
	}
}
