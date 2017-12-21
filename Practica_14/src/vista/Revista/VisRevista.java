package vista.Revista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import controlador.GestionRevista;
import modelo.revista.Articulo;
import modelo.revista.Revista;

public class VisRevista extends JInternalFrame implements ActionListener {

	private JTextField nombre, editorial, codigo;
	private JLabel etnombre, eteditorial, etcodigo;
	private JButton guardar, leer,buscar,actualizar;
	private JTable tblRevistas;
	private GestionRevista gr;
	private int numero;

	public void initComponents() {
		setTitle("Articulo");
		setSize(400, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VisRevista(GestionRevista gr) {
		this.gr = gr;
		setSize(400, 300);
		setTitle("Revista");
		initComponents();
		nombre = new JTextField(10);
		editorial = new JTextField(10);
		codigo = new JTextField(10);
		etnombre = new JLabel("Nombre:");
		eteditorial = new JLabel("Editorial:");
		etcodigo = new JLabel("Codigo");
		guardar = new JButton("Guardar");
		leer = new JButton("Leer");
		buscar=new JButton("Buscar");
		actualizar=new JButton("actualizar");
		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(etnombre, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(nombre, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;

		pan.add(eteditorial, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(editorial, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etcodigo, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(codigo, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;
		
		pan.add(guardar, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;
		
		pan.add(buscar, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 4;
		
		pan.add(actualizar, cp2);
		pan.setBorder(BorderFactory.createTitledBorder("Datos Revista"));
		cp1.add(pan, BorderLayout.CENTER);


		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");

		buscar.addActionListener(this);
		buscar.setActionCommand("buscar");

		actualizar.addActionListener(this);
		actualizar.setActionCommand("actualizar");
		

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		System.out.println("evento boton" + comando);
		switch (comando) {
		case "guardar":
			guardar();
			break;
		case "buscar":
			buscar();
			break;
		case "actualizar":
			try {
				actualizar();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	public void guardar() {
		String cod = codigo.getText();
		int codigo1 = Integer.parseInt(cod);
		try {
			if (gr.validarEspacio1(nombre.getText(), editorial.getText())) {
				if (gr.validarRevista(nombre.getText(), editorial.getText(), codigo1)) {
					gr.agregarRevista(nombre.getText(), editorial.getText(), codigo1);
					JOptionPane.showMessageDialog(this, "Revista registrada", "Mensaje de información",JOptionPane.INFORMATION_MESSAGE);
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
			// e.printStackTrace();
		}
		nombre.setText("");
		editorial.setText("");
		codigo.setText("");
	}

	public void buscar() {
		String num = JOptionPane.showInputDialog(this, "Inserte el numero de registro a bsucar.");
		 numero=Integer.parseInt(num);
		if (num.equals("")) {
			JOptionPane.showMessageDialog(this, "No a ingresado ningun dato.", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Revista r = gr.buscarRevista(Integer.parseInt(num));
				nombre.setText(r.getNombre());
				editorial.setText(r.getEditorial());
				String cod = String.valueOf(r.getCodigo());
				codigo.setText(cod);
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
		
	}
	public void actualizar() throws NumberFormatException, Exception{
		
		gr.editarRevista(numero,nombre.getText(), editorial.getText(), Integer.parseInt(codigo.getText()));

	}

	public void editar() {
		int cod = Integer.parseInt(codigo.getText());
		try {
			gr.editarRevista(1, nombre.getText(), editorial.getText(), cod);
			JOptionPane.showMessageDialog(this, "Dato sobre escrito", "MSJ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {

		}
	}

}
