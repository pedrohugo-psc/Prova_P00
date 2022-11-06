import CongressoBPOO.Program_Chairs;
import CongressoBPOO.General_Chairs;
import CongressoBPOO.Participante;
import CongressoBPOO.Autor;
import CongressoBPOO.Revisor;
import CongressoBPOO.Artigo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] arg) {
		int opcao = 0;
		boolean sair = false;
		String cpf = "";
		String senha = "";
		
		Participante p1 = new Participante("Maria", "05531958595", "31/10/1994", "Estudante", "UFBA", "1234");
		Autor p2 = new Autor("Pedro", "05531958595", "31/10/1994", "Estudante", "UFBA", "1234","Engenharia");
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
		
		p4.setAutor(p4,"Psicologia");
		
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
			try {
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
							System.out.println("Login Feito!");
							if(Participante.getTipoparticipante(cpf) == 'o') {
								System.out.println();
								System.out.println("Menu para ouvinte");
							}else if(Participante.getTipoparticipante(cpf) == 'a') {
								System.out.println();
								System.out.println("Menu para autor");
							}else if(Participante.getTipoparticipante(cpf) == 'r') {
								System.out.println();
								System.out.println("Menu para revisor");
							}else if(Participante.getTipoparticipante(cpf) == 'p') {
								System.out.println();
								System.out.println("Menu para program chair");
							}else if(Participante.getTipoparticipante(cpf) == 'g') {
								boolean sair2 = false;
								while(sair2 == false) {
									System.out.println();
									System.out.println("Menu para general chair");
									System.out.println();
									System.out.println("Escolha dessas opções: ");
									System.out.println("1 - Validar inscrição de participante");
									System.out.println("2 - Invalidar inscrição de participante");
									System.out.println("3 - Emitir certificado para participante");
									System.out.println("4 - Sair");
									Scanner scanner10 = new Scanner(System.in);
									try {
										int opcao2 = scanner10.nextInt();
										switch(opcao2){
											case 1:
												System.out.println();
												System.out.print("Digite o cpf de um participante para validar a sua inscrição: ");
												Scanner scanner11 = new Scanner(System.in);
												String cpf1 = scanner11.next();
												General_Chairs.validaInscricao(cpf1);
												break;
											case 2:
												System.out.println();
												System.out.print("Digite o cpf de um participante para invalidar a sua inscrição: ");
												Scanner scanner12 = new Scanner(System.in);
												String cpf2 = scanner12.next();
												General_Chairs.invalidaInscricao(cpf2);
												break;
											case 3:
												
												break;
											case 4:
												sair2 = true;
												break;
											default:
												System.out.println("Digite um valor correto");
												break;
										}
									}catch (InputMismatchException e){
										System.out.println("Erro: Você deve inserir um número!");
									}	
								
								}
							}
							
						}else {
							System.out.println();
							System.out.print("Login não encontrado");
						}
						break;
					case 2:
						System.out.println();
						System.out.print("Insira o seu nome: ");
						Scanner scanner3 = new Scanner(System.in);
						String nome_ins = scanner3.next();
						System.out.print("Insira o seu CPF: ");
						Scanner scanner4 = new Scanner(System.in);
						String cpf_ins = scanner4.next();
						System.out.print("Insira a sua data de nascimento: ");
						Scanner scanner5 = new Scanner(System.in);
						String data_nascimento_ins = scanner5.next();
						System.out.print("Insira a sua titulação: ");
						Scanner scanner6 = new Scanner(System.in);
						String titulacao_acad_ins = scanner6.next();
						System.out.print("Insira a sua instituição: ");
						Scanner scanner7 = new Scanner(System.in);
						String instituicao_vinc_ins = scanner7.next();
						System.out.print("Insira uma senha: ");
						Scanner scanner8 = new Scanner(System.in);
						String senha_ins = scanner8.next();
						Participante p = new Participante(nome_ins, cpf_ins, data_nascimento_ins, titulacao_acad_ins, instituicao_vinc_ins, senha_ins);
						if(p.getValidador() == 1) {
							boolean sair1 = false;
							while (sair1 == false) {
								System.out.println();
								System.out.println("Bem-vindo(a), "+ nome_ins+ "!");
								System.out.println();
								System.out.println("Escolha a sua categoria: ");
								System.out.println("1 - Ouvinte");
								System.out.println("2 - Autor");
								System.out.println("3 - Revisor");
								System.out.println("4 - Program Chair");
								System.out.println("5 - General Chair");
								Scanner scanner9 = new Scanner(System.in);
								try {
									int opcao1 = scanner9.nextInt();
									switch(opcao1){
										case 1:
											System.out.println("Você será ouvinte!");
											sair1 = true;
											break;
										case 2:
											System.out.println("Você será autor!");
											System.out.println();
											System.out.print("Digite sua área de conhecimento: ");
											Scanner scanner10 = new Scanner(System.in);
											String area = scanner10.next();
											p.setAutor(p,area);
											sair1 = true;
											break;
										case 3:
											System.out.println("Você será revisor!");
											System.out.println();
											System.out.print("Digite sua área de conhecimento: ");
											Scanner scanner11 = new Scanner(System.in);
											String area1 = scanner11.next();
											p.setRevisor(p,area1);
											sair1 = true;
											break;
										case 4:
											System.out.println("Você será program chair!");
											p.setProgramChairs(p);
											sair1 = true;
											break;
										case 5:
											System.out.println("Você será general chair!");
											p.setGeneralChairs(p);
											sair1 = true;
											break;
										default:
											System.out.println("Digite um valor correto");
											break;
									}
								}catch (InputMismatchException e){
									System.out.println("Erro: Você deve inserir um número!");
								}
							}
							
						}
						break;
					case 3:
						sair = true;
						break;
					default:
						System.out.println("Opção Invalida");
						break;
				}
			}catch (InputMismatchException e){
				System.out.println("Erro: Você deve inserir um número!");
			}
		}
		
		
	}

}
