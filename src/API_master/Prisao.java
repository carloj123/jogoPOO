package API_master;

import jogo_demo.JogoDemo.Chave;
import jogo_demo.JogoDemo.Ferramenta;
import jogo_demo.JogoDemo.Picareta;
import jogo_demo.JogoDemo.PilhaPedras;

public class Prisao extends Sala{
	public Prisao() {
		super("Pris�o");
		Picklock picklock = new Picklock();
		Bau bau = new Bau(chave);
		this.getFerramentas().put((picklock.getDescricao(), picklock);
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voc� esta no ").append(this.getNome()).append("\n");
		descricao.append("Est� tudo �mido, Voc� est� sozinho em uma cela.\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}
	
	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null || !(f instanceof Picklock)) {
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
		}
	}	

}