package forca;

import java.util.*;

public class JogoDaForca {

    public static void main(String[] args) {

        int indiceAleatorio;
        String palavraSecreta;
        int chace;


        Scanner entrada = new Scanner(System.in);
        List<String> palavras = List.of("Bola", "Teclado", "Celular", "Cachorro", "Carro", "Escola");

        Random random = new Random();
        indiceAleatorio = random.nextInt(palavras.size());
        palavraSecreta = palavras.get(indiceAleatorio).toUpperCase();


        System.out.println("JOGO DA FORCA");
        System.out.println("Tem 3 chance para acerta!!!");

        char[] palavraAdivinhada = new char[palavraSecreta.length()];

        for (int i = 0; i < palavraSecreta.length(); i++) {
            palavraAdivinhada[i] = '_';
        }


        chace = 3;
        boolean venceu = false;

        while (chace > 0 && !venceu) {

            System.out.println("Palavra: ");
            System.out.println(palavraAdivinhada);
            System.out.println("Chance restantes: " + chace);


            System.out.print("Digite uma letra: ");
            char letra = entrada.next().charAt(0);
            letra = Character.toUpperCase(letra);

            boolean acertou = false;
            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraAdivinhada[i] = letra;
                    acertou = true;
                }
            }

            if (!acertou) {
                chace--;
            }

            venceu = true;
            for (int i = 0; i < palavraAdivinhada.length; i++) {
                if (palavraAdivinhada[i] == '_') {
                    venceu = false;
                    break;
                }

            }
        }

        if (venceu) {
            System.out.println("Parabéns! Você adivinhou a palavra: " + palavraSecreta);
        }else {
            System.out.println("Você perdeu! A palavra era " + palavraSecreta);
        }
    }
}
