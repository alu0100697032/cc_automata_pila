import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Automata {

	private ArrayList<String> conjuntoQ;
	private ArrayList<String> conjuntoSingma;
	private ArrayList<String> conjuntoR;
	private String estadoInicial;
	private String simboloInicialPila;
	private ArrayList<String> conjuntoF;
	private ArrayList<ArrayList<String>> conjuntoTransiciones;
	
	public Automata() throws IOException{
		
		conjuntoQ = new ArrayList<String>();
		
		String nombreFichero;
		File ruta;
		Scanner imputUsuario = new Scanner(System.in);
		//Pedir el fichero al usuario
		System.out.println("Introduzca el nombre del fichero con los datos del autómata:");
		nombreFichero = imputUsuario.nextLine();
		ruta = new File(nombreFichero);
		//Leer informacion del fichero
		String textoFichero;
		FileReader leerFichero = new FileReader("./src/" + ruta);
		BufferedReader bufferLectura = new BufferedReader(leerFichero);
		int linea = 0;
		while((textoFichero = bufferLectura.readLine())!=null) {
			if(textoFichero.matches("#.*"))
				continue;
			else if(textoFichero.matches("\b*"))
				continue;
			else{
				String separarEspacios[] = textoFichero.split(" ");
				for(int i = 0; i < separarEspacios.length; i++){
					if(separarEspacios[i].matches("#.*"))
						break;
					else{
						if(linea == 0)
							conjuntoQ.add(separarEspacios[i]);
					}
				}
				linea++;
			}
		}
		bufferLectura.close();
		
	}
}

