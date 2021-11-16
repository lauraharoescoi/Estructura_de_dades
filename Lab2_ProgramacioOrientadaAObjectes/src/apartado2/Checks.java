package apartado2;

import java.util.Iterator;

public class Checks {
    public static <E> void removeIf(Iterator<E> it, Check<E> test) {
        // bucle per recorre la llista amb l'iterador
        while (it.hasNext()) {
            // si es parell borra l'element en el que apunta
            if (test.test(it.next())) {
                it.remove();
            }
        }
    }
}
