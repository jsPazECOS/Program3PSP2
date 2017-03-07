/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.CAIS.P3PSP2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Paz
 */
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

    public LinkedList<Data> getFiles() {
        return files;
    }

    public void setFiles(LinkedList<Data> files) {
        this.files = files;
    }

    public Data getX() {
        return x;
    }

    public void setX(Data x) {
        this.x = x;
    }

    public Data getY() {
        return y;
    }

    public void setY(Data y) {
        this.y = y;
    }

    public Double getXSum() {
        return XSum;
    }

    public void setXSum(Double XSum) {
        this.XSum = XSum;
    }

    public Double getYSum() {
        return YSum;
    }

    public void setYSum(Double YSum) {
        this.YSum = YSum;
    }

    public Double getXAvg() {
        return XAvg;
    }

    public void setXAvg(Double XAvg) {
        this.XAvg = XAvg;
    }

    public Double getYAvg() {
        return YAvg;
    }

    public void setYAvg(Double YAvg) {
        this.YAvg = YAvg;
    }

    public Double getXSquaredSum() {
        return XSquaredSum;
    }

    public void setXSquaredSum(Double XSquaredSum) {
        this.XSquaredSum = XSquaredSum;
    }

    public Double getYSquaredSum() {
        return YSquaredSum;
    }

    public void setYSquaredSum(Double YSquaredSum) {
        this.YSquaredSum = YSquaredSum;
    }

    public Double getXxY() {
        return XxY;
    }

    public void setXxY(Double XxY) {
        this.XxY = XxY;
    }

    public Double getB1() {
        return B1;
    }

    public void setB1() {
        int size = this.getX().getData().size();
        Double a = this.getXxY() - (size * this.getXAvg() * this.getYAvg());
        Double b = this.getXSquaredSum() - (size * this.getXAvg() * this.getXAvg());
        this.B1 = a / b;
    }

    public Double getB0() {
        return B0;
    }

    public void setB0() {

        this.B0 = this.getYSquaredSum() - (this.getB1() * this.getXSquaredSum());
    }

    public Double getRxy() {
        return Rxy;
    }

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

    public Double getR2() {
        return R2;
    }

    public void setR2() {
        this.R2 = Math.pow(this.getRxy(), 2);
    }

    public Double getYk() {
        return Yk;
    }

    public void setYk() {

        this.Yk = this.getB0() + (this.getB1() * this.getXk());
    }

    public Double getXk() {
        return Xk;
    }

    public void setXk(Double Xk) {
        this.Xk = Xk;
    }

    public Program() {
        this.files = new LinkedList<Data>();
    }

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

    public Double calculateSumatory(Data data) {
        Double sumatory = 0.0;
        Iterator it = data.getData().iterator();

        while (it.hasNext()) {
            double number = (Double) it.next();
            sumatory += number;
        }

        return sumatory;
    }

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
