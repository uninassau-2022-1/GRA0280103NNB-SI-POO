import java.util.Scanner;

public class Interface {

    public static void telaInicial(boolean existeCandidatos, Eleicao eleicao){
        linha();

        System.out.println("1. Iniciar Eleição");

        if (!existeCandidatos) {
            System.out.println("2. Cadastrar Candidatos");
        }

        linha();

        System.out.print("-> ");

        int resposta = novaEntradaInteira();

        if (!existeCandidatos && resposta == 1) {
            System.out.println("Primeiro, você deve cadastrar candidatos!");
            telaInicial(false, null);
        }else {
            switch (resposta) {
                case 1:
                    eleicao.iniciarVotacao();
                    break;
                case 2:
                    if (!existeCandidatos) {
                        Eleicao eleicaoNova = new Eleicao();
                        adicionarCandidato(eleicaoNova);
                    }else {
                        telaInicial(false, null);
                    }
                    break;
            }
        }
    }

    public static void adicionarCandidato(Eleicao eleicao){
        if (eleicao.iniciaEleicao()) {
            eleicao.iniciarVotacao();
        } else {
            while (eleicao.getCandidatos().size() < 5) {
                linha();
                System.out.printf("\n\n%d candidatos cadastrados até o momento, faltam %d\n", eleicao.getCandidatos().size(), 5-eleicao.getCandidatos().size());

                System.out.print("Digite o nome do candidato a ser cadastrado: ");
                String nome = novaEntradaTexto();

                System.out.printf("\nDigite o número para votar em %s: ", nome);
                int numero = novaEntradaInteira();

                eleicao.addCandidato(numero, nome);
            }
            telaInicial(true, eleicao);
        }
    }

    public static void linha(){
        System.out.println("========================");
    }

    public static String novaEntradaTexto(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextLine();
    }

    public static int novaEntradaInteira(){
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();
        entrada.nextLine();
        return num;
    }

    public static double novaEntradaDouble(){
        Scanner entrada = new Scanner(System.in);
        double num = entrada.nextDouble();
        entrada.nextLine();
        return num;
    }
}
