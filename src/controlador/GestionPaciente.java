package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.paciente.Consulta;
import modelo.paciente.Medico;
import modelo.paciente.Paciente;

public class GestionPaciente
{
	ArrayList<Consulta> consultas = new ArrayList<Consulta>();
	ArrayList<Medico> medicos = new ArrayList<Medico>();
	ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	private String pathPaciente = "src/archivos/Paciente.txt";
	private String pathMedico = "src/archivos/Medico.txt";
	private String pathConsulta = "src/archivos/Conculta.txt";
	public void ingresarPaciente(String cedula, String nombre, String apellido, String telefono)
	{
		try {
		Paciente p = new Paciente(cedula, nombre, apellido, telefono);
		pacientes.add(p);
	
		FileWriter file = new FileWriter(pathPaciente, true);
		BufferedWriter escr = new BufferedWriter(file);
		String registro = p.getCedula()+" "+p.getNombre()+" "+p.getApellido()+" "+p.getTelefono();
		escr.append("DATOS DE LA PACIENTE"+"\n");
		escr.append(registro + "\n");
		escr.close();
		file.close();}
		catch (Exception e){
			
		}

	}
	
	public void ingresrMedicos(String nombre, String cargo, String telefono, String codigo)
	{
		
		
		try {
			Medico m = new Medico(nombre, cargo, telefono, codigo);
			medicos.add(m);
		
			FileWriter file = new FileWriter(pathMedico, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = m.getNombre()+" "+m.getCargo()+" "+m.getTelefono()+" "+m.getCodigo();
			escr.append("DATOS DEL MEDICO"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();}
			catch (Exception e){
				
			}
	}
	
	public void ingresarConsulta(Paciente paciente, Medico medico, String fecha, String hora)
	{
		try {

			Consulta c = new Consulta(paciente, medico, fecha, hora);
			consultas.add(c);
		
			FileWriter file = new FileWriter(pathMedico, true);
			BufferedWriter escr = new BufferedWriter(file);
			String registro = c.getPaciente()+" "+c.getMedico()+" "+c.getFecha()+" "+c.getHora();
			escr.append("DATOS DE LA CONSULTA"+"\n");
			escr.append(registro + "\n");
			escr.close();
			file.close();}
			catch (Exception e){
				
			}
	}
	
	public boolean buscarPaciente(String nombre)
	{
		for(int i =0;i<pacientes.size();i++)
		{
			if(pacientes.get(i).getNombre().equals(nombre))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean buscarMedico(String nombre)
	{
		for(int i =0;i<medicos.size();i++)
		{
			if(medicos.get(i).getNombre().equals(nombre))
			{
				return true;
			}
		}
		return false;
	}
	
	public Paciente buscarPacientep(String nombre)
	{
		for(int i =0;i<pacientes.size();i++)
		{
			if(pacientes.get(i).getNombre().equals(nombre))
			{
				return pacientes.get(i);
			}
		}
		return null;
	}
	
	public Medico buscarMedicop(String nombre)
	{
		for(int i =0;i<medicos.size();i++)
		{
			if(medicos.get(i).getNombre().equals(nombre))
			{
				return medicos.get(i);
			}
		}
		return null;
	}

	public ArrayList<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(ArrayList<Consulta> consultas) {
		this.consultas = consultas;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public String leerPaciente() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathPaciente);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	public String leerMedico() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathMedico);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	public String leerConsulta() throws IOException {
		String aux = "";
		try {
			FileReader l = new FileReader(pathConsulta);
			BufferedReader es = new BufferedReader(l);
			String linea = "";
			while (linea != null) {
				linea = es.readLine();
				aux = aux + "" + linea + "\n";

			}
			es.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return aux;
	}
	
	
}

