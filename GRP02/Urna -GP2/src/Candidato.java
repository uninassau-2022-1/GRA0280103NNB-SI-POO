public class Candidato extends Partido {
	private int Votos;
	
	public Candidato(int Numero, String Nome, String Partido) {
		this.setNumero(Numero);
		this.setNome(Nome);
		this.setPartido(Partido);
		
	}
	
	public int getVotos() {
		return Votos;
	}
	
	public void setVotos(int Votos) {
		this.Votos = Votos;
	}
	
	public void Votar() {
		Votos++;
	}
	
}