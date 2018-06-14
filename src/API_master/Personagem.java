package API_master;


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
        if(f instanceof PickLock){
            f = (PickLock) f;
            if(!f.getDisponivel())
                return null;
        }

        return f;
    }
}
