public class Tree<Character> {
    private Node<Character> root;

    public Tree() {
        this.root = (Node<Character>) new Node<>(' ');
    }

    public Node<Character> getRoot() {
        return root;
    }

    public void add(Character letra, String morse) {
        char[] morseArray = morse.toCharArray();
        Node<Character> currentNode = root;
        for (char value : morseArray) {
            if (value == '.') {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft((Node<Character>) new Node<>(' '));
                }
                currentNode = currentNode.getLeft();
            } else if (value == '-') {
                if (currentNode.getRight() == null) {
                    currentNode.setRight((Node<Character>) new Node<>(' '));
                }
                currentNode = currentNode.getRight();
            }
        }
        currentNode.setData(letra);
    }



    public Character decodeLetra(String letra) {
        Node<Character> currentNode = root;
        char[] morseArray = letra.toCharArray();

        for (char symbol : morseArray) {
            if (symbol == '.') {
                currentNode = currentNode.getLeft();
            } else if (symbol == '-') {
                currentNode = currentNode.getRight();
            }

            if (currentNode == null) {
                throw new IllegalArgumentException("Sequência Morse inválida: " + letra);
            }
        }

        return currentNode.getData();
    }

    public String decodePalavra(String palavra) {
        String palavraDecodificada = "";
        String[] letras = palavra.split(" ");
        for (String letra : letras) {
            palavraDecodificada += decodeLetra(letra);
        }
        return palavraDecodificada;
    }



}
