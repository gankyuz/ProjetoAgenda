package br.ufpb.dcx.ayla.agenda.Gravador;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Contato;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDois {
    public static final String ARQUIVO_CONTATOS= "contatinhos.dat";
    public HashMap<String, Contato> recuperaContatinhos() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))){
            return (HashMap<String, Contato>) in.readObject();
        }catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }
    public void gravaContatinhos(Map<String, Contato> contato) throws IOException{
        try(ObjectOutputStream in = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))){
            in.writeObject(contato);
        }
    }
}
