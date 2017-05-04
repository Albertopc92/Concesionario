<<<<<<< HEAD
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import concesionario.Coche;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baja extends Plantilla {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Baja() {
		btnAccion.setText("Borrar");
		comboBox_Modelo.setEnabled(false);
		comboBox_Marca.setEnabled(false);
		rdbtn_Azul.setEnabled(false);
		rdbtn_Rojo.setEnabled(false);
		rdbtn_Plata.setEnabled(false);
		setTitle("Baja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnAdelante.setEnabled(false);
		btnAtras.setEnabled(false);

		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = concesionario.get(textField_Matricula.getText());
					if (coche != null) {
						mostrarCoche(coche);
						int n = JOptionPane.showOptionDialog(contentPanel, "¿Está seguro de que desea eliminarlo?",
								"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
								null);

						switch (n) {
						case JOptionPane.YES_OPTION:
							concesionario.eliminar(textField_Matricula.getText());
							clear();
							break;
						}
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(contentPanel, "No se ha podido eliminar." + exception.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
=======
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import concesionario.Coche;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baja extends Plantilla {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Baja() {
		btnAccion.setText("Borrar");
		comboBox_Modelo.setEnabled(false);
		comboBox_Marca.setEnabled(false);
		rdbtn_Azul.setEnabled(false);
		rdbtn_Rojo.setEnabled(false);
		rdbtn_Plata.setEnabled(false);
		setTitle("Baja");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		btnAdelante.setEnabled(false);
		btnAtras.setEnabled(false);

		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Coche coche = concesionario.get(textField_Matricula.getText());
					if (coche != null) {
						mostrarCoche(coche);
						int n = JOptionPane.showOptionDialog(contentPanel, "¿Está seguro de que desea eliminarlo?",
								"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
								null);

						switch (n) {
						case JOptionPane.YES_OPTION:
							concesionario.eliminar(textField_Matricula.getText());
							clear();
							break;
						}
					}
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(contentPanel, "No se ha podido eliminar." + exception.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
>>>>>>> ebb2624bf7cfc87a767ec1a733049750647eaf28
