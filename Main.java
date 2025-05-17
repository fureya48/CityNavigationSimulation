import bst.*;
import fasilitas.*;
import graph.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Scanner untuk input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Peta untuk menghubungkan nama titik (A-F) dengan indeks node dalam graf (0-5)
        Map<String, Integer> nameToNode = Map.of(
                "A", 0, "B", 1, "C", 2, "D", 3, "E", 4, "F", 5
        );
        
        // Peta untuk menghubungkan indeks node (0-5) dengan nama titik (A-F)
        Map<Integer, String> nodeToName = Map.of(
                0, "A", 1, "B", 2, "C", 3, "D", 4, "E", 5, "F"
        );

        // Membuat objek BST (Binary Search Tree) untuk menyimpan data warga
        BST warga = new BST();
        // Menambahkan data warga ke dalam BST
        warga.insert(101, "Andi", 0);
        warga.insert(102, "Budi", 1);
        warga.insert(103, "Citra", 2);
        warga.insert(104, "Dewi", 3);
        warga.insert(105, "Eka", 4);
        warga.insert(106, "Fahmi", 5);
        warga.insert(107, "Gina", 0);
        warga.insert(108, "Hadi", 1);
        warga.insert(109, "Intan", 2);
        warga.insert(110, "Joko", 3);
        warga.insert(111, "Kiki", 4);
        warga.insert(112, "Lina", 5);
        warga.insert(113, "Mira", 0);
        warga.insert(114, "Nina", 1);
        warga.insert(115, "Oki", 2);

        // Membuat objek HashTable untuk menyimpan data fasilitas
        HashTable fasilitas = new HashTable();
        // Menambahkan fasilitas ke dalam HashTable
        fasilitas.put("RS Siloam", new Fasilitas("Rumah Sakit", 5));
        fasilitas.put("RS Medika", new Fasilitas("Rumah Sakit", 4));
        fasilitas.put("Grand Indonesia Mall", new Fasilitas("Pusat Perbelanjaan", 3));
        fasilitas.put("Stasiun Dukuh Atas", new Fasilitas("Transportasi", 0));
        fasilitas.put("Kampus Universitas Indonesia", new Fasilitas("Pendidikan", 1));
        fasilitas.put("Pasar Induk", new Fasilitas("Pasar", 2));
        fasilitas.put("Kantor Pos", new Fasilitas("Layanan Publik", 1));
        fasilitas.put("Polsek Metro", new Fasilitas("Keamanan", 4));

        // Membuat objek Graph untuk peta kota dengan 6 node (A-F)
        Graph g = new Graph(6);
        // Menambahkan edge antara node dalam graf, dengan bobot jarak antar node
        g.addEdge(0, 1, 2);  // A-B
        g.addEdge(1, 2, 4);  // B-C
        g.addEdge(2, 3, 7);  // C-D
        g.addEdge(3, 4, 3);  // D-E
        g.addEdge(4, 5, 1);  // E-F

        // Menu utama program dengan opsi-opsi yang tersedia
        OUTER:
        while (true) {
            // Menampilkan menu
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Warga");
            System.out.println("2. Hapus Warga");
            System.out.println("3. Edit Warga");
            System.out.println("4. Cari Jalur ke Fasilitas Terdekat");
            System.out.println("5. Tampilkan Semua Warga");
            System.out.println("6. Cari Jalur dari Titik ke Titik");
            System.out.println("7. Keluar");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                // Opsi 1: Menambah Warga ke BST
                case 1 -> {
                    System.out.print("Masukkan ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan lokasi node (0-5): ");
                    int lokasi = scanner.nextInt();
                    warga.insert(id, nama, lokasi);
                    System.out.println("Warga ditambahkan.");
                }
                // Opsi 2: Menghapus Warga dari BST
                case 2 -> {
                    System.out.print("Masukkan ID yang akan dihapus: ");
                    int id = scanner.nextInt();
                    warga.delete(id);
                    System.out.println("Warga dihapus jika ada.");
                }
                // Opsi 3: Mengedit Data Warga dalam BST
                case 3 -> {
                    System.out.print("Masukkan ID yang akan diedit: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    BSTNode node = warga.search(id);
                    if (node != null) {
                        System.out.print("Masukkan nama baru: ");
                        node.name = scanner.nextLine();
                        System.out.print("Masukkan lokasi baru (0-5): ");
                        node.locationNode = scanner.nextInt();
                        System.out.println("Data warga diperbarui.");
                    } else {
                        System.out.println("Warga tidak ditemukan.");
                    }
                }
                // Opsi 4: Mencari Jalur Terdekat ke Fasilitas Berdasarkan Kategori
                case 4 -> {
                    System.out.print("Masukkan ID warga yang ingin dicari rutenya: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    BSTNode user = warga.search(id);
                    if (user == null) {
                        System.out.println("Warga tidak ditemukan.");
                        continue;
                    }
                    System.out.print("Masukkan kategori fasilitas (contoh: Rumah Sakit): ");
                    String kategori = scanner.nextLine();

                    // Menggunakan algoritma Dijkstra untuk mencari jarak terpendek dari lokasi warga
                    DijkstraResult res = g.dijkstra(user.locationNode);

                    int minDist = Integer.MAX_VALUE;  // Menyimpan jarak terpendek
                    int closest = -1;  // Menyimpan lokasi fasilitas terdekat
                    String namaFasilitas = "";  // Menyimpan nama fasilitas terdekat

                    // Iterasi melalui semua fasilitas untuk menemukan fasilitas terdekat dengan kategori yang diminta
                    for (var entry : fasilitas.getMap().entrySet()) {
                        Fasilitas f = entry.getValue();
                        if (f.kategori.equalsIgnoreCase(kategori)) {
                            int loc = f.lokasiNode;
                            if (res.dist[loc] < minDist) {
                                minDist = res.dist[loc];
                                closest = loc;
                                namaFasilitas = entry.getKey();
                            }
                        }
                    }

                    // Jika tidak ditemukan fasilitas dengan kategori yang diminta
                    if (closest == -1) {
                        System.out.println("Tidak ada fasilitas dengan kategori tersebut.");
                        continue;
                    }

                    // Menampilkan jalur terdekat
                    System.out.println("Jalur terdekat dari " + user.name + " ke " + namaFasilitas + ":");
                    for (int node : res.getPath(closest)) {
                        System.out.print(nodeToName.get(node) + " ");
                    }
                    System.out.println("\nJarak: " + minDist + " km");
                }
                // Opsi 5: Menampilkan Semua Warga yang Ada dalam BST
                case 5 -> {
                    System.out.println("Daftar semua warga:");
                    warga.inorderTraversal();  // Menampilkan warga secara inorder (urut berdasarkan ID)
                }
                // Opsi 6: Mencari Jalur dari Titik ke Titik
                case 6 -> {
                    System.out.print("Masukkan titik awal (A-F): ");
                    String dari = scanner.nextLine().toUpperCase();
                    System.out.print("Masukkan titik tujuan (A-F): ");
                    String ke = scanner.nextLine().toUpperCase();

                    // Validasi nama titik yang dimasukkan
                    if (!nameToNode.containsKey(dari) || !nameToNode.containsKey(ke)) {
                        System.out.println("Nama titik tidak valid.");
                        break;
                    }

                    // Menentukan indeks node untuk titik awal dan tujuan
                    int start = nameToNode.get(dari);
                    int end = nameToNode.get(ke);

                    // Menggunakan Dijkstra untuk mencari jalur terpendek
                    DijkstraResult res = g.dijkstra(start);
                    List<Integer> path = res.getPath(end);
                    int totalDist = res.dist[end];

                    // Menampilkan hasil jalur terpendek atau jika tidak ada jalur tersedia
                    if (path.isEmpty() || totalDist == Integer.MAX_VALUE) {
                        System.out.println("Tidak ada jalur tersedia.");
                    } else {
                        System.out.print("Jalur terpendek ditemukan: ");
                        for (int i = 0; i < path.size(); i++) {
                            System.out.print(nodeToName.get(path.get(i)));
                            if (i != path.size() - 1) System.out.print(" -> ");
                        }
                        System.out.println("\nJarak total: " + totalDist + " km");
                    }
                }
                // Opsi 7: Keluar dari Program
                case 7 -> {
                    System.out.println("Keluar dari program.");
                    break OUTER;
                }
                // Menangani input opsi yang tidak valid
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }
}
