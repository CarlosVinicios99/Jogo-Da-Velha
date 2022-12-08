package app;

public class Campo {
	
	private String rotulo;
	private Boolean marcado;
	
	public Campo() {
		rotulo = "-";
		marcado = false;
	}
	
	public String getRotulo() {
		return rotulo;
	}
	
	public Boolean estaMarcado() {
		return marcado;
	}
	
	public void marcar(String rotulo) {
		if(!estaMarcado()) {
			marcado = true;
			this.rotulo = rotulo;
		}
	}
	
	public void desmarcar() {
		marcado = false;
		rotulo = "-";
	}
	
	@Override
	public String toString() {
		return " " + rotulo;
	}
}