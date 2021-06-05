package Data;

import java.io.Serializable;

public class CarnetSocio implements Serializable{

	String tipoCarnet;

	
	public CarnetSocio(Socio socio) {
		this.tipoCarnet = calcularTipoCarnet(socio);
	}

	public String getTipoCarnet() {
		return tipoCarnet;
	}

	public void setTipoCarnet(String tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
	}
	
	public String calcularTipoCarnet(Socio socio) {
		
		
		if(socio.getAntiguedadSocio()>= 25){
			
			return "plata";
			
		}else if(socio.getEdad() < 18) {
			
			return "infantil";
			
		}else if(socio.getEdad() >= 18 && socio.getEdad() < 65) {
			
			return "adulto";
			
		}else{
			
			return "oro";
			
		}
		
	}
	
}
