import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;

public class Tela extends JFrame{
    CacaPalavraEvoluido jogo = new CacaPalavraEvoluido();

    private JLabel cacaletra = new JLabel("CAÇA LETRAS");
    private JLabel tentativas = new JLabel("Tentativas: "+String.valueOf(jogo.getTentativas()));
    private JLabel letra = new JLabel("Digite uma letra");
    private JLabel palavra = new JLabel(jogo.palavraAtual());
    private JTextField textoPalavra = new JTextField();
    private JButton botao = new JButton("Confirma"); 
    private JButton botaoCompleto = new JButton("Revelar Palavra"); 
    //private JButton botaoReiniciar = new JButton("Reiniciar"); 
    private Font fonte1 = new Font("Arial", Font.PLAIN, 18);
    private Font fonte2 = new Font("Arial", Font.BOLD, 23);

    public Tela(){
    setSize(800, 500); 
    setTitle("Tela principal"); 
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);

    cacaletra.setBounds(10, 10, 300, 25); 
    cacaletra.setFont(fonte2);
    add(cacaletra);

    letra.setBounds(10, 50, 300, 20); 
    letra.setFont(fonte1);
    add(letra);

    palavra.setBounds(10, 100, 300, 20); 
    palavra.setFont(fonte1);
    add(palavra);

    tentativas.setBounds(10, 150, 300, 20); 
    tentativas.setFont(fonte1);
    add(tentativas);
    
    textoPalavra.setBounds(10, 75, 200, 20);
    textoPalavra.setFont(fonte1);
    add(textoPalavra);

    botao.setBounds(230, 75, 200, 20);
    botao.setFont(fonte1);
    add(botao);
    botao.addActionListener(this::acao1);
    
    botaoCompleto.setBounds(230, 105, 200, 20);
    botaoCompleto.setFont(fonte1);
    add(botaoCompleto);
    botaoCompleto.addActionListener(this::acao2);
    
    /*botaoReiniciar.setBounds(230, 135, 200, 20);
    botaoReiniciar.setFont(fonte1);
    add(botaoReiniciar);
    botaoReiniciar.addActionListener(this::acao3);*/

    setVisible(true);
    }

    private void acao1 (ActionEvent actionEvent) {
        jogo.setLetra(textoPalavra.getText().charAt(0));
        jogo.jogar();
        palavra.setText(jogo.palavraAtual());
        tentativas.setText("Tentativas: "+String.valueOf(jogo.getTentativas()));
        textoPalavra.setText("");
    }

    private void acao2 (ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "A Palavra sorteada é: "+jogo.p.getPalavraEscolhida(), "Parabéns", JOptionPane.WARNING_MESSAGE);
    }

    /*private void acao3 (ActionEvent actionEvent) {
        jogo.p.escolherPalavra();
        jogo.palavraAtual();
        jogo.setTentativas(0);
        palavra.setText(jogo.palavraAtual());
        tentativas.setText("Tentativas: "+String.valueOf(jogo.getTentativas()));
        textoPalavra.setText("");
    }*/

}
