import CongressoBPOO.Program_Chairs;
import CongressoBPOO.General_Chairs;
import CongressoBPOO.Participante;
import CongressoBPOO.Pessoa;
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

		// Menu principal
		while (sair == false) {
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("Congresso Brasileiro de Programação Orientada a Objeto");
			System.out.println("------------------------------------------------------");
			System.out.println("1 - Fazer Login");
			System.out.println("2 - Inscrição");
			System.out.println("3 - Ver lista de artigos aprovados");
			System.out.println("4 - Ver lista de artigos reprovados");
			System.out.println("5 - Ver lista de todos os artigos");
			System.out.println("6 - Sair");
			System.out.print("Digite uma dessas opções acima: ");
			Scanner scanner = new Scanner(System.in);
			try {
				opcao = scanner.nextInt();
				switch(opcao) {
					case 1: // Fazer Login
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
							// Menu do Ouvinte (Apenas particiapante)
							if(Participante.getTipoparticipante(cpf) == 'o') {
								System.out.println();
								System.out.println("Bem-vindo, ouvinte!");
								System.out.println();
							// Menu do autor
							}else if(Participante.getTipoparticipante(cpf) == 'a') {
								boolean sair3 = false;
								while(sair3 == false) {
									System.out.println();
									System.out.println("Menu para o autor");
									System.out.println();
									System.out.println("Escolha uma dessas opções: ");
									System.out.println("1 - Submeter artigo");
									System.out.println("2 - Ver avaliação");
									System.out.println("3 - Sair");
									Scanner scanner14 = new Scanner(System.in);
									try {
										int opcao3 = scanner14.nextInt();
										switch(opcao3) {
											case 1:
												Autor[] autores = {};
												int num_autores = 0;
												boolean sai = false;
												while(sai == false) {
													Scanner scanner15 = new Scanner(System.in);
													try {
														System.out.println("Quantos autores vão participar desse artigo?");
														num_autores = scanner15.nextInt();
														if(num_autores <= 0 ||  num_autores > 5) {
															System.out.println("Você deve escolher entre 1 a 5 autores");
															
														}else {
															sai = true;
															autores = new Autor[num_autores];
															autores[0] = Participante.getAutor(cpf);
															if(num_autores > 1) {
																Autor co_autor; 
																for(int i = 1; i < num_autores; i++) {
																	boolean sai3 = false;
																	while(sai3 == false) {
																		System.out.println("Digite o CPF do autor " + i);
																		Scanner scanner17 = new Scanner(System.in);
																		String cpf_autor = scanner17.next();
																		if(Participante.verificaCPF(cpf_autor) == 1) {
																			if(Participante.getTipoparticipante(cpf_autor) == 'a') {
																				autores[i] = Participante.getParticipante(cpf_autor).getAutor(cpf_autor);
																				sai3 = true;
																			}else {
																				Participante.getParticipante(cpf_autor).setAutor(Participante.getParticipante(cpf_autor), Autor.getArea_conhecimento(cpf));
																				autores[i] = Participante.getParticipante(cpf_autor).getAutor(cpf_autor);
																				sai3 = true;
																			} 
																		}else {
																			System.out.println("Digite o nome do autor " + i);
																			Scanner scanner16 = new Scanner(System.in);
																			String nome_autor = scanner16.next();
																			System.out.println("Digite a data de nascimento do autor " + i);
																			Scanner scanner18 = new Scanner(System.in);
																			String data_nasc_autor = scanner18.next();
																			System.out.println("Digite a titulação do autor " + i);
																			Scanner scanner19 = new Scanner(System.in);
																			String titu_autor = scanner19.next();
																			System.out.println("Digite a instituição do autor " + i);
																			Scanner scanner20 = new Scanner(System.in);
																			String inst_autor = scanner20.next();
																			System.out.println("Digite a senha do autor " + i);
																			Scanner scanner21 = new Scanner(System.in);
																			String senha_autor = scanner21.next();
																			co_autor = new Autor(nome_autor, cpf_autor, data_nasc_autor, titu_autor, inst_autor, senha_autor,Autor.getArea_conhecimento(cpf));
																			if(co_autor.getValidador() == 1) {
																				autores[i] = co_autor;
																				sai3 = true;
																			}
																		}
																	}
																}
															}
														}
													}catch (InputMismatchException e){
														System.out.println("Erro: Você deve inserir um número!");
													}
												}
																							
												Revisor[] revisores = {};
												int num_revisores = 0; 
												boolean sai1 = false;
												while(sai1 == false) {
													Scanner scanner22 = new Scanner(System.in);
													try {
														System.out.println("Quantos revisores vão avaliar esse artigo?");
														num_revisores = scanner22.nextInt();
														if(num_revisores <= 1 ||  num_revisores > 5) {
															System.out.println("Você deve escolher entre 2 a 5 revisores");
														}else {
															sai1 = true;
															revisores = new Revisor[num_revisores];
															Revisor revisor;
															for(int i = 0; i < num_revisores; i++) {
																boolean sai4 = false;
																while(sai4 == false){
																	System.out.println("Digite o CPF do revisor " + i);
																	Scanner scanner24 = new Scanner(System.in);
																	String cpf_revisor = scanner24.next();
																	if(Participante.verificaCPF(cpf_revisor) == 1) {
																		if(Participante.getTipoparticipante(cpf_revisor) != 'r') {
																			Participante.getParticipante(cpf_revisor).setRevisor(Participante.getParticipante(cpf_revisor), Autor.getArea_conhecimento(cpf));
																			revisores[i] = Participante.getParticipante(cpf_revisor).getRevisor(cpf_revisor);
																			sai4 = true;
																		}
																	}else {
																		System.out.println("Digite o nome do revisor " + i);
																		Scanner scanner23 = new Scanner(System.in);
																		String nome_revisor = scanner23.next();
																		System.out.println("Digite a data de nascimento do revisor " + i);
																		Scanner scanner25 = new Scanner(System.in);
																		String data_nasc_revisor= scanner25.next();
																		System.out.println("Digite a titulação do revisor " + i);
																		Scanner scanner26 = new Scanner(System.in);
																		String titu_revisor = scanner26.next();
																		System.out.println("Digite a instituição do revisor " + i);
																		Scanner scanner27 = new Scanner(System.in);
																		String inst_revisor = scanner27.next();
																		System.out.println("Digite a senha do revisor " + i);
																		Scanner scanner28 = new Scanner(System.in);
																		String senha_revisor = scanner28.next();
																		Participante p = new Participante(nome_revisor, cpf_revisor, data_nasc_revisor, titu_revisor, inst_revisor, senha_revisor);
																		p.setRevisor(p,Autor.getArea_conhecimento(cpf));
																		if(p.getValidador() == 1) {
																			revisores[i] = p.getRevisor(cpf_revisor);
																			sai4 = true;
																		}
																	}
																}
															}
														}
													}catch (InputMismatchException e){
														System.out.println("Erro: Você deve inserir um número!");
													}
													
												}
												System.out.print("Digite um título: ");
												Scanner scanner29 = new Scanner(System.in);
												String titulo = scanner29.next();
												System.out.print("Digite um abstract: ");
												Scanner scanner30 = new Scanner(System.in);
												String abstract_artigo = scanner30.nextLine();
												String[] palavras_chaves = {};
												boolean sai2 = false;
												while(sai2 == false) {
													Scanner scanner31 = new Scanner(System.in);
													try {
														System.out.print("Quantas palavras-chaves terão no artigo? ");
														int num_palavras_chave = scanner31.nextInt();
														sai2 = true;
														palavras_chaves = new String[num_palavras_chave];
														for(int i = 0; i < num_palavras_chave; i++) {
															Scanner scanner32 = new Scanner(System.in);
															System.out.println("Insira a palavra-chave " + i);
															String palavra_chave = scanner32.next();
															palavras_chaves[i] = palavra_chave;
														}
													}catch (InputMismatchException e){
														System.out.println("Erro: Você deve inserir um número!");
													}
												}
												boolean sai5 = false;
												int paginas = 0;
												while(sai5 == false) {
													System.out.print("Quantas páginas terão o artigo? ");
													Scanner scanner33 = new Scanner(System.in);
													try {
														paginas = scanner33.nextInt();
														sai5 = true;
													}catch (InputMismatchException e){
														System.out.println("Erro: Você deve inserir um número!");
													}
												}
												System.out.print("Digite a data da submissão: ");
												Scanner scanner34 = new Scanner(System.in);
												String data_submissao = scanner34.next();
												Artigo artigo = new Artigo(autores,revisores,titulo,abstract_artigo,palavras_chaves,paginas,data_submissao);
												for(int i = 0; i < num_revisores; i++) {
													revisores[i].setArtigo(artigo);
												}
												for(int i = 0; i < num_autores; i++) {
													autores[i].setArtigo(artigo);
												}
												break;
											case 2:
												Participante.getAutor(cpf).avaliacaoArtigo();
												break;
												
											case 3:
												sair3 = true;
												break;
											default: 
												System.out.println("Opção Invalida");
												break;
										}
									}catch (InputMismatchException e){
										System.out.println("Erro: Você deve inserir um número!");
									}	
								}
							// Menu do Revisor
							}else if(Participante.getTipoparticipante(cpf) == 'r') {
								boolean sair4 = false;
								while(sair4 == false) {
									System.out.println();
									System.out.println("Menu para revisor");
									System.out.println();
									System.out.println("Escolha uma dessas opções: ");
									System.out.println("1 - Listar Artigos");
									System.out.println("2 - Avaliar Artigo");
									System.out.println("3 - Ver Avaliação do Artigo");
									System.out.println("4 - Sair");
									Scanner scanner34 = new Scanner(System.in);
									try {
										int opcao4 = scanner34.nextInt();
										switch(opcao4) {
											case 1:
												Participante.getRevisor(cpf).listaArtigos();
												break;
											case 2:
												System.out.println("Digite o título do artigo que você deseja avaliar: ");
												Scanner scanner35 = new Scanner(System.in);
												String titulo = scanner35.next();
												Participante.getRevisor(cpf).avaliaArtigo(titulo);
												break;
											case 3:
												Participante.getRevisor(cpf).verAvalicao();
												break;
											case 4:
												sair4 = true;
												break;
											default:
												System.out.println("Digite um valor correto");
												break;
										}
									}catch (InputMismatchException e){
										System.out.println("Erro: Você deve inserir um número!");
									}
								}
							// Menu do Program Chair
							}else if(Participante.getTipoparticipante(cpf) == 'p') {
								boolean sair5 = false;
								while(sair5 == false) {
									System.out.println();
									System.out.println("Menu para program chair");
									System.out.println();
									System.out.println("Escolha uma dessas opções: ");
									System.out.println("1 - Ver avaliação");
									System.out.println("2 - Aprova artigo");
									System.out.println("3 - Listar Especialistas");
									System.out.println("4 - Sair");
									Scanner scanner36 = new Scanner(System.in);
									try {
										int opcao5 = scanner36.nextInt();
										switch(opcao5) {
											case 1:
												Program_Chairs.verAvaliacao();
												break;
											case 2:
												System.out.println();
												System.out.println("Digite o título do artigo que deseja avaliar");
												Scanner scanner37 = new Scanner(System.in);
												String titulo = scanner37.next();
												System.out.println();
												System.out.println("Digite 1 para aprovar o artigo e 0 para recusar");
												Scanner scanner38 = new Scanner(System.in);
												try {
													int avalia = scanner38.nextInt();
													Participante.getProgramC(cpf).validaArtigo(titulo, avalia);
												}catch (InputMismatchException e){
													System.out.println("Erro: Você deve inserir um número!");
												}
												break;
											case 3:
												System.out.println("Lista dos especialistas:");
												Participante.getProgramC(cpf).listaEspecialista();
												break;
											case 4:
												sair5 = true;
												break;
											default:
												System.out.println("Opção Invalida");
												break;
										}
									}catch (InputMismatchException e){
										System.out.println("Erro: Você deve inserir um número!");
									}
								}
							// Menu do General Chair
							}else if(Participante.getTipoparticipante(cpf) == 'g') {
								boolean sair2 = false;
								while(sair2 == false) {
									System.out.println();
									System.out.println("Menu para general chair");
									System.out.println();
									System.out.println("Escolha uma dessas opções: ");
									System.out.println("1 - Validar inscrição de participante");
									System.out.println("2 - Invalidar inscrição de participante");
									System.out.println("3 - Emitir certificado para participante");
									System.out.println("4 - Listar Participantes");
									System.out.println("5 - Sair");
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
												System.out.println();
												System.out.print("Digite o cpf de um participante para emitir o certificado: ");
												Scanner scanner13 = new Scanner(System.in);
												String cpf3 = scanner13.next();
												General_Chairs.emitirCertificado(cpf3);
												break;
											case 4:
												System.out.println("Lista dos participantes:");
												General_Chairs.listaParticipantes();
												break;
											case 5:
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
					case 2: // Inscrição
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
					case 3: // Ver artigos aprovados
						Pessoa.listaArtigos_aprovados();
						break;
					case 4: // Ver artigos reprovados
						Pessoa.listaArtigos_reprovados();
						break;
					case 5: // Ver todos os artigos
						Pessoa.listaDadosArtigos();
						break;
					case 6: // Sair do sistema
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
