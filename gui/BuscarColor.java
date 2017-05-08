package gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import concesionario.Coche;
import java.awt.event.ActionEvent;

public class BuscarColor extends Plantilla {

	private static final long serialVersionUID = 1L;
	private ArrayList<Coche> concesionarioCopia = new ArrayList<Coche>();

	/**
	 * Create the dialog.
	 */
	public BuscarColor() {
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					indiceCoche = 0;
					concesionarioCopia = concesionario.getCochesColor(getColor());
					mostrarCoche(indiceCoche);
					comprobarBotones();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "No hay coches del color seleccionado!", "Aceptar",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCoche(++indiceCoche);
				comprobarBotones();
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCoche(--indiceCoche);
				comprobarBotones();
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
	
	/**
	 * Muestra el coche
	 * @param indiceCoche
	 */
	protected void mostrarCoche(int indiceCoche) {
		switch (concesionarioCopia.get(indiceCoche).getColor()) {
		case PLATA:
			rdbtn_Plata.setSelected(true);
			break;
		case ROJO:
			rdbtn_Rojo.setSelected(true);
			break;
		case AZUL:
			rdbtn_Azul.setSelected(true);
		}
		textField_Matricula.setText(concesionarioCopia.get(indiceCoche).getMatricula());
		comboBox_Marca.setSelectedItem(concesionarioCopia.get(indiceCoche).getModelo().getMarca());
		comboBox_Modelo.setSelectedItem(concesionarioCopia.get(indiceCoche).getModelo());
	}
	
	
	/**
	 * comprueba el estado de los botones y los habilita/deshabilita cuando es necesario
	 */
	@Override
	protected void comprobarBotones() {
		if (indiceCoche + 1 >= concesionarioCopia.size()) {
			btnAdelante.setEnabled(false);
		} else {
			btnAdelante.setEnabled(true);
		}
		if (indiceCoche - 1 == -1) {
			btnAtras.setEnabled(false);
		} else {
			btnAtras.setEnabled(true);
		}
	}
}
