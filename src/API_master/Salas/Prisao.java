package API_master.Salas;

import API_master.Ferramenta;
import API_master.Ferramentas.LockPick;
import API_master.Objetos.Cela;
import API_master.Sala;

public class Prisao extends Sala {


    public Prisao() {
        super("Prisão.");
        super.getObjetos().put("Cela", new Cela());
        super.getFerramentas().put("Grampo", new LockPick());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append(".\n");
        descricao.append("Está tudo úmido. Você está sozinho em uma cela.\n");
        descricao.append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n");
        descricao.append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n");
        descricao.append("Porta: ").append(this.portasDisponiveis().toString()).append("\n");
        return descricao.toString();
    }


    @Override
    public boolean usa(String ferramenta) {
        //A FERRAMENTA ESPERADA É UM LOCKPICK
        Ferramenta f = super.getMochila().usar(ferramenta);

        if (f instanceof LockPick) {//SE FOR LOCKPICK
            if (super.getObjetos().get("Cela").usar(f)) {//SE O LOCKPICK NÃO FALHAR, RETURN TRUE
                return true;
            }
        }
        
        return false;
    }

}