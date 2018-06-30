package API_master;

import java.util.Scanner;

import API_master.Salas.*;

public class Engine {
    private JanelaPrincipal janP;
    private Sala salaInicial;
    private Sala salaCorrente;
    private Mochila mochila;
    private boolean fim;

    public Engine(JanelaPrincipal jp){
        janP = jp;
        criaJogo();
        mochila = new Mochila();
        salaInicial.entra(mochila);
        salaCorrente = salaInicial;
        fim = false;
    }

    private void criaJogo(){
        Sala prisao = new Prisao();
        Sala salaEmChamas = new SalaEmChamas();
        Sala corredor = new Corredor();
        Sala salaDoCofre = new SalaDoCofre();
        Sala salaEscura = new SalaEscura();
        Sala salaInundada = new SalaInundada();


        prisao.getPortas().put(corredor.getNome(), corredor);

        corredor.getPortas().put(prisao.getNome(), prisao);
        corredor.getPortas().put(salaDoCofre.getNome(), salaDoCofre);
        corredor.getPortas().put(salaEscura.getNome(), salaEscura);
        corredor.getPortas().put(salaInundada.getNome(), salaInundada);
        corredor.getPortas().put(salaEmChamas.getNome(), salaEmChamas);


        salaDoCofre.getPortas().put(corredor.getNome(), corredor);
        salaEscura.getPortas().put(corredor.getNome(), corredor);
        salaEmChamas.getPortas().put(corredor.getNome(), corredor);
        salaInundada.getPortas().put(corredor.getNome(), corredor);

        salaInicial = prisao;
    }

    public void joga(String acao){
        if (fim) {
            fimDeJogo();
            return;
        }
    }

    String[] tokens = acao.split(" ");
		switch (tokens[0]) {
        case "pega":
            if (salaCorrente.pega(tokens[1])) {
                janP.exibeTexto("Ok! " + tokens[1] + " na mochila!"+"\n");
            } else {
                janP.exibeTexto("Objeto " + tokens[1] + " não encontrado."+"\n");
            }
            break;
        case "inventario":
            janP.exibeTexto("Conteudo da mochila: " + mochila.inventario()+"\n");
            break;
        case "usa":
            try {
                if (salaCorrente.usa(tokens[1])) {
                    janP.exibeTexto("Feito !!");
                } else {
                    janP.exibeTexto("Não é possível usar " + tokens[1] + " nesta sala");
                }
            } catch (FimDeJogoException e) {
                fim = true;
                fimDeJogo();
            }
            janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
            janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
            break;
        case "sai":
            Sala novaSala = salaCorrente.sai(tokens[1]);
            if (novaSala == null) {
                janP.exibeTexto("Sala desconhecida ...\n");
            } else {
                novaSala.entra(mochila);
                salaCorrente = novaSala;
                janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
                janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
            }
            break;
        case "start":
            janP.exibeTexto("\n"+salaCorrente.textoDescricao()+"\n");
            janP.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
            break;
        default:
            janP.exibeTexto("Comando desconhecido: " + tokens[0]+"\n");
            break;
    }


    private void fimDeJogo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Fim de jogo !!");
        alert.setHeaderText("Parabéns !!");
        alert.setContentText("Você conseguiu abrir o cofre !!\nFIM DE JOGO");
        alert.showAndWait();
    }
}
