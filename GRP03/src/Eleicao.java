import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Eleicao {
    private final Map<Integer, Candidato> candidatos = new HashMap<>();

    private int votosNulos = 0;
    private int votosEmBranco = 0;


    public void addCandidato(int numero, String nome) {
        if (candidatos.size() == 5){
            iniciaEleicao();
        }else {
            Candidato candidato = new Candidato(nome);
            candidatos.put(numero, candidato);
            System.out.printf("%d candidatos cadastrados. Faltam %d.\n", candidatos.size(), 5-candidatos.size());
        }
    }

    public boolean iniciaEleicao(){
        return this.candidatos.size() == 5;
    }

    public Map<Integer, Candidato> getCandidatos() {
        return candidatos;
    }

    public int getVotosEmBranco() {
        return votosEmBranco;
    }

    public int getVotosNulos() {
        return votosNulos;
    }

    private void votoBranco() {
        this.votosEmBranco += this.getVotosEmBranco() + 1;
    }

    private void votoNulo() {
        this.votosNulos += this.getVotosNulos() + 1;
    }

    public String getNomeCandidato(int numeroCandidato) {
        return this.candidatos.get(numeroCandidato).getNomeCompleto();
    }

    public int getVotosCandidato(int numeroCandidato) {
        return this.candidatos.get(numeroCandidato).getVotos();
    }

    public void votar(int numeroCandidato) {
        Candidato candidato = this.candidatos.get(numeroCandidato);

        if (candidato != null) {
            candidato.addVoto();
        } else if (numeroCandidato == 0) {
            votoBranco();
        } else {
            votoNulo();
        }

        System.out.println("Voto computado!");
    }

    public Candidato numeroParaCandidato(int numero) {
        return candidatos.get(numero);
    }

    public void resetarEleicao() {
        this.votosNulos = 0;
        this.votosEmBranco = 0;

        
        for (Map.Entry<Integer, Candidato> linha : candidatos.entrySet()) {
            linha.getValue().zeraVotos();
        }

        System.out.println("Eleição resetada!");
    }

    public void mostraCandidatos() {
        for (Map.Entry<Integer, Candidato> linha : candidatos.entrySet()) {
            Integer numero = linha.getKey();
            Candidato nome = linha.getValue();

            System.out.printf("\n%s : Vote %d", nome, numero);
        }
    }

    public void mostraResultados() {
        List<Candidato> listaCandidatos = new ArrayList<>();
        listaCandidatos.addAll(candidatos.values());

       
        listaCandidatos.sort(Comparator.comparingInt(Candidato::getVotos).reversed());

        AtomicInteger cont = new AtomicInteger(1);

        listaCandidatos 
                .stream() 
                .map(s -> cont.getAndIncrement() + "º Lugar -> " + s.getNomeCompleto()) 
                .forEach(System.out::println); 
    }

    public void iniciarVotacao() {
        Scanner entrada = new Scanner(System.in);
        int voto = 0;
        while (voto != -1) {
            Interface.linha();
            mostraCandidatos();
            System.out.print("\nNúmero do candidato -> ");
            voto = entrada.nextInt();
            entrada.nextLine();

            this.votar(voto);
        }
        mostraResultados();
    }
}
