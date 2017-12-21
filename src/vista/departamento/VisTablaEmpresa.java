package vista.departamento;
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
import javax.swing.table.TableModel;

import controlador.GestionDepartamento;

public class VisTablaEmpresa extends JInternalFrame implements ActionListener {
	private JTable tblEmpresas;
	private GestionDepartamento gd;

	public VisTablaEmpresa(GestionDepartamento gd){
		this.gd=gd;
		setSize(400,300);        
        getContentPane().setLayout(new BorderLayout());

        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("Lista Empresa");
        pnlTitulo.add(lblTitulo);
		
        tblEmpresas=new JTable();
        tblEmpresas.setModel(new ModeloEmpresa());

		JScrollPane scrollPaneTabla = new JScrollPane( tblEmpresas);

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
	            	System.out.println("sfsddf");
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
		 tblEmpresas.setModel( new ModeloEmpresa(gd.leerEmpresa()));
		
	}

}