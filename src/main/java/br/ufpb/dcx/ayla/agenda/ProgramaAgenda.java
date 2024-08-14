package br.ufpb.dcx.ayla.agenda;

import javax.swing.*;
import java.io.IOException;

public class ProgramaAgenda {
    public static void main(String[] args) {
        Agenda a2 = new AgendaAyla();
        try{
            a2.recuperarDados();
            boolean continuar = true;
            while (continuar){
                String opcao = JOptionPane.showInputDialog("1.Cadastrar\n2.Pesquisar\n3.Sair");
                switch (opcao) {
                    case "1":
                        String nome = JOptionPane.showInputDialog("Nome");
                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Mês:"));
                        a2.cadastraContato(nome, dia, mes);
                        break;
                    case "2":
                        int dia2 = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
                        int mes2 = Integer.parseInt(JOptionPane.showInputDialog("Mês:"));
                        JOptionPane.showMessageDialog(null,a2.pesquisaAniversariantes(dia2,mes2).size());
                        break;
                    case "3":
                        continuar = false;
                        break;
                }
            }
            a2.salvarDados();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
