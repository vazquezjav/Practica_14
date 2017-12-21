package modelo.departamento;

public class Departamento {
	private String nombreDepa;
	private String codigo;
	private Empleado empleados;

	public String getNombredepa() {
		return nombreDepa;
	}

	public void setNombredepa(String nombredepa) {
		this.nombreDepa = nombredepa;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Empleado getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado empleados) {
		this.empleados = empleados;
	}
	public String toString() {
		return nombreDepa;
	}
}
