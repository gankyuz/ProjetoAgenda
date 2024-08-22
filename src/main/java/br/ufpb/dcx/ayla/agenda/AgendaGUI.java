package br.ufpb.dcx.ayla.agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AgendaGUI extends JFrame {
    JLabel linha1,linha2;
    ImageIcon imagemFesta = new ImageIcon("./imgs/emojianiversario.png");


    public AgendaGUI(){
        setTitle("Agenda de Aniversários");
        setSize(400, 400);
        setLocation(0, 0);//localização da janela na tela
        setResizable(true);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Minha agenda de aniversário", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(imagemFesta, JLabel.CENTER);
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }
    public static void main(String []args){
        JFrame janela = new AgendaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
