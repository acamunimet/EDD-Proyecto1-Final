/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author juan
 */
public class Lista <T> {
    private Nodo First;
    private Nodo Last;
    private int size;

    public Lista() {
        this.First = null;
        this.Last = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return getFirst() == null;
    }

    
    /**
     * @return the First
     */
    public Nodo getFirst() {
        return First;
    }

    /**
     * @param First the First to set
     */
    public void setFirst(Nodo First) {
        this.First = First;
    }

    /**
     * @return the Last
     */
    public Nodo getLast() {
        return Last;
    }

    /**
     * @param Last the Last to set
     */
    public void setLast(Nodo Last) {
        this.Last = Last;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
     /**
     * Metodo para insertar un elemento de primero en la lista
     * @param elem Elemento a insertar
     */
    public void InsertAtFirst(Object elem){
        Nodo nuevo = new Nodo(elem);
        if(!isEmpty()){
            nuevo.setNext(First);
           
            First = nuevo;}
        else{
            First = nuevo;
            First.setNext(Last);
            Last = nuevo;
          
        }
        size++;
    }
    
    
    /**
     * Metodo para insertar un elemento de ultimo en la lista
     * @param elem Elemento a insertar
     */
    
    public void InsertInFinal(Object elem){
        Nodo nuevo = new Nodo(elem);
        if (isEmpty()){
            this.InsertAtFirst(elem);
        }else{
            Last.setNext(nuevo);
            Last= nuevo;
            size++;    
        }
    }
    
    public boolean buscar(String valor){
        Nodo<Usuario> aux = this.First;
        while (aux != null) {
            if(!aux.getElement().nombre.equals(valor)){
                aux = aux.getNext();
            }else{
                return true;
            }
        }
        return false;
    }
    
    public void imprimir(){
        if (!isEmpty()){
            Nodo aux = this.getFirst();
            for (int i = 0; i < size; i++) {
                System.out.println(aux.getElement()+" ");
                aux = aux.getNext();
            }
            
        }else{
            System.out.println("Lista vacía");
        }
    }
}
