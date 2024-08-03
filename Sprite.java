import java.util.ArrayList;
import java.util.Random;

public class Sprite {

    String [] names = {"Player","The Dealer"};

    private final int sprite_type;

    public Sprite(int sprite_type) {
        this.sprite_type = sprite_type;
    }

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("InterruptedException : %s%n", e);
        }
    }

    public ArrayList<Card> cards = new ArrayList<Card>();


    public void Deal() {
        Random rand = new Random();
        cards.add(new Card(rand.nextInt(10)+1,rand.nextInt(4)+1));
        cards.add(new Card(rand.nextInt(10)+1,rand.nextInt(4)+1));

    }


    public void draw() {
        Random rnd = new Random();
        int randomrank = rnd.nextInt(10)+1;
        int randomsuit = rnd.nextInt(7)+1;
        if (sprite_type == 0) {
            System.out.println("You have decided to hit.\n");
        }else {
            System.out.println("The " + names[sprite_type] + " has decided to hit\n");
        }
        cards.add(new Card(randomrank,randomsuit));

    }

    public int getPoints() {
        int points = 0;
        for (Card x: cards) {
            points+=x.getPoints();
        }
        return points;
    }

    public String RevealCards (boolean tookStand) {
        StringBuilder answer = new StringBuilder("");
        if (sprite_type == 0) {
            answer.append("Your cards are:\n");
            pause(200);
            if (cards.size() == 2) {
                answer.append(cards.get(0).inString()).append("\n").append(cards.get(1).inString()).append("\n");

            }else {
                for (Card x: cards) {
                    answer.append(x.inString()).append("\n");

                }


            }


        } else {
            answer.append("The Dealer's cards are:\n");
            pause(200);
            if (cards.size() == 2) {
                if (tookStand) {
                    answer.append(cards.get(0).inString()).append("\n").append(cards.get(1).inString()).append("\n");

                }else {
                    answer.append(cards.get(0).inString()).append(" \nUnknown\n");
                }

            }else {
                for (Card x: cards) {
                    answer.append(x.inString()).append("\n");

                }


            }

        }

        return answer.toString();
    }


}
