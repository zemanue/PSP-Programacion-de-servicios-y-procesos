import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ColeccionesPrueba {
    public static void main(String[] args) {
        // CLASES DE TIPO LIST: permiten duplicados y acceder por índice
        // ARRAYLIST: para acceder muchas veces por índice
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Mario");
        arrayList.add("Luisa");
        System.out.println("Primer elemento del ArrayList: " + arrayList.get(0));

        // LINKEDLIST: para agregar o eliminar muchas posiciones iniciales o intermedias
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Pepe");
        linkedList.add(0, "María");
        linkedList.add(1, "Manuel");
        System.out.println("LinkedList en orden:" + linkedList);

        // COPYONWRITEARRAYLIST: para seguridad en múltiples hilos
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        copyOnWriteArrayList.add("Isabel"); // Cada vez que se agrega un elemento, se crea una copia nueva
        copyOnWriteArrayList.add("Mario");
        copyOnWriteArrayList.addAllAbsent(arrayList); // Añade todos los elementos que no estén en la lista
        copyOnWriteArrayList.addAllAbsent(linkedList);
        System.out.println("CopyOnWriteArrayList:" + copyOnWriteArrayList);

        // CLASES DE TIPO SET: no permiten duplicados 
        // HASHSET: para búsqueda, inserción y eliminación eficientes sin mantener orden
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(copyOnWriteArrayList); // Se añade la lista pero no se mantiene el orden
        hashSet.add("Carla");
        hashSet.add("Carmen");
        hashSet.add("Carla"); // Se intenta insertar un elemento, pero como ya existe se ignora
        System.out.println("HashSet:" + hashSet);

        // LINKEDHASHSET: como el HashSet, pero manteniendo el orden de inserción
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.addAll(hashSet);
        linkedHashSet.add("Juan");
        System.out.println("LinkedHashSet:" + linkedHashSet);

        // TREESET: para búsqueda, inserción y eliminación eficientes manteniendo orden
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("Wendy");
        treeSet.add("Pedro");
        treeSet.add("Juan"); 
        System.out.println("TreeSet:" + treeSet); // El orden natural es mantenido (en este caso, por orden alfabético)

        // ENUMSET: optimizado para enumeraciones

        // COPYONWRITEARRAYSET: para seguridad en múltiples hilos y pocas modificaciones

        
    }
}
