package Data;

import java.time.LocalDate;



public class AbonoCompleto extends Abono{

	private static float TARIFA_COMPLETO = (float)15.00;
	
	public AbonoCompleto(Localidad localidad, String deporte) {
		super(localidad, deporte);
	}
	
	@Override
	public float getPrecio() {
		float precioBase = super.getPrecio();
		float precioFinal = precioBase + TARIFA_COMPLETO;
		return precioFinal;
	}

	@Override
	public String toString() {
	
		return "Abono [localidad=" + super.getLocalidad() + ", fechaCaducidad=" + super.getFechaCaducidad() 
		+ ", deporte=" + super.getDeporte() + ", tipo=" + "Completo" + ", precio=" + this.getPrecio() +"]" ;
	
	}

	
	
}
