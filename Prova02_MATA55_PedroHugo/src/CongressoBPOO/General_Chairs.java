package CongressoBPOO;

public class General_Chairs extends Organizadores{
	
	public General_Chairs(String nome_gc, String cpf_gc, String data_nascimento_gc, String titulacao_acad_gc, String instituicao_vinc_gc, String senha_gc) {
		super(nome_gc, cpf_gc, data_nascimento_gc, titulacao_acad_gc, instituicao_vinc_gc,senha_gc);
	}
	
	public General_Chairs(Participante inscrito) {
		super();
		this.setInscrito(true);
		inscrito.setValida(true);
	}
	
	public static void validaInscricao(String cpf) {
		int indice = -1; 
		for(int i = 0; i < Participante.participantes.size(); i++) {
			if(Participante.cpfs.get(i).equals(cpf)) {
				indice = i;
			}
		}
		if(indice == -1) {
			System.out.println("CPF não encontrado.");
		}else {
			Participante.participantes.get(indice).setValida(true);
			System.out.println(Participante.participantes.get(indice).getValida());
			
		}
	}
	
	public static void invalidaInscricao(String cpf) {
		int indice = -1; 
		for(int i = 0; i < Participante.participantes.size(); i++) {
			if(Participante.cpfs.get(i).equals(cpf)) {
				indice = i;
			}
		}
		if(indice == -1) {
			System.out.println("CPF não encontrado.");
		}else {
			Participante.participantes.get(indice).setValida(false);
			System.out.println(Participante.participantes.get(indice).getValida());
		}
	} 
}
