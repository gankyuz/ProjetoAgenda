package br.ufpb.dcx.ayla.agenda.GUI;

import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.Agenda;
import br.ufpb.dcx.ayla.agenda.ClassesDeAgenda.AgendaAyla;
import br.ufpb.dcx.ayla.agenda.Controller.AgendaAddController;
import br.ufpb.dcx.ayla.agenda.Controller.AgendaRemoveController;
import br.ufpb.dcx.ayla.agenda.Controller.AgendaSearchController;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AgendaGuiV3 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon boloImg = new ImageIcon("./imgs/bolo.jpg");
    ImageIcon addImg = new ImageIcon("./imgs/icons/add_person.png");
    ImageIcon pesqImg = new ImageIcon("./imgs/icons/search_person.png");
    ImageIcon removeImg = new ImageIcon("./imgs/icons/remove_person.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    Agenda agenda = new AgendaAyla();

    public AgendaGuiV3(){
        setTitle("Agenda de Aniversários");
        setSize(800,600); //tamanho da janela
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(new Color(249,229,188));

        linha1 = new JLabel("Minha agenda de aniversário", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));

        linha2 = new JLabel(boloImg, JLabel.CENTER);

        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));

        botaoPesquisar = new JButton("Pesquisar", pesqImg);
        botaoPesquisar.addActionListener(new AgendaSearchController(agenda, this));

        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));

        getContentPane().setLayout(new GridLayout(3,2)); //definindo as colunas

        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);

        getContentPane().add(linha2);
        getContentPane().add(botaoPesquisar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);

    }
    public static void main(String []args){
        JFrame janela = new AgendaGuiV3();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
