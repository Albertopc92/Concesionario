package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class About extends JDialog {

	private static final long serialVersionUID = 1L;


	/**
	 * Create the dialog.
	 */
	public About() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 442, 219);
		getContentPane().add(scrollPane);

		JTextArea textAreaAbout = new JTextArea();
		textAreaAbout.setEditable(false);
		scrollPane.setViewportView(textAreaAbout);
		textAreaAbout.setText("Concesionario IES Gran Capit\u00E1n\r\n\r\nVersion: (1.0)\r\nCopyright 2017.\r\n\r\nRealizado por:\r\n\tAlberto Pérez Cano");

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(293, 239, 91, 23);
		getContentPane().add(btnOk);
	}
}
