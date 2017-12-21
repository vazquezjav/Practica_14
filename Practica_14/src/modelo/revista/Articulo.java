package modelo.revista;

public class Articulo {

	private Revista revistas;
	private String tema;
	private String pagina;
	private int codigo;


	public Revista getRevistas() {
		return revistas;
	}

	public void setRevistas(Revista revistas) {
		this.revistas = revistas;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String toString() {
		return tema;
	}

}
