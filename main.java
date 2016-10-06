/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;
import java.util.*;
import java.util.Scanner;
public class main {
	/*
	 * Clase encargada del control del programa
	 * 
	 *  Este programa realiza la decodificacion de un String y muestra el codigo huffman  del arbol  que se realiza
	 */
	 // iniciacion del programa
	public static void main(String[] args) {
		
        String oracion = ""; 
        boolean hayArbolInicial=false;
        boolean ciclo=false;
        int op1=0;
        ArbolHuffman arbol=null;
		
        Scanner scan = new Scanner(System.in);
        FuncionesHuffman func= new FuncionesHuffman();
        System.out.println("Bienvenido al programa de operaciones con cadenas, elija entre los siguientes opciones: ");
        while (ciclo==false){
      // se solicita que el usuario ingrese un String  
	System.out.println("\n\n1- Escribir una cadena para saber la frecuencia de los caracteres.");
	System.out.println("2- Decodificar códigos.");
	System.out.println("3- Salir del programa");
	op1 = scan.nextInt();
        if(op1==1){
        System.out.println("\nIngrese la oracion a separar por frecuencia de caracteres:");
	oracion = scan.next();
        
		// se crea un vector con los espacios para la frecuencua de cada letra
        int[] frecuenciaChar = new int[256];
        for (char caracter : oracion.toCharArray())
            frecuenciaChar[caracter]++;
        
        // se manda a crear el arbol
        arbol = func.buildTree(frecuenciaChar);
        
        // obtencion del codigo
        System.out.println("Tabla de frecuencias");
        System.out.println("Caracter\tFrecuencia\tCódigo");
        func.imprimirCodigo(arbol, new StringBuffer());
        hayArbolInicial=true;
        }
        else if(op1==2&&hayArbolInicial==true){
        String codigoOr = "";
        System.out.println("\nIngrese el código a decodificar:");
	codigoOr = scan.next();
        
      
        System.out.println("\n\nDecodificado:");
        if(func.decodificar(arbol,codigoOr)!=null)
            System.out.println(func.decodificar(arbol,codigoOr));
        else
            System.out.println("ERROR, no se encontró dicho codigo en el arbol.");
        }
        else if(op1==2&&hayArbolInicial==false){
            System.out.println("\nERROR, aun no existe árbol existente del cual basarse para decodificar códigos.");
        }
        else if(op1==3){
            System.out.println("\nGracias por utilizar el programa :D");
            ciclo=true;
        }
        else{
            System.out.println("\nERRROR, ingrese una opción válida.");
        }
    }
        }

}
