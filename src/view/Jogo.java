/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Frame;
import model.BinaryTree;

/**
 *
 * @author bruna
 */
public class Jogo {
    // Adiciona o JFrame
    private static final Frame frame = new Frame();
    
    // Root da Binary Tree
    private final BinaryTree<String> root;
    
    private Jogo() {
        // Iniciando a Binary Tree
        this.root = new BinaryTree<>("massa", "Lasanha", "Bolo de Chocolate");
    }
    
    // Pergunta sobre a primeira comida
    private BinaryTree<String> adivinhaComida() {
        BinaryTree<String> bt = root;
        
        while(!bt.isChild()) {
            // Se true, retorna para a esquerda
            if(frame.perguntaCaracteristica(bt)) {
                bt = bt.getEsquerda();
            }
            // Se true, retorna para a direita
            else {
                bt = bt.getDireita();
            }
        }
        return bt;
    }
    
    // Adiciona nova comida
    private static void adicionaNova(BinaryTree<String> child, String comida, String caracteristica) {
        child.setDiretia(child.getInfo());
        child.setEsquerda(comida);
        child.setInfo(caracteristica);
    }
    
    // Começa o jogo
    public static void comecaJogo() {
        Jogo jogo = new Jogo();
        
        while(frame.iniciarJogo()) {
            BinaryTree<String> achar = jogo.adivinhaComida();
            
            // Se adivinhar a comida do usuário
            if(frame.perguntaCaracteristica(achar)) {
                frame.correto();
                continue;
            }
            
            // Se não acertar, adiciona nova comida
            String comida = frame.adicionaNovaComida();
            adicionaNova(achar, comida, frame.adicionaNovaCaracteristica(comida, achar));
        }
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                comecaJogo();
                System.exit(0);
            }
        });
    }
}
