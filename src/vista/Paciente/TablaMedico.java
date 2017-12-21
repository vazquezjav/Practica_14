package vista.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.paciente.Consulta;
import modelo.paciente.Medico;
import modelo.paciente.Paciente;

public class TablaMedico extends AbstractTableModel {


	
    public String[] columnas = { "Nombre","Cargo","Telefono","Codigo"};
    public Class[] columnasTipos = { String.class, String.class, String.class, String.class};
    private List<Medico> aspirantes;

    public TablaMedico() {
      super();
      aspirantes = new ArrayList<Medico>();
    }
    
    public TablaMedico(List<Medico> aspirantes) {
     super();
     this.aspirantes = aspirantes;
    }
    
    public int getColumnCount() {
      return columnas.length;
    }
    public int getRowCount() {
      return aspirantes.size();
    }
    public void setValueAt(Object value, int row, int col) {
     Medico aspirante = (Medico)(aspirantes.get(row));

      switch (col) {
      case 0:
    	aspirante.setNombre(((String) value));
        break;
      case 1:
        aspirante.setCargo((String) value);
        break;
      case 2:
        aspirante.setTelefono((String) value);
        break;
      case 3:
	    aspirante.setCodigo((String) value);;
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
    public Object getValueAt(int row, int col) {
      Medico aspirante =(Medico) aspirantes.get(row);

      switch (col) {
      case 0:
        return aspirante.getNombre();
      case 1:
        return aspirante.getCargo();
      case 2:
	    return aspirante.getTelefono();
      case 3:
        return aspirante.getCodigo();
   
      default:
        break;
      }
      return new String();
    }

}