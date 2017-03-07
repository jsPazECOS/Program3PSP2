/**
 * Programa: Programa 3 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 07/03/2017 Clase: Data Descripción: Clase que tiene los atributos de
 * cada archivo, nombre y datos.
*
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

    /**
     * Método constructor de la clase Data
     *
     * @param name nombre del archivo
     * @param data lista de los datos
     */
    public Data(String name, LinkedList<Double> data) {
        this.name = name;
        this.data = data;
    }
    /**
     * Método que permite acceder a los datos de la data
     *
     * @return un valor <code>LinkedList</code> que representa los datos
     */
    public LinkedList<Double> getData() {
        return data;
    }

}
