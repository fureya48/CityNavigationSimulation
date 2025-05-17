package bst;

// Struktur data Binary Search Tree untuk menyimpan data warga
public class BST {
    private BSTNode root;

    // Menambahkan data warga ke BST
    public void insert(int id, String name, int locationNode) {
        root = insertRec(root, id, name, locationNode);
    }

    private BSTNode insertRec(BSTNode node, int id, String name, int locationNode) {
        if (node == null) return new BSTNode(id, name, locationNode);
        if (id < node.id) node.left = insertRec(node.left, id, name, locationNode);
        else if (id > node.id) node.right = insertRec(node.right, id, name, locationNode);
        return node;
    }

    // Mencari data warga berdasarkan ID
    public BSTNode search(int id) {
        return searchRec(root, id);
    }

    private BSTNode searchRec(BSTNode node, int id) {
        if (node == null || node.id == id) return node;
        if (id < node.id) return searchRec(node.left, id);
        return searchRec(node.right, id);
    }

    // Menghapus data warga berdasarkan ID
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private BSTNode deleteRec(BSTNode node, int id) {
        if (node == null) return null;

        if (id < node.id) {
            node.left = deleteRec(node.left, id);
        } else if (id > node.id) {
            node.right = deleteRec(node.right, id);
        } else {
            // Node ditemukan
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            // Jika punya 2 anak, cari pengganti (min dari right subtree)
            BSTNode minNode = minValueNode(node.right);
            node.id = minNode.id;
            node.name = minNode.name;
            node.locationNode = minNode.locationNode;

            // Hapus node pengganti dari right subtree
            node.right = deleteRec(node.right, minNode.id);
        }

        return node;
    }

    // Mencari node dengan nilai terkecil (untuk bantu delete)
    private BSTNode minValueNode(BSTNode node) {
        BSTNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Optional: menampilkan isi tree secara inorder
    public void inorderTraversal() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.println("ID: " + node.id + ", Name: " + node.name + ", Lokasi: " + node.locationNode);
            inorderRec(node.right);
        }
    }
}
