package modelo;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ComboProveedores {
    
     public void rellenarcomboproveedores(String tabla, String valor, JComboBox combo) {
        String sql = "select * from " + tabla;
        Statement st;
        Conexion con = new Conexion();
        Connection conexion = con.Conexion();
        
        try 
        {
           st = (Statement) conexion.createStatement(); 
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()){
               combo.addItem(rs.getString(valor));
           }
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e.toString());
        }
    }
}

