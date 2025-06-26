public class AVLTree {
    private Node node;

    public AVLTree() {              
        this.node = null;
    }

    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.getHeight();
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node insertRec(Node node, int value) {
        if (node == null) {
            System.out.println("MATEO MOREJON - SEBASTIAN CERON");
             System.out.println("Valor a insertar " + value);
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado:" + newNode.getValue() + " balance al insertar = " + getBalance(newNode));
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insertRec(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRec(node.getRight(), value));
        } else {
            return node; 
        }

        System.out.println("Nodo actual:" + node.getValue());

        // ACTUALIZAR LA ALTURA DE ESTE ANCESTRO NODO
        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("Altuta = " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("Balance = " + balance);

        // Rotaciones, solo se imprime el mensaje final correcto
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("ROTACION A LA DERECHA");
        } else if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("ROTACION A LA IZQUIERDA");
        } else if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("ROTACION IZQUIERDA DERECHA");
        } else if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("ROTACION DERECHA IZQUIERDA");
        }

        return node;
    }

    public void insert(int value) {
        System.out.println("MATEO MOREJON Y SEBASTIAN CERON");
        System.out.println("Valor a insertar " + value);
        node = insertRecWithoutPrint(node, value);
    }

    private Node insertRecWithoutPrint(Node node, int value) {
        if (node == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado:" + newNode.getValue() + " balance al insertat = " + getBalance(newNode));
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecWithoutPrint(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecWithoutPrint(node.getRight(), value));
        } else {
            return node; 
        }

        System.out.println("Nodo actual:" + node.getValue());

        int altura = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(altura);
        System.out.println("Altuta = " + node.getHeight());

        int balance = getBalance(node);
        System.out.println("Balance = " + balance);

        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("ROTACION A LA DERECHA");
        } else if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("ROTACION A LA IZQUIERDA");
        } else if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("ROTACION IZQUIERDA DERECHA");
        } else if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("ROTACION DERECHA IZQUIERDA");
        }

        return node;
    }
}
