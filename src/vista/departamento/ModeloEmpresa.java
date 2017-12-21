package vista.departamento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
import modelo.departamento.Empresa;

public class ModeloEmpresa extends AbstractTableModel {
	public String []columnas ={"Nombre","Ruc","Direccion","Departamento"};
	public Class[] columnasTipos={ String.class, String.class, String.class,String.class};
	private List<Empresa>datos;
	public ModeloEmpresa(){
		super();
		datos= new ArrayList<Empresa>();
	}
	public ModeloEmpresa(List<Empresa>datos){
		super();
		this.datos=datos;
	}
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Empresa dato=(Empresa)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setRuc((String) value);
			break;
		case 2:
			dato.setDireccion((String) value);
			break;
		case 3:
			dato.setDepartamentos((Departamento)value);
			default:
			break;
		}
	}
	public String getColumnName(int col){
		return columnas[col];
	}
	public Class getColumnClass(int col){
		return columnasTipos[col];
	}
	public Object getValueAt(int row, int col) {
		Empresa dato=(Empresa)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getRuc();
		case 2:
			
			return dato.getDireccion();
		case 3:
			return dato.getDepartamentos();
			default:
				break;
		}
		
		return new String();
	}

}
