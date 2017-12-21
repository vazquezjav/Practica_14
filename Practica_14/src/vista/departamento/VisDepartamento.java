package vista.departamento;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionDepartamento;
import modelo.departamento.Departamento;
import modelo.departamento.Empresa;

public class VisDepartamento extends JInternalFrame implements ActionListener {
	private JTextField txtNombreEm;
	private JTextField txtApellidoEm;
	private JTextField txtCedula;
	private JTextField txtNombreDepa;
	private JTextField txtCodigo;
	private JTextArea txtListado;
	private JButton guardar;
	private JButton limpiar;
	private JButton salir;
	private GestionDepartamento gd;

	public VisDepartamento(GestionDepartamento gd) {
		this.gd = gd;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(800, 350);
		setClosable(true);
		setMaximizable(true);
		setMaximizable(true);
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gridbad = new GridBagLayout();
		Container cp = getContentPane();
		JPanel dato = new JPanel();
		dato.setLayout(gridbad);
		txtNombreEm = new JTextField(10);
		txtCedula = new JTextField(10);
		txtNombreDepa = new JTextField(10);
		txtListado = new JTextArea(20, 25);
		dato.setLayout(gridbad);
		JLabel tex1 = new JLabel(" Nombre del empleado ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex1, gbc);
		dato.add(tex1);
		txtNombreEm = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtNombreEm, gbc);
		dato.add(txtNombreEm);
		JLabel tex2 = new JLabel(" apellido  ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex2, gbc);
		dato.add(tex2);
		txtApellidoEm = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtApellidoEm, gbc);
		dato.add(txtApellidoEm);
		JLabel tex3 = new JLabel(" cedula");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex3, gbc);
		dato.add(tex3);
		txtCedula = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtCedula, gbc);
		dato.add(txtCedula);
		JLabel tex4 = new JLabel(" nombre del departamento");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex4, gbc);
		dato.add(tex4);
		txtNombreDepa = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtNombreDepa, gbc);
		dato.add(txtNombreDepa);
		JLabel tex5 = new JLabel(" codigo del departameto");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex5, gbc);
		dato.add(tex5);
		txtCodigo = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtCodigo, gbc);
		dato.add(txtCodigo);
		dato.setBorder(BorderFactory.createTitledBorder("DATOS DEL DEPARTAMETNO"));
		cp.add(dato, BorderLayout.CENTER);
		JPanel dato3 = new JPanel();
		dato3.setLayout(new FlowLayout());
		dato3.add(txtListado);
		gridbad.setConstraints(txtListado, gbc);
		dato3.add(txtListado);
		dato.setBorder(BorderFactory.createTitledBorder("listado"));
		cp.add(dato3, BorderLayout.EAST);
		JPanel dato2 = new JPanel();
		JButton boton1 = new JButton("Guardar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton1.addActionListener(this);
		boton1.setActionCommand("btnGuardar");
		dato2.add(boton1);
		JButton boton2 = new JButton("Limpiar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton2.addActionListener(this);
		boton2.setActionCommand("btnLimpiar");
		dato2.add(boton2);
		JButton boton3 = new JButton("Salir");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton3.addActionListener(this);
		boton3.setActionCommand("btnSalir");
		dato2.add(boton3);
		JButton boton4 = new JButton("Listar");
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.fill = 1;
		boton4.addActionListener(this);
		boton4.setActionCommand("btnListar");
		dato2.add(boton4);
		dato.setBorder(BorderFactory.createTitledBorder(""));
		cp.add(dato2, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		System.out.println("evento boton" + comando);
		switch (comando) {
		case "btnSalir":
			salir();
			break;
		case "btnGuardar":
			guardar();
			break;
		case "btnLimpiar":
			limpiar();
			break;
		case "btnListar":
			listar();
			break;
		default:
			break;
		}
	}

	private void guardar() {
		// TODO Auto-generated method stub
		String nombreEm = txtNombreEm.getText();
		String apellidoEm = txtApellidoEm.getText();
		String cedula = txtCedula.getText();
		String nombreDepa = txtNombreDepa.getText();
		String codigo = txtCodigo.getText();
		try {
			if (gd.isEsenci2(nombreEm, apellidoEm, cedula, nombreDepa, codigo)) {
				if (gd.isCedulaValida(cedula)) {
					gd.agregarDepartamento(nombreEm, apellidoEm, cedula, nombreDepa, codigo);
					limpiar();
//					leer();
					listar();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}

	}

	private void listar() {
		List<Departamento> departamentos = gd.getDepartamentos();
		for (int i = 0; i < departamentos.size(); i++) {
			Departamento depa = departamentos.get(i);
			System.out.println("Nombre del departamento :" + depa.getNombredepa() + " codigo del departamento :"
					+ depa.getCodigo() + " " + depa.getEmpleados());
		}
	}

//	public void leer() throws IOException {
//		txtListado.append(gd.leerDepartamento());
//	}

	private void limpiar() {
		txtNombreEm.setText("");
		txtApellidoEm.setText("");
		txtCedula.setText("");
		txtNombreDepa.setText("");
		txtCodigo.setText("");
	}

	private void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "Usted esta saliend del programa ", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "El programa se reanulara", "MSJ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
