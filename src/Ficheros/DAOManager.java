package Ficheros;

public class DAOManager {

	private DMUsuarioDAO usuarios = null;
	private DMSocioDAO socios = null;
	private DMSocioAbonadoDAO abonados = null;
	private DMSocioCompromisarioDAO compromisarios = null;
	private DMEntradaDAO entradas = null;
	private DMEstadioDAO estadios = null;
	private DMJuntaDAO juntas = null;
	
	public DAOManager() {}

	public DMUsuarioDAO getUsuarios() {
		return usuarios;
	}

	public DMSocioDAO getSocios() {
		return socios;
	}

	public DMSocioAbonadoDAO getAbonados() {
		return abonados;
	}

	public DMSocioCompromisarioDAO getCompromisarios() {
		return compromisarios;
	}

	public DMEntradaDAO getEntradas() {
		return entradas;
	}

	public DMEstadioDAO getEstadios() {
		return estadios;
	}
	
	
	
}
