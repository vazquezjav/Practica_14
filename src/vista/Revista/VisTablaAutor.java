package vista.Revista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.GestionRevista;

public class VisTablaAutor  extends JInternalFrame implements ActionListener{

	private JTable tblAutores;
	private GestionRevista gr;
	
	public VisTablaAutor(GestionRevista gr){
		this.gr=gr;
		
		setSize(400,300);        
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Lista Autores");
        pnlTitulo.add(lblTitulo);
		
        tblAutores=new JTable();
        tblAutores.setModel(new ModeloAutor());

		JScrollPane scrollPaneTabla = new JScrollPane(tblAutores);

		JPanel pnlBotones = new JPanel(new FlowLayout());
		JButton btnCargar = new JButton("Cargar");
        btnCargar.setActionCommand("btnCargar");
        btnCargar.addActionListener(this);
        pnlBotones.add(btnCargar);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setActionCommand("btnSalir");
        btnSalir.addActionListener(this);
        pnlBotones.add(btnSalir);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
        getContentPane().add(pnlBotones, BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        String comando = e.getActionCommand();
        
        switch(comando){
            case "btnSalir":
                salir();
                break;                
            case "btnCargar":
			try {
				cargarDatos();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                break;
            default:
                break;
        }
	}
	public void salir(){
		System.exit(0);
	}
	public void cargarDatos() throws IOException{
		tblAutores.setModel(new ModeloAutor(gr.leerAutor()));
		
	}


}
