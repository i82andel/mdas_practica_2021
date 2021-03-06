package Ficheros;

import java.io.FileNotFoundException;
import java.io.IOException;

import Data.Gestor;

public class DAOManager {

	private static DAOManager instance = null;
	
	private DMUsuarioDAO usuarios = null;
	private DMSocioDAO socios = null;
	private DMSocioAbonadoDAO abonados = null;
	private DMSocioCompromisarioDAO compromisarios = null;
	private DMEntradaDAO entradas = null;
	private DMEstadioDAO estadios = null;
	private DMJuntaDAO juntas = null;
	private DMSolicitudDAO solicitudes = null;
	
	public DAOManager() {}
	
public static DAOManager getInstance() {
		
		if(instance == null) {
			instance = new DAOManager();
		}
		
		return instance;
	}

	public DMUsuarioDAO getUsuarios() {
		if(usuarios == null){
            usuarios = new DMUsuarioDAO();
        }
		return usuarios;
	}

	public DMSocioDAO getSocios() {
		if(socios == null){
			socios = new DMSocioDAO();
        }
		return socios;
	}

	public DMSocioAbonadoDAO getAbonados() {
		if(abonados == null){
			abonados = new DMSocioAbonadoDAO();
        }
		return abonados;
	}

	public DMSocioCompromisarioDAO getCompromisarios() {
		if(compromisarios == null){
			compromisarios = new DMSocioCompromisarioDAO();
        }
		return compromisarios;
	}

	public DMEntradaDAO getEntradas() {
		if(entradas == null){
			entradas = new DMEntradaDAO();
        }
		return entradas;
	}

	public DMEstadioDAO getEstadios() {
		if(estadios == null){
			estadios = new DMEstadioDAO();
        }
		return estadios;
	}
	
	public DMJuntaDAO getJuntas() {
		if(juntas == null){
			juntas = new DMJuntaDAO();
        }
		return juntas;
	}
	
	public DMSolicitudDAO getSolicitudes() {
		if(solicitudes == null){
			solicitudes = new DMSolicitudDAO();
        }
		return solicitudes;
	}
	
	public void guardarFicheros() throws IOException, IOException {
		
		usuarios.guardarFichero();
		socios.guardarFichero();
		abonados.guardarFichero();
		compromisarios.guardarFichero();
		entradas.guardarFichero();
		estadios.guardarFichero();
		juntas.guardarFichero();
		solicitudes.guardarFichero();
		
		
	}
	
}
