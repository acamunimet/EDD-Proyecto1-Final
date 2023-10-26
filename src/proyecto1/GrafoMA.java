/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author User
 */
public class GrafoMA {
    private boolean dirigido;          
    private int maxNodos;                 
    private int numVertices;              
    private int matrizAdy [ ] [ ];
    
    public GrafoMA(boolean d) {
        dirigido = d;
        maxNodos = numVertices;
        
    }
    
    public GrafoMA( int i, int j, boolean d) {
        dirigido = d;
        maxNodos = 0;
        numVertices = 0;
        matrizAdy = new int [i] [j];
    }
    
    public GrafoMA( int n, boolean d) {
        dirigido = d;
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new int [n] [n];
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

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }
    
    public void setMatrizAdy(int i, int j) {
        this.matrizAdy = new int [i][j];
    }
    
     public void insertarVertice(String nombre) {
        Usuario nuevo= new Usuario(nombre,this.getNumVertices() +1);
        int n = 1;
        if ( n > maxNodos - numVertices ) 
            System.out.println ("Error, se supera el número de nodos máximo"); 
        else { 
            for (int i=0; i < numVertices + n; i++) { 
                for (int j = numVertices; j < numVertices + n; j++)  
                    matrizAdy [i] [j] = matrizAdy [j] [i] = false?1:0; 
                 } 
        numVertices = numVertices + n; 
    
        }
    }
     
     public void eliminarVertice(int n) {
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
    
    public void insertaArista(int i, int j) {
        if(i>numVertices || j>numVertices){
            System.out.println("ERROR");
        }else{
        matrizAdy [i] [j] = true?1:0; 
        if (!dirigido)  
            matrizAdy [j] [i] = matrizAdy [i] [j];
        }
    }
    
    public void eliminarArista(int i, int j) {
        if (matrizAdy[i][j] ==0){
            System.out.println("La Arista no existe");
        }else{
            matrizAdy [i] [j] = 0; 
        if (!dirigido)  
            matrizAdy [j] [i] = 0;
    }
    }
    
    public boolean existeArista(int i, int j) {
        return matrizAdy[i][j] != 0;
    }
    
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
    
    public boolean esVacio() {
       return numVertices == 0;
    }
    
    public boolean esDirigido( ) {
         return dirigido;
    }
    
    public void imprimirMA(){

            for (int i = 0; i < numVertices; i++) {
                System.out.println(" ");
                for (int j = 0; j < numVertices; j++) {
                    System.out.print((matrizAdy[i][j]) + " ");
                }
            }


        }

    public boolean existeVertice(int i){
            return i <= numVertices - 1;
        }

}
