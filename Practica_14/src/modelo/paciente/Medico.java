package modelo.paciente;

public class Medico 
{
		private String nombre;
		private String cargo;
		private String telefono;
		private String codigo;
		
		public Medico(String nombre, String cargo, String telefono, String codigo) {
			super();
			this.nombre = nombre;
			this.cargo = cargo;
			this.telefono = telefono;
			this.codigo = codigo;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getCargo() {
			return cargo;
		}
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		
		
		
}
