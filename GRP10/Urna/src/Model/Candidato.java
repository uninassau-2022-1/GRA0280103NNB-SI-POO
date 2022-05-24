package Model;

public class Candidato extends Pessoa{

	private Partido partido;
	private int quantidadeVotos;
		
//	public Candidato(Partido partido, int quantidadeVotos) {
//		
//		this.partido = partido;
//		this.quantidadeVotos = quantidadeVotos;
//	}
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public int getQuantidadeVotos() {
		return quantidadeVotos;
	}
	public void setQuantidadeVotos(int quantidadeVotos) {
		this.quantidadeVotos = quantidadeVotos;
	}
	
	
}
