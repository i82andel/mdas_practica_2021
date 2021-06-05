package DAOS;

import java.time.LocalDate;
import java.time.LocalTime;

import Data.Junta;

public interface JuntaDAO extends DAO<Junta, LocalDate> {

	Junta obtener(LocalDate fecha, LocalTime hora);

}
