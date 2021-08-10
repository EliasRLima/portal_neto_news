package neto_news.portal.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import neto_news.portal.Objects.Perfil;
import neto_news.portal.util.SenhaService;

public class AcessoModel {
	
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
    
    public Perfil buscaLogin(String email, String senha){
          try{
                String query = "select\r\n" + 
                			"    u.nome,\r\n" + 
                			"    u.dtNascimento\r\n" + 
                		      "from usuario u,\r\n" + 
                		        "	usuario_login l\r\n" + 
                		      "where l.idusuario = u.idusuario\r\n" + 
                		      "and u.email = '"+email+"' " + 
                		      "and l.senha = '"+SenhaService.Criptografar(senha)+"'\r\n" + 
                		      "and l.dtfim is null";
                this.resultSet = this.statement.executeQuery(query);
                while(this.resultSet.next()){
                    Perfil pessoa = new Perfil(this.resultSet.getString("nome"), this.resultSet.getString("dtNascimento"), email, senha);
                    return pessoa;
                }
            }catch(Exception e){
                return null;
            }
            
        return null;
    }
    
    public boolean existeNome(String nome) {
    	try{
            String query = "select 0 from usuario u where u.nome = '"+nome+"'";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean existeEmail(String email) {
    	try{
            String query = "select 0 from usuario u where u.nome = '"+email+"'";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
    
    private int getMaxUser() {
    	int id = 0;
    	try{
            String query = "select max(idusuario) + 1 as max from usuario u";
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()){
                return this.resultSet.getInt("max");
            }
            return 0;
        }catch(Exception e){
            return 0;
        }
    }
    
    public boolean novoCadastro(Perfil pessoa) {
    	try{
    		int id = getMaxUser();
            String query = "insert into usuario(idusuario, nome, email, dtNascimento) values("+id+", '"+pessoa.getNome()+"','"+pessoa.getEmail()+"','"+pessoa.getDtnasc()+"')";
            this.statement.executeUpdate(query);
            query = "insert into usuario_login(idusuario, senha, dtini) values("+id+", '"+pessoa.getSenha()+"',now())";
            this.statement.executeUpdate(query);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage(),"ERRO EM CADASTRAR NOVO USUARIO",3);
        }
        return false;
    }
}
