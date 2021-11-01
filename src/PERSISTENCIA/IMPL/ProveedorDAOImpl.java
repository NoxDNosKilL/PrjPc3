package PERSISTENCIA.IMPL;
import BEAN.Proveedor;
import PERSISTENCIA.DAO.ProveedorDAO;
import PERSISTENCIA.EXCEPTION.DAOException;
import UTIL.BDUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOImpl implements ProveedorDAO {

    @Override
    public List<Proveedor> listar() throws DAOException {
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            Connection cn = BDUtil.getConnection();

            String sql = "SELECT ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO FROM PROVEEDOR";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("ID_PROVEEDOR"));
                proveedor.setRazSoc(rs.getString("RAZ_SOC"));
                proveedor.setRuc(rs.getString("RUC"));
                proveedor.setDireccion(rs.getString("DIRECCION"));
                proveedor.setTelefono(rs.getInt("TELEFONO"));
                proveedor.setEstado(rs.getInt("ESTADO"));
                proveedor.setFechCrea(rs.getDate("FECHCREA"));
                proveedor.setTipo(rs.getString("TIPO"));
                proveedores.add(proveedor);
            }
            rs.close();
            st.close();
            cn.close();

        } catch (Exception e) {
            System.err.println("Error de consulta " + e.getMessage());
        }

        return proveedores;
    }

    @Override
    public List<Proveedor> listar(String razSoc) throws DAOException {
        List<Proveedor> proveedores = new ArrayList<>();

        try {
            Connection cn = BDUtil.getConnection();

            
            String sql = "SELECT ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO FROM PROVEEDOR WHERE UPPER(RAZ_SOC) like ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            razSoc = (razSoc == null)? "":razSoc;
            ps.setString(1, "%" + razSoc.toUpperCase() + "%");
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("ID_PROVEEDOR"));
                proveedor.setRazSoc(rs.getString("RAZ_SOC"));
                proveedor.setRuc(rs.getString("RUC"));
                proveedor.setDireccion(rs.getString("DIRECCION"));
                proveedor.setTelefono(rs.getInt("TELEFONO"));
                proveedor.setEstado(rs.getInt("ESTADO"));
                proveedor.setFechCrea(rs.getDate("FECHCREA"));
                proveedor.setTipo(rs.getString("TIPO"));
                proveedores.add(proveedor);
            }
            rs.close();
            ps.close();
            cn.close();

        } catch (Exception e) {
            System.err.println("Error de consulta " + e.getMessage());
        }

        return proveedores;
    }

    @Override
    public boolean insertar(Proveedor proveedor) throws DAOException {
        boolean sw = false;
        try {
            Connection cn = BDUtil.getConnection();

            String sql = "INSERT INTO PROVEEDOR(ID_PROVEEDOR,RAZ_SOC,RUC,DIRECCION,TELEFONO,ESTADO,FECHCREA,TIPO) VALUES (NEXT VALUE FOR Test.CountBy1,?,?,?,?,?,SYSDATETIME(),?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, proveedor.getRazSoc());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getEstado());
            ps.setString(6, proveedor.getTipo());

            int ret = ps.executeUpdate();

            if (ret > 0) {
                sw = true;
            }
            ps.close();
            cn.close();
        } catch (Exception e) {
            throw new DAOException("Error de registro " + e.getMessage());
        }

        return sw;
    }

    @Override
    public boolean modificar(Proveedor proveedor) throws DAOException {
            boolean sw = false;
                try {
            Connection cn = BDUtil.getConnection();

            String sql = "UPDATE PROVEEDOR SET RAZ_SOC =?, RUC =?, DIRECCION =?, TELEFONO =?, ESTADO = ?, TIPO = ? WHERE ID_PROVEEDOR = ?";
                            
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, proveedor.getRazSoc());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getEstado());
            ps.setString(6,proveedor.getTipo());
            ps.setInt(7, proveedor.getIdProveedor());
            int ret = ps.executeUpdate();
            if (ret > 0) {
                sw = true;
            }
            ps.close();
            cn.close();

        } catch (Exception e) {
            throw new DAOException("Error de actualizacion " + e.getMessage());
        }

        return sw;
    }
    
}
