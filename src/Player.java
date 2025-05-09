import java.util.Scanner;

public class Player {

    // Metodo di utilità per leggere un numero intero con controllo
    public static int leggiIntero(Scanner scanner, String messaggio) {
        System.out.println(messaggio);
        while (!scanner.hasNextInt()) {
            System.out.println("Errore: devi inserire un numero intero.");
            scanner.next();
            System.out.println(messaggio);
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        for (int i = 0; i < elementi.length; i++) {
            int tipo;

            // Scelta del tipo di elemento (con controllo)
            do {
                tipo = leggiIntero(scanner, "Inserisci tipo di elemento (1=Immagine, 2=Audio, 3=Video):");
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Errore: inserisci 1, 2 o 3.");
                }
            } while (tipo < 1 || tipo > 3);

            scanner.nextLine(); // consuma newline

            // Inserimento titolo
            System.out.println("Titolo:");
            String titolo = scanner.nextLine();

            // Creazione dell'oggetto in base al tipo
            switch (tipo) {
                case 1: // Immagine
                    int luminosita = leggiIntero(scanner, "Inserisci luminosità:");
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;

                case 2: // Audio
                    int durataA = leggiIntero(scanner, "Inserisci durata:");
                    int volumeA = leggiIntero(scanner, "Inserisci volume:");
                    elementi[i] = new Audio(titolo, durataA, volumeA);
                    break;

                case 3: // Video
                    int durataB = leggiIntero(scanner, "Inserisci durata:");
                    int volumeB = leggiIntero(scanner, "Inserisci volume:");
                    int luminositaB = leggiIntero(scanner, "Inserisci luminosità:");
                    elementi[i] = new Video(titolo, durataB, volumeB, luminositaB);
                    break;
            }

            scanner.nextLine(); // consuma newline extra
        }

        int scelta;

        do {
            System.out.println("Scegli un elemento della lista che hai creato, inserendo un numero da 1 a 5 per selezionare, 0 per terminare:");
            while (!scanner.hasNextInt()) {
                System.out.println("Errore: Inserisci un numero intero da 1 a 5 per selezionare, 0 per terminare:");
                scanner.next();
            }

            scelta = scanner.nextInt();

            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento instanceof ElementoRiproducibile) {
                    ((ElementoRiproducibile) elemento).play();
                } else if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                } else {
                    System.out.println("Tipo di elemento sconosciuto.");
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida. Inserisci un numero tra 1 e 5, oppure 0 per uscire.");
            }

        } while (scelta != 0);

        System.out.println("Lettore multimediale terminato.");
        scanner.close();
    }
}