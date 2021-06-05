package Data;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Gestor {
	
	private static Gestor instance = null;
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Socio> socios = new ArrayList<Socio>();
	private ArrayList<SocioAbonado> abonados = new ArrayList<SocioAbonado>();
	private ArrayList<SocioCompromisario> compromisarios = new ArrayList<SocioCompromisario>();
	//private ArrayList<Abono> abonos = new ArrayList<Abono>();
	//private ArrayList<CarnetSocio> carnets = new ArrayList<CarnetSocio>();
	private ArrayList<Entrada> entradas = new ArrayList<Entrada>();
	private ArrayList<Estadio> estadios = new ArrayList<Estadio>();
	
	private Gestor() {}
	
	public static Gestor getInstance() {
		
		if(instance == null) {
			instance = new Gestor();
		}
		
		return instance;
	}
	
	
	void cargarFicheros() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		usuarios.clear();
		socios.clear();
		abonados.clear();
		compromisarios.clear();
		//abonos.clear();
		//carnets.clear();
		entradas.clear();
		estadios.clear();
		
		ObjectInputStream leerUsuarios = new ObjectInputStream(new FileInputStream("src/Ficheros/Usuarios.txt"));
		usuarios = (ArrayList<Usuario>)leerUsuarios.readObject();
		leerUsuarios.close();
		
		ObjectInputStream leerSocios = new ObjectInputStream(new FileInputStream("src/Ficheros/Socios.txt"));
		socios = (ArrayList<Socio>)leerSocios.readObject();
		leerSocios.close();
		
		ObjectInputStream leerAbonados = new ObjectInputStream(new FileInputStream("src/Ficheros/SociosAbonados.txt"));
		abonados = (ArrayList<SocioAbonado>)leerAbonados.readObject();
		leerAbonados.close();
		
		ObjectInputStream leerCompromisarios = new ObjectInputStream(new FileInputStream("src/Ficheros/SociosCompromisarios.txt"));
		compromisarios = (ArrayList<SocioCompromisario>)leerCompromisarios.readObject();
		leerCompromisarios.close();
		
		//ObjectInputStream leerAbonos = new ObjectInputStream(new FileInputStream("src/Ficheros/Abonos.txt"));
		//abonos = (ArrayList<Abono>)leerAbonos.readObject();
		//leerAbonos.close();
		
		//ObjectInputStream leerCarnets = new ObjectInputStream(new FileInputStream("src/Ficheros/Carnets.txt"));
		//carnets = (ArrayList<CarnetSocio>)leerCarnets.readObject();
		//leerCarnets.close();
		
		ObjectInputStream leerEntradas = new ObjectInputStream(new FileInputStream("src/Ficheros/Entradas.txt"));
		entradas = (ArrayList<Entrada>)leerEntradas.readObject();
		leerEntradas.close();
		
		ObjectInputStream leerEstadios = new ObjectInputStream(new FileInputStream("src/Ficheros/Estadios.txt"));
		estadios = (ArrayList<Estadio>)leerEstadios.readObject();
		leerEstadios.close();
		
		
	}
	
	
	void guardarFicheros() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirUsuarios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Usuarios.txt"));
		escribirUsuarios.writeObject(usuarios);
		escribirUsuarios.close();
		
		ObjectOutputStream escribirSocios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Socios.txt"));
		escribirSocios.writeObject(socios);
		escribirSocios.close();
		
		ObjectOutputStream escribirAbonados = new ObjectOutputStream(new FileOutputStream("src/Ficheros/SociosAbonados.txt"));
		escribirAbonados.writeObject(abonados);
		escribirAbonados.close();
		
		ObjectOutputStream escribirCompromisarios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/SociosCompromisarios.txt"));
		escribirCompromisarios.writeObject(compromisarios);
		escribirCompromisarios.close();
		
		//ObjectOutputStream escribirAbonos = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Abonos.txt"));
		//escribirAbonos.writeObject(abonos);
		//escribirAbonos.close();
		
		//ObjectOutputStream escribirCarnets = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Carnets.txt"));
		//escribirCarnets.writeObject(carnets);
		//escribirCarnets.close();
		
		ObjectOutputStream escribirEntradas = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Entradas.txt"));
		escribirEntradas.writeObject(entradas);
		escribirEntradas.close();
		
		ObjectOutputStream escribirEstadios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Estadios.txt"));
		escribirEstadios.writeObject(estadios);
		escribirEstadios.close();
		
	}
	
	
	
	
}
