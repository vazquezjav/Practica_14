package vista.Paciente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.GestionPaciente;

public class VistaPaciente extends JInternalFrame implements ActionListener {

	private GestionPaciente gd;
	private JTable TablaPaciente;

	public VistaPaciente(GestionPaciente gd) {
	
		this.gd = gd;
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);
		setSize(500, 400);
		getContentPane().setLayout(new BorderLayout());
	
		
		JPanel pnlTitulo = new JPanel(new FlowLayout());

		JLabel lblTitulo = new JLabel("Paciente");
		pnlTitulo.add(lblTitulo);

		TablaPaciente = new JTable();
		TablaPaciente.setModel(new TablaPaciente());

		JScrollPane scrollPaneTabla = new JScrollPane(TablaPaciente);

		JPanel pnlBotones = new JPanel(new FlowLayout());
		JLabel nombre = new JLabel("NOMBRE");
		pnlBotones.add(nombre); 
		JTextField nombretxt= new JTextField();
		pnlBotones.add(nombretxt);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setActionCommand("btnCargar");
		btnCargar.addActionListener(this);
		pnlBotones.add(btnCargar);

		JButton Salir = new JButton("Salir");
		Salir.setActionCommand("btnSalir");
		Salir.addActionListener(this);
		pnlBotones.add(Salir);

		getContentPane().add(pnlTitulo, BorderLayout.NORTH);
		getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
		getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		String comando = evento.getActionCommand();

		switch (comando) {
		case "btnCargar":
			cargarDatos();
			break;
		case "btnSalir":
			salir();
		default:
			break;
		}
	}

	public void cargarDatos() {
		TablaPaciente.setModel(new TablaPaciente(gd.getPacientes()));
	
		
	}

	public void salir() {
		int opcion = JOptionPane.showConfirmDialog(this, "SALIR", "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		if (opcion == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(this, "CONTINUE", "CONFIRMAR", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
