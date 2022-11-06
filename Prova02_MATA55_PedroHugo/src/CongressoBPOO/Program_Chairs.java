package CongressoBPOO;

public class Program_Chairs extends Organizadores{
	
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
	public void validaArtigo(Artigo artigo_pc, int valida) {
		if(valida == 1 || valida == 0) {
			artigo_pc.setValida(valida);
		}else {
			System.out.println("É preciso inserir 1 ou 0");
		}
	}
}
