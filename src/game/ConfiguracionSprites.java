package game;

public enum ConfiguracionSprites {
	//PACMAN
	PACMAN_SPRITE ("img/pacman.gif"),
	//FANTASMA
	FANTASMA_SPRITE ("img/pacman.gif"),
	//BOLITAS
	BOLITA_SPRITE ("img/bolitaNormal.gif"),
	BOLITA_ESPECIAL_SPRITE ("img/bolitaEspecial.gif"),
	//MAPA
	;
	//Nombre de los campos (en orden)
	private String valor;
	
	//Constructor
	private ConfiguracionSprites(String v){
		this.valor=v;
	}

	public String getValor(){
		return valor;
	}
}