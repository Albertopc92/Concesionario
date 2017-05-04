package gui;

import concesionario.Coche;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarConcesionario extends Plantilla {

	private static final long serialVersionUID = 1L;
	private int indiceCoche = -1;

	/**
	 * Create the dialog.
	 */
	public MostrarConcesionario() {
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		actualizar();
		comboBox_Modelo.setEnabled(false);
		comboBox_Marca.setEnabled(false);
		rdbtn_Azul.setEnabled(false);
		rdbtn_Rojo.setEnabled(false);
		rdbtn_Plata.setEnabled(false);
		textField_Matricula.setEnabled(false);
		btnAccion.setVisible(false);
		setTitle("Mostrar Concesionario");
		setBounds(100, 100, 450, 300);
		
	}
	
	/**
	 * Comprueba si hay coches en el concesionario, muesta el primer coche y comprueba el estado de los botones
	 */
	void actualizar() {
		if (concesionario.size() == 0) {
			return;
		}
		indiceCoche = 0;
		mostrarCoche(concesionario.get(indiceCoche));
		comprobarBotones();		
	}
	
	/**
	 * Muestra el siguiente coche del concesionario
	 */
	private void mostrarSiguiente() {
		mostrarCoche(concesionario.get(++indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * Muestra el coche anterior del concesionario
	 */
	private void mostrarAnterior() {
		mostrarCoche(concesionario.get(--indiceCoche));
		comprobarBotones();
	}
	
	/**
	 * comprueba el estado de los botones y los habilita/deshabilita cuando es necesario
	 */
	private void comprobarBotones() {
		if (concesionario.get(indiceCoche + 1) == null)
			btnAdelante.setEnabled(false);
		else
			btnAdelante.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			btnAtras.setEnabled(false);
		else
			btnAtras.setEnabled(true);
	}
	
	/**
	 * Muestra un coche
	 */
	@Override
	protected void mostrarCoche(Coche coche) {
		textField_Matricula.setText(coche.getMatricula());
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
