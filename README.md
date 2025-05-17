# City Navigation Simulation

Proyek ini adalah simulasi sederhana dalam Java yang menggabungkan penggunaan struktur data **Binary Search Tree (BST)**, **Hash Table**, dan **Graph** (dengan algoritma Dijkstra) untuk menyelesaikan masalah pencarian rute tercepat dari warga ke fasilitas umum seperti rumah sakit.

---

## 📁 Struktur Proyek

CityNavigationSimulation/
│
├── bst/
│ ├── BST.java # Struktur dan operasi pada Binary Search Tree (warga)
│ └── BSTNode.java # Struktur node dalam BST
│
├── fasilitas/
│ ├── Fasilitas.java # Representasi data fasilitas (kategori & lokasi)
│ └── HashTable.java # Penyimpanan fasilitas menggunakan HashMap
│
├── graph/
│ ├── DijkstraResult.java # Menyimpan hasil algoritma Dijkstra
│ └── Graph.java # Struktur graph dan algoritma Dijkstra
│
├── Main.java # Entry point aplikasi: simulasi interaktif pengguna
├── README.md # Dokumentasi proyek ini


---

## Fitur Utama
1. **Tambah Warga**: Menambahkan warga baru ke dalam sistem dengan ID, nama, dan lokasi mereka di dalam kota.
2. **Hapus Warga**: Menghapus data warga berdasarkan ID.
3. **Edit Warga**: Mengedit data warga seperti nama atau lokasi mereka.
4. **Cari Jalur ke Fasilitas Terdekat**: Mencari jalur terpendek dari lokasi warga ke fasilitas terdekat berdasarkan kategori fasilitas (misal: Rumah Sakit, Pusat Perbelanjaan, dll).
5. **Tampilkan Semua Warga**: Menampilkan daftar seluruh warga yang terdaftar.
6. **Cari Jalur dari Titik ke Titik**: Menghitung jalur terpendek antara dua titik (misal: dari A ke E).
7. **Keluar**: Keluar dari aplikasi.

## Struktur Data yang Digunakan
- **Binary Search Tree (BST)**: Digunakan untuk menyimpan data warga, memungkinkan pencarian, penambahan, dan penghapusan data warga secara efisien.
- **HashTable**: Digunakan untuk menyimpan informasi fasilitas seperti rumah sakit, pusat perbelanjaan, dan layanan umum.
- **Graph**: Digunakan untuk merepresentasikan kota dengan node yang saling terhubung, serta untuk mencari jalur terpendek antar titik menggunakan algoritma **Dijkstra**.

## Algoritma
### Dijkstra
- Program ini menggunakan algoritma **Dijkstra** untuk menemukan jalur terpendek antara dua titik dalam graf. Setiap titik mewakili lokasi (node), dan setiap edge mewakili jarak antar titik.

## Cara Menjalankan Program
1. Pastikan Anda sudah menginstal **Java** di sistem Anda.
2. Unduh atau clone repository ini ke dalam direktori lokal Anda.
3. Compile program menggunakan perintah:
   ```bash
   javac Main.java
   ```
4. Jalankan program menggunakan perintah:
   ```bash
   java Main
   ```
## Menu Interaktif
Setelah menjalankan program, Anda akan melihat menu interaktif yang memungkinkan Anda untuk memilih berbagai opsi. Berikut adalah penjelasan tentang setiap opsi:
1. **Tambah Warga**: Anda akan diminta untuk memasukkan ID, nama, dan lokasi warga baru.
2. **Hapus Warga**: Anda akan diminta untuk memasukkan ID warga yang ingin dihapus.
3. **Edit Warga**: Anda akan diminta untuk memasukkan ID warga yang ingin diedit, serta informasi baru yang ingin diperbarui.
4. **Cari Jalur ke Fasilitas Terdekat**: Anda akan diminta untuk memasukkan ID warga, dan program akan mencari jalur terpendek ke fasilitas terdekat berdasarkan kategori yang dipilih.
5. **Tampilkan Semua Warga**: Program akan menampilkan daftar semua warga yang terdaftar dalam sistem.
6. **Cari Jalur dari Titik ke Titik**: Anda akan diminta untuk memasukkan dua titik (node) dalam graf, dan program akan menghitung jalur terpendek antara kedua titik tersebut.
7. **Keluar**: Keluar dari aplikasi.

## Contoh Penggunaan
### Menambahkan Warga
```yaml
Masukkan ID Warga: 121
Masukkan Nama Warga: John Doe
Masukkan Lokasi Warga: 3
Warga berhasil ditambahkan.
```
### Mencari Jalur ke Fasilitas Terdekat
```less
Masukkan ID Warga: 121
Masukkan Kategori Fasilitas (Rumah Sakit, Pusat Perbelanjaan): Rumah Sakit
Jalur terdekat dari Andi ke RS Medika:
A B C D E
Jarak: 12 km
```
### Menampilkan Jalur dari Titik ke Titik
```less
Masukkan titik awal (A-F): A
Masukkan titik tujuan (A-F): E
Jalur terpendek ditemukan: A -> B -> C -> E
Jarak total: 12 km
```

## Struktur Kode
- **Main.java**: Program utama yang mengontrol alur aplikasi.
- **BST.java**: Implementasi Binary Search Tree untuk mengelola data warga.
- **Graph.java**: Implementasi graf dan algoritma Dijkstra untuk mencari jalur terpendek.
- **Fasilitas.java**: Kelas untuk mewakili fasilitas dengan kategori dan lokasi node.
- **HashTable.java**: Implementasi HashTable untuk menyimpan fasilitas.

## Requirements
- Java 8 atau latest version
- IDE Java (Eclipse, IntelliJ, atau NetBeans) untuk pengembangan dan debugging