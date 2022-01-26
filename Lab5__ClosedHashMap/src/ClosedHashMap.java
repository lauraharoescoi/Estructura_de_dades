public class ClosedHashMap<K, V> implements Map<K, V> {

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Entry<K, V>[] entries;

    private enum Status {
        FREE, OCCUPIED, DELETED
    }

    private static class Entry<K, V> {
        private K key;
        private V value;
        private Status stat;

        public Entry(K key, V value, Status stat) {
            this.key = key;
            this.value = value;
            this.stat = stat;
        }
    }

    public ClosedHashMap() {
        this.size = 0;
        this.entries = new Entry[INITIAL_CAPACITY];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry<>(null, null, Status.FREE);
        }
    }

    @Override
    public int size() {
        int contador = 0;
        for (int i = 0; i < entries.length; i++) {
            if (entries[i].key != null) contador++;
        }
        return contador;
    }

    @Override
    public boolean isEmpty() {
        int index = 0;
        while (index < entries.length) {
            if (entries[index].key != null) return false;
            index++;
        }
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) return false;
        int i = 0;
        int index = indexFor(key.hashCode(), entries.length);
        int limit = size();
        while (entries[index].stat == Status.OCCUPIED || entries[index].stat == Status.DELETED && i < limit) {
            if (entries[index].key == key) return true;
            i++;
            index += Math.pow(i, 2);
        }
        return false;
    }

    @Override
    public V get(Object key) {
        if (key == null) return null;
        int i = 0;
        int index = indexFor(key.hashCode(), entries.length);
        int limit = size();
        while (entries[index].stat == Status.OCCUPIED || entries[index].stat == Status.DELETED && i < limit) {
            if (entries[index].key == key) return entries[index].value;
            i++;
            index += Math.pow(i, 2);
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {
        if (key == null || value == null) throw new NullPointerException();
        int i = 0;
        int checkpoint = -1;
        int index = indexFor(key.hashCode(), entries.length);
        int limit = size();

        if (entries[index].stat == Status.FREE) {
            entries[index].key = key;
            entries[index].value = value;
            entries[index].stat = Status.OCCUPIED;
            return null;
        }

        while (entries[index].stat == Status.OCCUPIED || entries[index].stat == Status.DELETED && i <= limit) {
            if (entries[index].stat == Status.OCCUPIED && entries[index].key == key) {
                var val = entries[index].value;
                entries[index].value = value;
                return val;
            }
            if (entries[index].stat == Status.DELETED && checkpoint <= 0) {
                checkpoint = index;
            }
            i++;
            index += Math.pow(i, 2);
        }
        if (checkpoint >= 0) {
            entries[checkpoint].key = key;
            entries[checkpoint].value = value;
            entries[checkpoint].stat = Status.OCCUPIED;
        }
        return null;
    }

    private int indexFor(int hash, int length) {
        return hash % length;
    }

    @Override
    public V remove(Object key) {
        if (key == null) throw new NullPointerException();
        int index = indexFor(key.hashCode(), entries.length);
        int i = 0;
        while (entries[index].stat == Status.OCCUPIED && i < size()) {
            if (entries[index].key == key) {
                var val = entries[index].value;
                entries[index].key = null;
                entries[index].value = null;
                entries[index].stat = Status.DELETED;
                return val;
            }
            i++;
            index += Math.pow(i, 2);
        }
        return null;
    }
}