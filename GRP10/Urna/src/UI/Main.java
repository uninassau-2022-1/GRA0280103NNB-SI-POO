package UI;

import java.util.Random;
import java.util.Scanner;

import Model.Candidato;
import Model.Eleitor;
import Model.Partido;
import Repositorio.RepCandidato;
import Repositorio.RepEleitor;

public class Main {
	static Scanner sc = new Scanner(System.in);
	private static String auxTitulo;
	private static int jaVoltado=0;
	
	public static void main(String[] args) {
		
		criandoCandidatos();
		
		int opcao, aux=0;
		do {
			
			if(aux == 0) {
				CadastrarEleitor(0);
			}
			aux++;
			opcao = menu();
			
		} while (opcao != 0);
		
		resultado();		
	}

	private static void resultado() {		
		for(int i = 0; i < 100; i++)
			System.out.print("=");
		System.out.println();
		
		if(RepCandidato.getInstancia().vencedor() != "HOUVE UM EMPATE") {
			System.out.println();
			System.out.println("NOVO PREESIDENTE");
			System.out.println();
		}
		
		System.out.println(RepCandidato.getInstancia().vencedor());
			

		for(int i = 0; i < 100; i++)
			System.out.print("=");
	
	}

	private static void CadastrarEleitor(int n) {
		
		Eleitor e = new Eleitor();
		if(n == 1) {
			sc.nextLine();
		}
		
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite o titulo de elitor: ");
		String titulo = sc.nextLine();
		auxTitulo = titulo;
		Random r = new Random(); 
		int idade = r.nextInt(65);
		if(idade < 16) {
			idade = idade + 16;
		}
		e.setNome(nome);
		e.setTitulo(titulo);
		e.setIdade(idade);
		
		RepEleitor.getInstancia().Add(e);
		limparConsole();
		System.out.println(RepEleitor.getInstancia().mostrarEleitor(titulo));
	}

	private static void ApuracaoDeVotos() {
		limparConsole();
		System.out.println(RepCandidato.getInstancia().mostrarTodosCandidato());
		
	}

	private static void votar() {
		int aux = 2;
		while(aux != 1) {
		    System.out.println("Digite o numero do seu voto: ");
		    int numero = sc.nextInt();
		    System.out.println(RepCandidato.getInstancia().mostrarCandidatoPorNumero(numero));
		    System.out.println("1- Confirmar / 2- Cancelar / 3- Branco");
		    
		    aux = sc.nextInt();
		    if(aux == 1) {
		    	RepCandidato.getInstancia().acrescentarVoto(numero);
		    	RepEleitor.getInstancia().numeroEscolhido(auxTitulo, numero);
		    }
		    if(aux == 3) {
		    	RepCandidato.getInstancia().acrescentarVoto(0);
		    	RepEleitor.getInstancia().numeroEscolhido(auxTitulo, 0);
		    }
		}
		
		
	}

	private static void consultarCandidatos() {
		
		limparConsole();
		System.out.println(RepCandidato.getInstancia().mostrarTodosCandidatoSemVotos());
		
	}
	
	private static void limparConsole() {
		for(int i =0; i < 100; i++)
			System.out.println();
	}
	
	public static int menu() {
		
		System.out.println("================================");
		System.out.println("| Consultar candidato, digite 1|"); //ellen
		System.out.println("| Votar, digite 2              |");//alisson
		System.out.println("| Apuração de votos, digite 3  |");//lucas
		System.out.println("| Resultado Final, digite 0    |");
		System.out.println("================================");
		
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			consultarCandidatos();
			break;
		case 2:
			votar();
			limparConsole();
			System.out.println("próximo eleitor? 1-Sim / 2-não");
			int resp = sc.nextInt();
			jaVoltado++;
			if(resp ==1)
				CadastrarEleitor(1);
			else
				opcao = 0;			
			break;
		case 3:
			if(jaVoltado != 0)
				ApuracaoDeVotos();
			else
				System.out.println("Não houve votação");
			break;
		case 0:
			break;
		default:
			System.out.println("Digite uma opção válida.");
			break;
		}
		return opcao;
	}

	private static void criandoCandidatos() {
		Candidato c = new Candidato();
		Partido P = new Partido();
		c.setNome("João Barbosa Filho");
		c.setIdade(48);
		P.setNome("MNJS");
		P.setNumero(1);
		c.setPartido(P);
		
		RepCandidato.getInstancia().Add(c);
		
		Candidato c1 = new Candidato();
		Partido P1 = new Partido();
		
		c1.setNome("Marco Silva Paiva");
		c1.setIdade(37);
		P1.setNome("ABCD");
		P1.setNumero(2);
		c1.setPartido(P1);	
		RepCandidato.getInstancia().Add(c1);
		
		
		Candidato c2 = new Candidato();
		Partido P2 = new Partido();
		c2.setNome("Melissa Alves França");
		c2.setIdade(38);
		P2.setNome("SGTY");
		P2.setNumero(3);
		c2.setPartido(P2);
		
		RepCandidato.getInstancia().Add(c2);
		
		Candidato c3 = new Candidato();
		Partido P3= new Partido();
		c3.setNome("Branco");	
		P3.setNumero(0);
		c3.setPartido(P3);
		
		RepCandidato.getInstancia().Add(c3);
		
	}
	
	

}
