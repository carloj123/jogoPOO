package API_master.Salas;

import API_master.Ferramenta;
import API_master.Ferramentas.Extintor;
import API_master.Ferramentas.Lanterna;
import API_master.Objetos.Escuridao;
import API_master.Sala;

public class SalaEscura extends Sala {

    public SalaEscura(){
        super("Sala Escura");
        super.getObjetos().put("Escuridao", new Escuridao());
        super.getFerramentas().put("Extintor", new Extintor());
    }

    @Override
    public String textoDescricao() {
        StringBuilder descricao = new StringBuilder();
        descricao.append("Você está na ").append(super.getNome()).append("\n")
                 .append("Está muito escuro aqui.").append("\n")
                 .append("Objetos: ").append(this.objetosDisponiveis().toString()).append("\n")
                 .append("Ferramentas: ").append(this.ferramentasDisponiveis().toString()).append("\n")
                 .append("Porta: ").append(this.portasDisponiveis().toString());

        return descricao.toString();
    }

    @Override
    public boolean usa(String ferramenta) {
        Ferramenta f = super.getMochila().usar(ferramenta);
        if(f instanceof Lanterna){
            if(((Lanterna) f).estaLigada())
                return super.getObjetos().get("Escuridao").usar(f);
        }

        return false;
    }
}
