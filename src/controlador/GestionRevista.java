package controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class GestionRevista {
	private List<Revista> revistas;
	private List<Articulo> articulos;
	private List<Autor> autores;
	private int c, c2;

	protected String pathRevistas = "src/archivos/Revistas.txt";
	private String pathArticulos = "src/archivos/Articulos.txt";
	private String pathAutores = "src/archivos/Autores.txt";

	public GestionRevista() {
		revistas = new ArrayList<Revista>();
		articulos = new ArrayList<Articulo>();
		autores = new ArrayList<Autor>();
		c = 0;
		c2 = 0;

	}

	public void agregarRevista(String nombreR, String editorial, int codigo) throws Exception {
		RandomAccessFile archivoEscritura;
		String cod = String.valueOf(codigo);

		if (nombreR.length() < 7) {
			while (nombreR.length() < 7) {
				nombreR += " ";
			}
		} else {
			if (nombreR.length() > 7) {
				throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
			}
		}
		if (editorial.length() < 7) {
			while (editorial.length() < 7) {
				editorial += " ";
			}
		} else {
			if (editorial.length() > 7) {
				throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
			}
		}
		if (cod.length() < 7) {
			while (cod.length() < 7) {
				cod += " ";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
		}
		if (nombreR.length() == 7 && editorial.length() == 7) {
			try {
				archivoEscritura = new RandomAccessFile(pathRevistas, "rw");
				archivoEscritura.writeUTF(nombreR);
				archivoEscritura.writeUTF(editorial);
				archivoEscritura.writeInt(codigo);
				archivoEscritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Revista> leerRevista() throws IOException {

		RandomAccessFile file = new RandomAccessFile(pathRevistas, "r");
		try {
			while (true) {
				Revista r = new Revista();
				r.setNombre(file.readUTF());
				r.setEditorial(file.readUTF());
				r.setCodigo(file.readInt());
				revistas.add(r);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			file.close();
		}
		return revistas;
	}

	public Revista buscarRevista(int tm) throws IOException {
		RandomAccessFile file = new RandomAccessFile(pathRevistas, "r");
		try {
			Revista r = new Revista();
			long linea = (tm - 1) * 21;
			System.out.println("Prin" + file.getFilePointer());
			file.seek(linea);
			r.setNombre(file.readUTF());
			r.setEditorial(file.readUTF());
			r.setCodigo(file.readInt());
			System.out.println("Fin" + file.getFilePointer());
			return r;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			file.close();
		}
		return null;
	}

	public void editarRevista(int tm, String nombreR, String editorial, int codigo) throws Exception {
		RandomAccessFile file = new RandomAccessFile(pathRevistas, "rw");
		String cod = String.valueOf(codigo);
		if (nombreR.length() < 7) {
			while (nombreR.length() < 7) {
				nombreR += " ";
			}
		} else {
			if (nombreR.length() > 7) {
				throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
			}
		}
		if (editorial.length() < 7) {
			while (editorial.length() < 7) {
				editorial += " ";
			}
		} else {
			if (editorial.length() > 7) {
				throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
			}
		}
		if (cod.length() < 7) {
			while (cod.length() < 7) {
				cod += " ";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
		}
		
		if (nombreR.length() == 7 && editorial.length() == 7) {
			try {
				file.seek((tm - 1) * 21);
				file.writeUTF(nombreR);
				file.writeUTF(editorial);
					file.writeInt(codigo);
					file.seek(0);
				file.close();
			} catch (Exception e) {
				throw new Exception("Error al escribir el archivo.");
			}
		}
	}

	public void agregarArticulo(String tema, String pagina, int codigo, int codigoR) throws Exception {

		RandomAccessFile archivoEscritura = null;
		if (tema.length() < 15) {
			while (tema.length() < 15) {
				tema += "";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");

		}
		if (tema.length() == 15) {
			try {
				archivoEscritura = new RandomAccessFile(pathArticulos, "rw");
				archivoEscritura.writeUTF(tema);
				archivoEscritura.writeUTF(pagina);
				archivoEscritura.writeInt(codigo);
				for (Revista r : revistas) {
					if (revistas.get(0).getCodigo() == codigoR) {
						archivoEscritura.writeUTF(revistas.get(0).getNombre());
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				archivoEscritura.close();
			}
		}
	}

	public List<Articulo> leerArticulo() throws IOException {
		RandomAccessFile file = new RandomAccessFile(pathArticulos, "r");
		try {
			while (true) {
				Articulo art = new Articulo();
				art.setTema(file.readUTF());
				art.setPagina(file.readUTF());
				art.setCodigo(file.readInt());
				for (int i = 0; i < revistas.size(); i++) {
					if (c == revistas.get(i).getCodigo()) {
						art.setRevistas(revistas.get(i));
					}
				}
				articulos.add(art);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			file.close();
		}
		return articulos;

	}

	public void agregarAutor(String nombre, String apellido, String nacionalidad, int codigoAr) throws Exception {
		RandomAccessFile archivoEscritura;
		if (apellido.length() < 15) {
			while (apellido.length() < 15) {
				apellido += "";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
		}
		if (nombre.length() < 15) {
			while (nombre.length() < 15) {
				nombre += "";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
		}
		if (nacionalidad.length() < 15) {
			while (nacionalidad.length() < 15) {
				nacionalidad += "";
			}
		} else {
			throw new Exception("No debe sobrepasar el tamanio maximo de 15 caracteres");
		}
		if (nombre.length() == 15 && nacionalidad.length() == 15 && apellido.length() == 15) {
			try {
				archivoEscritura = new RandomAccessFile(pathAutores, "rw");
				archivoEscritura.writeUTF(nombre);
				archivoEscritura.writeUTF(apellido);
				archivoEscritura.writeUTF(nacionalidad);
				for (Articulo ar : articulos) {
					if (articulos.get(0).getCodigo() == codigoAr) {
						archivoEscritura.writeUTF(articulos.get(0).getTema());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Autor> leerAutor() throws IOException {
		RandomAccessFile file = new RandomAccessFile(pathAutores, "r");
		try {
			while (true) {
				Autor au = new Autor();
				au.setNombre(file.readUTF());
				au.setNacionalidad(file.readUTF());
				au.setApellido(file.readUTF());

				for (int i = 0; i < articulos.size(); i++) {
					if (c2 == articulos.get(i).getCodigo()) {
						au.setArticulo(articulos.get(i));
					}
				}
				autores.add(au);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			file.close();
		}
		return autores;
	}

	// validar autor
	public boolean validarAutor(String nombre, String apellido, String nacionalidad) throws Exception {
		int n = 1;
		if (autores.size() > 0) {
			for (int i = 0; i < autores.size(); i++) {
				if (nombre.equals(autores.get(i).getNombre()) && apellido.equals(autores.get(i).getApellido())
						&& nacionalidad.equals(autores.get(i).getNacionalidad())) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El autor ya se encuentra inscrito");
			}
		}
		return true;
	}

	// metodo de validar articulo
	public boolean validarArticulo(String nombre, int codigo) throws Exception {
		int n = 1;
		if (articulos.size() > 0) {
			for (Articulo ar : articulos) {
				if (ar.getTema().equals(nombre) && ar.getCodigo() == codigo) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("El articulo ya se encuentra inscrito");
			}
		}
		return true;
	}

	// metodo para validar la revista
	public boolean validarRevista(String nombre, String editorial, int codigo) throws Exception {
		int n = 1;
		if (revistas.size() > 0) {
			for (Revista r : revistas) {
				if (r.getNombre().equals(nombre) && r.getEditorial().equals(editorial) && codigo == r.getCodigo()) {
					n++;
				}
			}
			if (n > 1) {
				throw new Exception("La revista ya se encuentra inscrita");
			}
		}
		return true;
	}

	// validar codigo articulo
	public boolean validarCodigoArticulo(int codigo) throws Exception {
		int n = 1;
		if (articulos.size() > 0) {
			for (Articulo ar : articulos) {
				if (ar.getCodigo() == codigo) {
					n++;
				}
			}
			if (n == 1) {
				throw new Exception("El Articulo no existe");
			}
		}
		return true;
	}

	// validar codigo revista
	public boolean validarCodigoRevista(int codigo) throws Exception {
		int n = 1;
		if (revistas.size() > 0) {
			for (Revista re : revistas) {
				if (re.getCodigo() == codigo) {
					n++;
				}
			}
			if (n == 1) {
				throw new Exception("La revista no existe");
			}
		}
		return true;
	}
	// metodo para validar los espacion en blanco

	public boolean validarEspacio(String nombre, String nombre2, String nombre3, String nombre4, String nombre5)
			throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (nombre.equals("") || nombre2.equals("") || nombre3.equals("") || nombre4.equals("") || nombre5.equals("")) {
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		}
		return true;
	}
	// validar choose

	public boolean validarChoose(Articulo articulo) throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (articulo == null)
			throw new Exception("no ha escojidoun articulo");
		return true;
	}

	// validar
	public boolean validarEspacio1(String nombre, String nombre2) throws Exception {
		try {

		} catch (Exception e) {
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if (nombre.equals("") || nombre2.equals("")) {
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		}
		return true;
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public List<Autor> getAutores() {
		return autores;
	}

}
