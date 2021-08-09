package neto_news.portal.util;

import javafx.scene.image.Image;

public class Noticia {
    
    private String titulo;
    private String mini_titulo;
    private Image img98x98;
    private Image img500x350;
    private String texto;
    private int likes;
    
    public Noticia() {
		// TODO Auto-generated constructor stub
	}

	public Noticia(String titulo, String  mini_titulo,Image img98x98, Image img500x350, String texto, int likes) {
		super();
		this.titulo = titulo;
		this.mini_titulo = mini_titulo;
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

	public javafx.scene.image.Image getImg500x350() {
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

	public String getMini_titulo() {
		return mini_titulo;
	}

	public void setMini_titulo(String mini_titulo) {
		this.mini_titulo = mini_titulo;
	}
    
	
     
}
