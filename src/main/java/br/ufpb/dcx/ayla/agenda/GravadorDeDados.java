package br.ufpb.dcx.ayla.agenda;

import java.io.*;
import java.util.*;

public class GravadorDeDados {

    public static final String ARQUIVO_CONTATOS = "contatos.dat";



    public void gravaTextoEmArquivo(Map<String, Contato> contatos, String nomeArquivo) throws IOException{
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Contato s: contatos.values()){
                gravador.write(s+"\n");
            }
        }finally {
            if (gravador!=null){
                gravador.close(); //fecha o stream(fluxo) de escrita
            }
        }
    }
    /**public HashMap<String, Contato> recuperaTextoDeArquivo(String nomeArquivo) throws IOException{
        BufferedReader leitor = null;
        HashMap<String, Contato> textoLido = new LinkedHashMap<>();
        try{
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;
            do {
                texto = leitor.readLine(); // lê a próxima linha do arquivo
                if (texto!=null){
                    textoLido.put(texto, );
                }
            }
        }
    }**/
    public void gravaContatos(Map<String, Contato> contatos)throws IOException{
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS));
            out.writeObject(contatos);
        }catch(FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo contato.dat",e);
        }catch (IOException e){
            throw e;
        }finally {
            if (out!=null){
                out.close();
            }
        }

    }

    public HashMap<String, Contato> recuperarContatos() throws IOException{
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS));
            return (HashMap<String, Contato>) in.readObject();
        }catch (FileNotFoundException e){
            throw new IOException("Não foi encontrado arquivo" +ARQUIVO_CONTATOS,e);
        }catch (IOException e){
            throw e;
        }catch (ClassNotFoundException e){
            throw new IOException("Classe dos objetos gravados no arquivo "+ARQUIVO_CONTATOS+" não existe",e);

        }finally {
            if (in!= null){
                in.close();
            }
        }
    }

}
