/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Texto {
    private static Component areaTexto;
    
    public static File FileChooser() {
       
    File fichero = null;
       
    JFileChooser fileChooser = new JFileChooser();
    int seleccion = fileChooser.showSaveDialog(areaTexto);
    if (seleccion == JFileChooser.APPROVE_OPTION)
    {
   fichero = fileChooser.getSelectedFile();}
    
    return fichero;
   
   }
   
   
   public static void LeerFichero(File archivo) {
       
      if (archivo == null) {JOptionPane.showMessageDialog(null, "No ha seleccionado ningún archivo");} 
   
      else {
      
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero/////////////////////////////////////////////////////////////////////

      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      }
   }
   
   
     

      public static GrafoMA LeerTxt(File archivo){

        Lista<Object> usuarios = new Lista<>();
        Lista<Object> lista_relaciones = new Lista<>();
        String nombre_usuario = "";
        
        String line;
        String usuariostxt = "";
        //String path = "test\\usuarios.txt";
        File file = archivo;
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if (!line.isEmpty()){
                        usuariostxt += line + "\n";
                    }
                }
                if(!"".equals(usuariostxt)){
                
                
                String[] datos = usuariostxt.split("\n");
                
           
                
//                En este bucle se buscan los usuarios registrados en el archivo seleccionado

                    int i = 0;
                    while ( i<datos.length-1){
                        if (datos[i].equalsIgnoreCase("relaciones")) {break;} //Se rompe el bucle al llegar a las relciones
                        
                            if(datos[i].contains("@")){
                         
//                                nombre_usuario +=datos[i]+", ";
                                nombre_usuario = datos[i];
                                Usuario usuario = new Usuario(nombre_usuario,i);
                                usuarios.InsertInFinal(usuario);
////                            En este pase creas el usuario porque aquí obtienes su nombre
                            }
                            i++;
                    }
                    
                  
//                            
//                //En este bucle se buscan las conexiones registradas en el archivo seleccionado
//                    
                    while (datos[i].equalsIgnoreCase("relaciones;")){
                        i++;
                            while(i<datos.length){
                                String[] atri = datos[i].split(",");
                                Conexion conexion = new Conexion(atri[0],atri[1]);
                                conexion.setInicio(atri[0]);
                                conexion.setDestino(atri[1]);
                                lista_relaciones.InsertInFinal(conexion);
                                i++;
                            }
                            if (i == datos.length) {break;}
//                        
//
                            }
                    }
        
                br.close();
                JOptionPane.showMessageDialog(null, "¡Lectura Exitosa!");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);}
        
//          Aqui se crearia el grafo con las listas ya creadas
            GrafoMA grafo = new GrafoMA(usuarios.getSize()-1);
            grafo.insertarUsuariosTxt(usuarios);
//          Aqui se le agrega al grafo las relaciones
            grafo.setUsuarios(usuarios);
            grafo.setRelaciones(lista_relaciones);
//          Aquí se le asignan las listas a el grafo

//          Aqui se retorna el grafo ya creado
            return grafo;
      }
}
