package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controlador.GestionDepartamento;
import controlador.GestionPaciente;
import controlador.GestionRevista;
import vista.Revista.VisArticulo;
import vista.Revista.VisAutor;
import vista.Revista.VisRevista;
import vista.Revista.VisTablaArticulo;
import vista.Revista.VisTablaAutor;
import vista.Revista.VisTablaRevista;
import vista.departamento.VisDepartamento;
import vista.departamento.VisEmpresa;
import vista.departamento.VisTablaDepartamento;
import vista.departamento.VisTablaEmpresa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public class MiVentana extends JFrame implements ActionListener {

	private JDesktopPane escritorio;
	private GestionRevista gr;
	private GestionDepartamento gd;
	private GestionPaciente gpa;

	public MiVentana() {
		initComplement();
		gr = new GestionRevista();
		gd = new GestionDepartamento();
		gpa = new GestionPaciente();

	}

	private void initComplement() {
		// TODO Auto-generated method stub
		setSize(950, 460);
		setTitle("MisVentanas");
		getContentPane().setLayout(new BorderLayout());

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		escritorio = new JDesktopPane();
		c.add(escritorio, BorderLayout.CENTER);

		JMenuBar barra = new JMenuBar();

		JMenu jugador = new JMenu("Jugador");
		JMenuItem juga = new JMenuItem("Ventana Jugador");
		juga.addActionListener(this);
		juga.setActionCommand("Jugador");

		jugador.add(juga);
		JMenu consulta = new JMenu("Consulta");
		JMenuItem con = new JMenuItem("Ventana Paciente");
		con.addActionListener(this);
		con.setActionCommand("Paciente");
		consulta.add(con);

		// Menu revistas
		JMenu revistas = new JMenu("Revistas");
		JMenuItem mnuVentana2 = new JMenuItem("Datos Revista");
		mnuVentana2.addActionListener(this);
		mnuVentana2.setActionCommand("mnuVentana2");
		revistas.add(mnuVentana2);
		
		JMenuItem mnuVentana1 = new JMenuItem("Datos Articulo");
		mnuVentana1.addActionListener(this);
		mnuVentana1.setActionCommand("mnuVentana1");
		revistas.add(mnuVentana1);
		
		JMenuItem mnuVentanaAu = new JMenuItem("Datos Autor");
		mnuVentanaAu.addActionListener(this);
		mnuVentanaAu.setActionCommand("mnuVentanaAu");
		revistas.add(mnuVentanaAu);

		JMenuItem lisAutores = new JMenuItem("Lista Autores");
		lisAutores.addActionListener(this);
		lisAutores.setActionCommand("lisAutores");
		revistas.add(lisAutores);

		JMenuItem lisArticulos = new JMenuItem("Lista Articulos");
		lisArticulos.addActionListener(this);
		lisArticulos.setActionCommand("lisArticulos");
		revistas.add(lisArticulos);

		JMenuItem lisRevistas = new JMenuItem("Lista Revistas");
		lisRevistas.addActionListener(this);
		lisRevistas.setActionCommand("lisRevistas");
		revistas.add(lisRevistas);

		JMenu mnuVentanas6 = new JMenu("Departamento");
		JMenuItem mnuVentanaDepa = new JMenuItem("Datos Departamento");
		JMenuItem mnuVentanaEmpe = new JMenuItem("Empresa");
		JMenuItem mnuVentanaListaDe = new JMenuItem("Listar Departamento");
		JMenuItem mnuVentanaListaEm = new JMenuItem("Listar Empresa");
		mnuVentanaDepa.addActionListener(this);
		mnuVentanaDepa.setActionCommand("mnuVentanaDepa");
		mnuVentanaEmpe.addActionListener(this);
		mnuVentanaEmpe.setActionCommand("mnuVentanaEmpe");
		mnuVentanaListaDe.addActionListener(this);
		mnuVentanaListaDe.setActionCommand("mnuVentanaListaDe");
		mnuVentanaListaEm.addActionListener(this);
		mnuVentanaListaEm.setActionCommand("mnuVentanaListaEm");
		mnuVentanas6.add(mnuVentanaDepa);
		mnuVentanas6.add(mnuVentanaEmpe);
		mnuVentanas6.add(mnuVentanaListaDe);
		mnuVentanas6.add(mnuVentanaListaEm);

		barra.add(revistas);
		;
		barra.add(mnuVentanas6);
		barra.add(jugador);
		barra.add(consulta);
		setJMenuBar(barra);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		System.out.println(comando);

		switch (comando) {
		case "mnuVentanaAu":
			datoAutor();
			break;
		case "mnuVentana1":
			datoArticulo();
			break;
		case "mnuVentana2":
			datoRevista();
			break;
		case "mnuVentanaDepa":
			datoDepartamento();
			break;
		case "mnuVentanaEmpe":
			datoEmpresa();
			break;
		case "mnuVentanaListaDe":
			ListarDepa();
			break;
		case "mnuVentanaListaEm":
			ListarEm();
			break;
		case "lisAutores":
			listaAutor();
			break;
		case "lisArticulos":
			listaArticulo();
			break;
		case "lisRevistas":
			listaRevista();
			break;
		case "Paciente":
			Paciente();
			break;
		default:
			break;

		}

	}

	public void Paciente() {
		vista.Paciente.VentanaPrincipal vr = new vista.Paciente.VentanaPrincipal();
		vr.setVisible(true);
		escritorio.add(vr);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// datos de la revista
	public void datoRevista() {
		VisRevista vr = new VisRevista(gr);
		vr.setVisible(true);
		escritorio.add(vr);
		try {
			vr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// datos del articulo
	public void datoArticulo() {
		VisArticulo va = new VisArticulo(gr);
		va.setVisible(true);
		escritorio.add(va);
		try {
			va.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void datoAutor(){
		VisAutor au= new VisAutor(gr);
		au.setVisible(true);
		escritorio.add(au);
		try {
			au.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// datos del departamento
	private void datoDepartamento() {
		VisDepartamento depa = new VisDepartamento(gd);
		depa.setVisible(true);
		escritorio.add(depa);
		try {
			depa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void datoEmpresa() {
		VisEmpresa emp = new VisEmpresa(gd);
		emp.setVisible(true);
		escritorio.add(emp);
		try {
			emp.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Listar departamento
	private void ListarDepa() {
		VisTablaDepartamento tbldepa = new VisTablaDepartamento(gd);
		tbldepa.setVisible(true);
		escritorio.add(tbldepa);
		try {
			tbldepa.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// lista de las empresas
	private void ListarEm() {
		VisTablaEmpresa tblem = new VisTablaEmpresa(gd);
		tblem.setVisible(true);
		escritorio.add(tblem);
		try {
			tblem.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ventana de las listas de los autores

	public void listaAutor() {
		VisTablaAutor ta = new VisTablaAutor(gr);
		ta.setVisible(true);
		escritorio.add(ta);
		try {
			ta.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ventana de las listas de los articulos
	public void listaArticulo() {
		VisTablaArticulo tar = new VisTablaArticulo(gr);
		tar.setVisible(true);
		escritorio.add(tar);
		try {
			tar.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ventan de las listas de las revistas
	public void listaRevista() {
		VisTablaRevista tr = new VisTablaRevista(gr);
		tr.setVisible(true);
		escritorio.add(tr);
		try {
			tr.setSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
