/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bruna
 */
public class BinaryTree<BT> {
    private BT info;
    private BinaryTree<BT> esquerda;
    private BinaryTree<BT> direita;
    
    public BinaryTree(BT info) {
        this.info = info;
    }

    public BinaryTree(BT info, BT esquerda, BT direita) {
        this.info = info;
        this.setEsquerda(esquerda);
        this.setDiretia(direita);
    }

    public BT getInfo() {
        return info;
    }

    public void setInfo(BT info) {
        this.info = info;
    }

    public BinaryTree<BT> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(BinaryTree<BT> esquerda) {
        this.esquerda = esquerda;
    }
    
    public void setEsquerda(BT esquerda) {
        this.setEsquerda(new BinaryTree<BT>(esquerda));
    }

    public BinaryTree<BT> getDireita() {
        return direita;
    }

    public void setDireita(BinaryTree<BT> direita) {
        this.direita = direita;
    }
    
    public void setDiretia(BT direita) {
        this.setDireita(new BinaryTree<BT>(direita));
    }
    
    // Retorna true se não tiver nenhuma child
    public boolean isChild() {
        return getDireita() == null && getEsquerda() == null;
    }
    
    
}
