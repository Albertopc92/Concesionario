package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import concesionario.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta extends Plantilla {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Alta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnAdelante.setVisible(false);
		btnAtras.setVisible(false);
		
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (concesionario.annadir(textField_Matricula.getText(), getColor(),
							(Modelo) comboBox_Modelo.getSelectedItem())) {
						JOptionPane.showMessageDialog(getContentPane(), "Coche a�adido con exito");
						clear();
					}

				} catch (Exception exception) {
					textField_Matricula.setBackground(Color.RED);
					JOptionPane.showMessageDialog(getContentPane(), "El coche no se ha podido a�adir." + exception.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
					textField_Matricula.setBackground(Color.WHITE);
				}
			}
		});

}}
