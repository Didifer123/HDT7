/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;
/*
 * Clase extension del arbol  creado con valor aritrario de A
 */
class Hoja extends ArbolHuffman {
    public final char valor; 
 
    public Hoja(int enterFrecuencia, char enterValor) {
        super(enterFrecuencia);
        valor = enterValor;
    }
}