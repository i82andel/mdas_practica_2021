package Ficheros;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.EntradaDAO;
import Data.Entrada;
import Data.Localidad;

public class DMEntradaDAO implements EntradaDAO{

	ArrayList<Entrada> entradas = new ArrayList<Entrada>();

	public DMEntradaDAO() {
		
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
	public void insertar(Entrada j) {
		entradas.add(j);
		
	}

	@Override
	public void modificar(Entrada j) {
		
		for(int i = 0; i < entradas.size(); i++) {
			if(entradas.get(i).getDatosPropietarioEntrada().getEmail() == j.getDatosPropietarioEntrada().getEmail()) {
				entradas.remove(i);
				entradas.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Entrada j) {
		
		for(int i = 0; i< entradas.size(); i++) {
			if(entradas.get(i) == j) {
				entradas.remove(i);
			}
		}
		
	}

	@Override
	public List<Entrada> obtenerTodos() {
		// TODO Auto-generated method stub
		return entradas;
	}
	
	@Override
	public Entrada obtener(String email) {
		
		for(int i = 0; i <entradas.size(); i++) {
			if(entradas.get(i).getDatosPropietarioEntrada().getEmail() == email) {
				return entradas.get(i);
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerEntradas = new ObjectInputStream(new FileInputStream("src/Ficheros/Entradas.txt"));
		entradas = (ArrayList<Entrada>)leerEntradas.readObject();
		leerEntradas.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirEntradas = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Entradas.txt"));
		escribirEntradas.writeObject(entradas);
		escribirEntradas.close();
		
	}



}
