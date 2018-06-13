package API_master.Ferramentas;


import API_master.Ferramenta;

public class PalitoFosforo extends Ferramenta{

    private final int MAX_SEGUNDOS_ACES0 = 10;
    private boolean estaQueimado;

    public PalitoFosforo(String descricao){
        super(descricao);
        estaQueimado = false;
    }

    public void acende(){
        for (int i = 0; i < MAX_SEGUNDOS_ACES0; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }

        estaQueimado = true;
    }

    public boolean getEstaQueimado(){
        return estaQueimado;
    }
}
