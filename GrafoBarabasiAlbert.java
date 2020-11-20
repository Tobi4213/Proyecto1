import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
import java.util.*;

public class GrafoBarabasiAlbert {
	public static void main(String[] args) {
        /*Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println("Número de nodos: ");
        String nodos = entradaEscaner.nextLine ();
        System.out.println("Núumero de aristas: "); 
        String aristas = entradaEscaner.nextLine();*/
        final String prueba = "C:\\Users\\brand\\Documents\\Maestria\\2semestre\\Algoritmos\\BarabasiAlbert500.csv";
        int n = 500;
        int d = 10;
		crearArchivoCSV(prueba,n,d);
	}

	private static void crearArchivoCSV(String prueba,int n,int d) {
        genBarabasiAlbert(prueba,",",n,d);
	}
	private static void genBarabasiAlbert(String file, String delim,int n,int d) {
		final String NEXT_LINE = "\n";
		try {
            List<List<String>> grafo = new ArrayList<List<String>>();
            for(int i=0; i<n; i++)
                grafo.add(new ArrayList<String>());
            for(int i=0; i<d; i++)
                for(int j=0; j<d; j++){
                    String st = Integer.toString(j);
                    grafo.get(i).add(st);
                }
            for(int i=d; i<n; i++)
                for(int k=0; k<grafo.size(); k++){
                    int count = d;
                    double p = Math.random();
                    double prob = grafo.get(k).size()/grafo.size();
                    if(p>=prob&&count!=0){
                        String str = Integer.toString(k);
                        grafo.get(i).add(str); 
                        count-=1;   
                        }
                    else
                        break;
            } 
			FileWriter fw = new FileWriter(file);
			fw.append("source").append(delim);
			fw.append("target").append(NEXT_LINE);
			/*fw.append("value1");
			fw.append(delim);
			fw.append("312");
            fw.append(NEXT_LINE);*/
            for(int i=0; i<grafo.size(); i++)
                for(int j=0; j<grafo.get(i).size(); j++){
                    String str1 = Integer.toString(i);
                    fw.append(str1);
                    fw.append(delim);
                    fw.append(grafo.get(i).get(j));
                    fw.append(NEXT_LINE);
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