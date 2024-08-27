package br.ufpb.dcx.ayla.agenda.Controller;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Agenda;
import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Contato;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

public class AgendaSearchController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;

    public AgendaSearchController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dia = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o dia do mês a pesquisar? [1-31]"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o mês a pesquisar?[1-12]" ));
        try {
            agenda.recuperarDados();
            Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);
            if (aniversariantes.size()>0){
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Aniversariantes encontrados:");
                for (Contato c: aniversariantes){
                    JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
                }
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal,
                        "Não foi encontrado nenhum aniversariante nesta data");
            }
        }catch (IOException a){
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
        /*Collection<Contato> aniversariantes = agenda.pesquisaAniversariantes(dia, mes);
        if (aniversariantes.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariantes encontrados:");
            for (Contato c: aniversariantes){
                JOptionPane.showMessageDialog(janelaPrincipal, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Não foi encontrado nenhum aniversariante nesta data");
        }*/
    }
}
