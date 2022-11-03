package CongressoBPOO;
import java.util.LinkedList;

public class Participante extends Pessoa {
	private boolean valida = true; // 1 - inscrição valida; 0 - inscrição invalida
	Autor autor;
	Revisor revisor;
	protected static LinkedList<String> participantes = new LinkedList<String>();
	protected static LinkedList<String> cpfs = new LinkedList<String>();
	protected static LinkedList<String> senhas = new LinkedList<String>();
	
	
	public Participante(String nome_par, String cpf_par, String data_nascimento_par, String titulacao_acad_par, String instituicao_vinc_par, String senha_par) {
		super(nome_par, cpf_par, data_nascimento_par, titulacao_acad_par, instituicao_vinc_par,senha_par);
		participantes.add(nome_par);
		cpfs.add(cpf_par);
		senhas.add(senha_par);
	}
	
	public void setAutor(String area_par) {
		autor = new Autor(this,area_par);
	}
	
	public void setRevisor(String area_par) {
		revisor = new Revisor(this,area_par);
	}
	
	public void setValida(boolean valida_par) {
		valida = valida_par;
	}
	
	public Autor getAutor(){
		return autor;
	}
	
	public static byte procuraCPFs(String cpf){
		byte existe = 0; 
		for(int i = 0; i < cpfs.size(); i++) {
			if(cpfs.get(i).equals(cpf)) {
				existe = 1;
			}
		}
		return existe;
	}
	
	public static byte procuraSenhas(String senha){
		byte existe = 0; 
		for(int i = 0; i < senhas.size(); i++) {
			if(senhas.get(i).equals(senha)) {
				existe = 1;
			}
		}
		return existe;
	}
	
	public void listaParticipantes() {
		for(int i = 0; i < participantes.size(); i++) {
			System.out.println(participantes.get(i));
		}
	}
}
