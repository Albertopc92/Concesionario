package gui;


import concesionario.Concesionario;
import javax.swing.JButton;
import javax.swing.JDialog;

import concesionario.Coche;
import concesionario.Color;
import concesionario.Marca;
import concesionario.Modelo;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Plantilla extends JDialog {

	private static final long serialVersionUID = 1L;
	protected JTextField textField_Matricula;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JRadioButton rdbtn_Plata, rdbtn_Rojo, rdbtn_Azul;
	protected JComboBox<Marca> comboBox_Marca;
	protected JComboBox<Modelo> comboBox_Modelo;
	protected JButton btnAtras;
	protected JButton btnAdelante;
	protected JButton btnAccion;
	protected Concesionario concesionario = ConcesionarioGUI.concesionario;


	private Object[] getModelo(JComboBox comboBox_Marca) {
		Marca marca = (Marca) comboBox_Marca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}

	Color getColor() {
		if (rdbtn_Plata.isSelected())
			return Color.PLATA;
		else if (rdbtn_Rojo.isSelected())
			return Color.ROJO;
		else if (rdbtn_Azul.isSelected())
			return Color.AZUL;
		else
			return null;
	}

	/**
	 * Create the dialog.
	 */
	public Plantilla() {
		setTitle("Alta");
		setModal(true);
		setBounds(100, 100, 423, 275);
		getContentPane().setLayout(null);

		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(42, 25, 69, 14);
		getContentPane().add(lblMatrcula);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(42, 66, 46, 14);
		getContentPane().add(lblColor);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(42, 110, 46, 14);
		getContentPane().add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(42, 155, 46, 14);
		getContentPane().add(lblModelo);

		textField_Matricula = new JTextField();
		textField_Matricula.addFocusListener(new FocusAdapter() {
			/**
			 * Cuando la matricula pierde el foco la convierte a mayusculas
			 */
			@Override
			public void focusLost(FocusEvent arg0) {
				textField_Matricula.setText(textField_Matricula.getText().toUpperCase());
			}
		});
		textField_Matricula.setBounds(98, 22, 159, 20);
		getContentPane().add(textField_Matricula);
		textField_Matricula.setColumns(10);

		rdbtn_Plata = new JRadioButton("Plata");
		buttonGroup.add(rdbtn_Plata);
		rdbtn_Plata.setBounds(94, 62, 69, 23);
		getContentPane().add(rdbtn_Plata);

		rdbtn_Rojo = new JRadioButton("Rojo");
		buttonGroup.add(rdbtn_Rojo);
		rdbtn_Rojo.setBounds(165, 62, 69, 23);
		getContentPane().add(rdbtn_Rojo);

		rdbtn_Azul = new JRadioButton("Azul");
		buttonGroup.add(rdbtn_Azul);
		rdbtn_Azul.setBounds(231, 62, 59, 23);
		getContentPane().add(rdbtn_Azul);

		comboBox_Marca = new JComboBox<Marca>();
		comboBox_Marca.setModel(new DefaultComboBoxModel<Marca>(Marca.values()));
		comboBox_Marca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				actualizarModelo();
			}
		});
		comboBox_Marca.setBounds(98, 106, 91, 22);
		getContentPane().add(comboBox_Marca);
		
		comboBox_Modelo = new JComboBox<Modelo>();
		comboBox_Modelo.setBounds(98, 151, 91, 22);
		getContentPane().add(comboBox_Modelo);
		actualizarModelo();

		btnAccion = new JButton("A\u00F1adir");
		btnAccion.setBounds(196, 198, 91, 23);
		getContentPane().add(btnAccion);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(297, 198, 91, 23);
		getContentPane().add(btnSalir);
		
		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtras.setBounds(231, 123, 46, 46);
		getContentPane().add(btnAtras);
		
		btnAdelante = new JButton(">");
		btnAdelante.setBounds(295, 123, 46, 46);
		getContentPane().add(btnAdelante);

	}
	
	private void actualizarModelo() {
		comboBox_Modelo.setModel(new DefaultComboBoxModel(getModelo(comboBox_Marca)));
	}
	
	/**
	 * Pone los campos indicados en blanco
	 */
	protected void clear() {
		textField_Matricula.setText("");
		buttonGroup.clearSelection();
		comboBox_Marca.setSelectedItem(null);
		comboBox_Modelo.setSelectedItem(null);	
	}
	/**
	 * Muestra un coche
	 * @param coche
	 */
	protected void mostrarCoche(Coche coche) {
		switch (coche.getColor()) {
		case PLATA:
			rdbtn_Plata.setSelected(true);
			break;
		case ROJO:
			rdbtn_Rojo.setSelected(true);
			break;
		case AZUL:
			rdbtn_Azul.setSelected(true);
		}
		comboBox_Marca.addItem(coche.getModelo().getMarca());
		comboBox_Marca.setSelectedItem(coche.getModelo().getMarca());
		comboBox_Modelo.addItem(coche.getModelo());
		comboBox_Modelo.setSelectedItem(coche.getModelo());
	}
}
