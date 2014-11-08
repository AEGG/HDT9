
/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */
import java.io.IOException;
/*
* Esta clase se utiliza para el manejo de los grafos, para encontrar las distancias entre ciudades y el centro del grafo
* todo esto utilizando objetos de tipo archivo para la lectura del fichero creado y las listas se tomo de referencia
* el código encontrado en el siguiente link:
* https://code.google.com/p/java-algorithms-implementation/feeds
*/
public class Grafo {
    Archivo a= new Archivo();
    InterfazGrafo D;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;
// Lectura del grrafo para obtener los datos de las ciudades con sus respectivas distancias
    public Grafo(){
        try {
// Se mandan a llamar a los metodos creados en la clase Archivo
            a.obtenerArchivo();
            a.arregloNombres();
            D = a.matrizCostos();
            P = new int[25][25];
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<a.grafo.size();n++){
            for(int m=0;m<a.grafo.size();m++){
                P[n][m]=0;
            }
        }
    }
    
    public void caminoCorto(){
        for(int k=0;k<a.grafo.size();k++){
            for(int i=0;i<a.grafo.size();i++){
                for(int j=0;j<a.grafo.size();j++){
                    if(D.getEdge(a.grafo.get(i),a.grafo.get(j))>(D.getEdge(a.grafo.get(i), a.grafo.get(k))+D.getEdge(a.grafo.get(k), a.grafo.get(j)))){
                        D.addEdge(a.grafo.get(i), a.grafo.get(j), (D.getEdge(a.grafo.get(i), a.grafo.get(k))+D.getEdge(a.grafo.get(k), a.grafo.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        D.show();
    }
    
    public String centroGrafo(){
        caminoCorto();
        int n=0;       
        for(int i=0;i<D.size();i++){
            for(int j=0;j<D.size()-1;j++){
                int num1=D.getEdge(D.get(j), D.get(i));
                n=j;
                n++;
                int num2=D.getEdge(D.get(n), D.get(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        
        for(int i=0;i<D.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        return ("El centro del grafo es: "+D.get(centro));
    }
}
