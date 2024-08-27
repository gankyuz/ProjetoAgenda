package br.ufpb.dcx.ayla.agenda.Controller;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Agenda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgendaAddController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;

    public AgendaAddController(Agenda agenda, JFrame janela){
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do aniversariante?");
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o dia do mês em nasceu?[1-31]"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o mês em que nasceu?[1-12]"));
        boolean cadastrou = agenda.cadastraContato(nome, dia,mes);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariante Cadastrado <3");
            try {
                agenda.salvarDados();
            }catch (IOException a){
                JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
            }
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Aniversariante não foi cadastrado. "+
                    "Verifique se já não existia8");
        }
    }

}
