package Data;

import java.io.Serializable;

public class CarnetSocio implements Serializable{

	private String tipoCarnet;

	
	public CarnetSocio(String tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
		//throw exception
	}

	public String getTipoCarnet() {
		return tipoCarnet;
	}

	public void setTipoCarnet(String tipoCarnet) {
		this.tipoCarnet = tipoCarnet;
	}
	
	
}
