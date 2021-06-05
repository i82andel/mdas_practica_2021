package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.SocioDAO;
import Data.Email;
import Data.Socio;
import Data.SocioAbonado;

public class DMSocioDAO  implements SocioDAO{

	ArrayList<Socio> socios = new ArrayList<Socio>();
	
	public DMSocioDAO() {
		
		try {
			this.cargarFichero();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void insertar(Socio j) {
		socios.add(j);
		
	}

	@Override
	public void modificar(Socio j) {
		
		for(int i = 0; i< socios.size(); i++) {
			if(socios.get(i).getEmail() == j.getEmail()) {
				socios.remove(i);
				socios.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Socio j) {
		socios.remove(j);
		
	}

	@Override
	public List<Socio> obtenerTodos() {
		// TODO Auto-generated method stub
		return socios;
	}

	@Override
	public Socio obtener(Email email) {
		
		for(int i = 0; i < socios.size(); i++) {
			if(socios.get(i).getEmail() == email.getEmail()) {
				return socios.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerSocios = new ObjectInputStream(new FileInputStream("src/Ficheros/Socios.txt"));
		socios = (ArrayList<Socio>)leerSocios.readObject();
		leerSocios.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirSocios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Socios.txt"));
		escribirSocios.writeObject(socios);
		escribirSocios.close();
		
	}

}
