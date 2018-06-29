package API_master.Salas;

import API_master.Ferramentas.LockPick;
import API_master.Mochila;
import API_master.Personagem;
import API_master.Sala;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;



public class PrisaoTest {

    @Test
    public void testLockPickNaCela(){
        Mochila p = new Personagem("Marlon");
        p.guardar(new LockPick());
        Sala s = new Prisao();
        s.entra(p);
        s.usa("Grampo");
        String esperado = "A cela está destrancada.";
        String obtido = s.getObjetos().get("Cela").getDescricao();

        assertEquals (esperado, obtido);

    }



}
