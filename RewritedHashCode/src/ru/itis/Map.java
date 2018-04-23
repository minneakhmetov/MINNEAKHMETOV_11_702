package ru.itis;

public interface Map<K, V> {
    public V get(K key);
    public void set(K key, V value);

}
