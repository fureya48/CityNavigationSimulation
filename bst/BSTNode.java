package bst;

// Node untuk Binary Search Tree, menyimpan data warga
public class BSTNode {
    public int id;
    public String name;
    public int locationNode; // lokasi node pada graph kota
    public BSTNode left, right;

    public BSTNode(int id, String name, int locationNode) {
        this.id = id;
        this.name = name;
        this.locationNode = locationNode;
        this.left = this.right = null;
    }
}