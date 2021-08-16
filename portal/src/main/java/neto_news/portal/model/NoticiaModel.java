package neto_news.portal.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.scene.image.Image;
import neto_news.portal.Objects.Noticia;

public class NoticiaModel {
	
	private Connection conexao = MySqlConector.conectar();
    private Statement statement = null;
    private ResultSet resultSet = null;
    
    public boolean estaConectado(){
		if(this.conexao != null){
			try{
                  this.statement = this.conexao.createStatement();
                  return true;
            }catch(Exception e){
                  System.out.println("Erro:"+e);
                  return false;
            }
		}
		else{
			return false;
		}
	}
    
    public ArrayList<Noticia> getNoticias(String emailUser){
    	    try {
    	    	InputStream input;
    	    	ArrayList<Noticia> lista = new ArrayList<Noticia>();
    	    	String query = "select * from noticia where removido is null and idusuarioautor in (select u.idusuario from usuario u where u.email = '"+emailUser+"')";
    	    	this.resultSet = this.statement.executeQuery(query);
    	    	while(this.resultSet.next()){
                	input = this.resultSet.getBinaryStream("img64x64");
                	Image img64 = new Image(input);
                	input = this.resultSet.getBinaryStream("img500x300");
                	Image img300 = new Image(input);
                    lista.add(new Noticia(this.resultSet.getString("titulo"), this.resultSet.getString("minititulo"), img64, img300, this.resultSet.getString("texto"), this.resultSet.getInt("likes")));
                }
                return lista;
                
    	    }catch(Exception e) {
    	    	return null;
    	    }
    }
    
    public boolean cadNoticia(Noticia noticia, String email) {
    	String query = "INSERT INTO `nn`.`noticia`\r\n" + 
    			"(`idusuarioautor`,\r\n" + 
    			"`titulo`,\r\n" + 
    			"`minititulo`,\r\n" + 
    			"`texto`,\r\n" + 
    			"`img64x64`,\r\n" + 
    			"`img500x300`)"
    			+ "values ((select u.idusuario from usuario u where u.email = "+email+"')"+", "+noticia.getTitulo()+", "+noticia.getMini_titulo()+", "+noticia.getTexto()+", "+noticia.getImg98x98()+", "+noticia.getImg500x350()+")";
    	try {
			this.statement.executeUpdate(query);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
}
