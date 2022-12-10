package app;

import javafx.scene.control.Button;

public class Botao extends Button{
	
	private int linha;
	private int coluna;
	
	public Botao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		setText("-");
		setMaxSize(100, 100);
		this.getStyleClass().add("botoes");
	}
	
	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}
}
