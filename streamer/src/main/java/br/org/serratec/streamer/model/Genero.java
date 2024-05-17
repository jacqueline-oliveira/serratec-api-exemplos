package br.org.serratec.streamer.model;

public enum Genero {
	ACAO("Action"),
	ROMANCE("Romance"),
	COMEDIA("Comedy"),
	DRAMA("Drama"),
	CRIME("Crime"),
	TERROR("Horror"),
	SUSPENSE("Thriler"),
	INDEFINIDO("Undefined");
	
	private String categoriaIngles;

	private Genero(String categoriaIngles) {
		this.categoriaIngles = categoriaIngles;
	}
	
	public static Genero toGenero(String textoIngles) {
		for (Genero genero : Genero.values()) {
			if (genero.categoriaIngles.equalsIgnoreCase(textoIngles)) {
				return genero;
			}
		}
		
		return Genero.INDEFINIDO;
	}
	
	

}
