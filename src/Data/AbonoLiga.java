package Data;

import java.time.LocalDate;

public class AbonoLiga extends Abono{

	private static float TARIFA_LIGA = (float)45.00;
	
	public AbonoLiga(Localidad localidad, String deporte) {
		super(localidad, deporte);
	}

	
	@Override
	public float getPrecio() {
		float precioBase = super.getPrecio();
		float precioFinal = precioBase + TARIFA_LIGA;
		return precioFinal;
	}
	
}
