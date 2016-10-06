/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;

import java.util.PriorityQueue;

/**
 *
 * @author Didier
 *Clase encargada de crear el arbol con las letras obtenidas del texto
 */
class FuncionesHuffman{
    
	// funcion que determina el arbol a usar 
    public  ArbolHuffman  buildTree(int[] frecuenciasChar) {
    	
        PriorityQueue<ArbolHuffman> foresta = new PriorityQueue<ArbolHuffman>();
        //Crea las frecuencias para cada letra.
        for (int cont = 0; cont < frecuenciasChar.length; cont++){
            if (frecuenciasChar[cont] > 0)
                foresta.offer(new Hoja(frecuenciasChar[cont], (char)cont)); //Inserta a los elementos de acuerdo a la prioridad de las frecuencias.
        }
        //Recorre todos los elementos de la fila.
        //Crea un arbol binario de abajo hacia arriba.
        while (foresta.size() > 1) {
            // nodos con menor frecuencia
            ArbolHuffman  a = foresta.poll(); 
            ArbolHuffman  b = foresta.poll(); 
 
            foresta.offer(new Nodo(a, b)); 
        }
        // retorna el valor del nodo
        return foresta.poll();
    }
 
    
    
    /*  decodificador del String dado*/
    public  String decodificar(ArbolHuffman  arbol, String oracionEnCodigo) {
		// 
    	assert arbol != null;
    	
    	String textoDecodificado="";
    	Nodo nod = (Nodo)arbol;
    	for (char codigo : oracionEnCodigo.toCharArray()){
    		if (codigo == '0'){ 
    		    if (nod.izquierda instanceof Hoja) { 
    		    	textoDecodificado += ((Hoja)nod.izquierda).valor; // se retorna el valor del nnodo
	                nod = (Nodo)arbol; 
	    		}else{
	    			nod = (Nodo) nod.izquierda; // ordena el ambio de nodo
	    		}
    		}else if (codigo == '1'){ 
    		    if (nod.derecha instanceof Hoja) {
    		    	textoDecodificado += ((Hoja)nod.derecha).valor; //retorna el valor del nodo derecho especifico
	                nod = (Nodo)arbol; 
	    		}else{
	    			nod = (Nodo) nod.derecha;
	    		}
    		}
    	} 
    	return textoDecodificado; //se retorna el texto ya decodificado, obtenido del String ingresado
    }    
    
    // metodo para imprimir el codigo de huffman
    public  void imprimirCodigo(ArbolHuffman  arbol, StringBuffer caracteres) {
        assert arbol != null;
        
        if (arbol instanceof Hoja) {
            Hoja hojita = (Hoja)arbol;
            
            
            System.out.println(hojita.valor + "\t" + hojita.frecuencia + "\t\t" + caracteres);
 
        } else if (arbol instanceof Nodo) {
            Nodo nod = (Nodo)arbol;
 
           // imprime 0 si es izquierda
            caracteres.append('0');
            imprimirCodigo(nod.izquierda, caracteres);
            caracteres.deleteCharAt(caracteres.length()-1);
 
            //  imprime 1 si es derecha
            caracteres.append('1');
            imprimirCodigo(nod.derecha, caracteres);
            caracteres.deleteCharAt(caracteres.length()-1);
        }
    }
    
}
