package CongressoBPOO;
import java.util.LinkedList;

public class Participante extends Pessoa {
	protected boolean valida = false; // true - inscrição valida; false - inscrição invalida
	Autor autor;
	Revisor revisor;
	Program_Chairs program;
	General_Chairs general;
	protected static LinkedList<String> nomes_participantes = new LinkedList<String>();
	protected static LinkedList<String> cpfs = new LinkedList<String>();
	protected static LinkedList<String> senhas = new LinkedList<String>();
	protected static LinkedList<Participante> participantes = new LinkedList<Participante>();
	protected char tipo_participante = 'o'; // o -> ouvinte; a -> autor; r -> revisor; g -> program chairs; p -> program chairs
	
	
	public Participante(String nome_par, String cpf_par, String data_nascimento_par, String titulacao_acad_par, String instituicao_vinc_par, String senha_par) {
		super(nome_par, cpf_par, data_nascimento_par, titulacao_acad_par, instituicao_vinc_par,senha_par);
		if(this.getValidador() == 1) {
			nomes_participantes.add(nome_par);
			cpfs.add(cpf_par);
			senhas.add(senha_par);
			participantes.add(this);
		}
	}
	
	public void setAutor(Participante inscrito,String area_par) {
		autor = new Autor(inscrito, area_par);
		tipo_participante = 'a';
	}
	
	public void setRevisor(Participante inscrito,String area_par) {
		revisor = new Revisor(inscrito,area_par);
		tipo_participante = 'r';
	}
	
	public void setProgramChairs(Participante inscrito) {
		program = new Program_Chairs(inscrito);
		tipo_participante = 'p';
	}
	
	public void setGeneralChairs(Participante inscrito) {
		general = new General_Chairs(inscrito);
		tipo_participante = 'g';
	}
	
	public void setValida(boolean valida_par) {
		this.valida = valida_par;
	}
	
	public boolean getValida() {
		return valida;
	}
	
	public Autor getAutor(){
		return autor;
	}
	
	public char getTipoparticipante(){
		return tipo_participante;
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
	
	public static String resgataParticipantes(String cpf){
		int indice = 0; 
		for(int i = 0; i < participantes.size(); i++) {
			if(cpfs.get(i).equals(cpf)) {
				indice = i;
			}
		}
		return participantes.get(indice).nome;
	}
	
	public static char getTipoparticipante(String cpf) {
		int indice = 0; 
		for(int i = 0; i < participantes.size(); i++) {
			if(cpfs.get(i).equals(cpf)) {
				indice = i;
			}
		}
		return participantes.get(indice).tipo_participante;
	}
	
	public void listaParticipantes() {
		for(int i = 0; i < nomes_participantes.size(); i++) {
			System.out.println(nomes_participantes.get(i));
		}
	}
}
