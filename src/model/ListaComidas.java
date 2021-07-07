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
import java.util.ArrayList;
import java.util.List;

public class ListaComidas {
    private List<Comida> comidas = new ArrayList<>();

    public ListaComidas() {

    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }
}
