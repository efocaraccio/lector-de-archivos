package lector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcesadorDeArchivo {

	File archivo;
	FileReader fr;
	BufferedReader br;
	
	
	public ProcesadorDeArchivo() {
		try {
			archivo = new File("C:\\Users\\Biactiva\\Documents\\usuarioprode1");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			try {
				fr.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public BufferedReader getBr() {
		return br;
	}
	
	public FileReader getFr() {
		return fr;
	}
	
	
	public static void main(String[] args) throws IOException {
		ProcesadorDeArchivo procesador = new ProcesadorDeArchivo();
		String linea;
		String text = "";
		
		FileWriter fichero = new FileWriter("C:\\Users\\Biactiva\\Documents\\emailsProde1.txt");
		PrintWriter pw = new PrintWriter(fichero);
		int i=0;
		try {
			while((linea=procesador.getBr().readLine()) != null) {
				String words[] = linea.split("	");
				System.out.println(words[4]);
				i++;
				text += words[4] + ";";
			}
			pw.print(text);
			System.out.println(i);
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			procesador.getFr().close();
			fichero.close();
		}
		
	}

}
