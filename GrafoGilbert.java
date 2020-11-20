import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GrafoGilbert {
	public static void main(String[] args) {
        /*Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println("Número de nodos: ");
        String nodos = entradaEscaner.nextLine ();
        System.out.println("Núumero de aristas: "); 
        String aristas = entradaEscaner.nextLine();*/
        final String prueba = "C:\\Users\\brand\\Documents\\Maestria\\2semestre\\Algoritmos\\Gilbert500.csv";
        int n = 500;
        double p = 0.2;
        //int m = 124;
		crearArchivoCSV(prueba,n,p);
	}

	private static void crearArchivoCSV(String prueba,int n,double p) {
        genGilbert(prueba,",",n,p);
	}
	private static void genGilbert(String file, String delim,int n,double p) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			fw.append("source").append(delim);
			fw.append("target").append(NEXT_LINE);
			/*fw.append("value1");
			fw.append(delim);
			fw.append("312");
            fw.append(NEXT_LINE);*/
            double prob=0;
		    for(int i=0; i<=n; i++)
			    for(int j=0; j<=n; j++){
				    prob=Math.random();
				    if(prob<=p){
                        String str1 = Integer.toString(i); 
                        String str2 = Integer.toString(j); 
                        fw.append(str1);
                        fw.append(delim);
                        fw.append(str2);
                        fw.append(NEXT_LINE);
                    }
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