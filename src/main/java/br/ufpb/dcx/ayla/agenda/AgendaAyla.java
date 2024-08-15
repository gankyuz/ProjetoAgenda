package br.ufpb.dcx.ayla.agenda;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AgendaAyla implements Agenda{

    private Map<String, Contato> contatos;
    private GravadorDeDados gravador;
    private GravadorDois record;

    public AgendaAyla(){
        this.contatos = new HashMap<>();
        this.gravador = new GravadorDeDados();
        this.record = new GravadorDois();
    }
    public void salvarDados() {
        try{
            gravador.gravaContatos(this.contatos);
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public void recuperarDados(){
        try {
            this.contatos = gravador.recuperarContatos();
        }catch (IOException e){
            System.err.println(e.getMessage());
            this.contatos = new HashMap<>();
        }
    }

    public boolean cadastraContato(String nome, int dia, int mes){
        Contato um = new Contato(nome, dia,mes);
        this.contatos.put(nome,um);

        if(this.contatos.containsValue(um)){
            return true;
        } else {
            return false;
        }
    }

    public Collection<Contato> pesquisaAniversariantes(int dia, int mes){
        Collection<Contato> listaNova = new ArrayList<>();

        for(Contato c: this.contatos.values()){
            if(c.getDiaAniversario() == dia && c.getMesAniversario() == mes){
                listaNova.add(c);
            }
        }

        return listaNova;
    }

    public boolean removeContato(String nome) throws ContatoInexistenteException{
        if(this.contatos.containsKey(nome)){
            this.contatos.remove(nome);
            return true;

        } else {
            throw new ContatoInexistenteException("O contato não existe com esse nome. ");
        }
    }



}
