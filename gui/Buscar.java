package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import concesionario.Coche;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Buscar extends Plantilla {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Buscar() {
		btnAccion.setText("Buscar");
		setTitle("Buscar por matr\u00EDcula");
		comboBox_Modelo.setEnabled(false);
		rdbtn_Azul.setEnabled(false);
		rdbtn_Rojo.setEnabled(false);
		rdbtn_Plata.setEnabled(false);
		comboBox_Marca.setEnabled(false);
		btnAdelante.setEnabled(false);
		btnAtras.setEnabled(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Coche coche = concesionario.get(textField_Matricula.getText());
				if (coche != null)
					mostrarCoche(coche);
				}catch (Exception exception) {
					JOptionPane.showMessageDialog(getContentPane(),"No existe ningún coche con esa matricula.", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		
	}

}
