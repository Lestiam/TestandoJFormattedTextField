package br.com.exemplos.gui;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class TestandoJFormattedTextField extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        TestandoJFormattedTextField field = new TestandoJFormattedTextField();
        field.testaJFormattedTextField();
    }

    private void testaJFormattedTextField() {
        Container janela = getContentPane();
        setLayout(null);

        //Define os rótulos dos botões
        JLabel labelCep = new JLabel("CEP: ");
        JLabel labelTel = new JLabel("Telefone: ");
        JLabel labelCpf = new JLabel("CFP: ");
        JLabel labelData = new JLabel("DATA: ");
        labelCep.setBounds(50, 40, 100, 20);
        labelTel.setBounds(50, 80, 100, 20);
        labelCpf.setBounds(50, 120, 100, 20);
        labelData.setBounds(50, 160, 100, 20);

        //Define as máscaras
        MaskFormatter mascaraCep = null;
        MaskFormatter mascaraTel = null;
        MaskFormatter mascaraCpf = null;
        MaskFormatter mascaraData = null;

        try {
            mascaraCep = new MaskFormatter("#####-###");
            mascaraTel = new MaskFormatter("(##)#####-####");
            mascaraCpf = new MaskFormatter("#########-##");
            mascaraData = new MaskFormatter("##/##/####");

        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

        //Seta as máscaras nos objetos JFormattedTextField
        JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
        JFormattedTextField jFormattedTextTel = new JFormattedTextField(mascaraTel);
        JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
        JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
        jFormattedTextCep.setBounds(150, 40, 100, 20);
        jFormattedTextTel.setBounds(150, 80, 100, 20);
        jFormattedTextCpf.setBounds(150, 120, 100, 20);
        jFormattedTextData.setBounds(150, 160, 100, 20);

        //Adiciona os rótulos e os campos de textos com máscaras na tela
        janela.add(labelCep);
        janela.add(labelTel);
        janela.add(labelCpf);
        janela.add(labelData);
        janela.add(jFormattedTextCep);
        janela.add(jFormattedTextTel);
        janela.add(jFormattedTextCpf);
        janela.add(jFormattedTextData);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
