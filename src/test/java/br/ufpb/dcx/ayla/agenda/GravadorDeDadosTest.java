package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;

public class GravadorDeDadosTest {

    @Test
    public void testaGravadorDeDados(){
        GravadorDeDados gravador = new GravadorDeDados();
        Map<String, Contato> tb = new HashMap<>();
        try {
            gravador.gravaContatos(tb);
        }catch (Exception e){
            //ok
        }
    }
}
