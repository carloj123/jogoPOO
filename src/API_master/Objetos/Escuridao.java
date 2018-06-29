package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.Lanterna;
import API_master.Objeto;

public class Escuridao extends Objeto {

    public Escuridao(){
        super("A sala está ecura.", "A sala está iluminada.");
    }

    @Override
    public boolean usar(Ferramenta f) {

        if(f instanceof Lanterna){
            this.setAcaoOk(true);
            return f.usar();
        }

        return false;
    }
}
