package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.Extintor;
import API_master.Objeto;

public class Fogo extends Objeto {
    public Fogo(){
        super("O fogo está aceso.", "O fogo está apagado.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof Extintor){
            f.usar();
            this.setAcaoOk(true);
            return true;
        }

        return false;
    }
}
