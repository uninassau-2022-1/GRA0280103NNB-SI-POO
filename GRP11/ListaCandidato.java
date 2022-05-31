public class ListaCandidato extends Partido {
    private int votos;
	 
	public ListaCandidato (String nome, int numero, String partido) {
		this.setNome(nome); /// Polimorfismo.
		this.setNumero(numero);
		this.setPartido(partido);
		
	}
	
	public int getVotos() {
		return votos;
	}
	
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public void Votar() {
		votos++;
	}
	
}