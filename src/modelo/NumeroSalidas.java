package modelo;

import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.*;

public class NumeroSalidas {
    
     public void numerosSalidas(String tabla, String valor, JTextField salida) {
        String sql = "select * from " + tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conexion();
        
        try 
        {
           st = (Statement) conexion.createStatement(); 
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()){
               salida.setText(rs.getString(valor));
           }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }
}

