package entities;

public class Candidates {

	private String nome;
	private String partido;
	private String numero;
	int votos = 0;

	public Candidates(String numero, String nome, String partido) {
		this.numero = numero;
		this.nome = nome;
		this.partido = partido;
	}

	public void Votar() {
		votos++;
	}

	public int getVotos() {
		return votos;
	}

	public String getNumero() {
		return numero;
	}

	public String getNome() {
		return nome;
	}

	public String getPartido() {
		return partido;
	}
}
