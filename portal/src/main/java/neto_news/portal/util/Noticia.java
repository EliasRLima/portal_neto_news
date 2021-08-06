package neto_news.portal.util;

import java.awt.Image;

public class Noticia {
    
    private String titulo;
    private Image img98x98;
    private Image img500x350;
    private String texto;
    private int likes;
    
    public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Noticia(String titulo, Image img98x98, Image img500x350, String texto, int likes) {
		super();
		this.titulo = titulo;
		this.img98x98 = img98x98;
		this.img500x350 = img500x350;
		this.texto = texto;
		this.likes = likes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Image getImg98x98() {
		return img98x98;
	}

	public void setImg98x98(Image img98x98) {
		this.img98x98 = img98x98;
	}

	public Image getImg500x350() {
		return img500x350;
	}

	public void setImg500x350(Image img500x350) {
		this.img500x350 = img500x350;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
    
     
}
