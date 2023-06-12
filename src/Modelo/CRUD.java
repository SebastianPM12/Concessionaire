package Modelo;

import java.util.List;

/**
 *
 * @author
 */
public interface CRUD {

    public List listar();

    public int add(Object[] o);

    public int actualizar(Object[] o);

    public void eliminar(int id);

    public void eliminarR(String id);
    
}
