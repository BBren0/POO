import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cantor {
    String nome;
    int idade;
    String generoMusical;
    String genero;
    String nacionalidade;

    public Cantor(String nome, int idade, String generoMusical, String genero, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.generoMusical = generoMusical;
        this.genero = genero;
        this.nacionalidade = nacionalidade;
    }
}

public class Akinator {

    public static void main(String[] args) {
        Cantor[] cantores = {
                // Lista de cantores aqui
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pense em um cantor...\nAgora responda às perguntas para que possamos adivinhá-lo");

        // Perguntas
        String[] perguntas = {
                "O cantor tem menos de 40 anos?",
                "Qual o gênero musical do cantor? (POP, Rock, Funk, Country)",
                "Qual o gênero do cantor? (Masculino, Feminino)",
                "Qual a nacionalidade do cantor? (Nacional, Internacional)"
        };

        String[] respostas = new String[perguntas.length];

        for (int i = 0; i < perguntas.length; i++) {
            System.out.println(perguntas[i]);
            respostas[i] = scanner.nextLine().toLowerCase();
        }

        Cantor[] cantoresPossiveis = filtrarCantores(cantores, perguntas, respostas);

        // Após fazer todas as perguntas, o programa tentará adivinhar o cantor
        if (cantoresPossiveis.length == 1) {
            System.out.println("O cantor que você está pensando é: " + cantoresPossiveis[0].nome);
        } else {
            System.out.println("Não consegui adivinhar o cantor. Talvez você tenha pensado em alguém que não está na lista.");
        }

        scanner.close();
    }

    private static Cantor[] filtrarCantores(Cantor[] cantores, String[] perguntas, String[] respostas) {
        List<Cantor> cantoresFiltrados = new ArrayList<>();

        for (Cantor cantor : cantores) {
            boolean correspondeATodasAsPerguntas = true;

            for (int i = 0; i < perguntas.length; i++) {
                String pergunta = perguntas[i];
                String resposta = respostas[i];

                if (pergunta.equals("O cantor tem menos de 40 anos?")) {
                    if ((resposta.equals("sim") && cantor.idade >= 40) || (resposta.equals("não") && cantor.idade < 40)) {
                        correspondeATodasAsPerguntas = false;
                        break;
                    }
                } else if (pergunta.equals("Qual o gênero musical do cantor? (pop, rock, funk, country)")) {
                    if (!cantor.generoMusical.equalsIgnoreCase(resposta)) {
                        correspondeATodasAsPerguntas = false;
                        break;
                    }
                } else if (pergunta.equals("Qual o gênero do cantor? (masculino, feminino)")) {
                    if (!cantor.genero.equalsIgnoreCase(resposta)) {
                        correspondeATodasAsPerguntas = false;
                        break;
                    }
                } else if (pergunta.equals("Qual a nacionalidade do cantor? (nacional, internacional)")) {
                    if (!cantor.nacionalidade.equalsIgnoreCase(resposta)) {
                        correspondeATodasAsPerguntas = false;
                        break;
                    }
                }
            }

            if (correspondeATodasAsPerguntas) {
                cantoresFiltrados.add(cantor);
            }
        }

        Cantor[] cantoresArray = new Cantor[cantoresFiltrados.size()];
        cantoresFiltrados.toArray(cantoresArray);

        return cantoresArray;
    }
}
