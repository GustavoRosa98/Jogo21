/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula07.pkg10;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author guga-
 */
public class Aula0710 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String st, stNaipe, jop, totalCartas, cartaAtual;
        String simbCarta;
        int nValorTotal, valorCarta = 0, naipe = 0, simbolo = 0;
        boolean denovo = true, perdeu = false;
        JOptionPane.showMessageDialog(null, "AULA 07/10\nJogo 21\nClique para iniciar");
        while(true){
            Baralho b1 = new Baralho();
            nValorTotal = 0;
            totalCartas = "";
            do{
                perdeu = false;
                valorCarta = 0;
                Random random = new Random();
                 do{
                    naipe = random.nextInt(3);
                    simbolo = random.nextInt(12);
                }while(b1.verificaSeJaFoi(naipe, simbolo)== true);
                simbCarta = b1.getCarta(naipe, simbolo);
                b1.lancaCarta(naipe, simbolo);
                valorCarta = b1.calculaValorCarta(simbolo);
                stNaipe = b1.getNaipe(naipe, simbolo);
                nValorTotal += b1.calculaValorCarta(simbolo);
                cartaAtual = "|" + simbCarta + " " + stNaipe + "| ";
                totalCartas = totalCartas + " " + cartaAtual;
                jop = "Total Cartas: " + totalCartas + "\nValor total: " + nValorTotal;
                if(nValorTotal > 21){
                    JOptionPane.showMessageDialog(null, jop + "\nVocê Perdeu", "Fim de Jogo", JOptionPane.ERROR_MESSAGE);
                    perdeu = true;
                    break;
                }
                st = JOptionPane.showInputDialog(jop + "\nLançar outra carta? (S/N) ou 0 para sair");
                if(st.equals("S") || st.equals("s"))
                    denovo = true;
                else if(st.equals("0"))
                    return;
                else
                    denovo = false;
            }while(denovo == true); 
            //O JOGADOR DECIDIU PARAR
            if(perdeu == false){
                int scoreJogador = nValorTotal;
                
                
                //VEZ DA MAQUINA JOGAR
                
                b1 = new Baralho();
                do{
                    valorCarta = 0;
                    Random random = new Random();
                    do{
                        naipe = random.nextInt(3);
                        if(nValorTotal <= 15)
                            simbolo = random.nextInt(12);
                        else
                            simbolo = random.nextInt(4);
                    }while(b1.verificaSeJaFoi(naipe, simbolo)== true);
                    simbCarta = b1.getCarta(naipe, simbolo);
                    b1.lancaCarta(naipe, simbolo);
                    valorCarta = b1.calculaValorCarta(simbolo);
                    stNaipe = b1.getNaipe(naipe, simbolo);
                    nValorTotal += b1.calculaValorCarta(simbolo);
                    cartaAtual = "|" + simbCarta + " " + stNaipe + "| ";
                    totalCartas = totalCartas + " " + cartaAtual;                
                }while(nValorTotal <= scoreJogador);
                jop = "Cartas CPU: " + totalCartas;
                jop = jop + "\nScore Jogador: "+ scoreJogador + "\nScore CPU: "
                    + nValorTotal;
                if(nValorTotal > 21){
                    JOptionPane.showMessageDialog(null, jop + "\nVocê Venceu!");
                }else{
                    JOptionPane.showMessageDialog(null, jop + "\nVocê Perdeu");
                }
            }
        }//WHILE TRUE
    }
    
}
