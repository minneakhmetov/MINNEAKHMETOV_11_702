package ru.itis;

public class Hash<K, V> {
    final int size = 16;

    LinkedList<K, V>[] list = new LinkedList[size];

    public Hash(){

    }


    V get(K key) {
        int index = hash(key);
        if (list[index].size() == 1){
            return list[index].get(0).value;
        }
        for (int i = 0; i < list[index].size(); i++){
            if (list[index].get(i).key.hashCode() == key.hashCode() && (list[index].get(i).key.equals(key))){
                return list[index].get(i).value;
            }
        }
        throw new IllegalArgumentException("There is no such key");

    }

    void set(K key, V value){
        int remain = hash(key);
        if (list[remain] == null) {
            list[remain] = new LinkedList<>();
            list[remain].add(key,value);
        } else {
            for (int i = 0; i < list[remain].size(); i++) {
                if (list[remain].get(i).key.hashCode() == key.hashCode() && (list[remain].get(i).key.equals(key))) {
                    list[remain].add(key, value);
                    return;
                }
            }
            list[remain].add(key,value);
        }
    }

    public int hash(K key){
        return Math.abs(key.hashCode() % size);
    }


}
