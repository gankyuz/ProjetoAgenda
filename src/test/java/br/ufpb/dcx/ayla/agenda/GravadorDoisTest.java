package br.ufpb.dcx.ayla.agenda;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Contato;
import br.ufpb.dcx.ayla.agenda.Gravador.GravadorDois;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GravadorDoisTest {

    @Test
    public void testaGravador() throws IOException {
        File arquivoContatos = new File(GravadorDois.ARQUIVO_CONTATOS);
        if(arquivoContatos.exists()){
            arquivoContatos.delete();
        }
        GravadorDois g1 = new GravadorDois();
        File arquivo = new File(GravadorDois.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String, Contato> c1 = new HashMap<>();
        c1.put("Ayla", new Contato("Ayla", 05, 10));
        g1.gravaContatinhos(c1);
        assertTrue(arquivo.exists());
        arquivo.delete();
    }
    @Test
    public void testaRecuperacao() throws IOException{
        File arquivoContatos = new File(GravadorDois.ARQUIVO_CONTATOS);
        if(arquivoContatos.exists()){
            arquivoContatos.delete();
        }
        GravadorDois g1 = new GravadorDois();
        File arquivo = new File(GravadorDois.ARQUIVO_CONTATOS);
        assertFalse(arquivo.exists());
        HashMap<String, Contato> c1 = new HashMap<>();
        c1.put("Ayla", new Contato("Ayla", 05, 10));
        g1.gravaContatinhos(c1);
        assertTrue(arquivo.exists());
        HashMap<String, Contato> contatosRecuperados = g1.recuperaContatinhos();
        Contato c2 = contatosRecuperados.get("Ayla");
        assertEquals(05, c2.getDiaAniversario());
        assertEquals(10, c2.getMesAniversario());
        assertEquals("Ayla", c2.getNome());

        arquivo.delete();
    }

}
