package src;

import java.util.*;

public class Urna {

    private static int totalVotos;

    public static void main(String[] args) {


        Partido partido1 = new Partido("PSL", "17");
        Partido partido2 = new Partido("PT", "13");
        Partido partido3 = new Partido("PSOL", "50");

        Candidato candidato1 = new Candidato("Niedson", "33", partido1);
        Candidato candidato2 = new Candidato("João", "30", partido2);
        Candidato candidato3 = new Candidato("Randerson", "29", partido3);

       List<Candidato> candidatos = new ArrayList<>();

        candidatos.add(candidato1);
        candidatos.add(candidato2);
        candidatos.add(candidato3);

        Scanner teclado = new Scanner(System.in);

        var rerpetir = true;

        do{
            System.out.println("Escolha :\n1-votar\n2-Apurar votos");

            var menu = teclado.nextInt();
            switch (menu) {
                case 1 -> {
                    System.out.println("Digite o numero do candidato");
                    var voto = teclado.next();
                    if (!voto.matches("^\\d+$")) {
                        System.out.println("Digite um número válido");
                        break;
                    }
                    int indexCandidato = buscarCandidato(candidatos, voto);
                    if (indexCandidato >= 0) {
                        System.out.println("Confirma?\n1-Sim\n2-Não");
                        var confirmacao = teclado.next();
                        if(confirmacao.equals("1")){
                            candidatos.get(indexCandidato).setQtdVotos();
                            totalVotos++;
                        }else if(confirmacao.equals("2")){
                            System.out.println("Tente novamente!");
                        } else  {
                            System.out.println("Entrada inválida");
                        }

                    } else {
                        System.out.println("numero do candidáto invalido");
                    }
                    break;
                }
                case 2 -> {
                    if (totalVotos > 0) {
                        System.out.println("Apuração de votos");
                        apuracao(candidatos);
                    } else {
                        System.out.println("Eleição não realizada");
                    }
                    rerpetir = false;
                }
                default -> System.out.println("Opção inválida");
            }
        }while (rerpetir);

    }

    private static void apuracao(List<Candidato> candidatos) {
        Collections.sort(candidatos);
        var i = 0;

        if(candidatos.get(0).getQtdVotos() == candidatos.get(2).getQtdVotos()){
            System.out.println("Empate entre o candidato: \n"+candidatos.get(0)+"\n e o candidato: \n"+candidatos.get(1));
            i++;
        }
        for (Candidato candidato: candidatos) {
            if (i==0){
                System.out.println(candidato+"\nGanhou a eleição com "+candidato.getQtdVotos()+" votos, "+(candidato.getQtdVotos()*100/totalVotos)+"%");
                i++;
            }else {
                System.out.println(candidato+"\nteve "+candidato.getQtdVotos()+" votos, "+(candidato.getQtdVotos()*100/totalVotos)+"%");
            }
        }
    }

    private static int buscarCandidato(List<Candidato> candidatos, String voto) {
        for (int i =0; i<candidatos.size(); i++) {

            if (candidatos.get(i).getPartido().getNumero().equals(voto)) {
                System.out.println(candidatos.get(i));

                return i;
            } else if( i == candidatos.size()){
                System.out.println("Candidato não encontrado!");
            }
        }
        return -1;
    }

}


