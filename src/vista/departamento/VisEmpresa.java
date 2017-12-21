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
import modelo.revista.Articulo;

public class VisEmpresa extends JInternalFrame implements ActionListener {
	private JTextField txtNombre;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextArea txtListado;
	private JButton guardar;
	private JButton limpiar;
	private JButton salir;
	private JComboBox escojer;
	private GestionDepartamento gd;

	public VisEmpresa(GestionDepartamento gd) {
		this.gd = gd;
		initComponents();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(600, 250);
		setClosable(true);
		setMaximizable(true);
		setMaximizable(true);
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout gridbad = new GridBagLayout();
		Container cp = getContentPane();
		JPanel dato = new JPanel();
		dato.setLayout(gridbad);
		txtNombre = new JTextField(10);
		txtRuc = new JTextField(10);
		txtDireccion = new JTextField(10);
		txtListado = new JTextArea(10, 15);
		dato.setLayout(gridbad);
		JLabel tex1 = new JLabel(" Nombre de la Empresa: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex1, gbc);
		dato.add(tex1);
		txtNombre = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtNombre, gbc);
		dato.add(txtNombre);
		JLabel tex2 = new JLabel(" Ruc de la empresa: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex2, gbc);
		dato.add(tex2);
		txtRuc = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtRuc, gbc);
		dato.add(txtRuc);
		JLabel tex3 = new JLabel(" Direccion de la empresa");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex3, gbc);
		dato.add(tex3);
		txtDireccion = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.fill = 1;
		gridbad.setConstraints(txtDireccion, gbc);
		dato.add(txtDireccion);
		JLabel tex4 = new JLabel(" Escoja departamento");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = 1;
		gbc.weightx = 1.0;
		gridbad.setConstraints(tex4, gbc);
		dato.add(tex4);
		buscarDepartamento();
		gbc.gridx = 1;
		gbc.gridy = 3;
		dato.add(escojer, gbc);
		dato.setBorder(BorderFactory.createTitledBorder("DATOS DE LA Empresa"));
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

	private void buscarDepartamento() {
		// TODO Auto-generated method stub
		Vector mo = new Vector();
		List<Departamento> departamentos = gd.getDepartamentos();
		for (int i = 0; i < departamentos.size(); i++) {
			Departamento depa = departamentos.get(i);
			mo.addElement(depa);

		}
		escojer = new JComboBox(mo);
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
		String nombre = txtNombre.getText();
		String ruc = txtRuc.getText();
		String direccion = txtDireccion.getText();
		try {
				if (gd.isEsenci(nombre, ruc, direccion)) {
					if(gd.isChoose((Departamento) escojer.getSelectedItem())){
						gd.agregarEmpresa(nombre, ruc, direccion, (Departamento) escojer.getSelectedItem());
						//leer() ;
						listar();
						limpiar();
					}
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			e.printStackTrace();
		}
		}

	private void listar() {
		// TODO Auto-generated method stub
		List<Empresa> empresas = gd.getEmpresas();
		for (int i = 0; i < empresas.size(); i++) {
			Empresa emp = empresas.get(i);
			System.out.println("Nombre=" + emp.getNombre() + " " + emp.getRuc() + " " + emp.getDireccion() + " "+ (Departamento) escojer.getSelectedItem());
			txtListado.append(emp.getNombre()+" "+emp.getRuc()+" "+emp.getDireccion()+" "+ (Departamento) escojer.getSelectedItem()+"\n");
		}
	}

//	public void leer() throws IOException {
//		txtListado.append(gd.leerEmpresa());
//	}
	private void limpiar() {
		// TODO Auto-generated method stub
		txtNombre.setText("");
		txtRuc.setText("");
		txtDireccion.setText("");
	}

	private void salir() {
		// TODO Auto-generated method stub
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
