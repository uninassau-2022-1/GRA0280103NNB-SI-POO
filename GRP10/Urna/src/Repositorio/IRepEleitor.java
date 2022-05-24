package Repositorio;

import Model.Eleitor;

public interface IRepEleitor {
	
	public void Add(Eleitor eleitor);	
	public String mostrarEleitor(String titulo);
	public void numeroEscolhido(String titulo, int numero);
	
}
