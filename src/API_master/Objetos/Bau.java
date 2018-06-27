package API_master.Objetos;

import API_master.Ferramentas.*;
import API_master.Objeto;
import API_master.Ferramenta;




public class Bau extends Objeto{

	private String chave;


	public Bau(String chave) {
		super("O baú está trancado.", "O baú está aberto.");
		this.chave = chave;

	}

	@Override
	public boolean usar(Ferramenta f) {
		if (f instanceof LockPick) {
			LockPick lp = (LockPick) f;
			if(!lp.estaQuebrado()) {
				this.setAcaoOk(((LockPick) f).abrir());
				return true;
			}
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
