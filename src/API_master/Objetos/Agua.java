package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.Dreno;
import API_master.Objeto;

public class Agua extends Objeto {
    public Agua(){
        super("A sala está inundada.", "A água foi drenada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Dreno){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
