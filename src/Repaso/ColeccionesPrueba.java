package Repaso;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
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

        // CLASES DE TIPO QUEUE: colas que procesan elementos en orden FIFO (primero en
        // entrar, primero en salir)
        // LINKEDLIST: también permite operaciones de cola en ambos extremos
        System.out.println("Primer elemento de la cola: " + linkedList.peek());
        linkedList.poll(); // Elimina el primer elemento
        linkedList.offer("Pedro"); // Agrega el elemento al final
        linkedList.push("Lucas"); // Agrega al principio
        System.out.println("Cola: " + linkedList);

        // PRIORITYQUEUE: para ordenar los elementos de forma natural o con un
        // Comparator dado (como el TreeSet)
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("James");
        priorityQueue.offer("Andy"); // add() y offer() son equivalentes
        priorityQueue.offer("Peter");
        System.out.println("PriorityQueue: " + priorityQueue); // El orden natural es mantenido (en este caso, por orden
                                                               // alfabético)

        // ARRAYDEQUE: para manejar colas y pilas de elementos más eficientemente que
        // LinkedList
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("Rafael");
        arrayDeque.offer("Donatello");
        arrayDeque.add("Michelangelo");
        arrayDeque.push("Leonardo");
        System.out.println("ArrayDeque: " + arrayDeque); // El orden es mantenido

        // CLASES DE TIPO MAP: almacenan pares de elementos en forma de claves únicas y
        // valores
        // HASHMAP: almacena pares clave-valor en una tabla hash, sin orden
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Manzana");
        hashMap.put(2, "Sandía");
        hashMap.put(3, "Melón");
        hashMap.put(4, "Naranja");
        System.out.println("Primer elemento del HashMap: " + hashMap.get(1));
        hashMap.remove(3);
        System.out.println("HashMap: " + hashMap);

        // LINKEDHASHMAP: subclase que mantiene el orden de inserción

        // TREEMAP: para mantener un orden natural o con un Comparator dado (como el
        // TreeSet)
        

    }
}
