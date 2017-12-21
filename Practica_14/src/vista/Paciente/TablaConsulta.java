package vista.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.table.AbstractTableModel;

import modelo.paciente.Consulta;
import modelo.paciente.Medico;
import modelo.paciente.Paciente;

public class TablaConsulta extends AbstractTableModel {

	public String[] columnas = { "Paciente","Mecio","Fecha","Hora"};
    public Class[] columnasTipos = { Paciente.class, Medico.class, String.class, String.class};
    private List<Consulta> aspirantes;

    public TablaConsulta() {
      super();
      aspirantes = new ArrayList<Consulta>();
    }
    
    public TablaConsulta(List<Consulta> aspirantes) {
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
     Consulta aspirante = (Consulta)(aspirantes.get(row));

      switch (col) {
      case 0:
    	aspirante.setPaciente(((Paciente) value));
        break;
      case 1:
        aspirante.setMedico((Medico) value);
        break;
      case 2:
        aspirante.setFecha((String) value);
        break;
      case 3:
	    aspirante.setHora((String) value);;
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
      Consulta aspirante =(Consulta) aspirantes.get(row);

      switch (col) {
      case 0:
        return aspirante.getPaciente();
      case 1:
        return aspirante.getMedico();
      case 2:
	    return aspirante.getFecha();
      case 3:
        return aspirante.getHora();
   
      default:
        break;
      }
      return new String();
    }

}