package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
import modelo.departamento.Empresa;
import modelo.revista.Articulo;
import modelo.revista.Autor;
import modelo.revista.Revista;

public class GestionDepartamento {
	private List<Empresa> empresas;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private String pathEmpresa = "PracticaBinario/src/archivos/Empresas.dat";
	private String pathDepartamento = "PracticaBinario/src/archivos/Departamentos.dat";

	public GestionDepartamento() {
		empresas = new ArrayList<Empresa>();
		departamentos = new ArrayList<Departamento>();
		empleados = new ArrayList<Empleado>();
	}
//metodo para agragar datos del departamento y de el trabajador
	public void agregarDepartamento(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo) {
		try {
			Empleado em = new Empleado();
			em.setNombreEm(nombreEm);
			em.setApellidoEm(apellidoEm);
			em.setCedula(cedula);
			empleados.add(em);

			Departamento depa = new Departamento();
			depa.setNombredepa(nombreDepa);
			depa.setCodigo(codigo);
			depa.setEmpleados(em);
			departamentos.add(depa);

			FileOutputStream file = new FileOutputStream(pathDepartamento, true);
			DataOutputStream escr = new DataOutputStream(file);
			escr.writeUTF(nombreEm);
			escr.writeUTF(apellidoEm);
			escr.writeUTF(cedula);
			escr.writeUTF(nombreDepa);
			escr.writeUTF(codigo);
		//	escr.writeUTF(em);
			escr.close();
			file.close();

		} catch (Exception e) {
		}
	}
//metodo para agragar empresa
	public void agregarEmpresa(String nombre, String ruc, String direccion, Departamento departamento) {
		try {
			Empresa emp = new Empresa();
			emp.setNombre(nombre);
			emp.setRuc(ruc);
			emp.setDireccion(direccion);
			emp.setDepartamentos(departamento);
			empresas.add(emp);
			
			FileOutputStream file = new FileOutputStream(pathEmpresa, true);
			DataOutputStream escr = new DataOutputStream(file);
			escr.writeUTF(nombre);
			escr.writeUTF(ruc);
			escr.writeUTF(direccion);
			//escr.writeUTF(departamento);
			escr.close();
			file.close();

		} catch (Exception e) {
		}
	}

	//metodo para validar error del choose
	public boolean isChoose(Departamento departamento) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(departamento==null )
			throw new Exception("NO A LLENADO EL DEPARTAMENTO");
		return true;
	}
	//metodo de validacion de espacios en blanco
	public boolean isEsenci(String nombre,String ruc,String direccion) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(nombre.equals("")|| ruc.equals("") || direccion.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
	}
	//validacion de cedula
	public boolean isCedulaValida(String cedula) throws Exception{
		try {
			int a = Integer.parseInt(cedula);
		}catch(NumberFormatException e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(cedula.length()!=10)
			throw new Exception("Debe ser de 10 dígitos");
		
		return true;
	}
	//validacion de espacios vacios
	public boolean isEsenci2(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo) throws Exception{
		try {
			
		}catch(Exception e){
			throw new Exception("Formato incorrecto, contiene caracteres");
		}
		if(nombreEm.equals("")|| apellidoEm.equals("") || cedula.equals("")|| nombreDepa.equals("")|| codigo.equals(""))
			throw new Exception("ERROR UN COMPONENTE SE ENCUENTRA VACIO");
		return true;
	}
	

	
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public List<Empleado> getEmpleados() {
		return empleados;
	}
public List<Departamento> leerDepartamento() throws IOException {
		
		String aux = "";
		FileInputStream lec = null;
		DataInputStream entrada = null;
		try {
			String ruta = pathEmpresa;
			String line = "";
			lec = new FileInputStream(ruta);
			entrada = new DataInputStream(lec);
			while (true) {
				String nombreEm = entrada.readUTF();
				String apellidoEm = entrada.readUTF();
				String cedula = entrada.readUTF();
				String nombredepa = entrada.readUTF();
				String codigo= entrada.readUTF();
				Empleado em=new Empleado();
				em.setNombreEm(nombreEm);
				em.setApellidoEm(apellidoEm);
				em.setCedula(cedula);
				Departamento depa=new Departamento();
				depa.setNombredepa(nombredepa);
				depa.setCodigo(codigo);
				depa.setEmpleados(em);
				departamentos.add(depa);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			entrada.close();
		}
		return departamentos;
	}
	
public List<Empresa> leerEmpresa() throws IOException {
	
	String aux = "";
	FileInputStream lec = null;
	DataInputStream entrada = null;
	try {
		String ruta = pathEmpresa;
		String line = "";
		lec = new FileInputStream(ruta);
		entrada = new DataInputStream(lec);
		while (true) {
			String nombre = entrada.readUTF();
			String ruc = entrada.readUTF();
			String direccion= entrada.readUTF();
			String nombredepa = entrada.readUTF();
			String codigo= entrada.readUTF();
			Empresa emp=new Empresa();
			emp.setNombre(nombre);
			emp.setRuc(ruc);
			emp.setDireccion(direccion);
			empresas.add(emp);
		}

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}finally {
		entrada.close();
	}
	return empresas;
}
	
}
