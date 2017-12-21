package vista.departamento;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
public class ModeloDepartamento extends AbstractTableModel{
	public String []columnas ={"Nombre","codigo","Empleado"};
	public Class[] columnasTipos={ String.class, String.class, String.class};
	private List<Departamento>datos;
	
	public ModeloDepartamento(){
		super();
		datos= new ArrayList<Departamento>();
	}
	public ModeloDepartamento(List<Departamento>datos){
		super();
		this.datos=datos;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Departamento dato=(Departamento)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombredepa((String) value);
			break;
		case 1:
			dato.setCodigo((String) value);
			break;
		case 2:
			dato.setEmpleados((Empleado) value);
			break;
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
	@Override
	public Object getValueAt(int row, int col) {
		Departamento dato=(Departamento)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombredepa();
		case 1:
			return dato.getCodigo();
		case 2:
			
			return dato.getEmpleados();
			default:
				break;
		}
		
		return new String();
	}

}
