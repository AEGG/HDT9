/*
 * Universidad del Valle de Guatemala
 * Hoja de Trabajo #9 Aloritmo de Floyd
 * Max de Le�n - 13012
 * Aar�n Gir�n - 13042
 * Ricardo Franco - 13261
 */
public interface InterfazGrafo<V,E> {

    public void add(V label);
    
    public void addEdge(V vtx1, V vtx2, E label);
    
    public String show();
    
    public V get(int label);
    
    public int getEdge(V label1, V label2);
    
    public boolean contains(V label);
    
    public int size();
    
}