package app.visao;

import java.util.ArrayList;

import app.modelo.Tabuleiro;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class TabuleiroVisao extends GridPane{
	
	private Tabuleiro tabuleiro = new Tabuleiro();
	private Stage secondStage = new Stage();
	private ArrayList<Botao> botoes = new ArrayList<Botao>();
	
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
					checarSituacaoAtualDoJogo();
				});
				add(botao, linha, coluna);
				botoes.add(botao);
			}
		}	
	}
	
	private void checarSituacaoAtualDoJogo() {
		if(tabuleiro.jogoFoiFinalizado()) {
			anunciarResultado();
		}
	}
	
	private void anunciarResultado() {
		String CSS = getClass()
			.getResource("/app/visao/jogoDaVelha.css").toExternalForm();
		
		HBox boxResultado = new HBox();
		boxResultado.getStyleClass().add("resultado");
		Label labelVencedor = new Label(tabuleiro.anunciarResultado());
		labelVencedor.getStyleClass().add("textoFinal");
		labelVencedor.setMaxSize(180, 30);
		boxResultado.setMaxWidth(300);
		boxResultado.setMaxHeight(40);
		boxResultado.setAlignment(Pos.BOTTOM_RIGHT);
		boxResultado.setSpacing(10);
		
		Button botaoNovaPartida = new Button("Reiniciar");
		botaoNovaPartida.getStyleClass().add("botoesResultado");
		botaoNovaPartida.setOnAction(e -> {
			secondStage.close();
			tabuleiro.reinicializar();
			for(Botao botao: botoes) {
				botao.setText("-");
			}
		});
		
		Button botaoSair = new Button("Sair");
		botaoSair.getStyleClass().add("botoesResultado");
		botaoSair.setOnAction(e -> {
			System.exit(0);
		});
		botaoNovaPartida.setMaxSize(80, 20);
		botaoSair.setMaxSize(80, 20);
		boxResultado.getChildren().addAll(labelVencedor, botaoNovaPartida, botaoSair);
		
		Scene cenaResultado = new Scene(boxResultado, 300, 40);
		cenaResultado.getStylesheets().add(CSS);
		secondStage.setTitle("Fim De Jogo");
		secondStage.setScene(cenaResultado);
		secondStage.setResizable(false);
		secondStage.show();
		
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
