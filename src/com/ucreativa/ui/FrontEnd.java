package com.ucreativa.ui;

import com.ucreativa.repositories.FileRepository;
import com.ucreativa.services.CatalogoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String titulo){
        super(titulo);
    }

    public void build(){
        this.construccionPantalla();
        this.crearComponentas();
        super.setVisible(true);

    }

    private void construccionPantalla(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500,250);
        super.setLayout(new GridLayout(4,2));
    }

    private void crearComponentas(){

        JLabel lblMarca = new JLabel("Marca");
        //JTextField txtMarca = new JTextField();
        JComboBox cbMarca = new JComboBox();

        cbMarca.addItem("Toyota");
        cbMarca.addItem("Nissan");
        cbMarca.addItem("Mazda");
        cbMarca.addItem("Suzuki");
        cbMarca.addItem("Honda");
        cbMarca.addItem("Jeep");

        this.agregarComponente(lblMarca);
        this.agregarComponente(cbMarca);

        JLabel lblModelo = new JLabel("Modelo");
        JTextField txtModelo = new JTextField();
        this.agregarComponente(lblModelo);
        this.agregarComponente(txtModelo);

        JLabel lblColor = new JLabel("Color");
        JComboBox cbColor = new JComboBox();

        cbColor.addItem("Blanco");
        cbColor.addItem("Rojo");
        cbColor.addItem("Azul");
        cbColor.addItem("Negro");
        cbColor.addItem("Verde");
        cbColor.addItem("Gris");


        this.agregarComponente(lblColor);
        this.agregarComponente(cbColor);

        JLabel lblPuertas = new JLabel("Cantidad de Puertas");
        JTextField txtPuertas = new JTextField();
        this.agregarComponente(lblPuertas);
        this.agregarComponente(txtPuertas);

        JLabel lblIsNuevo = new JLabel("Es Nuevo?");
        JCheckBox ckbIsNuevo = new JCheckBox();
        this.agregarComponente(lblIsNuevo);
        this.agregarComponente(ckbIsNuevo);

        JLabel lblIsGarantia = new JLabel("Garantia?");
        JCheckBox ckbIsGarantia = new JCheckBox();
        this.agregarComponente(lblIsGarantia);
        this.agregarComponente(ckbIsGarantia);

        JLabel lblPlaca = new JLabel("Placa");
        JTextField txtPlaca = new JTextField();
        this.agregarComponente(lblPlaca);
        this.agregarComponente(txtPlaca);

        ckbIsNuevo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblIsGarantia.setVisible(ckbIsNuevo.isSelected());
                ckbIsGarantia.setVisible(ckbIsNuevo.isSelected());
                lblPlaca.setVisible(!ckbIsNuevo.isSelected());
                txtPlaca.setVisible(!ckbIsNuevo.isSelected());

            }
        });

        JButton btnAgregar = new JButton("Agregar");
        this.agregarComponente(btnAgregar);

        btnAgregar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CatalogoService service = new CatalogoService(new FileRepository());
                try{
                    service.save(
                        (String)cbMarca.getSelectedItem(),
                        txtModelo.getText(),
                        (String)cbColor.getSelectedItem(),
                        ckbIsNuevo.isSelected(),
                        txtPuertas.getText(),
                        ckbIsGarantia.isSelected(),
                        txtPlaca.getText());


                    String reporte = String.join("\n", service.get());
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), reporte);


                }catch (ErrorEnCantPuertasException error) {
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(),
                            error.getMessage());

                }
            }
        });











    }

    private void agregarComponente(Component component){
        super.getContentPane().add(component);
    }





}
