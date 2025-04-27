import java.util.LinkedList;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private LinkedList<HashNode<K, V>>[] chainArray;
    private int M;
    private int size;

    public MyHashTable() {
        this(11); // по умолчанию 11 ячеек
    }

    public MyHashTable(int M) {
        this.M = M;
        this.size = 0;
        chainArray = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chainArray[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        chainArray[index].add(new HashNode<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        for (HashNode<K, V> node : chainArray[index]) {
            if (node.key.equals(key)) {
                V value = node.value;
                chainArray[index].remove(node);
                size--;
                return value;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        for (LinkedList<HashNode<K, V>> list : chainArray) {
            for (HashNode<K, V> node : list) {
                if (node.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (LinkedList<HashNode<K, V>> list : chainArray) {
            for (HashNode<K, V> node : list) {
                if (node.value.equals(value)) {
                    return node.key;
                }
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int[] getBucketSizes() {
        int[] sizes = new int[M];
        for (int i = 0; i < M; i++) {
            sizes[i] = chainArray[i].size();
        }
        return sizes;
    }
}
