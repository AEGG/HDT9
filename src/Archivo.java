
/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */
 // Se importa la libreria para lectura de ficheros en java
import java.io.*;
/*
* Metodos y teoria para el uso de esta clase fue obtenida de la página 
* http://www.discoduroderoer.es/clases-filereader-y-filewriter-para-ficheros-de-texto-en-java/
* con la cual se trabajo para el uso y manejo de ficheros para dicha hoja de trabajo 
*/
public class Archivo{
    File archivo;
    FileReader fr;
    BufferedReader br;
    InterfazGrafo grafo = new GraphMatrix();    
// Se obtiene el nombre del archivo el cual ya esta creado y almacenado en la carpeta del proyecto
    public void obtenerArchivo() throws FileNotFoundException{
       archivo=new File("datos.txt"); 
    }  
    
    public InterfazGrafo arregloNombres() throws IOException{
// Lectura del archivo de texto que posee nuestras ciudades y distancias
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo;
    }
    
    public InterfazGrafo matrizCostos() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }  
}
