package src;

import java.util.Objects;

public class Candidato extends Pessoa implements Comparable<Candidato> {

    private Partido partido;
    private int qtdVotos;

    public Candidato(String nome, String idade, Partido partido) {
        super(nome, idade);
        this.partido = partido;
        this.qtdVotos = 0;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getQtdVotos() {
        return qtdVotos;
    }

    public void setQtdVotos() {
        this.qtdVotos++;
    }

    @Override
    public String toString() {
        return "Candidato" +
                "\nnome: " +getNome()+
                "\npartido: " + partido;
    }

    @Override
    public int compareTo(Candidato o) {
        return Integer.compare(o.getQtdVotos(), this.qtdVotos);
    }
}

