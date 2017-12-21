package vista.Revista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.revista.Articulo;
import modelo.revista.Autor;

public class ModeloAutor extends AbstractTableModel{

	public String []columnas ={"Nombre","Apellido","Nacionalidad","Articulo"};
	public Class[] columnasTipos={ String.class, String.class, String.class,String.class};
	private List<Autor>datos;
	
	public ModeloAutor(){
		super();
		datos= new ArrayList<Autor>();
	}
	public ModeloAutor(List<Autor>datos){
		super();
		this.datos=datos;
	}
	
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}


	public void setValueAt(Object value, int row, int col){
		Autor dato=(Autor)(datos.get(row));
		switch(col){
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setApellido((String) value);
			break;
		case 2:
			dato.setNacionalidad((String) value);
			break;
		case 3: 
			dato.setArticulo((Articulo)value);
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
		Autor dato=(Autor)(datos.get(row));
		switch(col){
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getApellido();
		case 2:
			return dato.getNacionalidad();
		case 3: 
			return dato.getArticulo();
			default:
				break;
		}
		
		return new String();
	}

}
