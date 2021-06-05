package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.SolicitudDAO;
import Data.Estadio;
import Data.Junta;
import Data.Socio;
import Data.Solicitud;

public class DMSolicitudDAO implements SolicitudDAO{

	ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
	
	@Override
	public void insertar(Solicitud j) {
		solicitudes.add(j);
		
	}

	@Override
	public void modificar(Solicitud j) {
		for(int i = 0; i< solicitudes.size(); i++) {
			if(solicitudes.get(i) == j) {
				solicitudes.remove(i);
				solicitudes.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Solicitud j) {
		solicitudes.remove(j);
		
	}

	@Override
	public List<Solicitud> obtenerTodos() {
		// TODO Auto-generated method stub
		return solicitudes;
	}

	@Override
	public Solicitud obtener(Socio socio) {
		// TODO Auto-generated method stub
		for(int i = 0; i < solicitudes.size(); i++) {
			if(solicitudes.get(i).getSocioSolicitante() == socio) {
				return solicitudes.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream leerSolicitudes = new ObjectInputStream(new FileInputStream("src/Ficheros/Solicitudes.txt"));
		solicitudes = (ArrayList<Solicitud>)leerSolicitudes.readObject();
		leerSolicitudes.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ObjectOutputStream escribirSolicitud = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Solicitudes.txt"));
		escribirSolicitud.writeObject(solicitudes);
		escribirSolicitud.close();
		
	}

}
