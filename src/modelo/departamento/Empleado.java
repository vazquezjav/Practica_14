package modelo.departamento;

public class Empleado {
	private String nombreEm;
	private String apellidoEm;
	private String cedula;

	public String getNombreEm() {
		return nombreEm;
	}

	public void setNombreEm(String nombreEm) {
		this.nombreEm = nombreEm;
	}

	public String getApellidoEm() {
		return apellidoEm;
	}

	public void setApellidoEm(String apellidoEm) {
		this.apellidoEm = apellidoEm;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return nombreEm ;
	}

}
