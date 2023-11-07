import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Perguntas {
   private String Pergunta;
   private String AlternativaSim;
   private String AlternativaNao;
   private String Resposta;
    
public Perguntas(String Pergunta, String AlternativaSim, String AlternativaNao, String Resposta)`{
    this.pergunta = pergunta;
    this.AlternativaSim = AlternativaSim;
    this.AlternativaNao = AlternativaNao;
    this.Resposta = Resposta;
    }
}
    
public class Cantor {
   private String nome;
   private int idade;
   private String generoMusical;
   private String genero;
   private String nacionalidade;

public Cantor(String nome, int idade, String generoMusical, String genero, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.generoMusical = generoMusical;
        this.genero = genero;
        this.nacionalidade = nacionalidade;
    }
}

public class Akinator {
    
    // Cantores
    public static void main(String[] args) {
         cantores = new ArrayCantores<>();
            cantores.add(new Cantor("Bruno Mars","37","POP", "Masculino","Internacional"));
            cantores.add(new Cantor("Bon Jovi","71","Rock","Masculono","Internacional"));
            cantores.add(new Cantor("Anitta","30","Funk","Feminino","Nacional"));
            cantores.add(new Cantor("Marilia Mendonça","26","Country","Feminino","Nacional"));
            cantores.add(new Cantor("Beyonce","42","POP","Feminino","Internacional"));
            cantores.add(new Cantor("Avril Lavigne","39","Rock","Feminino","Internacional"));
            cantores.add(new Cantor("Mc Pedrinho","21","Funk","Masculino","Nacional"));
            cantores.add(new Cantor("Gustavo Lima","34","Country","Masculino","Nacional"));
            cantores.add(new Cantor("Jao","28","POP","Masculino","Nacional"));
            cantores.add(new Cantor("Rita Lee","75","Rock","Feminino","Nacional"));
            cantores.add(new Cantor("James Brown","73","Funk","Masculino","Internacional"));
            cantores.add(new Cantor("Johnny Cash","62","Country","Masculino","Internacional"));
            cantores.add(new Cantor("Iza","33","POP","Feminino","Nacional"),
            cantores.add(new Cantor("Raul Seixas","44","Rock","Masculino","Nacional"));
            cantores.add(new Cantor("Ludmilla","28","Funk","Feminino","Nacional"));
            cantores.add(new Cantor("Taylor Swift","33","Country","Feminino","Internacional"));
            }
        }

        public Cantor adivinharCantor(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Pense em um cantor...\nAgora responda às perguntas para que possamos adivinhá-lo");
            
            for (Cantor cantor : cantores) { //Itera para cada cantor na lista
                System.out.println("O cantor tem " + cantor.getIdade() + " anos?");
                String resposta = scanner.nextLine().toLowerCase();
            }  
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
