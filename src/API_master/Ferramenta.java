package API_master;

public class Ferramenta {
	private String descricao;

	public Ferramenta(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean usar() {
		return true;
	}
}