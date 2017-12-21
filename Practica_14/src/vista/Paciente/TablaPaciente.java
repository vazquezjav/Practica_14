package vista.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.paciente.Medico;
import modelo.paciente.Paciente;

public class TablaPaciente extends AbstractTableModel {

	Locale localizacion=VentanaPrincipal.Localizacion;
	ResourceBundle lang= ResourceBundle.getBundle("Idiomas.mensaje",localizacion);
	
    public String[] columnas = { "Cedula","Nombre","Apellido","Telefono"};
    public Class[] columnasTipos = { String.class, String.class, String.class, String.class};
    private List<Paciente> aspirantes;

    public TablaPaciente() {
      super();
      aspirantes = new ArrayList<Paciente>();
    }
    
    public TablaPaciente(List<Paciente> aspirantes) {
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
     Paciente aspirante = (Paciente)(aspirantes.get(row));

      switch (col) {
      case 0:
    	aspirante.setCedula(((String) value));
        break;
      case 1:
        aspirante.setNombre((String) value);
        break;
      case 2:
        aspirante.setApellido((String) value);
        break;
      case 3:
	    aspirante.setTelefono((String) value);;
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
      Paciente aspirante =(Paciente) aspirantes.get(row);

      switch (col) {
      case 0:
        return aspirante.getCedula();
      case 1:
        return aspirante.getNombre();
      case 2:
	    return aspirante.getApellido();
      case 3:
        return aspirante.getTelefono();
   
      default:
        break;
      }
      return new String();
    }

}