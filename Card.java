
/*points distribution:
/*Code for card type: 1-4 suit types, 5-7 are face cards*/
public class Card {

    private final int rank;
    private final int suit;

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        String suittype = switch (suit) {
            case 1 -> "Clubs";
            case 2 -> "Diamonds";
            case 3 -> "Hearts";
            case 4 -> "Spades";
            case 5 -> "King";
            case 6 -> "Queen";
            case 7 -> "Jack";
            default -> "";
        };

        return (suittype);

    }

    public int getPoints() {
        int points;
        if (suit >= 1 && suit <=4) {
            points = rank;
        } else {
            points = 10;
        }

        return points;
    }

    public String inString() {
        if (suit>4 && suit<8) {
            return (this.getSuit());
        }else if (rank == 1) {
            return ("Ace of "+this.getSuit());
        }else {
            return (rank + " of "+this.getSuit());
        }
    }
}
