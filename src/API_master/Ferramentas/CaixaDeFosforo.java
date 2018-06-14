package API_master.Ferramentas;

import API_master.Ferramenta;
import java.util.Stack;

public class CaixaDeFosforo extends Ferramenta{
    private Stack<PalitoFosforo> palitos;
    private final int QTD_MAX_PALITOS = 10;
    private int qtdPalitosRestantes;

    public CaixaDeFosforo(String descricao){
        super("Caixa de fósforo");
        qtdPalitosRestantes = QTD_MAX_PALITOS;
        palitos = new Stack<>();
        preencherCaixa();
    }

    public boolean usarUmPalito(){
        if(palitos.empty())
            return false;

        PalitoFosforo umPalito = palitos.pop();
        umPalito.acender();
        return true;
    }

    private void preencherCaixa(){
        for(int i = 0; i < QTD_MAX_PALITOS; i++){
            palitos.push(new PalitoFosforo("Palito de fósforo"));
        }
    }


}
