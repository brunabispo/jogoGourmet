/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JFrame;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author bruna
 */
public class Frame {
    // Criar o JFrame programaticamente
    private final JFrame jFrame;
//    private int resposta;
    
    public Frame() {
        this.jFrame = new JFrame();
    }
    
    // Começar o jogo
    public boolean iniciarJogo() {
        int resposta = showConfirmDialog(jFrame, "Pense em um prato que goste", "Jogo Gourmet", OK_CANCEL_OPTION);
        return resposta == OK_OPTION;
    }
    
    // Perguntar para o usuário se essa é a comida escolhida
    private boolean perguntaComida(String str) {
        String pergunta = String.format("O prato que você pensou é %s?", str);
        int resposta = showConfirmDialog(jFrame, pergunta, "Jogo Gourmet", YES_NO_OPTION, QUESTION_MESSAGE);
        return resposta == YES_OPTION;
    }
    
    // Perguntar para o usuário se essa característica pertence a comida escolhida
    public boolean perguntaCaracteristica(BinaryTree<String> bt) {
        return perguntaComida(bt.getInfo());
    }
    
    // Quando acertar a comida escolhida pelo usuário
    public void correto() {
        showMessageDialog(jFrame, "Acertei de novo!", "Acertei!", INFORMATION_MESSAGE);
    }
    
    /* Quando nenhuma das comidas é a correta
        e o usuário tem que adicionar uma nova
    */
    public String adicionaNovaComida() {
        return showInputDialog(jFrame, "Qual prato você pensou?", "Desisto", QUESTION_MESSAGE);
    }
    
    /* Pergunta para o usuário qual a característica do novo prato que não tem
        no prato já adicionado
    */
    public String adicionaNovaCaracteristica(String novaComida, BinaryTree<String> antigaComida) {
        return showInputDialog(jFrame, String.format("%s é ______________ mas %s não.", novaComida, antigaComida.getInfo()), "Desisto", QUESTION_MESSAGE);
    }   
}
