package modelo.departamento;

public class Empresa {
	private String nombre;
	private String ruc;
	private String direccion;
	private Departamento departamentos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Departamento getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamento departamentos) {
		this.departamentos = departamentos;
	}
	public String toString() {
		return nombre;
	}
}
