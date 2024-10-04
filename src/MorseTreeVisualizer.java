import javax.swing.*;
import java.awt.*;

public class MorseTreeVisualizer extends JPanel {

    private final Tree<Character> morseTree;

    public MorseTreeVisualizer(Tree<Character> morseTree) {
        this.morseTree = morseTree;
        setPreferredSize(new Dimension(800, 600)); // Tamanho da janela
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Posição inicial para o nó raiz
        int startX = getWidth() / 2;
        int startY = 50;
        drawTree(g2d, morseTree.getRoot(), startX, startY, getWidth() / 4, 100);
    }

    private void drawTree(Graphics2D g, Node<Character> node, int x, int y, int xOffset, int yOffset) {
        if (node == null) return;

        // Desenha o círculo e o valor do nó
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30); // Círculo com raio 15
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.getData()), x - 5, y + 5); // Desenha o caractere no meio

        // Desenhar linha e nós filhos (esquerda e direita)
        if (node.getLeft() != null) {
            int newX = x - xOffset;
            int newY = y + yOffset;
            g.setColor(Color.BLACK);
            g.drawLine(x, y, newX, newY); // Linha para o nó esquerdo
            drawTree(g, node.getLeft(), newX, newY, xOffset / 2, yOffset); // Recursão para o nó esquerdo
        }

        if (node.getRight() != null) {
            int newX = x + xOffset;
            int newY = y + yOffset;
            g.setColor(Color.BLACK);
            g.drawLine(x, y, newX, newY); // Linha para o nó direito
            drawTree(g, node.getRight(), newX, newY, xOffset / 2, yOffset); // Recursão para o nó direito
        }
    }
}