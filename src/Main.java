import java.util.Objects;
import java.util.Scanner;

public class Main {
    public Tree<String> generateMorseTree() {
        Tree<String> morseTree = new Tree<String>();
        morseTree.add("E", ".");
        morseTree.add("T", "-");

        morseTree.add("I", "..");
        morseTree.add("A", ".-");
        morseTree.add("N", "-.");
        morseTree.add("M", "--");

        morseTree.add("S", "...");
        morseTree.add("U", "..-");
        morseTree.add("R", ".-.");
        morseTree.add("W", ".--");
        morseTree.add("D", "-..");
        morseTree.add("K", "-.-");
        morseTree.add("G", "--.");
        morseTree.add("O", "---");

        morseTree.add("H", "....");
        morseTree.add("V", "...-");
        morseTree.add("F", "..-.");
        morseTree.add("L", ".-..");
        morseTree.add("P", ".--.");
        morseTree.add("J", ".---");
        morseTree.add("B", "-...");
        morseTree.add("X", "-..-");
        morseTree.add("C", "-.-.");
        morseTree.add("Y", "-.--");
        morseTree.add("Z", "--..");
        morseTree.add("Q", "--.-");

        morseTree.add("5", ".....");
        morseTree.add("4", "....-");
        morseTree.add("3", "...--");
        morseTree.add("2", "..---");
        morseTree.add("1", ".----");
        morseTree.add("6", "-....");
        morseTree.add("7", "--...");
        morseTree.add("8", "---..");
        morseTree.add("9", "----.");
        morseTree.add("0", "-----");

        morseTree.add("+", ".-.-.");
        morseTree.add("=", "-...-");
        morseTree.add("/", "-..-.");

        return morseTree;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Tree<String> morseTree = main.generateMorseTree();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a frase em código morse que você deseja traduzir, com as letras separadas por espaço (0 para sair):");
            String palavraMorse = scanner.nextLine();

            if (Objects.equals(palavraMorse, "0")) {
                break;
            }

            System.out.println("Palavra traduzida: "+ morseTree.decodePalavra(palavraMorse)+"\n\n");

        }

    }
}