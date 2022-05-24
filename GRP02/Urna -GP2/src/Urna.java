import java.util.ArrayList;
import java.util.Scanner;
public class Urna {

	public static void main(String[] args) {
		ArrayList<Candidato> Candidatos = new ArrayList<Candidato>();
		Candidatos.add(new Candidato(12, "Zé Vaqueiro", "ZZ"));
		Candidatos.add(new Candidato(15, "Wesley Safadão", "WS"));
		Candidatos.add(new Candidato(19, "Ulisses Guimarans", "HH"));

		Scanner teclado = new Scanner(System.in);
		int Escolha, EscolhaCand, Numero, Consulta, ContadorVoto = 0;
		String Nome, Partido;

		do {
			
			System.out.println("Escolha uma das opcoes:      ");
			System.out.println("Opcao 1 - Consulta           ");
			System.out.println("Opcao 2 - Votar              ");
			System.out.println("Opcao 3 - Apuracao de votos ");
			System.out.println("Opcao 4 - Sair               ");
			
			Escolha = teclado.nextInt();

			switch (Escolha) {
			case 1:
				Urna.clearConsole("");
				do {
					System.out.println("Escolha uma das opcoes:           ");
					System.out.println("Opcao 1 - Todos os candidatos     ");
					System.out.println("Opcao 2 - Apenas 1 candidato      ");
					System.out.println("Opcao 3 - Volta menu              ");
					
					EscolhaCand = teclado.nextInt();

					if (EscolhaCand == 1) {
						Urna.clearConsole("");
						
						System.out.println("Seus candidatos sao:    ");
						for (int i = 0; i < Candidatos.size(); i++) {
							System.out.println("Nome: " + Candidatos.get(i).getNome() + ", Partido: "
									+ Candidatos.get(i).getPartido() + ", Votos: " + Candidatos.get(i).getVotos());

						}
						System.out.println("Total de candidatos: " + Candidatos.size() + "");
						
					} else if (EscolhaCand == 2) {
						Urna.clearConsole("");
						
						System.out.println("Digite o numero do candidato:   ");
						Consulta = teclado.nextInt();
						
						for (int i = 0; i < Candidatos.size(); i++) {
							if (Candidatos.get(i).getNumero() == Consulta) {
								System.out.println("Seu candidato e: ");
								System.out.println("Nome: " + Candidatos.get(i).getNome() + ", Partido: "
										+ Candidatos.get(i).getPartido() + ", Votos: " + Candidatos.get(i).getVotos());
								
								break;
							}

						}

					}
				} while (EscolhaCand != 3);

				Urna.clearConsole("Voltando ao menu principal.");
				break;
			case 2:
				do {
					System.out.println("Digite um numero do candidato a ser votado: ");
					Consulta = teclado.nextInt();

					int i;
					for (i = 0; i < Candidatos.size(); i++) {
						if (Candidatos.get(i).getNumero() == Consulta) {
							break;
						}
					}
					if (i != Candidatos.size()) {
						Candidatos.get(i).Votar();
						ContadorVoto++;

						System.out.println("Obrigado por votar!");

					} else {

						System.out.println("Candidato invalido! ");

					}
					System.out.println("Para continuar votando digite 1");
				} while (teclado.nextInt() != 9999);
				break;
			case 3:
				Urna.clearConsole("");
				
				System.out.println("Validando votos...  ");
				System.out.println("Votos validos:      ");

				int maior = 0;
				int indexVencedor = -1;
				ArrayList empatados = new ArrayList<Integer>();

				for (int j = 0; j < Candidatos.size(); j++) {
					System.out.println("Nome: " + Candidatos.get(j).getNome() + ", Partido: "
							+ Candidatos.get(j).getPartido() + ", Votos: " + Candidatos.get(j).getVotos());

					System.out.println("Media de votos: " + (Candidatos.get(j).getVotos() * 100) / ContadorVoto + "%");
					if (Candidatos.get(j).getVotos() > maior) {
						maior = Candidatos.get(j).getVotos();
						indexVencedor = j;
					} else if (Candidatos.get(j).getVotos() == maior) {
						empatados.add(indexVencedor);
						empatados.add(j);
					}
				}
				
				System.out.println("Total de candidatos: " + Candidatos.size() + "");
				System.out.println("Total de votos: " + ContadorVoto + "");
				System.out.println("Candidato vencedor: " + Candidatos.get(indexVencedor).getNome());

				System.out.println("Obrigado a todos que votaram. ");
				
				Escolha = 5;
				break;
			case 4:
				
				System.out.println("Saindo... ");
				System.out.println("Obrigado. Pela paciencia. ");
				
				break;
			default:
			
				System.out.println("Opcao invalida! Tente novamente. ");
			}

		} while (Escolha != 4);

	}

	public static void clearConsole(String mensagem) {
		for (int i = 0; i < 1050; ++i) {
			System.out.println();
		}
		if (mensagem.length() > 0) {
			
			System.out.println("" + mensagem + "");
			
		}
	}
}