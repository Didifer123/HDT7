/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;
/**
 *
 * @author Esteban Avalos
 */
// Clase abstracta encargada  de encontrar la frecuencia de las letras
abstract class ArbolHuffman implements Comparable<ArbolHuffman> {
    public final int frecuencia; 
    
    public ArbolHuffman(int enterFrecuencia) { 
    	frecuencia = enterFrecuencia; 
    }
    
    
    public int compareTo(ArbolHuffman tree) {
        return frecuencia - tree.frecuencia;
    }
}