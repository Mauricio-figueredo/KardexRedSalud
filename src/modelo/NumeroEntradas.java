package modelo;

import com.mysql.jdbc.Statement;
import java.sql.*;
import javax.swing.*;

public class NumeroEntradas {
    
     public void numerosEntradas(String tabla, String valor, JTextField entrada) {
        String sql = "select * from " + tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conexion();
        
        try 
        {
           st = (Statement) conexion.createStatement(); 
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()){
               entrada.setText(rs.getString(valor));
           }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }
}

