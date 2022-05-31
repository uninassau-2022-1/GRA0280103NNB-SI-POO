import java.util.ArrayList;
import java.util.Scanner;

public class Urna {

	public static void main(String[] args) {
		ArrayList<ListaCandidato> Candidatos = new ArrayList<ListaCandidato>();
		Candidatos.add(new ListaCandidato("Fabio Santos", 55, "TE"));
		Candidatos.add(new ListaCandidato("Camila Silva", 25, "PE"));
		Candidatos.add(new ListaCandidato("Marcus Antonio", 10, "AM"));
		Candidatos.add(new ListaCandidato("Everal Costa", 45, "AP"));

		Scanner cadastro = new Scanner(System.in);
		int opcoes, opcoesCandidato, consulta;
		int contadorVoto = 0;

		do {
			System.out.println(" Digite abaixo o número de sua escolha:     ");
			System.out.println(" 1 - Consulta          ");
			System.out.println(" 2 - Votar             ");
			System.out.println(" 3 - Apuração de votos ");
			System.out.println(" 4 - Sair              ");

			opcoes = cadastro.nextInt();

			switch (opcoes) {
			case 1:
				Urna.clearConsole("");
				do {
					System.out.println(" Filtrar por uma das opções: ");
					System.out.println(" 1 - Lista de candidatos  ");
					System.out.println(" 2 - Candidato especifíco ");
					System.out.println(" 3 - Voltar para o menu   ");

					opcoesCandidato = cadastro.nextInt();

					if (opcoesCandidato == 1) {
						Urna.clearConsole("Aguarde um instante... ");
						System.out.println(" Os candidatos são:               ");
						for (int i = 0; i < Candidatos.size(); i++) {
							System.out.println(" Nome: " + Candidatos.get(i).getNome() + ", Partido: "
									+ Candidatos.get(i).getPartido() + ", Votos: " + Candidatos.get(i).getVotos());

						}
						System.out.println(" Total de candidatos: " + Candidatos.size());
					} else if (opcoesCandidato == 2) {
						Urna.clearConsole("");
						System.out.println(" Informe o número do candidato:     ");
						consulta = cadastro.nextInt();
						for (int i = 0; i < Candidatos.size(); i++) {
							if (Candidatos.get(i).getNumero() == consulta) {
								System.out.println(" Seu candidato parece ser esse: ");
								System.out.println(" Nome: " + Candidatos.get(i).getNome() + ", Partido: "
										+ Candidatos.get(i).getPartido() + ", Votos: " + Candidatos.get(i).getVotos());
								break;
							}
						}
					}
				} while (opcoesCandidato != 3);
				break;
			case 2:
			Urna.clearConsole("Resetando informações... ");
				System.out.println("Digite um número do candidato a ser votado: ");
				consulta = cadastro.nextInt();
				int i;
				for (i = 0; i < Candidatos.size(); i++) {
					if (Candidatos.get(i).getNumero() == consulta) {
						break;
					}
				}
				if (i != Candidatos.size()) {
					Candidatos.get(i).Votar();
					contadorVoto++;
					System.out.println("Obrigado. Seu voto foi computado.");;
				} else {
					System.out.println("Candidato inexistente!");

				}
				break;
			case 3:
				Urna.clearConsole("");
				System.out.println(" Avaliando votos...                       ");
				System.out.println(" Votos válidos:                           ");

				for (int j = 0; j < Candidatos.size(); j++) {
					System.out.println("| Nome: " + Candidatos.get(j).getNome() + ", Partido: "
							+ Candidatos.get(j).getPartido() + ", Votos: " + Candidatos.get(j).getVotos());
				}
				System.out.println(" Total de candidatos: " + Candidatos.size() + "");
				System.out.println(" Total de votos: " + contadorVoto );
				System.out.println(" Fim da votação!");
				opcoes = 5;
				break;
			case 5:
				System.out.println(" Fazendo logout...");
				System.out.println(" Pronto. Obrigado por usar nosso sistema.");
				break;
			default:
				System.out.println("Não reconheci a opção. Por favor, tente novamente. ");
			}
		} while (opcoes != 5);
		cadastro.close();
	}
	public static void clearConsole(String mensagem) {
		for (int i = 0; i < 1050; ++i) {
			System.out.println();
		}
		if (mensagem.length() > 0) {
			System.out.println(" " + mensagem);
		}
	}
}