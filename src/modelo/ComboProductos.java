package modelo;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ComboProductos {

    public void rellenarcombos(String tabla, String valor, JComboBox combo) {
        String sql = "SELECT * FROM " + tabla;
        Statement st = null;
        ResultSet rs = null;
        Conexion con = new Conexion();
        Connection conexion = con.Conexion();

        try {
            st = (Statement) conexion.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
            }
        }
    }

    public String[] obtenerDetalles(String tabla1, String valor, String columna1, String columna2) {
        String sql = "SELECT " + columna1 + ", " + columna2 + " FROM " + tabla1 + " WHERE nombre = ?";
        Conexion con = new Conexion();
        Connection conexion = (Connection) con.Conexion();
        String[] detalles = new String[2];
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            pst = (PreparedStatement) conexion.prepareStatement(sql);
            pst.setString(1, valor);
            rs = pst.executeQuery();
            if (rs.next()) {
                detalles[0] = rs.getString(columna1);  // columna1 goes to detalles[0]
                detalles[1] = rs.getString(columna2);  // columna2 goes to detalles[1]
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return detalles;
    }
}
