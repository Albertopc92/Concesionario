package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarColor extends Plantilla {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public BuscarColor() {
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAnterior();
			}
		});
		actualizar();
		setTitle("Buscar por color");
		btnAccion.setText("Buscar");
		comboBox_Modelo.setEnabled(false);
		comboBox_Marca.setEnabled(false);
		textField_Matricula.setEnabled(false);
		setBounds(100, 100, 450, 300);
	}

}
