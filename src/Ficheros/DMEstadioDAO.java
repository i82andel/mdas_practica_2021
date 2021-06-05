package Ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		for(int i = 0; )
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	

}
