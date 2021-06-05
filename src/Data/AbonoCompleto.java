package Data;

import java.time.LocalDate;



public class AbonoCompleto extends Abono{

	private static float TARIFA_COMPLETO = (float)15.00;
	
	public AbonoCompleto(Localidad localidad, LocalDate fechaCaducidad, String deporte) {
		super(localidad, fechaCaducidad, deporte);
	}
	
	@Override
	public float getPrecio() {
		float precioBase = super.getPrecio();
		float precioFinal = precioBase + TARIFA_COMPLETO;
		return precioFinal;
	}


	
}
