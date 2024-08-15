package br.ufpb.dcx.ayla.agenda;

import java.io.IOException;

public class ProgramaAgenda2 {
    public static void main(String[] args) {
        Agenda sistema = new AgendaAyla();

        try{
            sistema.recuperarDados();
            sistema.cadastraContato("João", 30, 05);
            sistema.cadastraContato("Maria", 30,05);
            System.out.println(sistema.pesquisaAniversariantes(30,05).size());
        }catch (IOException e){
            //ok
            sistema.cadastraContato("Gabriela", 12,04);
            System.out.println(sistema.pesquisaAniversariantes(12,04));
        }
    }
}
