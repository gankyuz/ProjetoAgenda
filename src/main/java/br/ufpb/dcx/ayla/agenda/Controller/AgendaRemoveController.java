package br.ufpb.dcx.ayla.agenda.Controller;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Agenda;
import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.ContatoInexistenteException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AgendaRemoveController implements ActionListener {
    private Agenda agenda;
    private JFrame janelaPrincipal;
    public AgendaRemoveController(Agenda agenda, JFrame janela) {
        this.agenda = agenda;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = JOptionPane.showInputDialog(janelaPrincipal,
                "Qual o nome do aniversariante a remover?");
        boolean removeu = false;
        try {
            agenda.recuperarDados();
            agenda.removeContato(nome);
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante removido com sucesso");
            agenda.salvarDados();
        } catch (ContatoInexistenteException ex) {
            JOptionPane.showMessageDialog(janelaPrincipal,
                    "Aniversariante não foi encontrado. "+
                            "Operação não realizada");
        }catch (IOException a){
            JOptionPane.showMessageDialog(janelaPrincipal, a.getMessage());
        }
    }
}
