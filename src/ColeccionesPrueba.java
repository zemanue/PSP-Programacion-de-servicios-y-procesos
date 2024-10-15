import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ColeccionesPrueba {
    public static void main(String[] args) {
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

    }
}
