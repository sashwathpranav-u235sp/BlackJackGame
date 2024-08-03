
/*Course: COE 318
* Lab Number: 5
* Blackjack game by Sashwath
* Rules for the game are from the following website
* https://www.agco.ca/lottery-and-gaming/fair-or-exhibition-event-licence-rules-play-blackjack
*/

import java.util.Scanner;
import java.util.Random;

public class Main {




    //Gameloop in the psvm method
    public static void main(String[] args) {

        boolean loop = true;
        Game Blackjack = new Game();

        while (loop) {
            Scanner menu_input = new Scanner(System.in);
            System.out.println("1989(Sashwath's Version) Blackjack game\nGame rules: https://www.agco.ca/lottery-and-gaming/fair-or-exhibition-event-licence-rules-play-blackjack\n");
            System.out.println("Enter an option number below\n1.Play\n2.Exit");
            int answer = menu_input.nextInt();
            if (answer == 1) {
                System.out.println("Game in BETA form\n");
                Blackjack.play();

            }else {
                System.out.println("Thank you for using me :D");
                loop = false;
            }

        }

    }
}