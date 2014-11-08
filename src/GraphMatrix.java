
/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */

//Cogigo basdo de 
import java.util.Vector;

public class GraphMatrix<V,E> implements InterfazGrafo<V,E>{

    private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    private String rpta;
    
    public GraphMatrix(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }
    public void add(V label){
        if(!vertices.contains(label)){
            vertices.add(label);
        }
    }
    public void addEdge(V vtx1, V vtx2, E label) {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        arcos[i][j]=peso;
    }
    public String show(){
        for(int a=0;a<vertices.size();a++){
            for(int b=0;b<vertices.size();b++){
            	rpta=""+arcos[a][b]+" ";
            	//System.out.print(""+arcos[a][b]+" ");
            }
            rpta+="";
            //System.out.println("");
        }
        return rpta;
    }
    public int size(){
        return vertices.size();
    }
    public int getEdge(V label1, V label2){
        return arcos[vertices.indexOf(label1)][vertices.indexOf(label2)];
    }
    public V get(int label){   
        return (V)vertices.get(label);
    }
    public boolean contains(V label){
        return vertices.contains(label);
    }
}