package neto_news.portal.model;


import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConector {
	public static Connection conectar(){
		String servidor = "jdbc:mysql://127.0.0.1:3306/nn";
		try{
            
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(servidor, "root", "");
			return conexao;
			
		}
        catch(Exception e){
			System.out.println("Erro em conectar: " +e.getMessage());
            return null;
		}
                 
	}
}
