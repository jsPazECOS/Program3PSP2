/**
 * Programa: Programa 3 - PSP 2
 *
 * @author Juan Sebastian Paz Prieto
 * @date 07/03/2017 Clase: Program Descripción: Clase que lee cada archivo y
 * realiza los calculos requeridos en el formato de requerimientos.
*
 */
package edu.uniandes.ecos.CAIS.P3PSP2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Program {

    private LinkedList<Data> files;
    private Data x;
    private Data y;
    private Double XSum;
    private Double YSum;
    private Double XAvg;
    private Double YAvg;
    private Double XSquaredSum;
    private Double YSquaredSum;
    private Double XxY;
    private Double B1;
    private Double B0;
    private Double Rxy;
    private Double R2;
    private Double Yk;
    private Double Xk;

    /**
     * Método que permite acceder a la listas de datos leidas desde los archivos
     * de texto
     *
     * @return un valor <code>LinkedList</code> que representa los datos
     */
    public LinkedList<Data> getFiles() {
        return files;
    }

    /**
     * Método que permite acceder a los valores de X
     *
     * @return un valor <code>Data</code> los datos de X
     */
    public Data getX() {
        return x;
    }

    /**
     * Método que permite establecer los valores de X
     *
     * @param x
     */
    public void setX(Data x) {
        this.x = x;
    }

    /**
     * Método que permite acceder a los valores de Y
     *
     * @return un valor <code>Data</code> los datos de Y
     */
    public Data getY() {
        return y;
    }

    /**
     * Método que permite establecer los valores de Y
     *
     * @param y
     */
    public void setY(Data y) {
        this.y = y;
    }

    /**
     * Método que permite acceder a la sumatoria de los valores de X
     *
     * @return un valor <code>Double</code> de la sumatoria de los valores de X
     */
    public Double getXSum() {
        return XSum;
    }

    /**
     * Método que permite establecer el valor de la sumatoria de X
     *
     * @param XSum
     */
    public void setXSum(Double XSum) {
        this.XSum = XSum;
    }

    /**
     * Método que permite acceder a la sumatoria de los valores de Y
     *
     * @return un valor <code>Double</code> de la sumatoria de los valores de Y
     */
    public Double getYSum() {
        return YSum;
    }

    /**
     * Método que permite establecer el valor de la sumatoria de Y
     *
     * @param YSum
     */
    public void setYSum(Double YSum) {
        this.YSum = YSum;
    }

    /**
     * Método que permite acceder al promedio de los valores de X
     *
     * @return un valor <code>Double</code> del promedio de los valores de X
     */
    public Double getXAvg() {
        return XAvg;
    }

    /**
     * Método que permite establecer el valor promedio de los valores de X
     *
     * @param XAvg
     */
    public void setXAvg(Double XAvg) {
        this.XAvg = XAvg;
    }

    /**
     * Método que permite acceder al promedio de los valores de Y
     *
     * @return un valor <code>Double</code> del promedio de los valores de Y
     */
    public Double getYAvg() {
        return YAvg;
    }

    /**
     * Método que permite establecer el valor promedio de los valores de Y
     *
     * @param YAvg
     */
    public void setYAvg(Double YAvg) {
        this.YAvg = YAvg;
    }

    /**
     * Método que permite acceder a la sumatoria de los valores de X al cuadrado
     *
     * @return un valor <code>Double</code> del promedio de los valores de X
     */
    public Double getXSquaredSum() {
        return XSquaredSum;
    }

    /**
     * Método que permite establecer el valor de la sumatoria de los valores de
     * X al cuadrado
     *
     * @param XSquaredSum
     */
    public void setXSquaredSum(Double XSquaredSum) {
        this.XSquaredSum = XSquaredSum;
    }

    /**
     * Método que permite acceder a la sumatoria de los valores de X al cuadrado
     *
     * @return un valor <code>Double</code> de la sumatoria de los valores de X
     * al cuadrado
     */
    public Double getYSquaredSum() {
        return YSquaredSum;
    }

    /**
     * Método que permite establecer el valor de la sumatoria de los valores de
     * Y al cuadrado
     *
     * @param YSquaredSum
     */
    public void setYSquaredSum(Double YSquaredSum) {
        this.YSquaredSum = YSquaredSum;
    }

    /**
     * Método que permite acceder a la sumatoria de los valores de la
     * multiplicación entre Y y X
     *
     * @return un valor <code>Double</code> de la sumatoria de los valores de X
     * al cuadrado
     */
    public Double getXxY() {
        return XxY;
    }

    /**
     * Método que permite establecer el valor de la sumatoria de los valores de
     * la multiplicación entre Y y X
     *
     * @param XxY
     */
    public void setXxY(Double XxY) {
        this.XxY = XxY;
    }

    /**
     * Método que permite acceder al valor de B1
     *
     * @return un valor <code>Double</code> de B1
     */
    public Double getB1() {
        return B1;
    }

    /**
     * Método que permite calcular el valor de B1
     */
    public void setB1() {
        int size = this.getX().getData().size();
        Double a = this.getXxY() - (size * this.getXAvg() * this.getYAvg());
        Double b = this.getXSquaredSum() - (size * this.getXAvg() * this.getXAvg());
        this.B1 = a / b;
    }

    /**
     * Método que permite acceder al valor de B0
     *
     * @return un valor <code>Double</code> de B0
     */
    public Double getB0() {
        return B0;
    }

    /**
     * Método que permite calcular el valor de B0
     */
    public void setB0() {
        this.B0 = this.getYAvg() - (this.getB1() * this.getXAvg());
    }

    /**
     * Método que permite acceder al valor de Rxy
     *
     * @return un valor <code>Double</code> de Rxy
     */
    public Double getRxy() {
        return Rxy;
    }

    /**
     * Método que permite calcular el valor de Rxy
     */
    public void setRxy() {
        int size = this.getX().getData().size();

        Double partA = size * this.getXxY();
        Double partB = this.getXSum() * this.getYSum();

        Double a = partA - partB;

        Double b = (size * this.getXSquaredSum()) - (Math.pow(this.getXSum(), 2));
        Double c = (size * this.getYSquaredSum()) - (Math.pow(this.getYSum(), 2));
        Double d = Math.sqrt(b * c);

        this.Rxy = a / d;
    }

    /**
     * Método que permite acceder al valor de R al cuadrado
     *
     * @return un valor <code>Double</code> de R al cuadrado
     */
    public Double getR2() {
        return R2;
    }

    /**
     * Método que permite calcular el valor de R al cuadrado
     */
    public void setR2() {
        this.R2 = Math.pow(this.getRxy(), 2);
    }

    /**
     * Método que permite acceder al valor de Yk
     *
     * @return un valor <code>Double</code> de Yk
     */
    public Double getYk() {
        return Yk;
    }

    /**
     * Método que permite calcular el valor de Yk
     */
    public void setYk() {
        this.Yk = this.getB0() + (this.getB1() * this.getXk());
    }

    /**
     * Método que permite acceder al valor de Xk
     *
     * @return un valor <code>Double</code> de Xk
     */
    public Double getXk() {
        return Xk;
    }

    /**
     * Método que permite calcular el valor de Xk
     *
     * @param Xk
     */
    public void setXk(Double Xk) {
        this.Xk = Xk;
    }

    /**
     * Método constructor de la clase Program
     */
    public Program() {
        this.files = new LinkedList<Data>();
    }

    /**
     * Método que lee los archivos localizados en path para instanciar objetos
     * de tipo Data
     *
     * @param path
     */
    public void readFiles(String path) {

        File[] files = new File(path).listFiles();

        for (File file : files) {
            String name = file.getName();
            LinkedList<Double> data = new LinkedList<Double>();
            BufferedReader content = this.getFileContent(file.getPath());
            try {
                String sCurrentLine;

                while ((sCurrentLine = content.readLine()) != null) {
                    sCurrentLine = sCurrentLine.trim();
                    data.add(Double.parseDouble(sCurrentLine));
                }
            } catch (IOException ex) {

            }
            this.files.add(new Data(name, data));
        }

    }

    private BufferedReader getFileContent(String path) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return br;
    }

    /**
     * Método que permite crear los casos de prueba apartir de los datos de los
     * archivos
     *
     * @param x
     * @param y
     */
    public void createCase(int x, int y) {
        this.setX(this.getFiles().get(x));
        this.setY(this.getFiles().get(y));

        this.setXSum(this.calculateSumatory(this.getX()));
        this.setYSum(this.calculateSumatory(this.getY()));

        this.setXAvg(this.getXSum() / this.getX().getData().size());
        this.setYAvg(this.getYSum() / this.getY().getData().size());

        this.setXSquaredSum(this.calculateSquaredSumatory(this.getX()));
        this.setYSquaredSum(this.calculateSquaredSumatory(this.getY()));

        this.setXxY(this.multiplication(this.getX(), this.getY()));

        this.setB1();
        this.setB0();
        this.setRxy();
        this.setR2();
        this.setYk();
    }

    /**
     * Método que calcula la sumatoria de los datos de una serie de datos
     *
     * @param data
     * @return un valor <code>Double</code> de la sumatoria de una serie de
     * datos
     */
    public Double calculateSumatory(Data data) {
        Double sumatory = 0.0;
        Iterator it = data.getData().iterator();

        while (it.hasNext()) {
            double number = (Double) it.next();
            sumatory += number;
        }

        return sumatory;
    }

    /**
     * Método que calcula la sumatoria de los datos al cuadrado de una serie de
     * datos
     *
     * @param data
     * @return un valor <code>Double</code> de la sumatoria de los datos al
     * cuadrado una serie de datos
     */
    public Double calculateSquaredSumatory(Data data) {
        Double sumatory = 0.0;
        Iterator it = data.getData().iterator();

        while (it.hasNext()) {
            double number = (Double) it.next();
            number = number * number;
            sumatory += number;
        }

        return sumatory;
    }

    /**
     * Método que calcula la sumatoria de la multiplicación entre los datos de
     * dos series de datos
     *
     * @param X
     * @param Y
     * @return un valor <code>Double</code> de la sumatoria de la multiplicación
     * entre los datos de dos series de datos
     */
    public Double multiplication(Data X, Data Y) {
        Double sumatory = 0.0;
        Iterator it = X.getData().iterator();
        int i = 0;
        while (it.hasNext()) {
            sumatory += X.getData().get(i) * Y.getData().get(i);
            i++;
            it.next();
        }

        return sumatory;
    }

}
