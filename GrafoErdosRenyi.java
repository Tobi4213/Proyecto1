import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GrafoErdosRenyi {
	public static void main(String[] args) {
        /*Scanner entradaEscaner = new Scanner (System.in); 
        System.out.println("Número de nodos: ");
        String nodos = entradaEscaner.nextLine ();
        System.out.println("Núumero de aristas: "); 
        String aristas = entradaEscaner.nextLine();*/
        final String prueba = "C:\\Users\\brand\\Documents\\Maestria\\2semestre\\Algoritmos\\ErdosRenyi500.csv";
        int n = 500;
        int m = 345;
		crearArchivoCSV(prueba,n,m);
	}

	private static void crearArchivoCSV(String prueba,int n,int m) {
        genErdosRenyi(prueba,",",n,m);
	}
	private static void genErdosRenyi(String file, String delim,int n,int m) {
		final String NEXT_LINE = "\n";
		try {
			FileWriter fw = new FileWriter(file);
			fw.append("source").append(delim);
			fw.append("target").append(NEXT_LINE);
			/*fw.append("value1");
			fw.append(delim);
			fw.append("312");
            fw.append(NEXT_LINE);*/
            for(int i=0; i<m; i++){
                Random r = new Random();
                int n1=r.nextInt(n)+1; 
                int n2=r.nextInt(n)+1; 
                String str1 = Integer.toString(n1); 
                String str2 = Integer.toString(n2); 
                fw.append(str1);
                fw.append(delim);
                fw.append(str2);
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