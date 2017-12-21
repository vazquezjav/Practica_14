package vista.Revista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.GestionRevista;

public class VisAutor extends JInternalFrame implements ActionListener{


	private JTextField nombre, codigoAr, apellido, nacionalidad;
	private JLabel etnombre, etcodigoAr, etapellido, etnacionalidad;
	private JButton guardar, leer;
	private GestionRevista gr;

	public void initComponents() {
		setTitle("Articulo");
		setSize(400, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}	
	public VisAutor(GestionRevista gr){
		this.gr = gr;
		setSize(400, 300);
		setTitle("Aspirante");
		initComponents();

		nombre = new JTextField(10);
		codigoAr = new JTextField(10);
		apellido = new JTextField(10);
		nacionalidad = new JTextField(10);
		etnombre = new JLabel("Nombre:");
		etcodigoAr = new JLabel("Codigo Articulo:");
		etapellido = new JLabel("Apellido:");
		etnacionalidad = new JLabel("Nacionalidad:");
		guardar = new JButton("Guardar");
		leer = new JButton("Leer");
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

		pan.add(etapellido, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(apellido, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etnacionalidad, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(nacionalidad, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;

		pan.add(etcodigoAr, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;

		pan.add(codigoAr, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 4;
		cp2.gridwidth = 2;
		cp2.fill = 1;
		pan.add(guardar, cp2);

		pan.setBorder(BorderFactory.createTitledBorder("Datos Articulo"));
		cp1.add(pan, BorderLayout.CENTER);
		
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");

		leer.addActionListener(this);
		leer.setActionCommand("leer");
		
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
		default:
			break;
		}
	}
	public void guardar(){
		String cod= codigoAr.getText();
		int codigo=Integer.parseInt(cod);
		try{
				if(gr.validarCodigoArticulo(codigo)){
					if(gr.validarAutor(nombre.getText(), apellido.getText(), nacionalidad.getText())){
						gr.agregarAutor(nombre.getText(), apellido.getText(), nacionalidad.getText(), codigo);
						JOptionPane.showMessageDialog(this, "Articulo registrado", "Mensaje de información",
								JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);
		}
		nombre.setText("");
		apellido.setText("");
		nacionalidad.setText("");
		codigoAr.setText("");
		
	}

}
