
/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */
import java.io.*;

public class Archivo{
    File archivo;
    FileReader fr;
    BufferedReader br;
    InterfazGrafo grafo = new GraphMatrix();    
    
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