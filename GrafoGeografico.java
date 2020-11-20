import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class GrafoGeografico {
	public static void main(String[] args) {
        /*Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println("Número de nodos: ");
        String nodos = entradaEscaner.nextLine ();
        System.out.println("Núumero de aristas: "); 
        String aristas = entradaEscaner.nextLine();*/
        final String prueba = "C:\\Users\\brand\\Documents\\Maestria\\2semestre\\Algoritmos\\Geografico500.csv";
        int n = 500;
        int x = 25;
        int y = 20;
        double r= 1.5;
        //double p = 0.2;
        //int m = 124;
		crearArchivoCSV(prueba,n,x,y,r);
	}

	private static void crearArchivoCSV(String prueba,int n,int x,int y, double r) {
        genGilbert(prueba,",",n,x,y,r);
	}
	private static void genGilbert(String file, String delim,int n,int x,int y,double r) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			fw.append("source").append(delim);
			fw.append("target").append(NEXT_LINE);
			/*fw.append("value1");
			fw.append(delim);
			fw.append("312");
            fw.append(NEXT_LINE);*/
            int ns = 1;
            int nt = 1;
            double distancia;
		    for(int i=0; i<x; i++)
                for(int j=0; j<y; j++){
                    for(int k=0; k<x; k++)
                        for(int l=0; l<y; l++){
                            distancia=Math.sqrt(Math.pow((k-i),2)+Math.pow((l-j),2));
                            if(distancia<=r){
                                String str1 = Integer.toString(ns); 
                                String str2 = Integer.toString(nt); 
                                fw.append(str1);
                                fw.append(delim);
                                fw.append(str2);
                                fw.append(NEXT_LINE);
                            }
                            nt = nt+1;
                        }
                    ns = ns+1;
                    nt = 1;
                }
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// Error al crear el archivo, por ejemplo, el archivo 
			// está actualmente abierto.
			e.printStackTrace();
		}
	}
}