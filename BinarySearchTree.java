class BinarySearchTree {

    class Node {
        String key;
        String[] value;
        Node left, right;

        public Node(String item, String[] arr) {
            key = item;
            value = arr;
            left = right = null;
        }
    }

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    /**
     * Inserta un nuevo nodo al arbol
     * 
     * @param key
     * @param value
     */
    public void insert(String key, String[] value) {
        root = insertRec(root, key, value);
    }

    /**
     * Realiza las comparaciones necesarias para equilibrar el arbol
     * 
     * @param root
     * @param key
     * @param value
     * @return Node
     */
    public Node insertRec(Node root, String key, String[] value) {

        if (root == null) {
            root = new Node(key, value);
            return root;
        }

        if (key.compareToIgnoreCase(root.key) < 0)
            root.left = insertRec(root.left, key, value);
        else if (key.compareToIgnoreCase(root.key) >= 0)
            root.right = insertRec(root.right, key, value);

        return root;
    }

    /**
     * Obtiene todo el arbol y lo imprime en consola
     */
    public void getBST() {
        inorderRec(root);
    }

    /**
     * 
     * @param root
     */
    private void inorderRec(Node root) {
        if (root != null) {

            inorderRec(root.left);

            try {
                System.out.println("\n - " + root.key);

                System.out.println("   Ingles: " + root.value[0]);
                System.out.println("   Espanol: " + root.value[1]);
                System.out.println("   Frances: " + root.value[2]);

            } catch (Exception e) {
                System.out.println("\n - " + root.key + " - sin datos");
            }

            inorderRec(root.right);
        }
    }

    String[] arr = null;

    /**
     * Realiza una busqueda en el arbol del nodo con la clave indicada
     * 
     * @param key
     * @return el nodo con la clave indicada
     */
    public String[] getNode(String key) {
        arr = null;
        getNodeRec(root, key);
        return arr;
    }

    /**
     * Realiza una busqueda en el arbol del nodo con la clave indicada
     * 
     * @param root
     * @param key
     */
    public void getNodeRec(Node root, String key) {
        if (root != null) {

            getNodeRec(root.left, key);

            if (root.key.equals(key)) {
                arr = root.value;
            }

            getNodeRec(root.right, key);
        }
    }
}
