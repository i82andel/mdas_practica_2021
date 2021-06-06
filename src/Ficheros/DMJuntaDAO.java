package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import DAOS.JuntaDAO;
import Data.Junta;
import Data.Socio;
import Data.Usuario;

public class DMJuntaDAO implements JuntaDAO{

	ArrayList<Junta> juntas = new ArrayList<Junta>();
	
	public DMJuntaDAO() {
		
	}
	@Override
	public void insertar(Junta j) {
		juntas.add(j);
		
	}

	@Override
	public void modificar(Junta j) {
		
		for(int i = 0; i< juntas.size(); i++) {
			if(juntas.get(i).getFechaJunta()== j.getFechaJunta() && juntas.get(i).getHoraJunta() == j.getHoraJunta()) {
				juntas.remove(i);
				juntas.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Junta j) {
		juntas.remove(j);
		
	}

	@Override
	public List<Junta> obtenerTodos() {
		// TODO Auto-generated method stub
		return juntas;
	}


	@Override
	public Junta obtener(LocalDate fecha, LocalTime hora) {
		
		for(int i = 0; i < juntas.size(); i++) {
			if(juntas.get(i).getFechaJunta()== fecha && juntas.get(i).getHoraJunta() == hora) {
				return juntas.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerJuntas = new ObjectInputStream(new FileInputStream("src/Ficheros/Juntas.txt"));
		juntas = (ArrayList<Junta>)leerJuntas.readObject();
		leerJuntas.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirJuntas = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Juntas.txt"));
		escribirJuntas.writeObject(juntas);
		escribirJuntas.close();
		
	}

	@Override
	public Junta obtener(LocalDate id) {
		// TODO Auto-generated method stub
		return null;
	}

}
