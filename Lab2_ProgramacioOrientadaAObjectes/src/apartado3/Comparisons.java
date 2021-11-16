package apartado3;

import java.util.Iterator;

public class Comparisons {
    public static void removeLower(Iterator<? extends Person> it, Person p) {
        // bucle per recorre la llista amb l'iterador
        while (it.hasNext()) {
            // si es inferior alfabeticament, esborra l'element
            if (it.next().compareTo(p) < 0) {
                it.remove();
            }
        }
    }
}
