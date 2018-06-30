package API_master.Objetos;

import API_master.Ferramenta;
import API_master.Ferramentas.LockPick;
import API_master.Objeto;

public class CofreEletrocutado extends Objeto {

    public CofreEletrocutado(){
        super("O cofre está trancado.", "O cofre está destrancado. ");

    }

    @Override
    public boolean usar(Ferramenta f){
        if(f instanceof LockPick){
            if(((LockPick) f).abrir()){
                this.setAcaoOk(true);
                return f.usar();
            }
        }

        return false;
    }
}
