package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

  private Connection cn = null;
  
  public Connection Conexion() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      getClass();
      getClass();
      getClass();
      this.cn = DriverManager.getConnection("jdbc:mysql://localhost/redsalud", "root", "");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } 
    return this.cn;
  }
}

