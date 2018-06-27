package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.LockPick;
import API_master.Objeto;

public class Cela extends Objeto {
    public Cela(){
        super("A cela está trancada.", "A cela está destrancada.");
    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof LockPick){
            if(((LockPick)f).abrir()) {
                System.out.println("Usou " + f.getDescricao());
                this.setAcaoOk(true);
                return true;
            }
        }

        return false;
    }
}
