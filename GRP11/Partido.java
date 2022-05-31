public class Partido extends Candidato /* Herança */ {
	private int numero;    // Encapsulamento
    private String partido; // Encapsulamento
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getPartido() {
		return partido;
	}
}