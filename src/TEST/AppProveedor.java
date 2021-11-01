package TEST;

import BEAN.Proveedor;
import PERSISTENCIA.DAO.ProveedorDAO;
import PERSISTENCIA.EXCEPTION.DAOException;
import PERSISTENCIA.IMPL.ProveedorDAOImpl;
import UTIL.BDUtil;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class AppProveedor {

    public static void main(String[] args) {
        //listar("Claro");
        //insertar();
        modificar();
    }

    private static void listar() {
        try {
            ProveedorDAO proveedorDAO = new ProveedorDAOImpl();

            List<Proveedor> proveedores = proveedorDAO.listar();
            /*
			 * for (Mueble mueble : muebles) { System.out.println(mueble); }
             */

            proveedores.forEach(System.out::println);

        } catch (Exception e) {

            System.err.println(e.getMessage());
        }

    }

    private static void listar(String razSoc) {
        try {
            ProveedorDAO proveedorDAO = new ProveedorDAOImpl();

            List<Proveedor> proveedores = proveedorDAO.listar(razSoc);
            proveedores.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    private static void insertar() {

        try {
            ProveedorDAO proveedorDAO = new ProveedorDAOImpl();

            Proveedor proveedor = new Proveedor();
            proveedor.setRazSoc("ENTEL");
            proveedor.setRuc("20413256098");
            proveedor.setDireccion("LINCE");
            proveedor.setTelefono(988765123);
            proveedor.setEstado(1);
            proveedor.setTipo("CELULARES");

            if (proveedorDAO.insertar(proveedor)) {
                System.out.println("Exito de registro");
            } else {
                System.err.println("Error de registro");
            }
        } catch (DAOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static void modificar() {
        try {
            ProveedorDAO proveedorDAO = new ProveedorDAOImpl();
            Proveedor proveedor = new Proveedor();
            
            proveedor.setIdProveedor(2);
            proveedor.setRazSoc("TUENTI");
            proveedor.setRuc("20467534026");
            proveedor.setDireccion("LOS ALAMOS");
            proveedor.setTelefono(933805027);
            proveedor.setEstado(1);
            proveedor.setTipo("CELULARES");
            

            if (proveedorDAO.modificar(proveedor)) {
                System.out.println("Exito de actualizacion");
            } else {
                System.err.println("Error de actualizacion");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
