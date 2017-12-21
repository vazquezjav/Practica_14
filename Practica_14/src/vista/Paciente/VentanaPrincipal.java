package vista.Paciente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JInternalFrame implements ActionListener
{	
	private JDesktopPane escritorio;
	private controlador.GestionPaciente gd;
	public static Locale Localizacion;
	private JMenu ingreso,listar,idiomas;
	private JMenuItem consulta,paciente,medico,ventanaConsulta,ventanaPaciente,ventanaMedico;
	public VentanaPrincipal()
	{
		gd = new controlador.GestionPaciente();
		initComponentes();
	}
	public void initComponentes()
	{
		
		setSize(800,600);		
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();
		getContentPane().add(escritorio, BorderLayout.CENTER);
		setTitle("Paciente");
		JMenuBar barra = new JMenuBar();
		ingreso = new JMenu("Ingreso");
		listar = new JMenu("Listar");	
		
		consulta = new JMenuItem("Consulta");
		consulta.addActionListener(this);
		consulta.setActionCommand("consulta");
		ingreso.add(consulta);
		
		paciente = new JMenuItem("Paciente");
		paciente.addActionListener(this);
		paciente.setActionCommand("paciente");
		ingreso.add(paciente);
	
		medico = new JMenuItem("Medico");
		medico.addActionListener(this);
		medico.setActionCommand("medico");
		ingreso.add(medico);		
		barra.add(ingreso);
		
		ventanaPaciente = new JMenuItem("VentanaPaciente");
		ventanaPaciente.addActionListener(this);
		ventanaPaciente.setActionCommand("ventanaPaciente");
		listar.add(ventanaPaciente);
		
		ventanaMedico= new JMenuItem("VentanaMedico");
		ventanaMedico.addActionListener(this);
		ventanaMedico.setActionCommand("ventanaMedico");
		listar.add(ventanaMedico);	
		
		ventanaConsulta= new JMenuItem("VentanaConsulta");
		ventanaConsulta.addActionListener(this);
		ventanaConsulta.setActionCommand("ventanaConsulta");
		listar.add(ventanaConsulta);	
		
		barra.add(listar);
	
		
		setJMenuBar(barra);		
	}
	public void actionPerformed(ActionEvent accion) {
		
		String comando = accion.getActionCommand();
		System.out.println("Eventos  " + comando);
		switch (comando) {
		case "consulta":
			VentanaConsulta va = new VentanaConsulta(gd);
			va.setVisible(true);
			escritorio.add(va);
			try {
				va.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "paciente":
			VentanaPaciente un = new VentanaPaciente(gd);
			un.setVisible(true);
			escritorio.add(un);
			try {
				un.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "medico":
			VentanaMedico car = new VentanaMedico(gd);
			car.setVisible(true);
			escritorio.add(car);
			try {
				car.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaPaciente":
			VistaPaciente vi = new VistaPaciente(gd);
			vi.setVisible(true);
			escritorio.add(vi);
			try {
				vi.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaMedico":
			VistaMedico ec= new VistaMedico(gd);
			ec.setVisible(true);
			escritorio.add(ec);
			try {
				ec.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
		case "ventanaConsulta":
			VistaConsulta uc = new VistaConsulta(gd);
			uc.setVisible(true);
			escritorio.add(uc);
			try {
				uc.setSelected(true);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			break;
	
		}
	}
	
	


	
	
}