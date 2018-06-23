package API_master;

import jogo_demo.JogoDemo.Chave;
import jogo_demo.JogoDemo.Cofre;
import jogo_demo.JogoDemo.Ferramenta;
import jogo_demo.JogoDemo.FimDeJogoException;
import jogo_demo.JogoDemo.Lanterna;
import jogo_demo.JogoDemo.Sala;

public class SalaCentral extends Sala{
	private boolean escuro;
	
	public SalaCentral() {
		super("Central");
		escuro = true;
		CxaFosforo fosforos = new CxaFosforo();
		this.getFerramentas().put(fosforos.getDescricao(), fosforos);
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Você esta no salão ").append(this.getNome()).append("\n");
		descricao.append("Tudo está escuro, com excessão de um único canto da sala por onde permeia um pequeno feixe de luz .\n");
		descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}
	
	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {
			return false;
		}
		if (f instanceof fosforos) {
		    escuro = false;
		    return true;
		}
	}
	

}
