/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JOptionPane;

/**
 *
 * @author juan, andre
 */
public class GrafoMA {
    private boolean dirigido;          
    private int maxNodos;                 
    private int numVertices;              
    private int matrizAdy [ ] [ ];
    private Lista usuarios;
    private Lista relaciones;
    
    public GrafoMA( int n) {
        dirigido = true;
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new int [n] [n];
    }

    public GrafoMA() {
        this.dirigido = true;
        this.maxNodos = 0;
        this.numVertices = 0;
        this.matrizAdy = new int [maxNodos] [maxNodos];
    }
    
    public void setUsuarios(Lista usuarios) {
        this.usuarios = usuarios;
    }

    public void setRelaciones(Lista relaciones) {
        this.relaciones = relaciones;
    }

    public Lista getUsuarios() {
        return usuarios;
    }

    public Lista getRelaciones() {
        return relaciones;
    }
    
    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public int getMaxNodos() {
        return maxNodos;
    }

    public void setMaxNodos(int maxNodos) {
        this.maxNodos = maxNodos;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }
    
    public void setMatrizAdy(int i, int j) {
        this.matrizAdy = new int [i][j];
    }
    
    //Esta función inserta un vértice o usuario nuevo al grafo, tanto a su lista como a su matriz, a partir de un nuevo string
    public void insertarVertice(String nombre) {
        this.setMaxNodos(maxNodos + 1);
        Usuario nuevo = new Usuario(nombre,this.getNumVertices());
        this.usuarios.InsertInFinal(nuevo);
        int n = 1;
        if ( n > maxNodos - numVertices ) 
            System.out.println ("Error, se supera el número de nodos máximo."); 
        else { 
            for (int i=0; i < numVertices + n; i++) { 
                for (int j = numVertices; j < numVertices + n; j++)  
                    matrizAdy [i] [j] = matrizAdy [j] [i] = false?1:0; 
                 } 
        numVertices = numVertices + n; 
    
        }
    }
    
    //Esta función inserta todos los usuarios presentes en la lista de usuarios presentes en el archivo de texto
    public void insertarUsuariosTxt(Lista usuarios) {
        int n = usuarios.getSize(); //13
        for (int i=0; i < numVertices + n; i++) {       //Mientras i menor que 13
            for (int j = 0; j < numVertices + n; j++)  //Mientras j menor que 13
                matrizAdy [i] [j] = matrizAdy [j] [i] = false?1:0; // 0 0
        } 
        numVertices = numVertices + n; 
    
     }
     
    //Esta función elimina un vértice del grafo a partir de un usuario indicado
    public void eliminarVertice(Usuario persona) {         
        int n;
        n = persona.numero;
        for (int i = 0; i < numVertices; i++) {
            for (int j = n; j < numVertices - 1; j++) {
                matrizAdy[i][j] = matrizAdy[i][j+1];
                
            }
        }
        for (int i = n; i < numVertices; i++) {
            for (int j = 0; j < numVertices -1; j++) {
                matrizAdy[i][j]= matrizAdy[i+1][j];
                
            }
            
        }
        numVertices -=1;
    }
     
    //Esta función retorna unobjeto usuario con un nombre que coincida con un string dado
    public Usuario retornar_usuario(String nombre) {
        Nodo<Usuario> aux = this.usuarios.getFirst();
        for (int i = 0; i < this.usuarios.getSize(); i++) {
            if (aux.getElement().nombre != nombre) {
                aux = aux.getNext();
            }
        }
        return aux.getElement();
    }
    
    //Esta función inserta una relación indicándole su posición en la matriz de adyacencia
    public void insertaArista(int i, int j) {
        if(i>numVertices || j>numVertices){
            System.out.println("ERROR");
        }else{
        matrizAdy [i] [j] = true?1:0; 
        if (!dirigido)  
            matrizAdy [j] [i] = matrizAdy [i] [j];
        }
    }
    
    //Esta función inserta el conjunto de relaciones indicadas en la lista de relaciones presentes en el archivo de texto
    public void insertarRelaciones(Lista relaciones, Lista usuarios) {
        Nodo<Conexion> aux1 = relaciones.getFirst();
        Nodo<Usuario> aux2 = usuarios.getFirst();
        Lista lista_filas = new Lista();
        Lista lista_columnas = new Lista();
        
        for (int k = 0; k < this.relaciones.getSize(); k++) {
            for (int l = 0; l < this.usuarios.getSize(); l++) {
                int fila = 0;
                int columna = 0;
                String string_conexion_inicio = aux1.getElement().getInicio();
                String string_conexion_destino = aux1.getElement().getDestino();
                String string_usuario = aux2.getElement().nombre;
                if (string_conexion_inicio.equals(string_usuario)) {
                    fila = aux2.getElement().numero;
                    lista_filas.InsertInFinal(fila);
                }else if(string_conexion_destino.equals(string_usuario)){
                    columna = aux2.getElement().numero;
                    lista_columnas.InsertInFinal(columna);
                }
                aux2 = aux2.getNext();
            }
            aux1 = aux1.getNext();
        }
        
        lista_filas.imprimir();
        lista_columnas.imprimir();
//        Nodo<> aux3 = lista_filas.getFirst().getElement();
//        
//        for (int m = 0; m < lista_filas.getSize(); m++) {
//            matrizAdy[i][j] = true?1:0;
//                if (!dirigido)
//                    matrizAdy[j][i] = matrizAdy[i][j];
//        }
//        
//        Código de prueba... No logramos hacer que esto funcionara 😞
//        
//        for (int k = 0; k < this.relaciones.getSize(); k++) {
//            String nombre_inicio = aux1.getElement().getInicio();
//            String nombre_destino = aux1.getElement().getDestino();
//            Usuario usuario_inicio = this.retornar_usuario(nombre_inicio);
//            Usuario usuario_destino = this.retornar_usuario(nombre_destino);
//            int i = usuario_inicio.numero;
//            int j = usuario_destino.numero;
//            if (i > numVertices || j > numVertices){
//                JOptionPane.showMessageDialog(null, "Este usuario no se encuentra dentro del sistema.", "Error", HEIGHT);
//            }else{
//                matrizAdy[i][j] = true?1:0;
//                if (!dirigido)
//                    matrizAdy[j][i] = matrizAdy[i][j];
//                }
//            aux1 = aux1.getNext();
//        }
    }
    
    //Esta función elimina una relación en una posición dada
    public void eliminarArista(int i, int j) {
        if (matrizAdy[i][j] ==0){
            System.out.println("La Arista no existe");
        }else{
            matrizAdy [i] [j] = 0; 
        if (!dirigido)  
            matrizAdy [j] [i] = 0;
    }
    }
    
    //Esta función retorna el tamaño del grafo
    public int tamano() {
        int tam = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if(matrizAdy[i][j] != 0){
                    tam++;
                }
            }
            
        }
        return tam;
    }
    
    //Esta función retorna un booleano que indica si el grafo es vacío o no
    public boolean esVacio() {
       return numVertices == 0;
    }
    
    //Esta función retorna un booleano que indica si el grafo está dirigido o no
    public boolean esDirigido( ) {
         return dirigido;
    }
    
    //Esta función imprime por consola la matriz de adyacencia generada
    public void imprimirMA(){

            for (int i = 0; i < numVertices; i++) {
                System.out.println(" ");
                for (int j = 0; j < numVertices; j++) {
                    System.out.print((matrizAdy[i][j]) + " ");
                }
            }


        }

    //Esta función retorna un booleano que indica si existe un vértice determinado dentro del grafo
    public boolean existeVertice(int i){
            return i <= numVertices - 1;
        }

}
