package Ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.SocioAbonadoDAO;
import Data.Email;
import Data.SocioAbonado;

public class DMSocioAbonadoDAO implements SocioAbonadoDAO{

	ArrayList<SocioAbonado> abonados = new ArrayList<SocioAbonado>();
	
	public DMSocioAbonadoDAO() {
		
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
	public void insertar(SocioAbonado j) {
		abonados.add(j);
		
	}

	@Override
	public void modificar(SocioAbonado j) {
		
		for(int i = 0; i< abonados.size(); i++) {
			if(abonados.get(i).getEmail() == j.getEmail()) {
				abonados.remove(i);
				abonados.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(SocioAbonado j) {
		abonados.remove(j);
		
	}

	@Override
	public List<SocioAbonado> obtenerTodos() {
		// TODO Auto-generated method stub
		return abonados;
	}

	@Override
	public SocioAbonado obtener(Email email) {
		
		for(int i = 0; i < abonados.size(); i++) {
			if(abonados.get(i).getEmail() == email.getEmail()) {
				return abonados.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		ObjectInputStream leerAbonados = new ObjectInputStream(new FileInputStream("src/Ficheros/SociosAbonados.txt"));
		abonados = (ArrayList<SocioAbonado>)leerAbonados.readObject();
		leerAbonados.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		ObjectOutputStream escribirAbonados = new ObjectOutputStream(new FileOutputStream("src/Ficheros/SociosAbonados.txt"));
		escribirAbonados.writeObject(abonados);
		escribirAbonados.close();
		
	}

}
