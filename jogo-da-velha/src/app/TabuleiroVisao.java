package app;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
public class TabuleiroVisao extends GridPane{
	
	private Tabuleiro tabuleiro = new Tabuleiro();
	
	public TabuleiroVisao() {
		criarGrid();
		criarBotoes();
	}
	
	private void criarGrid() {
		getRowConstraints().addAll(criarLinha(), criarLinha(), criarLinha());
		getColumnConstraints().addAll(criarColuna(), criarColuna(), criarColuna());
		setGridLinesVisible(true);
	}
	
	private void criarBotoes() {
		
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				Botao botao = new Botao(linha, coluna);
				botao.setOnAction(e -> {
					alterarRotuloBotao(botao);
				});
				add(botao, linha, coluna);
			}
		}	
	}
	
	private void alterarRotuloBotao(Botao botao) {
		if(botao.getText().equals("-")) {
			String novoRotulo = tabuleiro.obterJogadorAtual();
			tabuleiro.realizarJogada(botao.getLinha(), botao.getColuna());
			botao.setText(novoRotulo);
		}
	}
	
	public ColumnConstraints criarColuna() {
		ColumnConstraints coluna = new ColumnConstraints();
		coluna.setPercentWidth(35);
		coluna.setFillWidth(true);
		return coluna;
	}
	
	private RowConstraints criarLinha() {
		RowConstraints linha = new RowConstraints();
		linha.setPercentHeight(35);
		linha.setFillHeight(true);
		return linha;
	}
}
