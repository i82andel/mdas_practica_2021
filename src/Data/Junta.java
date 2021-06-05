package Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Junta implements Serializable{

	private SocioCompromisario socioConvocante;
	private ArrayList<String> temasTratarJunta;
	private LocalDate fechaJunta;
	private LocalTime horaJunta;
	
	
	public Junta(SocioCompromisario socioConvocante, ArrayList<String> temasTratarJunta, LocalDate fechaJunta,
			LocalTime horaJunta) {
		super();
		this.socioConvocante = socioConvocante;
		this.temasTratarJunta = temasTratarJunta;
		this.fechaJunta = fechaJunta;
		this.horaJunta = horaJunta;
	}


	public SocioCompromisario getSocioConvocante() {
		return socioConvocante;
	}

	public void setSocioConvocante(SocioCompromisario socioConvocante) {
		this.socioConvocante = socioConvocante;
	}

	public ArrayList<String> getTemasTratarJunta() {
		return temasTratarJunta;
	}

	public void setTemasTratarJunta(ArrayList<String> temasTratarJunta) {
		this.temasTratarJunta = temasTratarJunta;
	}

	public LocalDate getFechaJunta() {
		return fechaJunta;
	}

	public void setFechaJunta(LocalDate fechaJunta) {
		this.fechaJunta = fechaJunta;
	}

	public LocalTime getHoraJunta() {
		return horaJunta;
	}

	public void setHoraJunta(LocalTime horaJunta) {
		this.horaJunta = horaJunta;
	}
	
	
}
