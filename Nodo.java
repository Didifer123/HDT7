/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;
/*
 *  clase que crea el nodo
 */
 
 // clase heredada del arbol, que es la  que crea cada nodo
class Nodo extends ArbolHuffman {
    public final ArbolHuffman izquierda, derecha; 
 
    public Nodo(ArbolHuffman izq, ArbolHuffman der) {
        super(izq.frecuencia + der.frecuencia);
        izquierda = izq;
        derecha = der;
    }
}