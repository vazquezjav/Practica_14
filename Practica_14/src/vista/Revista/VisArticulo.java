package vista.Revista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controlador.GestionRevista;
import modelo.revista.Articulo;
import modelo.revista.Revista;

public class VisArticulo extends JInternalFrame implements ActionListener {

	private JTextField paguina, codigoAr, codigoRe, tema;
	private JLabel etpaguina, etcodigoAr, etcodigoRe, ettema;
	private JButton guardar, leer;
	private GestionRevista gr;

	public void initComponents() {
		setTitle("Articulo");
		setSize(400, 400);
		setClosable(true);
		setMaximizable(false);
		setMaximizable(true);

	}

	public VisArticulo(GestionRevista gr) {
		this.gr = gr;
		setSize(400, 300);
		setTitle("Aspirante");
		initComponents();

		paguina = new JTextField(10);
		codigoAr = new JTextField(10);
		codigoRe = new JTextField(10);
		tema = new JTextField(10);
		etpaguina = new JLabel("Paguina:");
		etcodigoAr = new JLabel("Codigo:");
		etcodigoRe = new JLabel("Codigo Revista:");
		ettema = new JLabel("Tema:");
		guardar = new JButton("Guardar");
		leer = new JButton("Leer");

		JPanel pan = new JPanel();

		Container cp1 = getContentPane();

		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(ettema, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;

		pan.add(tema, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 1;

		pan.add(etcodigoAr, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 1;

		pan.add(codigoAr, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 2;

		pan.add(etpaguina, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 2;

		pan.add(paguina, cp2);
		
		cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 3;

		pan.add(etcodigoRe, cp2);

		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 3;

		pan.add(codigoRe, cp2);
		
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

	public void guardar() {
		String cod= codigoAr.getText();
		String codR= codigoRe.getText();
		int cod1= Integer.parseInt(cod);
		int codR1=Integer.parseInt(codR);
		try {
			//if (gr.validarEspacio(paguina.getText(), codigoAr.getText(), codigoRe.getText(), tema.getText(),null)) {
				if(gr.validarCodigoRevista(codR1)){
					if (gr.validarArticulo(tema.getText(), cod1)) {
						gr.agregarArticulo(tema.getText(),paguina.getText(), cod1, codR1);
						JOptionPane.showMessageDialog(this, "Articulo registrado", "Mensaje de información",
								JOptionPane.INFORMATION_MESSAGE);
					}
				//}
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensaje de error", JOptionPane.ERROR_MESSAGE);

			// e.printStackTrace();
		}
		paguina.setText("");
		codigoAr.setText("");
		codigoRe.setText("");
		tema.setText("");
		listar();
	}


	public void listar() {
		List<Articulo> articulos = gr.getArticulos();
		for (int i = 0; i < articulos.size(); i++) {
			Articulo u = articulos.get(i);
			System.out.println("Nombre=" + u.getTema() + "apellido=" );
		}
	}
}
