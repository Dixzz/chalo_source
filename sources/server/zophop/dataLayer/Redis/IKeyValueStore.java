package server.zophop.dataLayer.Redis;

public interface IKeyValueStore<K, V> {
    boolean containsKey(K k);

    boolean geoAdd(K k, String str, double d, double d2);

    V get(K k);

    void put(K k, V v);

    void put(K k, V v, int i);

    boolean remove(K k);

    boolean removeFromSet(K k, String str);
}
