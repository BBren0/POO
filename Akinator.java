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
           new Cantor("Bruno Mars",37,"POP","Masculino","Internacional"),
            new Cantor("Bon Jovi",71,"Rock","Masculino","Internacional"),
            new Cantor("Anitta",30,"Funk","Feminino","Nacional"),
            new Cantor("Marilia Mendonça",26,"Country","Feminino","Nacional"),
            new Cantor("Beyonce",42,"POP","Feminino","Internacional"),
            new Cantor("Avril Lavigne",39,"Rock","Feminino","Internacional"),
            new Cantor("Mc Pedrinho",21,"Funk","Masculino","Nacional"),
            new Cantor("Gustavo Lima",34,"Country","Masculino","Nacional"),
            new Cantor("Jão",28,"POP","Masculino","Nacional"),
            new Cantor("Rita Lee",75,"Rock","Feminino","Nacional"),
            new Cantor("James Brown",73,"Funk","Masculino","Internacional"),
            new Cantor("Johnny Cash",62,"Country","Masculino","Internacional"),
            new Cantor("Iza",33,"POP","Feminino","Nacional"),
            new Cantor("Raul Seixas",44,"Rock","Masculino","Nacional"),
            new Cantor("Ludmilla",28,"Funk","Feminino","Nacional"),
            new Cantor("Taylor Swift",33,"Country","Feminino","Internacional"),
        };
    
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\tPense em um cantor...\n\tAgora responda às perguntas para que possamos adivinhá-lo");
    
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
    
        Cantor[] cantoresFiltrados = cantores;
    
        // Filtragem com base nas respostas do usuário
        if (respostas[0].equals("sim")) {
            cantoresFiltrados = filtrarPorIdade(cantoresFiltrados, 40, true);
        } else {
            cantoresFiltrados = filtrarPorIdade(cantoresFiltrados, 40, false);
        }
    
        if (respostas[1].equals("pop")) {
            cantoresFiltrados = filtrarPorGeneroMusical(cantoresFiltrados, "POP");
        } else if (respostas[1].equals("rock")) {
            cantoresFiltrados = filtrarPorGeneroMusical(cantoresFiltrados, "Rock");
        } else if (respostas[1].equals("funk")) {
            cantoresFiltrados = filtrarPorGeneroMusical(cantoresFiltrados, "Funk");
        } else if (respostas[1].equals("country")) {
            cantoresFiltrados = filtrarPorGeneroMusical(cantoresFiltrados, "Country");
        }
    
        if (respostas[2].equals("masculino")) {
            cantoresFiltrados = filtrarPorGenero(cantoresFiltrados, "Masculino");
        } else if (respostas[2].equals("feminino")) {
            cantoresFiltrados = filtrarPorGenero(cantoresFiltrados, "Feminino");
        }
    
        if (respostas[3].equals("nacional")) {
            cantoresFiltrados = filtrarPorNacionalidade(cantoresFiltrados, "Nacional");
        } else if (respostas[3].equals("internacional")) {
            cantoresFiltrados = filtrarPorNacionalidade(cantoresFiltrados, "Internacional");
        }
    
        // Após fazer todas as perguntas, o programa tentará adivinhar o cantor, com base nas respostas e nas funções/métodos de filtragem
        if (cantoresFiltrados.length == 1) {
            System.out.println("O cantor que você está pensando é: " + cantoresFiltrados[0].nome);
        } else {
            System.out.println("Não consegui adivinhar o cantor. Talvez você tenha pensado em alguém que não está na lista.");
        }
    
        scanner.close();
    }
    
    //Função/MÉTODO para filtrar idade com base nas respostas da pergunta 1    
    private static Cantor[] filtrarPorIdade(Cantor[] cantores, int idadeLimite, boolean menorQueLimite) {
        List<Cantor> cantoresFiltrados = new ArrayList<>();
    
        for (Cantor cantor : cantores) {
            if (menorQueLimite && cantor.idade < idadeLimite) {
                cantoresFiltrados.add(cantor);
            } else if (!menorQueLimite && cantor.idade >= idadeLimite) {
                cantoresFiltrados.add(cantor);
            }
        }
    
        return cantoresFiltrados.toArray(new Cantor[0]);
    }
    
    //Função para filtrar gênero com base na pergunta 2
    private static Cantor[] filtrarPorGeneroMusical(Cantor[] cantores, String generoMusical) {
        List<Cantor> cantoresFiltrados = new ArrayList<>();
    
        for (Cantor cantor : cantores) {
            if (cantor.generoMusical.equalsIgnoreCase(generoMusical)) {
                cantoresFiltrados.add(cantor);
            }
        }
    
        return cantoresFiltrados.toArray(new Cantor[0]);
    }
    
    //Função para filtrar gênero (sexual) com base na pergunta 3
    private static Cantor[] filtrarPorGenero(Cantor[] cantores, String genero) {
        List<Cantor> cantoresFiltrados = new ArrayList<>();
    
        for (Cantor cantor : cantores) {
            if (cantor.genero.equalsIgnoreCase(genero)) {
                cantoresFiltrados.add(cantor);
            }
        }
    
        return cantoresFiltrados.toArray(new Cantor[0]);
    }
    
    //Função para filtrar a nacionalidade com base na pergunta 4
    private static Cantor[] filtrarPorNacionalidade(Cantor[] cantores, String nacionalidade) {
        List<Cantor> cantoresFiltrados = new ArrayList<>();
    
        for (Cantor cantor : cantores) {
            if (cantor.nacionalidade.equalsIgnoreCase(nacionalidade)) {
                cantoresFiltrados.add(cantor);
            }
        }
    
        return cantoresFiltrados.toArray(new Cantor[0]);
    }
    
}
