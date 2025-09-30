import java.util.*;

public class Ejercicio9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Deck deck = new Deck();
        deck.shuffle(); // Mezclamos el mazo

        Hand player = new Hand();
        Hand dealer = new Hand();

        // Repartir 2 cartas iniciales al jugador y al crupier
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());

        System.out.println("=== Bienvenido al juego de Blackjack ===\n");

        // Mostrar cartas del jugador y una del crupier
        System.out.println("Tus cartas: " + player);
        System.out.println("Puntos actuales: " + player.getPoints());
        System.out.println("Carta visible del crupier: " + dealer.getCards()[0]);

        // Turno del jugador
        while (player.getPoints() < 21 && player.getCount() < 5) {
            System.out.print("\n¿Deseas otra carta? (s/n): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                player.addCard(deck.dealCard());
                System.out.println("Tus cartas ahora: " + player);
                System.out.println("Puntos actuales: " + player.getPoints());
            } else {
                break;
            }
        }

        // Si el jugador se pasa de 21
        if (player.getPoints() > 21) {
            System.out.println("\nTe pasaste de 21. Has perdido.");
            return;
        }

        // Turno del crupier
        System.out.println("\nTurno del crupier...");
        System.out.println("Cartas del crupier: " + dealer + " (Puntos: " + dealer.getPoints() + ")");
        while (dealer.getPoints() < 16 && dealer.getCount() < 5) {
            dealer.addCard(deck.dealCard());
            System.out.println("El crupier toma otra carta: " + dealer + " (Puntos: " + dealer.getPoints() + ")");
        }

        // Mostrar resultado
        int playerPts = player.getPoints();
        int dealerPts = dealer.getPoints();

        System.out.println("\n=== Resultado final ===");
        System.out.println("Tus puntos: " + playerPts);
        System.out.println("Puntos del crupier: " + dealerPts);

        if (dealerPts > 21 || playerPts > dealerPts) {
            System.out.println("¡Felicidades! Has ganado.");
        } else if (playerPts == dealerPts) {
            System.out.println("El resultado es un empate.");
        } else {
            System.out.println("El crupier gana. Mejor suerte la próxima vez.");
        }
    }
}

// ======================= CLASE DECK =======================
class Deck {
    Card[] cardArray = new Card[52];
    int index = 0;

    Deck() {
        int suits = 4;
        int cardType = 13;
        int cardCount = 0;
        for (int i = 1; i <= suits; i++) {
            for (int j = 1; j <= cardType; j++) {
                cardArray[cardCount] = new Card(i, j);
                cardCount++;
            }
        }
    }

    public void shuffle() {
        List<Card> list = Arrays.asList(cardArray);
        Collections.shuffle(list);
        list.toArray(cardArray);
        index = 0;
    }

    public Card dealCard() {
        if (index < cardArray.length) {
            return cardArray[index++];
        }
        return null;
    }
}

// ======================= CLASE HAND =======================
class Hand {
    private Card[] cards = new Card[5];
    private int count = 0;

    public void addCard(Card c) {
        if (count < 5) {
            cards[count] = c;
            count++;
        }
    }

    public Card[] getCards() {
        return cards;
    }

    public int getCount() {
        return count;
    }

    public int getPoints() {
        int total = 0;
        int aces = 0;

        for (int i = 0; i < count; i++) {
            total += cards[i].getPoints();
            if (cards[i].getName().equals("Ace")) {
                aces++;
            }
        }

        // Ajustar el valor de los Ases si el total pasa de 21
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        return total;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += cards[i] + " ";
        }
        return result;
    }
}

// ======================= CLASE CARD =======================
class Card {
    String suit, name;
    int points;

    Card(int n1, int n2) {
        suit = getSuit(n1);
        name = getName(n2);
        points = getPoints(name);
    }

    public String toString() {
        return name + " de " + suit;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getName(int i) {
        if (i == 1) return "Ace";
        if (i == 2) return "Dos";
        if (i == 3) return "Tres";
        if (i == 4) return "Cuatro";
        if (i == 5) return "Cinco";
        if (i == 6) return "Seis";
        if (i == 7) return "Siete";
        if (i == 8) return "Ocho";
        if (i == 9) return "Nueve";
        if (i == 10) return "Diez";
        if (i == 11) return "Jota";
        if (i == 12) return "Reina";
        if (i == 13) return "Rey";
        return "error";
    }

    public int getPoints(String n) {
        if (n.equals("Jota") || n.equals("Reina") || n.equals("Rey") || n.equals("Diez"))
            return 10;
        if (n.equals("Dos")) return 2;
        if (n.equals("Tres")) return 3;
        if (n.equals("Cuatro")) return 4;
        if (n.equals("Cinco")) return 5;
        if (n.equals("Seis")) return 6;
        if (n.equals("Siete")) return 7;
        if (n.equals("Ocho")) return 8;
        if (n.equals("Nueve")) return 9;
        if (n.equals("Ace")) return 11; // Comienza como 11
        return -1;
    }

    public String getSuit(int i) {
        if (i == 1) return "Diamantes";
        if (i == 2) return "Tréboles";
        if (i == 3) return "Picas";
        if (i == 4) return "Corazones";
        return "error";
    }
}
