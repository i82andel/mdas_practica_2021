package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.EstadioDAO;
import Data.Estadio;

public class DMEstadioDAO implements EstadioDAO{

	ArrayList<Estadio> estadios = new ArrayList<Estadio>();

	@Override
	public void insertar(Estadio j) {
		estadios.add(j);
		
	}

	@Override
	public void modificar(Estadio j) {

		for(int i = 0; i< estadios.size(); i++) {
			if(estadios.get(i).getIdEstadio() == j.getIdEstadio()) {
				estadios.remove(i);
				estadios.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Estadio j) {
		
		for(int i = 0; i< estadios.size(); i++) {
			if(estadios.get(i) == j) {
				estadios.remove(i);
			}
		}
		
	}

	@Override
	public List<Estadio> obtenerTodos() {
		// TODO Auto-generated method stub
		return estadios;
	}

	@Override
	public Estadio obtener(Integer id) {
		// TODO Auto-generated method stub
		for(int i = 0; i < estadios.size(); i++) {
			if(estadios.get(i).getIdEstadio() == id) {
				return estadios.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream leerEstadios = new ObjectInputStream(new FileInputStream("src/Ficheros/Estadios.txt"));
		estadios = (ArrayList<Estadio>)leerEstadios.readObject();
		leerEstadios.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		ObjectOutputStream escribirEstadios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Estadios.txt"));
		escribirEstadios.writeObject(estadios);
		escribirEstadios.close();
		
	}
	
	

}
