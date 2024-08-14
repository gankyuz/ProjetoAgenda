package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaAylaTest {

    @Test
    public void testaAgendaAyla(){
        Agenda a1 = new AgendaAyla();
        assertTrue(a1.cadastraContato("Gabriela", 12,04));
        assertEquals(1 ,a1.pesquisaAniversariantes(12,04).size());
        try{
            assertTrue(a1.removeContato("João"));
            fail();
        }catch (ContatoInexistenteException e){
            //ok
        }
        /**a1.salvarDados();
        try{
            assertTrue(a1.);
        }catch (IOException e){

        }**/
    }
}
