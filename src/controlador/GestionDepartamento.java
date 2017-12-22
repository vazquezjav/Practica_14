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
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import modelo.departamento.Departamento;
import modelo.departamento.Empleado;
import modelo.departamento.Empresa;
import utilidades.Texto;
public class GestionDepartamento {
	private List<Empresa> empresas;
	private List<Departamento> departamentos;
	private List<Empleado> empleados;
	private String pathEmpresa = "Practica_14/src/archivos/Empresas.dat";
	private String pathDepartamento = "Practica_14/src/archivos/Departamentos.dat";
	private int TAMANO_REG=75 ;
	
	public GestionDepartamento() throws Exception{
//		empresas = new ArrayList<Empresa>();
//		departamentos = new ArrayList<Departamento>();
//		empleados = new ArrayList<Empleado>();
		cargarDatosDepartamento();
	}

	private void  cargarDatosDepartamento() throws Exception {
		try {
			departamentos = leerDepartamento();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Error recuperar datos de archivo");
		}
	}
//metodo para agragar datos del departamento y de el trabajador
	public void agregarDepartamento(String nombreEm, String apellidoEm, String cedula, String nombreDepa, String codigo,int nreg) throws Exception {
	
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
			try {
				if(nreg>0) {
					editarDepartamentoArchivo(nreg,depa,em);
					cargarDatosDepartamento();
				}else{
					agregarDepartamento(nombreEm,  apellidoEm, cedula,  nombreDepa,  codigo, nreg);
					departamentos.add(depa);
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception("Error al guardar datos, error en archivo");
			}
			
	}
	
	public Departamento getPersonaMemoria(int nreg) {
		return departamentos.get(nreg-1);
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
	departamentos = new ArrayList<Departamento>();
	empleados = new ArrayList<Empleado>();
	RandomAccessFile out = new RandomAccessFile(pathDepartamento, "rw");
	try {
		while(true) {
			String nombreEm = out.readUTF();
			String apellidoEm = out.readUTF();
			String cedula = out.readUTF();
			String nombreDepa = out.readUTF();
			String codigo = out.readUTF();
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
		}
	}catch(EOFException e){
		System.out.println("Fin de archivo");
	}
		return departamentos;
	}
public Departamento getPersonaArchivo(int nreg) throws IOException {
	RandomAccessFile out = new RandomAccessFile(pathDepartamento, "rw");
	int pos = (nreg -1) *  TAMANO_REG;
	out.seek(pos);
	
	String nombreEm = out.readUTF();
	String apellidoEm = out.readUTF();
	String cedula = out.readUTF();
	String nombreDepa = out.readUTF();
	String codigo = out.readUTF();
	
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
	return depa;
}
private void guardarDepartamentoArchivo(Departamento depa,Empleado em) throws IOException {
	RandomAccessFile out = new RandomAccessFile(pathDepartamento, "rw");
	out.seek(out.length());
	out.writeUTF(Texto.tamano(em.getNombreEm(), 15));
	out.writeUTF(Texto.tamano(em.getApellidoEm(), 15));
	out.writeUTF(Texto.tamano(em.getCedula(), 10));	
	out.writeUTF(Texto.tamano(depa.getNombredepa(), 15));
	out.writeUTF(Texto.tamano(depa.getCodigo(), 10));	
	out.close();
}
public void editarDepartamentoArchivo(int nreg,Departamento depa,Empleado em) throws IOException {
	RandomAccessFile out = new RandomAccessFile(pathDepartamento, "rw");
	int pos = (nreg -1) *  TAMANO_REG;
	out.seek(pos);
	out.writeUTF(Texto.tamano(em.getNombreEm(), 15));
	out.writeUTF(Texto.tamano(em.getApellidoEm(), 15));
	out.writeUTF(Texto.tamano(em.getCedula(), 10));	
	out.writeUTF(Texto.tamano(depa.getNombredepa(), 15));
	out.writeUTF(Texto.tamano(depa.getCodigo(), 10));	
	out.close();
}
public void eliminarDepartamentoArchivo(int nreg) throws IOException {
	RandomAccessFile out = new RandomAccessFile(pathDepartamento, "rw");		
	try {
		while(true){
			int posN = (nreg) *  TAMANO_REG;
			out.seek(posN);
			String nombreEm = out.readUTF();
			String apellidoEm = out.readUTF();
			String cedula = out.readUTF();
			String nombreDepa = out.readUTF();
			String codigo = out.readUTF();
			
			int pos = (nreg -1) *  TAMANO_REG;
			out.seek(pos);
			out.writeUTF(nombreEm);
			out.writeUTF(apellidoEm);
			out.writeUTF(cedula);
			out.writeUTF(nombreDepa);
			out.writeUTF(codigo);
			nreg ++;
		}
	}catch(EOFException e){
		System.out.println("Fin de archivo");
		out.setLength(out.length() - TAMANO_REG);
	}
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
