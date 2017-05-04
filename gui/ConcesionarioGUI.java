package gui;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import concesionario.Concesionario;
import ficheros.Fichero;
import ficheros.Filtro;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConcesionarioGUI {

	private JFrame frmConcesionario;
	private About about;
	private Alta alta;
	private Baja baja;
	private BuscarMatricula buscarMatricula;
	private BuscarColor buscarColor;
	private Ayuda ayuda;
	private MostrarConcesionario mostrarConcesionario;
	protected static Concesionario concesionario = new Concesionario();
	private Filtro filtro = new Filtro(".obj", "Objeto");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConcesionarioGUI window = new ConcesionarioGUI();
					window.frmConcesionario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConcesionarioGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionario = new JFrame();
		frmConcesionario.setResizable(true);
		frmConcesionario.setTitle("Concesionario - " + Fichero.fichero.getName());
		frmConcesionario.setBounds(100, 100, 650, 428);
		frmConcesionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConcesionario.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 655, 21);
		frmConcesionario.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setMnemonic('A');
		menuBar.add(mnNewMenu);

		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo Concesionario");
		mntmNuevoConcesionario.addActionListener(new ActionListener() {
			/**
			 * Crea un nuevo concesionario
			 */
			public void actionPerformed(ActionEvent arg0) {
				nuevoConcesionario();
			}
		});
		mntmNuevoConcesionario
				.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnNewMenu.add(mntmNuevoConcesionario);

		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir Concesionario...");
		mntmAbrirConcesionario.addActionListener(new ActionListener() {
			/**
			 * Abre un concesionario ya existente
			 */
			public void actionPerformed(ActionEvent e) {
				abrirConcesionario();
			}
		});
		mnNewMenu.add(mntmAbrirConcesionario);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			/**
			 * Guarda un concesionario en uso
			 */
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			/**
			 * Permite guardar con la accion Guardar Como...
			 */
			public void actionPerformed(ActionEvent e) {
				guardarComo();
				concesionario.setModificado(false);
			}
		});
		mnNewMenu.add(mntmGuardarComo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.isModificado()){
					Object[] options = { "SI", "NO", "CANCELAR" };
					int respuesta = JOptionPane.showOptionDialog(null, "No has guardado, ¿Desea Guardar?", "NO HAS GUARDADO",
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if(respuesta == 0){
						guardarComo();
					}else if(respuesta == 1){
						System.exit(0);
					}
				}else{
					System.exit(0);
				}
					
			}
		});
		mnNewMenu.add(mntmSalir);

		JMenu mnCoche = new JMenu("Coche");
		mnCoche.setMnemonic('C');
		menuBar.add(mnCoche);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta = new Alta();
				alta.setVisible(true);
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoche.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baja = new Baja();
				baja.setVisible(true);
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnCoche.add(mntmBaja);

		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar Concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarConcesionario = new MostrarConcesionario();
				mostrarConcesionario.setVisible(true);
			}
		});
		mnCoche.add(mntmMostrarConcesionario);

		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);

		JMenuItem mntmPorMatricula = new JMenuItem("Por matricula");
		mntmPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarMatricula = new BuscarMatricula();
				buscarMatricula.setVisible(true);
			}
		});
		mnBuscar.add(mntmPorMatricula);

		JMenuItem mntmPorColor = new JMenuItem("Por color");
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarColor = new BuscarColor();
				buscarColor.setVisible(true);
			}
		});
		mnBuscar.add(mntmPorColor);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('H');
		menuBar.add(mnAyuda);

		JMenuItem mntmSobreConcesionario = new JMenuItem("Sobre Concesionario");
		mntmSobreConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about = new About();
				about.setVisible(true);
			}
		});
		
		JMenuItem mntmVerLaAyuda = new JMenuItem("Ver la ayuda");
		mntmVerLaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ayuda ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerLaAyuda);
		mnAyuda.add(mntmSobreConcesionario);
	}

	/**
	 * Metodo que permite la creacion de un nuevo archivo concesionario
	 */
	private void nuevoConcesionario() {
		if (concesionario.isModificado()) {
			Object[] options = { "SI", "NO", "CANCELAR" };
			int respuesta = JOptionPane.showOptionDialog(null, "No has guardado, ¿Desea Guardar?", "NO HAS GUARDADO",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (respuesta == 0) {
				guardarComo();
				Fichero.setFichero("SinTitulo");
				concesionario = new Concesionario();
				frmConcesionario.setTitle(Fichero.fichero.getName());
				concesionario.setModificado(false);
			} else if (respuesta == 1) {
				Fichero.setFichero("SinTitulo");
				concesionario = new Concesionario();
				frmConcesionario.setTitle(Fichero.fichero.getName());
				concesionario.setModificado(false);
			} else {
			}
		} else {
			Fichero.setFichero("SinTitulo");
			concesionario = new Concesionario();
			frmConcesionario.setTitle(Fichero.fichero.getName());
			concesionario.setModificado(false);
		}
	}

	/**
	 * Abre un concesionario existente
	 */
	private void abrirConcesionario() {
		if (concesionario.isModificado()) {
			Object[] options = { "SI", "NO", "CANCEL" };
			int respuesta = JOptionPane.showOptionDialog(null, "No has guardado, ¿Desea Guardar?", "NO HAS GUARDADO",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			if (respuesta == 0) {
				guardarComo();
			} else if (respuesta == 1) {
				try {
					abrirFicheroFileChooser();
				} catch (IOException | ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Error al abrir fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
					Fichero.nuevo();
				}
			} else {
			}
		} else {
			try {
				abrirFicheroFileChooser();
			} catch (IOException | ClassNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Error al abrir fichero", "ERROR", JOptionPane.ERROR_MESSAGE);
				Fichero.nuevo();
			}

		}
	}

	/**
	 * Metodo que crea un FileChooser
	 * 
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void abrirFicheroFileChooser() throws FileNotFoundException, ClassNotFoundException, IOException {
		JFileChooser abrir = new JFileChooser();
		abrir.setAcceptAllFileFilterUsed(false);
		abrir.addChoosableFileFilter(filtro);
		if (abrir.showDialog(abrir, "Abrir Fichero") == JFileChooser.APPROVE_OPTION) {
			Fichero.fichero = abrir.getSelectedFile();
			concesionario = (Concesionario) Fichero.abrir(abrir.getSelectedFile());
			frmConcesionario.setTitle(Fichero.getFichero().getName());
			concesionario.setModificado(false);

		}
	}
	
	/**
	 * Metodo que permite guardar un fichero
	 */
	private void guardar() {
		if (Fichero.fichero.getName().equalsIgnoreCase("SinTitulo")) {
			guardarComo();
			concesionario.setModificado(false);
		} else {
			try {
				Fichero.guardar(concesionario);
				concesionario.setModificado(false);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error al guardar", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * 
	 * Metodo que permite guardar un fichero con la accion guardar como...
	 */
	private void guardarComo() {
		JFileChooser guardarComo = new JFileChooser();
		guardarComo.setAcceptAllFileFilterUsed(false);
		guardarComo.addChoosableFileFilter(filtro);

		if (JFileChooser.APPROVE_OPTION == guardarComo.showDialog(guardarComo, "Guardar Archivo")) {

			guardarComo.setAcceptAllFileFilterUsed(false);
			Fichero.comprobarFichero(guardarComo.getSelectedFile());
			if (Fichero.getFichero().exists()) {
				Object[] options = { "Si", "No" };
				int respuesta = JOptionPane.showOptionDialog(null, "El archivo ya existe, ¿Desea Sobreescribir?",
						"Guardando", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
						options[0]);
				if (respuesta == 0) {
					try {
						Fichero.guardarComo(concesionario, Fichero.getFichero());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "El archivo no se ha guardado", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}else{
				guardar();
			}

			frmConcesionario.setTitle(Fichero.getFichero().getName());
			concesionario.setModificado(false);
		}
	}
}