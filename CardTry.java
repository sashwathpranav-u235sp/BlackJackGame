import java.util.ArrayList;

public class CardTry {
    public static void main(String[] args) {
        Card randomcard = new Card(7,2);
        System.out.println(randomcard.inString());
        System.out.println(randomcard.getPoints());
    }
}
