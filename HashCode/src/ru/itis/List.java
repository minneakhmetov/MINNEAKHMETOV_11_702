
package ru.itis;
public interface List<K, V> {
    void add(K key, V value);
    V get(K key);
}
