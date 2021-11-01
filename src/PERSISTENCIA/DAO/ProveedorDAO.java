package PERSISTENCIA.DAO;

import BEAN.Proveedor;
import PERSISTENCIA.EXCEPTION.DAOException;
import java.util.List;

public interface ProveedorDAO {
    List <Proveedor> listar () throws DAOException;
    List <Proveedor> listar (String descripcion) throws DAOException;
    boolean insertar(Proveedor mueble)throws DAOException;
    boolean modificar(Proveedor mueble)throws DAOException;
}
