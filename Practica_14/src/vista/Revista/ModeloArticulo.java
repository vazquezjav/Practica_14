package vista.Revista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class ModeloArticulo extends AbstractTableModel {

	public String[] columnas = { "Tema", "Pagina", "Codigo" , "Revista"};
	public Class[] columnasTipos = { String.class, String.class, String.class, String.class };
	private List<Articulo> datos;

	public ModeloArticulo() {
		super();
		datos = new ArrayList<Articulo>();
	}

	public ModeloArticulo(List<Articulo> datos) {
		super();
		this.datos = datos;
	}

	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}

	public void setValueAt(Object value, int row, int col) {
		Articulo dato = (Articulo) (datos.get(row));
		switch (col) {
		case 0:
			dato.setTema((String) value);
			break;
		case 1:
			dato.setPagina((String) value);
			break;
		case 2:
			dato.setCodigo((int)value);
			break;
		case 3:
			dato.setRevistas((Revista)value);
		default:
			break;
		}
	}

	public String getColumnName(int col) {
		return columnas[col];
	}

	public Class getColumnClass(int col) {
		return columnasTipos[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Articulo dato = (Articulo) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getTema();
		case 1:
			return dato.getPagina();
		case 2:
			return dato.getCodigo();
		case 3:
			return dato.getRevistas();
		default:
			break;
		}

		return new String();
	}

}
