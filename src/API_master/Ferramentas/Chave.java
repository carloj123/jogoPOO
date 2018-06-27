package API_master.Ferramentas;

import API_master.Ferramenta;
import API_master.Objetos.Bau;

public class Chave extends Ferramenta {
    private Bau bau;

    public Chave(String descricao, Bau bau){
        super(descricao);
        this.bau = bau;
    }

    public boolean usar(Bau bau){
        if(this.bau.equals(bau))
            return super.usar();

        return false;
    }
}
