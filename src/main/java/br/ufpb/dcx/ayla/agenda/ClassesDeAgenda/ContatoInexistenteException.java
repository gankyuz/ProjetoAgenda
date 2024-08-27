package br.ufpb.dcx.ayla.agenda.ClassesDeAgenda;

public class ContatoInexistenteException extends Exception{
    public ContatoInexistenteException(String msg){
        super(msg);
    }
    public ContatoInexistenteException(){
     super("Contato Inexistente");
    }
}
