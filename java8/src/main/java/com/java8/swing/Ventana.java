package com.java8.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventana extends JFrame implements ActionListener {

    String[] Rut = {"20583773619","20968025420","22456736720","21029594120","20886090920"};
    String[] Nombre={"Aliante","Calderon","Cañete","Fernandez","Henriquez"};
    String[] email={"s.aliante01@ufromail.cl","g.calderon05@ufromail.cl", "n.canete01@ufromail.cl","n.fernandez07@ufromail.cl","m.henriquez11@ufromail.cl"};
    JButton boton;

    protected Ventana(String nombre, int largoX, int largoY) {
        super(nombre);
        super.setVisible(true);
        super.setDefaultCloseOperation(3);
        super.setSize(largoX, largoY);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        this.setLayout(null);
    }
    public  Ventana(){
    }

    public void Curso() {
        Ventana v1 = new Ventana("Curso ICC264",500,400);
        v1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JComboBox lista = new JComboBox(Rut);
        JComboBox lista1= new JComboBox(Nombre);
        JComboBox lista2= new JComboBox(email);
        lista.setBounds(20,20,100,30);
        v1.add(lista);
        boton = new JButton();
        boton.setText("Nuevo estudiante");
        boton.setBounds(320,300,150,20);
        this.add(boton);
        boton.addActionListener(this);
        v1.add(boton);
        JLabel etiqueta = new JLabel();
        JLabel etiqeta2 = new JLabel();
        etiqueta.setText("Nombre: ");
        etiqeta2.setText("Email: ");
        etiqueta.setBounds(50,70,100,40);
        etiqeta2.setBounds(50,90,100,40);
        v1.add(etiqueta);
        v1.add(etiqeta2);
        JTextField cajon = new JTextField(5);
        JTextField cajon2 = new JTextField(5);
        cajon.setBounds(100,80,200,20);
        cajon2.setBounds(100,110,200,20);
        v1.add(cajon);
        v1.add(cajon2);
        lista.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    cajon.setText((String) lista1.getSelectedItem());
                }
                if (e.getStateChange()==ItemEvent.SELECTED){
                    cajon2.setText((String) lista2.getSelectedItem());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton){
            Ventana v2 = new Ventana();
            v2.setTitle("Agregar Nuevo estudiante");
            v2.setSize(500,400);
            v2.setVisible(true);
            v2.setLayout(null);
            v2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JLabel etiqueta = new JLabel();
            JLabel etiqueta1 = new JLabel();
            JLabel etiqueta2 = new JLabel();
            etiqueta.setText("Rut");
            etiqueta1.setText("Nombre");
            etiqueta2.setText("Email");
            etiqueta.setBounds(10,100,100,40);
            etiqueta1.setBounds(10,120,100,40);
            etiqueta2.setBounds(10,140,100,40);
            v2.add(etiqueta);
            v2.add(etiqueta1);
            v2.add(etiqueta2);
            JTextField cajon= new JTextField();
            JTextField cajon1= new JTextField();
            JTextField cajon2= new JTextField();
            cajon.setBounds(100,110,100,20);
            cajon1.setBounds(100,130,100,20);
            cajon2.setBounds(100,150,100,20);
            v2.add(cajon);
            v2.add(cajon1);
            v2.add(cajon2);

        }
    }
}

