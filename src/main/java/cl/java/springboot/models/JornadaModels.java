/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.java.springboot.models;

import java.util.ArrayList;

/**
 *
 * @author Gamer
 */
public class JornadaModels {

    private Number id;
    private ArrayList<String> tareas;

    public JornadaModels(Number id, ArrayList<String> tareas) {
        this.id = id;
        this.tareas = tareas;
    }
    public JornadaModels(){}

    public ArrayList<String> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<String> tareas) {
        this.tareas = tareas;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

}
