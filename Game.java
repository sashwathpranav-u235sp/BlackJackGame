import java.util.Scanner;

public class Game {

    public static void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.err.format("InterruptedException : %s%n", e);
        }
    }

    Sprite Dealer = new Sprite(1);
    Sprite Player = new Sprite(0);


    public void play() {
        Dealer.cards.clear();
        Player.cards.clear();
        Dealer.Deal();
        Player.Deal();
        boolean loop = true;
        boolean tookstand = false;
        Scanner hitorstand = new Scanner(System.in);
        while (loop) {
            System.out.println(Dealer.RevealCards(tookstand) + "\n");
            System.out.println("The Dealer's points: " + Dealer.getPoints() + "\n");
            System.out.println("-----------------------------------------------------------------------------\n");
            System.out.println(Player.RevealCards(false) + "\n");
            System.out.println("Your points: " + Player.getPoints() + "\n");
            System.out.println("Choose an option:\n1.Hit\n2.Stand");
            int answer = hitorstand.nextInt();
            if (answer == 1) {
                Player.draw();
                if (Player.getPoints() > 21) {
                    System.out.println("You are bust! The Dealer wins\n");
                    tookstand = true;
                    System.out.println(Dealer.RevealCards(tookstand));
                    System.out.println("The Dealer's points: " + Dealer.getPoints() + "\n");
                    System.out.println("-----------------------------------------------------------------------------\n");
                    System.out.println(Player.RevealCards(false) + "\n");
                    System.out.println("Your points: " + Player.getPoints());
                    System.out.println("\n");
                    loop = false;
                }

            } else if (answer == 2) {
                tookstand = true;
                boolean subloop = true;
                while (subloop) {
                    int subDealerpoints = Dealer.getPoints();
                    int subPlayerpoints = Player.getPoints();
                    System.out.println(Dealer.RevealCards(tookstand));
                    System.out.println("The Dealer's points: " + Dealer.getPoints() + "\n");
                    System.out.println("-----------------------------------------------------------------------------\n");
                    System.out.println(Player.RevealCards(false) + "\n");
                    System.out.println("Your points: " + Player.getPoints());
                    if ( subDealerpoints <= 16) {
                        Dealer.draw();
                        if (Dealer.getPoints() > 21) {
                            System.out.println("The Dealer is bust!\n");
                            System.out.println(Dealer.RevealCards(tookstand));
                            System.out.println("The Dealer's points: " + Dealer.getPoints() + "\n");
                            System.out.println("-----------------------------------------------------------------------------\n");
                            System.out.println(Player.RevealCards(false) + "\n");
                            System.out.println("Your points: " + Player.getPoints());
                            System.out.println("\n");
                            subloop = false;
                            loop = false;

                        }
                    } else if (subDealerpoints <= 21) {
                        System.out.println("The Dealer has decided to Stand.\n");
                        subloop = false;
                    }


                }


                //Checking win condition
                boolean win1 = (Dealer.getPoints() > 21);
                boolean win2 = (Player.getPoints() > Dealer.getPoints() && Player.getPoints() <= 21);
                boolean win3 = (Player.getPoints() == Dealer.getPoints() && Player.getPoints() == 21 && Dealer.cards.size() < Player.cards.size());

                if (win1 ||win2 || win3) {
                    System.out.println("You win this game! Congratulations.\nYour points: " + Player.getPoints());
                    System.out.println("The Dealer's points: " + Dealer.getPoints());
                    System.out.println("\n");
                } else {

                    System.out.println("The Dealer won this game!\nYour points: " + Player.getPoints());
                    System.out.println("The Dealer's points: " + Dealer.getPoints());
                    System.out.println("\n");

                }




                loop = false;


            }else {
                System.out.println("The input is invalid, please try again");
            }



        }

    }
}
