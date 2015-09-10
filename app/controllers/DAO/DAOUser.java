package controllers.DAO;
import models.User;
import play.db.*;
import javax.sql.DataSource;
import java.sql.*;


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
            String sql = "SELECT * FROM tbuser WHERE username=? AND password=?";
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
                System.out.println(resultado.toString());
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
}
