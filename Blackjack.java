import java.util.Scanner;
public class Blackjack
{
   public static void main(String[] args)
   {
       boolean looping = true;

       // print these four variable when the statistics button in chosen
       int counter = 0;
       int playerWins = 0;
       int dealerWins = 0;
       int tieTracker = 0;
       int operation;

       P1Random rng = new P1Random();

       String faceCard = ""; //used to assign names to facecards

       Scanner scan = new Scanner(System.in);

       while (looping) // changing game number
       {
           boolean selecting = true;
           counter += 1;

           int playerValue = 0;
           int dealerValue = 0;

           System.out.println();
           System.out.println("START GAME #" + counter);
           System.out.println();

           playerValue = 0;

           int newCard = (rng.nextInt(13) + 1);

           while (selecting)
           {

               // assigns the value of 10 to the facecards
               if (newCard == 1)
               {
                   System.out.println("Your card is a " + faceCard + "!");
               } else if (newCard >= 11 && newCard <= 13)

               {
                   System.out.println("Your card is a " + faceCard + "!");
                   newCard = 10;

               } else if (newCard > 1 && newCard < 11)
               {
                   System.out.println("Your card is a " + newCard + "!");
               }

               playerValue += newCard;
               System.out.println("Your hand is: " + playerValue);


               //Check for blackjack

               if (playerValue == 21)
               {
                   System.out.println("BLACKJACK! You win!");
                   playerWins++;
                   selecting = false;
                   continue;

               } else if (playerValue > 21)
               {
                   System.out.println("You exceeded 21! You lose.");
                   dealerWins++;
                   selecting = false;
                   continue;
               }
               do
               {
                   //option menu
                   System.out.println("1. Get another card");
                   System.out.println("2. Hold hand");
                   System.out.println("3. Print statistics");
                   System.out.println("4. Exit");
                   System.out.println();

                   System.out.println("Choose an option: ");

                   operation = scan.nextInt();

                   if (operation >= 5 || operation <= 0)
                   {
                       System.out.println("Invalid input!");
                       System.out.println("Please enter an integer value between 1 and 4.");
                       continue;
                   } else if (operation == 3)
                   {
                       System.out.println("Number of Player wins: " + playerWins);
                       System.out.println("Number of Dealer wins: " + dealerWins);
                       System.out.println("Number of tie games: " + tieTracker);
                       counter = counter - 1;
                       System.out.println("Total # of games played is: " + counter);
                       System.out.println("Percentage of Player wins:" + (playerWins * 100 / counter) + ".0%");
                       System.out.println();
                       continue;
                   }
               } while(operation == 3 || operation > 4 || operation < 1);


               switch (operation)
               {
                   case 1:
                       newCard = (rng.nextInt(13) + 1);

                       //declare the face value to the cards

                       if (newCard == 1)
                       {
                           faceCard = "ACE";
                       } else if (newCard == 11)
                       {
                           faceCard = "JACK";
                       } else if (newCard == 12)
                       {
                           faceCard = "QUEEN";
                       } else if (newCard == 13)
                       {
                           faceCard = "KING";

                       }
                       break;
                   case 2:
                       dealerValue = (rng.nextInt(11) + 16);
                       System.out.println("Dealer's hand: " + dealerValue);
                       System.out.println("Your hand is: " + playerValue);
                       System.out.println();

                       // check if greater than 21 for dealer
                       // else if check if player and dealer are equal
                       // check who has the higher had value and declare them the winner

                       if (dealerValue > 21)
                       {
                           System.out.println("You win!");
                           playerWins++;
                           selecting = false;
                       } else if (dealerValue == playerValue)
                       {
                           System.out.println("It's a tie! No one wins!");
                           tieTracker++;
                           selecting = false;
                       } else if (dealerValue > playerValue)
                       {
                           System.out.println("Dealer wins!");
                           dealerWins++;
                           selecting = false;
                       }
                       break;
                   case 4:
                       System.exit(0);
                       selecting = false;
                       break;
               }
           }
       }
   }
}
