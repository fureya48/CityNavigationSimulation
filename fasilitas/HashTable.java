package fasilitas;

import java.util.HashMap;

// Struktur HashTable untuk menyimpan fasilitas kota berdasarkan nama
public class HashTable {
    private HashMap<String, Fasilitas> map;

    public HashTable() {
        map = new HashMap<>();
    }

    public void put(String nama, Fasilitas f) {
        map.put(nama, f);
    }

    public Fasilitas get(String nama) {
        return map.get(nama);
    }

    public HashMap<String, Fasilitas> getMap() {
        return map;
    }
}