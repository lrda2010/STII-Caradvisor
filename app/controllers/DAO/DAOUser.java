package controllers.DAO;
import models.*;
import play.db.*;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrador on 22/06/2015.
 */
public class DAOUser implements IFUser {

    DataSource ds = DB.getDataSource();
    Connection con;
    private int contador;

    @Override
    public Connection getConnection() {

        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }


    @Override
    public User validarBD(String user, String password) {

        Connection con = getConnection();
        User resultado = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM usuario_foro WHERE username=? AND password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs.next()) {
                User usuario = new User(rs.getString(1),rs.getString(2));
                resultado = usuario;
            }
            else
                resultado = null;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List listaVehiculos(User usuario) {

        Connection con = getConnection();
        List<Vehiculo_Usuario> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM vehiculo_user WHERE FK_ID_Propietario=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getUsername());

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                contador++;

                Vehiculo_Usuario veh = new Vehiculo_Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        contador);



                resultado.add(veh);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;


    }

    @Override
    public List<Proveedor> listaDistribuidoresTop() {
        Connection con = getConnection();
        List<Proveedor> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM proveedores WHERE tipo=\"dis\" order by proveedores.puntaje DESC limit 0,4";
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                Proveedor proveedor = new Proveedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));

                resultado.add(proveedor);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;

    }

    @Override
    public List<Proveedor> listaTalleresTop() {
        Connection con = getConnection();
        List<Proveedor> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM proveedores WHERE tipo=\"tal\" order by proveedores.puntaje DESC limit 0,4";
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                Proveedor proveedor = new Proveedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));

                resultado.add(proveedor);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;

    }

    @Override
    public List<Proveedor> listaMecanicosTop() {
        Connection con = getConnection();
        List<Proveedor> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM proveedores WHERE tipo=\"mec\" order by proveedores.puntaje DESC limit 0,4";
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                Proveedor proveedor = new Proveedor(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8));

                resultado.add(proveedor);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    @Override
    public Integer devolverIdMantenimiento(String marca, String modelo) {

        Connection con = getConnection();
        Integer resultado = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT id FROM vehiculo_generico WHERE marca=? AND modelo=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, marca);
            pstmt.setString(2, modelo);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                resultado = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    @Override
    public List<Mantenimiento> devolverMantenimiento(Integer id, Integer kilometraje) {
        Connection con = getConnection();
        List<Mantenimiento> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM mantenimiento_preventivo " +
                    "WHERE id_veh_gen=? AND ? between km_min and km_max";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, kilometraje);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            while (rs.next()) {

                Mantenimiento mantenimiento = new Mantenimiento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));

                resultado.add(mantenimiento);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    @Override
    public void AgregarVehiculo(Vehiculo_Usuario veh) {
        Connection con = getConnection();
        List<Mantenimiento> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "INSERT INTO vehiculo_user " +
                    "(marca,modelo,year,color,kilometraje,FK_ID_Propietario) " +
                    "VALUES (?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, veh.getMarca());
            pstmt.setString(2, veh.getModelo());
            pstmt.setInt(3, veh.getYear());
            pstmt.setString(4, veh.getColor());
            pstmt.setInt(5, veh.getKilometraje());
            pstmt.setString(6, veh.getFK_ID_usuario());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Integer devolverIdRepuesto(String marca) {

        Connection con = getConnection();
        Integer resultado = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT id FROM vehiculo_generico WHERE marca=? LIMIT 0,1";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, marca);
            rs = pstmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                resultado = rs.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;

    }

    @Override
    public List<Repuesto> devolverRepuestos(Integer id, String trepuesto) {

        Connection con = getConnection();
        List<Repuesto> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            String sql = "SELECT * FROM repuesto " +
                    "WHERE id_veh_gen=? AND tipo_repuesto=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2,trepuesto);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            while (rs.next()) {

                Repuesto repuesto = new Repuesto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6)) ;

                resultado.add(repuesto);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;
    }

    @Override
    public void RegistrarUsuario(User_Prop propietario, User usuario) {

        Connection con = getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "INSERT INTO propietario_vehiculo " +
                    "(ID_Propietario,Nombre,Apellido,DNI,Direccion,Telefono) " +
                    "VALUES (?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, propietario.getId());
            pstmt.setString(2, propietario.getNombre());
            pstmt.setString(3, propietario.getApellido());
            pstmt.setString(4, propietario.getDNI());
            pstmt.setString(5, propietario.getDireccion());
            pstmt.setInt(6, propietario.getTelefono());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            String sql = "INSERT INTO usuario_foro " +
                    "(ID_Usuario_Foro,username,password,DNI,Email,Perfil,FK_ID_Propietario) " +
                    "VALUES (?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getID_Usuario_foro());
            pstmt.setString(2, usuario.getUsername());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setString(4, usuario.getDNI());
            pstmt.setString(5, usuario.getEmail());
            pstmt.setString(6, usuario.getPerfil());
            pstmt.setString(7, usuario.getFK_ID_propietario());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    @Override
    public Proveedor devolverProveedor(String id) {

        Connection con = getConnection();
        Proveedor resultado = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM proveedores WHERE ID_Proveedor=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

               Proveedor pro = new Proveedor(
                       rs.getString(1),
                       rs.getString(2),
                       rs.getString(3),
                       rs.getString(4),
                       rs.getString(5),
                       rs.getString(6),
                       rs.getString(7),
                       rs.getInt(8)
               ) ;

                resultado = pro;

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;

    }

    @Override
    public void AgregarCalificacion(Calificacion cal) {

        Connection con = getConnection();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        int puntaje_base = 0;
        int cuenta = 0;


        try {
            String sql = "INSERT INTO calificacion " +
                    "(comentario,calificacionG,calidad,Ubicacion,EquipoL,NivelR," +
                    " fk_proveedor, fk_usuario) " +
                    "VALUES (?,?,?,?,?,?,?,?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cal.getId());
            pstmt.setInt(2, cal.getCalificacionG());
            pstmt.setInt(3, cal.getCalidad());
            pstmt.setInt(4, cal.getUbicacion());
            pstmt.setInt(5, cal.getEquipoL());
            pstmt.setInt(6, cal.getNivelR());
            pstmt.setString(7, cal.getFk_proveedor());
            pstmt.setString(8, cal.getFk_usuario());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Calcular Puntaje Nuevo//

        try {
            String sql = "SELECT PUNTAJE FROM proveedores WHERE ID_Proveedor=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cal.getFk_proveedor());

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
                while (rs.next()) {
                  puntaje_base = rs.getInt(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        try {
            String sql = "SELECT COUNT(*) FROM calificacion where fk_proveedor=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cal.getFk_proveedor());

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                cuenta = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            String sql = "UPDATE proveedores SET PUNTAJE=? WHERE ID_Proveedor =?";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ((puntaje_base+cal.getCalificacionG())/(cuenta+1)));
            pstmt.setString(2, cal.getFk_proveedor());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
