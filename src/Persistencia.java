import java.util.Random;

public class Persistencia {
    private Arquivo arq = new Arquivo("Palavras.txt");
    private String palavraEscolhida;

    public Persistencia() {
    }

    public Arquivo getArq() {
        return arq;
    }

    public void setArq(Arquivo arq) {
        this.arq = arq;
    }

    public String getPalavraEscolhida() {
        return palavraEscolhida;
    }

    public void setPalavraEscolhida(String palavraEscolhida) {
        this.palavraEscolhida = palavraEscolhida;
    }

    public void escolherPalavra() {
        Random random = new Random();
        int linha = random.nextInt(1471);

        if (arq.abrirLeitura()){
            for (int i = 0; i < linha; i++) {
                palavraEscolhida = arq.lerLinha();
            }
        }
        arq.fecharArquivo();
    }
}
