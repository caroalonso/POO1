package ejercicio1;

public class WallPost {
	private String texto;
	private int cantlikes;
	private boolean destacado;

        // Constructor
        public WallPostImpl() {
		this.texto = "Undefined post";
		this.cantlikes = 0;
		this.destacado = false;
	}

	// Retorna el texto descriptivo de la publicación.
	public String getText() {
		return this.texto;
	}

	// Establece el texto descriptivo de la publicación.
	public void setText(String text) {
		this.texto = text;
	}

	//Retorna la cantidad de me gusta.
	public int getLikes() {
		return this.cantlikes;
	}

	// Incrementa la cantidad de likes en uno.
	public void like() {
		this.cantlikes++;
	}

	// Decrementa la cantidad de likes en uno (chequear mayor a cero).
	public void dislike() {
		if (this.cantlikes > 0) {
			this.cantlikes--;
		}

	}

	// Retorna true o false.
	public boolean isFeatured() {
		return this.destacado;
	}

	// Cambia el post del estado destacado a no destacado y viceversa.
	public void toggleFeatured() {
		this.destacado = !this.destacado;
	}

	@Override
    public String toString() {
        return "--------------------" +"\n"+
				"WallPost:" +"\n"+
				"text: " + getText() +"\n"+
				"likes: " + getLikes() +"\n"+
				"featured: " + isFeatured() +"\n"+
				"--------------------";
    }
}
