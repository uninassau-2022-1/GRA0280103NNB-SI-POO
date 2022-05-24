package Model;

public class Eleitor extends Pessoa {
	private String titulo;
	private int votoEscolhido;

	public int getVotoEscolhido() {
		return votoEscolhido;
	}

	public void setVotoEscolhido(int votoEscolhido) {
		this.votoEscolhido = votoEscolhido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
