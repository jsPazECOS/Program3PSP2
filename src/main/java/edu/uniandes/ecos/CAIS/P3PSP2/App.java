package edu.uniandes.ecos.CAIS.P3PSP2;

/**
* Programa: Programa 3 - PSP 2
* @author Juan Sebastian Paz Prieto 
* @date  07/03/2017 
* Clase: App
* Descripción: Esta clase Instancia la clase Program y accede a sus métodos
**/

public class App {

    public static void main(String[] args) {
        Program program3 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        program3.readFiles(path);
        program3.setXk(386.0);
       
        System.out.println("Test 1");
        program3.createCase(2, 0);
        System.out.println("B1 " + program3.getB1());
        System.out.println("B0 " + program3.getB0());
        System.out.println("Rxy " + program3.getRxy());
        System.out.println("R2 " + program3.getR2());
        System.out.println("Yk " + program3.getYk());
        
        System.out.println("Test 2");
        program3.createCase(2, 1);
        System.out.println("B1 " + program3.getB1());
        System.out.println("B0 " + program3.getB0());
        System.out.println("Rxy " + program3.getRxy());
        System.out.println("R2 " + program3.getR2());
        System.out.println("Yk " + program3.getYk());
        
        System.out.println("Test 3");
        program3.createCase(3, 0);
        System.out.println("B1 " + program3.getB1());
        System.out.println("B0 " + program3.getB0());
        System.out.println("Rxy " + program3.getRxy());
        System.out.println("R2 " + program3.getR2());
        System.out.println("Yk " + program3.getYk());
        
        System.out.println("Test 4");
        program3.createCase(3, 1);
        System.out.println("B1 " + program3.getB1());
        System.out.println("B0 " + program3.getB0());
        System.out.println("Rxy " + program3.getRxy());
        System.out.println("R2 " + program3.getR2());
        System.out.println("Yk " + program3.getYk());
    }
}
