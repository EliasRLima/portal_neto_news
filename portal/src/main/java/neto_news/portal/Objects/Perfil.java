package neto_news.portal.Objects;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import neto_news.portal.util.SenhaService;

public class Perfil {
    
	private String nome;
	private String email;
	private String dtnasc;
	private String senha;
	
	public Perfil() {
		// TODO Auto-generated constructor stub
	}
	
	public Perfil(String nome, String dtnasc, String email, String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.nome = nome;
		this.email = email;
		this.dtnasc = dtnasc;
		this.senha = SenhaService.Criptografar(senha);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	
	
}
