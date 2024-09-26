import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class MorseTreeVisualizer extends JPanel {
    private final Tree<String> morseTree;

    public MorseTreeVisualizer(Tree<String> morseTree) {
        this.morseTree = morseTree;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Node<String> root = morseTree.getRoot();
        if (root != null) {
            drawTree(g2d, root, getWidth() / 2, 50, getWidth() / 4, 50);
        }
    }

    private void drawTree(Graphics2D g2d, Node<String> node, int x, int y, int xOffset, int yOffset) {
        g2d.setColor(Color.BLACK);
        g2d.drawString(node.getData(), x - 10, y); // Desenha o dado no nó

        if (node.getLeft() != null) {
            // Desenhar linha para o filho à esquerda
            g2d.draw(new Line2D.Double(x, y, x - xOffset, y + yOffset));
            drawTree(g2d, node.getLeft(), x - xOffset, y + yOffset, xOffset / 2, yOffset);
        }
        if (node.getRight() != null) {
            // Desenhar linha para o filho à direita
            g2d.draw(new Line2D.Double(x, y, x + xOffset, y + yOffset));
            drawTree(g2d, node.getRight(), x + xOffset, y + yOffset, xOffset / 2, yOffset);
        }
    }

    public static void main(String[] args) {
        Tree<String> morseTree = new Tree<>();

        morseTree.add(" ");
        morseTree.add("E");
        morseTree.add("T");
        morseTree.add("I");
        morseTree.add("A");
        morseTree.add("N");
        morseTree.add("M");
        morseTree.add("S");
        morseTree.add("U");
        morseTree.add("R");
        morseTree.add("W");
        morseTree.add("D");
        morseTree.add("K");
        morseTree.add("G");
        morseTree.add("O");
        morseTree.add("H");
        morseTree.add("V");
        morseTree.add("F");
        morseTree.add("L");
        morseTree.add("P");
        morseTree.add("J");
        morseTree.add("B");
        morseTree.add("X");
        morseTree.add("C");
        morseTree.add("Y");
        morseTree.add("Z");
        morseTree.add("Q");
        morseTree.add("5");
        morseTree.add("4");
        morseTree.add("3");
        morseTree.add("2");
        morseTree.add("1");
        morseTree.add("6");
        morseTree.add("7");
        morseTree.add("8");
        morseTree.add("9");
        morseTree.add("0");
        morseTree.add("+");
        morseTree.add("=");
        morseTree.add("/");

        JFrame frame = new JFrame("Morse Tree Visualizer");
        MorseTreeVisualizer treeVisualizer = new MorseTreeVisualizer(morseTree);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(treeVisualizer);
        frame.pack();
        frame.setVisible(true);
    }
}

