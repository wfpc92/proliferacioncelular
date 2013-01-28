

package Abstracto;


public interface  Componente {
 
    public void add (Componente c);
    public void eliminar (Componente c);
    public Componente obtenerHijo (int num);
    
    
    
    void mostrar ();
}
