import CongressoBPOO.Program_Chairs;
import CongressoBPOO.General_Chairs;
import CongressoBPOO.Participante;
import CongressoBPOO.Autor;
import CongressoBPOO.Revisor;
import CongressoBPOO.Artigo;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) {
		int opcao = 0;
		boolean sair = false;
		String cpf = "";
		String senha = "";
		
		Participante p1 = new Participante("Maria", "05531958595", "31/10/1994", "Estudante", "UFBA", "1234");
		Autor p2 = new Autor("Pedro", "057531958595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Revisor p3 = new Revisor("Raquel", "055531958595", "31/10/1994", "Estudante", "UFBA", "1234", "Matematica");
		Participante p4 = new Participante("Iva", "055531958596", "31/10/1994", "Estudante", "UFBA", "1234");
		
		Autor au1 = new Autor("Pedro", "057531958595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Autor au2 = new Autor("Gabriela", "057531954595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Autor au3 = new Autor("ALberto", "027531958595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Autor au4 = new Autor("Francisco", "157531954595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Autor au5 = new Autor("Leticia", "057535958595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		
		Revisor r1 = new Revisor("Amanda", "057535958795", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		Revisor r2 = new Revisor("Tulio", "057535458795", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
		
		Autor[] autores = {au1};
		Revisor[] revisores = {r1,r2};
		String[] palavras_chaves_a1 = {"Vida","Mar"};
		
		Artigo a1 = new Artigo(autores,revisores,"Teste","Esse artigo é muito legal",palavras_chaves_a1,40,"21/10/2021");
		
		Program_Chairs pc1 = new Program_Chairs ("Carlos", "00031955597", "12/10/2017", "Professor", "UFBA","123f");
		
		pc1.listaEspecialista();
		
		pc1.validaArtigo(a1, 2);
		
		p4.setAutor("Psicologia");
		
		Autor[] autores1 = {au1,p4.getAutor()};
		
		Artigo a2 = new Artigo(autores1,revisores,"Teste","Esse artigo é muito legal",palavras_chaves_a1,40,"21/10/2021");
		
		System.out.println();
		
		pc1.listaEspecialista();
		
		while (sair == false) {
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("Congresso Brasileiro de Programação Orientada a Objeto");
			System.out.println("------------------------------------------------------");
			System.out.println("1 - Fazer Login");
			System.out.println("2 - Inscrição");
			System.out.println("3 - Sair");
			System.out.print("Digite uma dessas opções acima: ");
			Scanner scanner = new Scanner(System.in);
			opcao = scanner.nextInt();
		
			switch(opcao) {
				case 1:
					System.out.println();
					System.out.print("Insira o seu CPF: ");
					Scanner scanner1 = new Scanner(System.in);
					cpf = scanner1.next();
					System.out.print("Insira a sua senha: ");
					Scanner scanner2 = new Scanner(System.in);
					senha = scanner2.next();
					if (Participante.procuraCPFs(cpf) == 1 && Participante.procuraSenhas(senha) == 1) {
						System.out.println();
						System.out.print("Login Feito!");
					}else {
						System.out.println();
						System.out.print("Login não encontrado");
					}
					break;
				case 2:
				case 3:
					sair = true;
					break;
				default:
					System.out.println("Opção Invalida");
					break;
			}
		}
		
		
	}

}
