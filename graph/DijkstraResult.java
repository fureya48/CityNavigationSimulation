package graph;

import java.util.*;

// Menyimpan hasil perhitungan algoritma Dijkstra
public class DijkstraResult {
    public int[] dist; // jarak terpendek dari source
    public int[] prev; // node sebelumnya untuk rekonstruksi jalur

    public DijkstraResult(int[] dist, int[] prev) {
        this.dist = dist;
        this.prev = prev;
    }

    // Mendapatkan path dari source ke target node
    public List<Integer> getPath(int target) {
        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}