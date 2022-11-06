package CongressoBPOO;
import java.util.LinkedList;

public abstract class Pessoa {
	// Declaração das variáveis
	protected String nome;
	protected String cpf;
	protected String data_nascimento;
	protected String titulacao_acad;
	protected String instituicao_vinc;
	protected String senha;
	protected static LinkedList<String> cpf_pessoas = new LinkedList<String>();
	protected byte validador = 1;
	 protected boolean inscrito = false; // true - inscrito; false - nao inscrito
	
	// Construtor
	public Pessoa(String nome_p, String cpf_p, String data_nascimento_p, String titulacao_acad_p, String instituicao_vinc_p, String senha_p) {
		for (int i = 0; i < cpf_pessoas.size(); i++) {
			if(cpf_pessoas.get(i).equals(cpf_p)) {
				System.out.println("Esse CPF já foi cadastrado.");
				validador = 0;
			}
		}
		if (validador == 1) {
			this.nome = nome_p;
			this.cpf = cpf_p;
			this.data_nascimento = data_nascimento_p;
			this.titulacao_acad = titulacao_acad_p;
			this.instituicao_vinc = instituicao_vinc_p;
			this.senha = senha_p;
			cpf_pessoas.add(cpf_p);
		}
	}
	
	public Pessoa() {
		
	}
	
	public byte getValidador() {
		return validador;
	}
	
	public void setInscrito(boolean inscrito_p) {
		inscrito = inscrito_p;
	}
	
	public boolean getInscrito() {
		return inscrito;
	}
}
