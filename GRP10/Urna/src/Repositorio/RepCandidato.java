package Repositorio;

	import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Candidato;

	public class RepCandidato implements IRepCandidato {
		
		private List<Candidato> ListaCandidato = new ArrayList<>();
		private static RepCandidato instancia;
		
		public static RepCandidato getInstancia() {
	        if (instancia == null) {
	            instancia = new RepCandidato();
	        }
	        return instancia;
	    }
		
		@Override
		public void Add(Candidato C) {
			ListaCandidato.add(C);	
		}

		@Override
		public String mostrarCandidatoPorNumero(int numero) {
			String msg="";
			if(numero != 0) {
				for(Candidato c : ListaCandidato) {
					if(c != null && c.getPartido().getNumero() == numero) {
					msg +="| Nome: "+c.getNome()+
						  "\n| Partido: "+c.getPartido().getNome()+
						  "\n| Número do partido: "+c.getPartido().getNumero()+
						  "\n";	
					}			
				}
				if(msg == "") {
					msg = "Candidato inexistente";
				}
			}else {
				msg = "Branco";
			}
			return msg;
		}
		
		@Override
	    public void acrescentarVoto(int numero) {
			for(int i = 0; i < ListaCandidato.size(); i++) {
				if(ListaCandidato.get(i) != null && ListaCandidato.get(i).getPartido().getNumero() == numero) {
					ListaCandidato.get(i).setQuantidadeVotos(ListaCandidato.get(i).getQuantidadeVotos()+1);
				}
			}

	    }

		@Override
		public String mostrarTodosCandidato() {
			String msg="";
			for(Candidato c : ListaCandidato) {
				if(c.getPartido().getNumero() != 0) {
				msg +="| Nome: "+c.getNome()+
					  "\n| Partido: "+c.getPartido().getNome()+
					  "\n| Número do partido: "+c.getPartido().getNumero()+
					  "\n| Total de votos: "+c.getQuantidadeVotos()+
					  "\n\n";
				}
			}
			return msg;
		}

		@Override
		public String vencedor() {
			String msg="";			
			int maiorQunatidadeVotos=0;
			int  aux=0;
			for(int i = 0; i < ListaCandidato.size(); i++) {
				if(ListaCandidato.get(i).getQuantidadeVotos() > maiorQunatidadeVotos) {
					maiorQunatidadeVotos = ListaCandidato.get(i).getQuantidadeVotos();
				}				
			}
			String media = calculo(maiorQunatidadeVotos);
			for(Candidato c : ListaCandidato) {
				if(c.getQuantidadeVotos() == maiorQunatidadeVotos) {
					aux++;
					msg +=
						  "\ncom o partido "+c.getPartido().getNome()+
						  "\ne aos seus "+c.getIdade()+" anos o PRESIDENTE vencedorª é "+c.getNome()+
						  "\ncom total de "+c.getQuantidadeVotos()+" votos"+
						  "\ncom "+media+"% dos votos"+
						  "\n";
				}
				if(aux > 1)
					msg = "HOUVE UM EMPATE";
			}
			return msg;
		}

		@Override
		public String calculo(int maiorVoto) {
			DecimalFormat df = new DecimalFormat("#.00");			
			int  soma=0;
			double aux;
			for(int i = 0; i < ListaCandidato.size(); i++) {
				soma += ListaCandidato.get(i).getQuantidadeVotos();		
			}
			aux = (maiorVoto/soma)*100;
		

			return df.format(aux).toString();
		}

		@Override
		public String mostrarTodosCandidatoSemVotos() {
			String msg="";
			for(Candidato c : ListaCandidato) {
				if(c.getPartido().getNumero() != 0) {
				msg +="| Nome: "+c.getNome()+
					  "\n| Partido: "+c.getPartido().getNome()+
					  "\n| Número do partido: "+c.getPartido().getNumero()+
					  "\n\n";
				}
			}
			return msg;
		}
}

	
