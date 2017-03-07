/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P3PSP2;

import java.util.LinkedList;

/**
 *
 * @author Juan Paz
 */
public class Data {

    private String name;
    private LinkedList<Double> data;

    public Data(String name, LinkedList<Double> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Double> getData() {
        return data;
    }

    public void setData(LinkedList<Double> data) {
        this.data = data;
    }
    
    
    
}
