package DAOS;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface DAO<T, K> {
	
	void insertar(T j);
    
    void modificar(T j);
    
    void eliminar(T j);
    
    List<T> obtenerTodos();
    
    T obtener(K id);
    
    void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException;
    
    void guardarFichero() throws FileNotFoundException, IOException;
}
