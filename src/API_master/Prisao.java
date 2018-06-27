package API_master;

import API_master.Ferramentas.LockPick;
import API_master.Objetos.Bau;

import java.util.List;

public class Prisao extends Sala{


	public Prisao() {
		super("Prisão");

        super.getFerramentas().put("LockPick", new LockPick());
        super.getObjetos().put("Baú", new Bau("abc123"));
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Você está na ").append(super.getNome()).append(".\n");
		descricao.append("Está tudo úmido. Você está sozinho em uma cela.\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}
	
	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);

		if(f == null)
			return false;
		if(f instanceof LockPick){
			((LockPick) f).abrir();
		}


		/*if (f == null || !(f instanceof LockPick)) {
			return false;
		}
		Cadeado cadeado = (Cadeado)this.getObjetos().get("Cadeado");
		cadeado.usar(f);
		if (picklock.abrir()) {
		bau.abrir();
		Chave chave = new Chave();
		this.getFerramentas().put(chave.getDescricao(), chave);
		return true;
		}
		else {
			return false;
		}*/
	}	

}