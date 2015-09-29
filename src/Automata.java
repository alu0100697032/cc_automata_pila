import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Automata {

	/*
	 * ATRIBUTOS
	 */
	private ArrayList<String> conjuntoQ;
	private ArrayList<String> conjuntoSingma;
	private ArrayList<String> conjuntoR;
	private String estadoInicial;
	private String simboloInicialPila;
	private ArrayList<String> conjuntoF;
	private ArrayList<String[]> conjuntoTransiciones;
	
	/*
	 * CONSTRUCTOR
	 */
	 
	public Automata() throws IOException{
		
		conjuntoQ = new ArrayList<String>();
		conjuntoSingma = new ArrayList<String>();
		conjuntoR = new ArrayList<String>();
		conjuntoF = new ArrayList<String>();
		conjuntoTransiciones = new ArrayList<String[]>();
		
		String nombreFichero;
		File ruta;
		Scanner imputUsuario = new Scanner(System.in);
		//Pedir el fichero al usuario
		//System.out.println("Introduzca el nombre del fichero con los datos del autómata:");
		//nombreFichero = imputUsuario.nextLine(); (para versión final)
		imputUsuario.close();
		nombreFichero = "automata1.txt"; //para versión de desarrollo
		ruta = new File(nombreFichero);
		//Almacenar la informacion del fichero
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
				if(linea >= 6){
					String separarEspacios[] = textoFichero.split(" ");
					conjuntoTransiciones.add(separarEspacios);
				}else{
					String separarEspacios[] = textoFichero.split(" ");
					for(int i = 0; i < separarEspacios.length; i++){
						if(separarEspacios[i].matches("#.*"))
							break;
						else{
							if(linea == 0)
								conjuntoQ.add(separarEspacios[i]);
							else if(linea == 1)
								conjuntoSingma.add(separarEspacios[i]);
							else if(linea == 2)
								conjuntoR.add(separarEspacios[i]);
							else if(linea == 3)
								estadoInicial = separarEspacios[i];
							else if(linea == 4)
								simboloInicialPila = separarEspacios[i];
							else if(linea == 5)
								conjuntoF.add(separarEspacios[i]);
						}
					}
				}
				linea++;
			}
		}
		bufferLectura.close();
		
	}
	/*
	 * MOSTRAR INFORMACION DEL AUTOMATA
	 */
	public void mostrarInformacionAutomata(){
		System.out.println("Información del autómata con pila");
		System.out.println();
		System.out.println("Estado inicial: " + estadoInicial);
		System.out.println("Símbolo inicial de la pila: " + simboloInicialPila);
		System.out.println("Conjunto Q: " + conjuntoQ.toString());
		System.out.println("Conjunto Sigma: " + conjuntoSingma.toString());
		System.out.println("Conjunto R: " + conjuntoR.toString());
		System.out.println("Conjunto F: " + conjuntoF.toString());
		System.out.println("Conjunto de transiciones:");
		for(int i = 0; i < conjuntoTransiciones.size(); i++)
			System.out.println(Arrays.toString(conjuntoTransiciones.get(i)));
	}
	/*
	 * EJECUTAR AUTOMATA	
	 */
	public void ejecutarAutomata(){
		Scanner imputUsuario = new Scanner(System.in);
		System.out.println("Inserte la cadena a probar:");
		String cadenaEntrada = imputUsuario.nextLine();
		imputUsuario.close();
		//SEPARAR LA CADENA EN LETRAS SEPARADAS
		for(int i = 0; i < cadenaEntrada.length(); i++){
			
		}
	}
}

