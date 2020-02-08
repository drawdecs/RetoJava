/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edward
 */
public class RetoJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in)); 
        int op = -1;
        while(op !=0){
            switch (op) {
                case 1:
                    
                    System.out.println("Por Favor ingrese el los datos del rectangulo:");
                    int alto=-1;
                    while(alto<1 || alto>9){
                        System.out.print("Alto: ");
                        try {
                            alto = Integer.parseInt(in.readLine());
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("el valor ingresado es incorrecto intente con un numero del 1 al 9");
                        }
                    }
                    int ancho=-1;
                    while(ancho<1 || ancho>9){
                        System.out.print("Ancho: ");
                        try {
                            ancho = Integer.parseInt(in.readLine());
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("el valor ingresado es incorrecto intente con un numero del 1 al 9");
                        }
                    }
                    generar(alto,ancho);
                    System.out.print("presione una tecla para continuar");
                    in.read();
                    op = -1;
                    break;
                case 2:
                    System.out.println("Ingrese el texto para Justificar, deje en blanco y presione enter para ver el ejemplo");
                    String texto = in.readLine();
                    System.out.println();
                    justificar(texto);
                    System.out.println();
                    System.out.print("presione una tecla para continuar");
                    in.read();
                    op = -1;
                    break;
                default:
                    {
                        System.out.println("**********************************");
                        System.out.println("***************MENU***************");
                        System.out.println("1  Ejercicio 1: Generar Rectangulo");
                        System.out.println("2  Ejercicio 2: Justificar Texto");
                        System.out.println("0  Salir");
                        System.out.println("**********************************");
                        System.out.println("Elija una opcion:");

                        try {
                            op =Integer.parseInt(in.readLine());
                        } catch (NumberFormatException ex) {
                            op=-1;
                        }
                    } 
                    
            }
            
        }
        System.out.println("Adios...");
        //generar();
        //justificar();
    }
    
    public static void generar(int alto,int ancho){
        System.out.println("Generando Rectangulo...");
        int x;
        int y;
        for(int i=alto;i>0;i--){
            if(i>(alto/2)){
                y=ancho-(alto-i);
            }else{
                y=ancho-i+1;
            }
            for(int j = ancho;j>0;j--){
                if (j > ancho / 2 ) {
                    x=ancho-(ancho-j);
                } else {
                    x=ancho-j+1;
                }
                System.out.print(x>y?x:y);
            }
            System.out.println();
        }
    }
    
    public static void justificar(String textoX){
        String texto;
        if(textoX==null || textoX.isEmpty()){
            texto = "A veces pocas personas logran entender que tanto hacemos con cara de frustración frente a un ordenador, a veces estamos divagando en algoritmos otras ocasiones usando MSN, Kopete, Gaim . . . pero en raras veces dedicamos tiempo al amor informático.";
        }else{
            texto = textoX;
        }
        int linewidht=82;
        String[] a = texto.split(" ");
        List<List<String>> parrafo= new ArrayList<>();
        List<String> linea = new ArrayList<>();
        int[] linecount= new int[texto.length()/linewidht+2];
        int c=0;
        for(int i=0;i<a.length;i++){
            if((linecount[c]+linea.size()+a[i].length())>linewidht){
                parrafo.add(linea);
                linea = new ArrayList<>();
                c++;
                linecount[c]=0;
            }
            linea.add(a[i]);
            linecount[c] =linecount[c]+a[i].length();
        }
        parrafo.add(linea);
        for(int i = 0;i< parrafo.size();i++){
            List<String> plinea = parrafo.get(i);
            int faltante=linewidht-linecount[i];
            int resto = faltante%plinea.size();
            int espaciadobase = (faltante-resto)/plinea.size();
            String strlinea="";
            for(int k=0; k<plinea.size();k++){
                String palabra = plinea.get(k);
                int espaciadofinal = i==parrafo.size()-1?1: espaciadobase+(resto>0?1:0);
                for(int l=0;l<espaciadofinal;l++){
                    palabra += " ";
                }
                resto--;
                plinea.set(k, palabra);
                strlinea = strlinea+palabra;
            }
            
            
//            int j = 0;
//            while(linecount.get(i)<linewidht){
//                String palabra = plinea.get(j);
//                plinea.set(j, palabra+ " ");
//                j++;
//                linecount.set(i,linecount.get(i)+1);
//                if(j==plinea.size()){
//                    j=0;
//                }
//            }
//            for(String palabra : plinea){
//                strlinea =strlinea+ palabra+(plinea.indexOf(palabra)==plinea.size()-1?"":" ");
//            }
//            
            System.out.println(strlinea);
        }
    }
    
}
