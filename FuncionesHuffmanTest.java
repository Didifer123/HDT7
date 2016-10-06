/* Universidad del valle de guatemala
* Autores
* Didier salazar 15487
* Esteban Avalos 15059
*/
package hdt7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Didier
 */
public class FuncionesHuffmanTest {
    
    public FuncionesHuffmanTest() {
    }

    /**
     * Testea los metodos de la clase que controla los arboles de Huffman generados con prioritys queues.
     */
    
    /**
     * Testea el metodo de construccion del arbol.
     */
    @Test
    public void testConstruirArbol() {
        //Aca se prueban el arbol binario y el heap, es decir la priority queue.
        System.out.println("construirArbol");
        int[] frecuenciasChar = new int[256];
        String test = "abaccda";  //Prueba que el caracter con el arbol con mayor frecuencia será el primero en el mismo.
        ArbolHuffman arbol=null;
        FuncionesHuffman func= new FuncionesHuffman();
        for (char c : test.toCharArray())
            frecuenciasChar[c]++;
        arbol = func.construirArbol(frecuenciasChar);
       
        Nodo nod = (Nodo)arbol; //Se vuelve un nodo el arbol, ya que se vera el primero del mismo.
        Hoja hojita = (Hoja)nod.izquierda; //Luego se vuelve una hoja del arbol, para desglosarnos y encontrar al caracter --a--
        String result = "";
        if(hojita.valor=='a'){ //Si el primer valor encontrado es -a-, la prueba con la priority queue es un exito.
            result="a";
        }
        String expResult = "a"; //Resultado esperado.
        assertEquals(expResult, result); //Se comparan ambos resultados.
        
    }

    /**
     * Test of decodificar method, of class FuncionesHuffman.
     */
    @Test
    public void testDecodificar() {
        //Se prueba que la operacion de decodificacion es un exito.
        System.out.println("decodificar");
        int[] frecuenciasChar = new int[256];
        String test = "abaccda";   //Crea un arbol con esta secuencia de caracteres.
        ArbolHuffman arbol=null;
        FuncionesHuffman func= new FuncionesHuffman();
        
        for (char c : test.toCharArray())
            frecuenciasChar[c]++; 
        //Se ingresan al arbol los caracteres segun su frecuencia.         
        arbol = func.construirArbol(frecuenciasChar);
        String oracionEnCodigo="110100"; //Se indica el codigo para decodificar.
        String expResult = "bca"; //Si la secuencia de caracteres es igual a esta, entonces la prueba es un exito.
        String result = func.decodificar(arbol, oracionEnCodigo); //Se realiza la decodificacion.
        assertEquals(expResult, result); //Compara el resultado esperado con el obtenido.
        
    }

    /**
     * Test of imprimirCodigo method, of class FuncionesHuffman.
     */
    @Test
    public void testImprimirCodigo() {
        System.out.println("imprimirCodigo");
        int[] frecuenciasChar = new int[256];
        String test = "abaccda";   //Crea un arbol con esta secuencia de caracteres.
        ArbolHuffman arbol=null;
        FuncionesHuffman func= new FuncionesHuffman();
        
        for (char c : test.toCharArray())
            frecuenciasChar[c]++; 
        //Se ingresan al arbol los caracteres segun su frecuencia.         
        arbol = func.construirArbol(frecuenciasChar);
         Nodo nod1 = (Nodo)arbol; //Se vuelve un nodo el arbol, ya que se vera el primer hijo del mismo.
        Hoja hojita = (Hoja)nod1.izquierda; //Luego se vuelve una hoja del arbol, para desglosarnos y encontrar al caracter --a-- 
        
        
        String result = "";
        //Si se desglosa en orden al imprimir los valores segun la frecuencia, el metodo esta bien codificado.
        if(hojita.valor=='a'&&hojita.frecuencia==3){ //Si el primer valor encontrado es -a- y la frecuencia del mismo es 3, la prueba con la priority queue es un exito.
            result="1";
        }
        String expResult = "1"; 
        assertEquals(expResult, result); //Compara el resultado esperado con el obtenido.
    }
    
}
