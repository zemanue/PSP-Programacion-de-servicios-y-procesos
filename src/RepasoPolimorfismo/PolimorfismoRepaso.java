/*
 * Ejercicio 1:
Implementa una clase base Animal con un método hacerSonido(). Luego, crea las clases Perro y Gato que extiendan de Animal y sobrescriban el
método hacerSonido() para que el Perro "ladre" y el Gato "maúlle". Demuestra polimorfismo creando un método que acepte un objeto Animal y
llame a hacerSonido().
 */

package RepasoPolimorfismo;

public class PolimorfismoRepaso {
    public static void main(String[] args) {
        Animal animal = new Animal();
        hablarAlAnimal(animal);
        
        Animal perro = new Perro();
        hablarAlAnimal(perro);
        
        Animal gato = new Gato();
        hablarAlAnimal(gato);
    }

    public static void hablarAlAnimal(Animal animal) {
        System.out.println("¡Hola, " + animal.getClass().getSimpleName() + "!");
        animal.hacerSonido();
    }
}
