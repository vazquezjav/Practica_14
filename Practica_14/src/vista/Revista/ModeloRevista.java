package vista.Revista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class ModeloRevista extends AbstractTableModel {

	public String[] columnas = { "Nombre", "Editorial", "Codigo" };
	public Class[] columnasTipos = { String.class, String.class, String.class };
	private List<Revista> datos;

	public ModeloRevista() {
		super();
		datos = new ArrayList<Revista>();
	}

	public ModeloRevista(List<Revista> datos) {
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
		Revista dato = (Revista) (datos.get(row));
		switch (col) {
		case 0:
			dato.setNombre((String) value);
			break;
		case 1:
			dato.setEditorial((String) value);
			break;
		case 2:
			dato.setCodigo((int) value);
			break;
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
		Revista dato = (Revista) (datos.get(row));
		switch (col) {
		case 0:
			return dato.getNombre();
		case 1:
			return dato.getEditorial();
		case 2:
			return dato.getCodigo();
		default:
			break;
		}

		return new String();
	}

}
