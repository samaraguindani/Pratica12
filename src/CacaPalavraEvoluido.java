import javax.swing.JOptionPane;

public class CacaPalavraEvoluido {
    Persistencia p = new Persistencia();

    private boolean[] letrasReveladas;
    private int tentativas;
    private char letra;

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public int getTentativas() {
        return tentativas;
    }

    public CacaPalavraEvoluido() {
        p.escolherPalavra();
        letrasReveladas = new boolean[p.getPalavraEscolhida().length()];
        tentativas = 0;
    }
    
    public boolean tentarLetra() {
        letra = Character.toUpperCase(letra);
        boolean acertou = false;

        for (int i = 0; i < p.getPalavraEscolhida().length(); i++) {
            if (!letrasReveladas[i] && p.getPalavraEscolhida().charAt(i) == letra) {
                letrasReveladas[i] = true;
                acertou = true;
            }
        }
        tentativas++;
        return acertou;
    }

    public String palavraAtual() {
        StringBuilder palavraAtual = new StringBuilder();

        for (int i = 0; i < p.getPalavraEscolhida().length(); i++) {
            if (letrasReveladas[i]) {
                palavraAtual.append(p.getPalavraEscolhida().charAt(i));
            } else {
                palavraAtual.append("_");
            }
            palavraAtual.append(" ");
        }

        return palavraAtual.toString();
    }

    public boolean palavraCompleta() {
        for (boolean letraRevelada : letrasReveladas) {
            if (!letraRevelada) {
                return false;
            }
        }
        return true;
    }

    public void jogar(){
        if (Character.isLetter(letra) == false) {
            JOptionPane.showMessageDialog(null, "Tente novamente", "ERRO", JOptionPane.WARNING_MESSAGE);
        }

        if (tentarLetra()) {
            JOptionPane.showMessageDialog(null, "Acertou!", "Parabéns", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Letra não encontrada na palavra.", "Parabéns", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void mostrarPalavra(){
        if (palavraCompleta()) {
            JOptionPane.showMessageDialog(null, "Parabéns! Você adivinhou a palavra: " + p.getPalavraEscolhida(), "Parabéns", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Tente novamente", "ERRO", JOptionPane.WARNING_MESSAGE);                      
        } 
    }
}
