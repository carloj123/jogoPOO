package API_master;


import API_master.Ferramentas.CaixaDeFosforo;
import API_master.Ferramentas.LockPick;

public class Personagem extends Mochila{


    private String nome;
    private final int MAX_VIDAS = 3;
    private boolean estaVivo;
    private int qtdVidasRestantes;

    public Personagem(String nome) {
        this.nome = nome;
        estaVivo = true;
        qtdVidasRestantes = MAX_VIDAS;
    }

    public boolean getEstaVivo() {
        return estaVivo;
    }

    public void perdeVida(){
        qtdVidasRestantes--;
        if(qtdVidasRestantes == 0)
            estaVivo = false;
    }

    public String getNome() {
        return nome;
    }

    public int getQtdVidasRestantes() {
        return qtdVidasRestantes;
    }

    @Override
    public Ferramenta usar(String descricção){
        Ferramenta f = super.usar(descricção);

        if(f instanceof LockPick){
            if(((LockPick) f).estaQuebrado())
                return null;
        }else if(f instanceof CaixaDeFosforo){
             if(!((CaixaDeFosforo) f).usarUmPalito()){
                return null;
            }
        }

        return f;
    }
}
