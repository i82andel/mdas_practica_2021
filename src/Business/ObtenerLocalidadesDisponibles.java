package Business;

import java.util.ArrayList;

import Data.*;

public interface ObtenerLocalidadesDisponibles {

	public static ArrayList<Localidad> getLocalidadesDisponibles(Estadio estadio){
		
		ArrayList<Localidad> localidadesDisponibles= new ArrayList<Localidad>();
		for(Localidad localidadAuxiliar : estadio.getLocalidadesEstadio()) {
			if(!localidadAuxiliar.isOcupada()) {
				localidadesDisponibles.add(localidadAuxiliar);
			}
			
		}
		return localidadesDisponibles;
		
	}
	
	public static boolean ocuparLocalidad(Localidad localidadDeseada) {
		
		boolean proceso = false;
		
		if(localidadDeseada.isOcupada()) {
			
			localidadDeseada.setOcupada(true);
			proceso = true;
		}
		
		return proceso;
	}
}
