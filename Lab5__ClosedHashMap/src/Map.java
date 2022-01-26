public interface Map<K, V> {
    int size();

    boolean isEmpty();

    boolean containsKey(Object key);

    V get(Object key);

    V put(K key, V value);

    V remove(Object key);
}