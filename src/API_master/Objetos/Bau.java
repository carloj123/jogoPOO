package API_master.Objetos.;

import API_master.Ferramentas.*;
import API_master.Objeto;
import API_master.Ferramenta;




public class Bau extends Objeto{

	private String chave;

	public Bau() {
		super("O ba� est� trancado", "O ba� est� aberto");
		this.chave = chave;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean usar(Ferramenta f) {
		if (f instanceof LockPick && ((LockPick) f).getDis()) {
			this.setAcaoOk(((LockPick) f).abrir());
			return true;
		}
		return false;
	}
	
	public boolean usarChave(String s) {
		if (s.equals(chave)) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
	
	
	
	

}
