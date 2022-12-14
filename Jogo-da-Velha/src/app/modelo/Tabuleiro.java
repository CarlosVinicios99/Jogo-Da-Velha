package app.modelo;


public class Tabuleiro {
	private Campo [][] matrizDeCampos = new Campo[3][3];
	private TipoDeJogador jogadorAtual;
	
	
	public Tabuleiro() {
		inicializar();
		jogadorAtual = TipoDeJogador.X;
	}
	
	public String obterJogadorAtual() {
		if(jogadorAtual == TipoDeJogador.O) {
			return "O";
		}
		return "X";
	}
	
	public String obterRotuloDoCampo(int linha, int coluna) {
		return matrizDeCampos[linha][coluna].getRotulo();
	}
	
	public boolean realizarJogada(int linha, int coluna) {
		if(!matrizDeCampos[linha][coluna].estaMarcado()) {
			matrizDeCampos[linha][coluna].marcar(jogadorAtual.toString());
			alterarJogadorAtual();
			return true;
		}
		
		return false;
	}
	
	
	public boolean jogoFoiFinalizado() {
		boolean vencedorNaHorizontal = houveVencedorNaHorizontal();
		boolean vencedorNaVertical = houveVencedorNaVertical();
		boolean vencedorNaDiagonal = houveVencedorNaDiagonal();
		boolean houveEmpate = todosOsCamposMarcados();
		
		boolean jogoFinalizado =
			vencedorNaHorizontal || vencedorNaVertical || vencedorNaDiagonal || houveEmpate;
		
		return jogoFinalizado;
	}
	
	public String anunciarResultado() {
		alterarJogadorAtual();
		
		if(todosOsCamposMarcados()) {
			return "Empate!";
		}
		
		else if(jogadorAtual == TipoDeJogador.O) {
			return "Vencedor: O";
		}
		
		else{
			return "Vencedor: X";
		}
		
	}
	
	public void reinicializar() {
		for(Campo [] linhaDeCampos: matrizDeCampos) {
			for(Campo campo: linhaDeCampos) {
				campo.desmarcar();
			}
		}
		alterarJogadorAtual();
	}
	
	@Override
	public String toString() {	
		StringBuilder sb = new StringBuilder();
		
		sb.append("  1 2 3\n");
		int linha = 1;
		
		for(Campo[] linhaDeCampos: matrizDeCampos) {
			sb.append(linha);
			linha++;
			
			for(Campo campo: linhaDeCampos) {
				sb.append(campo);
			}
			
			sb.append("\n");
		}
		return "\n" + sb.toString();
	}
	
	private void inicializar() {
		for(int linha = 0; linha < 3; linha++) {
			for(int coluna = 0; coluna < 3; coluna++) {
				matrizDeCampos[linha][coluna] = new Campo();
			}
		}
	}
	
	private void alterarJogadorAtual() {
		jogadorAtual = 
			jogadorAtual == TipoDeJogador.X ? TipoDeJogador.O : TipoDeJogador.X; 
	}
	
	private boolean todosOsCamposMarcados() {
		
		for(Campo[] linhaDeCampos: matrizDeCampos) {
			for(Campo campo: linhaDeCampos) {
				if(!campo.estaMarcado()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private boolean houveVencedorNaHorizontal() {
		int linha = 0, coluna = 0;
		String rotuloDoCampo = "";
		
		for(linha = 0; linha < 3; linha++) {
			int resultado = 0;
			rotuloDoCampo = matrizDeCampos[linha][0].getRotulo();
			
			for(coluna = 0; coluna < 3; coluna++) {
				if(rotuloDoCampo.equals(matrizDeCampos[linha][coluna].getRotulo())
					&& !rotuloDoCampo.equals("-")) {
					resultado++;
				}
			}
			
			if(resultado == 3) {
				return true;
			}
		
		}
		return false;
	}
	
	private boolean houveVencedorNaVertical() {
		int linha = 0, coluna = 0;
		String rotuloDoCampo = "";
		
		for(coluna = 0; coluna < 3; coluna++) {
			
			int resultado = 0;
			rotuloDoCampo = matrizDeCampos[0][coluna].getRotulo();
			
			for(linha = 0; linha < 3; linha++) {
				if(rotuloDoCampo.equals(matrizDeCampos[linha][coluna].getRotulo())
					&& !rotuloDoCampo.equals("-")) {
					resultado++;
				}
			}
			
			if(resultado == 3) {
				return true;
			}
		
		}
		return false;
	}
	
	private boolean houveVencedorNaDiagonal() {
		int linha = 0, coluna = 0;
		
		int resultadoDiagonal1 = 0;
		int resultadoDiagonal2 = 0;
		String rotuloDoCampoDiagonal1 = matrizDeCampos[0][0].getRotulo();
		String rotuloDoCampoDiagonal2 = matrizDeCampos[0][2].getRotulo();
		
		for(linha = 0; linha < 3; linha++) {
			for(coluna = 0; coluna < 3; coluna++) {
				
				if(coluna == linha) {
					if(rotuloDoCampoDiagonal1.equals(matrizDeCampos[linha][coluna].getRotulo())
						&& !rotuloDoCampoDiagonal1.equals("-")) {
						resultadoDiagonal1++;
					}
				}
				
				else if(linha != coluna && linha + coluna == 2) {
					if(rotuloDoCampoDiagonal2.equals(matrizDeCampos[linha][coluna].getRotulo())
						&& !rotuloDoCampoDiagonal2.equals("-")) {
						resultadoDiagonal2++;
					}
				}
				
			}
		}
		
		if(resultadoDiagonal1 == 3 || resultadoDiagonal2 == 3) {
			return true;
		}
		
		return false;
	}
}
