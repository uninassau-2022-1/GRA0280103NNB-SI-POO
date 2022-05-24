package Repositorio;

import java.util.ArrayList;
import java.util.List;

import Model.Eleitor;

public class RepEleitor implements IRepEleitor {
	
	private List<Eleitor> ListaEleitor = new ArrayList<>();
	private static RepEleitor instancia;
	
	public static RepEleitor getInstancia() {
        if (instancia == null) {
            instancia = new RepEleitor();
        }
        return instancia;
    }
	
	@Override
	public void Add(Eleitor eleitor) {
		ListaEleitor.add(eleitor);
		
	}

	@Override
	public String mostrarEleitor(String titulo) {
		String msg="";
		for(Eleitor e : ListaEleitor) {
			if(e != null && e.getTitulo() == titulo) {
			msg +="Nome: "+e.getNome()+
				  "\nTitulo: "+e.getTitulo()+
				  "\n";	
			}
		}
		return msg;
	}

	@Override
	public void numeroEscolhido(String titulo, int numero) {
		for(Eleitor e : ListaEleitor) {
			if(e != null && e.getTitulo() == titulo) {
				e.setVotoEscolhido(numero);
			}
		}
	}
	
	

}
