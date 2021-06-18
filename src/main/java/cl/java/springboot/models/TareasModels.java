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
public class TareasModels {

    private int total_horas;
    private int dias_trabajo;
    private ArrayList<JornadaModels> jornadas;
    private int horas_jornadas;

    public TareasModels(int total_horas, int dias_trabajo, ArrayList<JornadaModels> jornadas, int horas_jornadas) {
     this.total_horas = total_horas;
     this.dias_trabajo = dias_trabajo;
     this.jornadas = jornadas;
     this.horas_jornadas = horas_jornadas;
    }
    public TareasModels(){
    }

    public ArrayList<JornadaModels> getJornadas() {
        return jornadas;
    }

    public void setJornadas(ArrayList<JornadaModels> jornadas) {
        this.jornadas = jornadas;
    }

    public int getTotal_horas() {
        return total_horas;
    }

    public void setTotal_horas(int total_horas) {
        this.total_horas = total_horas;
    }

    public int getDias_trabajo() {
        return dias_trabajo;
    }

    public void setDias_trabajo(int dias_trabajo) {
        this.dias_trabajo = dias_trabajo;
    }

    public int getHoras_jornadas() {
        return horas_jornadas;
    }

    public void setHoras_jornadas(int horas_jornadas) {
        this.horas_jornadas = horas_jornadas;
    }

}
