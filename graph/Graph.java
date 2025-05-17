package graph;

import java.util.*;

// Struktur graph dengan algoritma Dijkstra
public class Graph {
    private int V; // jumlah node
    private List<List<int[]>> adj; // adjacency list

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // Tambah edge dua arah antara node u dan v dengan bobot w
    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new int[]{v, w});
        adj.get(v).add(new int[]{u, w});
    }

    // Algoritma Dijkstra untuk mencari jarak terpendek dari source
    public DijkstraResult dijkstra(int src) {
        int[] dist = new int[V];
        int[] prev = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return new DijkstraResult(dist, prev);
    }
}