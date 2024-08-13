package br.ufpb.dcx.ayla.agenda;

public class Contato {

    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int diaAniversario, int mesAniversario) {
        this.nome = nome;
        this.diaAniversario = diaAniversario;
        this.mesAniversario = mesAniversario;
    }

    public Contato() {
        this("", 0, 0);
    }
}
