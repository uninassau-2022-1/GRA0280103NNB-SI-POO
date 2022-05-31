public class Candidato extends Pessoa {
    private static int numeroCandidatos = 0;
    private final int numeroCandidato;
    private int votos = 0;

    public Candidato(String nome) {
        super(nome);
        this.numeroCandidato = Candidato.numeroCandidatos + 1;
        numeroCandidatos++;
    }

    public void addVoto(){
        this.votos += 1;
    }

    public void zeraVotos(){
        this.votos = 0;
    }

    public int getNumeroCandidato() {
        return numeroCandidato;
    }

    public static int getNumeroCandidatos() {
        return numeroCandidatos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public String toString() {
        return super.getNomeCompleto();
    }
}