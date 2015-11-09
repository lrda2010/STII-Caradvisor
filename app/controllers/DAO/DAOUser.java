package controllers.DAO;
import models.Proveedor;
import models.User;
import models.Vehiculo;
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
            pstmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public List listaVehiculos(User usuario) {

        Connection con = getConnection();
        List<Vehiculo> resultado = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement pstmt = null;


        try {
            String sql = "SELECT * FROM vehiculo WHERE FK_ID_Propietario=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, usuario.getUsername());

            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                Vehiculo veh = new Vehiculo(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7));

                resultado.add(veh);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pstmt.close();
            rs.close();
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
                        rs.getInt(1),
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
            pstmt.close();
            rs.close();
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
                        rs.getInt(1),
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
            pstmt.close();
            rs.close();
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
                        rs.getInt(1),
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
            pstmt.close();
            rs.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultado;
    }
}
