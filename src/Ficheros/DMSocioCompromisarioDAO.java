package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.SocioCompromisarioDAO;
import Data.Email;
import Data.SocioCompromisario;

public class DMSocioCompromisarioDAO implements SocioCompromisarioDAO{

	ArrayList<SocioCompromisario> compromisarios = new ArrayList<SocioCompromisario>();
	
	public DMSocioCompromisarioDAO() {
		
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
	public void insertar(SocioCompromisario j) {
		compromisarios.add(j);
		
	}

	@Override
	public void modificar(SocioCompromisario j) {
		
		for(int i = 0; i< compromisarios.size(); i++) {
			if(compromisarios.get(i).getEmail() == j.getEmail()) {
				compromisarios.remove(i);
				compromisarios.add(j);
			}
		}
	}

	@Override
	public void eliminar(SocioCompromisario j) {
		compromisarios.remove(j);
		
	}

	@Override
	public List<SocioCompromisario> obtenerTodos() {
		// TODO Auto-generated method stub
		return compromisarios;
	}

	@Override
	public SocioCompromisario obtener(Email email) {
		
		for(int i = 0; i < compromisarios.size(); i++) {
			if(compromisarios.get(i).getEmail() == email.getEmail()) {
				return compromisarios.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerCompromisarios = new ObjectInputStream(new FileInputStream("src/Ficheros/SociosCompromisarios.txt"));
		compromisarios = (ArrayList<SocioCompromisario>)leerCompromisarios.readObject();
		leerCompromisarios.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirCompromisarios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/SociosCompromisarios.txt"));
		escribirCompromisarios.writeObject(compromisarios);
		escribirCompromisarios.close();
		
	}

}
