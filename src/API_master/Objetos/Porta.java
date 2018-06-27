package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.Chave;
import API_master.Objeto;

public class Porta extends Objeto {
    public Porta(){
        super("A porta está trancada.", "A porta está destrancada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Chave){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
