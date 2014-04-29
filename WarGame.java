import java.util.Random;
import java.util.ArrayList;   
   
public class WarGame extends Deck1
{
   public static void main(String [] args) 
   {
      WarGame game1 = new WarGame();
      
      Deck1 playerOneDeck = new Deck1(); //Create player decks
      Deck1 playerTwoDeck = new Deck1();
      
      playerOneDeck.Clear(); //Empty them
      playerTwoDeck.Clear();
   
      Deck1 deck = new Deck1();//Create total pile
      deck.shuffle(); //Shuffle
      
      
      while (!(deck.isEmpty()))
         {
         playerOneDeck.add(deck.dealCard());//Deal cards from big deck into two smaller decks
         playerTwoDeck.add(deck.dealCard());
         }
         
         playerOneDeck.shuffle();
         playerTwoDeck.shuffle();
         
         int i = 1;
         int quit;

      while (playerOneDeck.cardsRemaining() > 1 && playerTwoDeck.cardsRemaining() > 1)
      {
         Card c1 = playerOneDeck.dealCard();
         Card c2 = playerTwoDeck.dealCard();
         
         System.out.println(c1);
         System.out.println(c2);
         
         int winner = game1.Turn(c1,c2);
            
         System.out.println(winner);
         
         if(winner == 1)
            {
               playerOneDeck.add(c1);
               playerOneDeck.add(c2);
            }
         if(winner == 2)
            {
               playerTwoDeck.add(c1);
               playerTwoDeck.add(c2);
            }
         if(winner == 0)
            {  
                  Card c3 = playerOneDeck.dealCard();//c3 and c4 are the face down
                  Card c4 = playerTwoDeck.dealCard();
                  Card c5 = playerOneDeck.dealCard();//c5 and c6 are face up
                  Card c6 = playerTwoDeck.dealCard();
                  int warWinner = game1.Turn(c5,c6);        
                     if(warWinner == 1)
                        {
                           playerOneDeck.add(c1);
                           playerOneDeck.add(c2);
                           playerOneDeck.add(c3);
                           playerOneDeck.add(c4);
                           playerOneDeck.add(c5);
                           playerOneDeck.add(c6);
                        }
                     if(warWinner == 2)
                        {
                           playerTwoDeck.add(c1);
                           playerTwoDeck.add(c2);
                           playerTwoDeck.add(c3);
                           playerTwoDeck.add(c4);
                           playerTwoDeck.add(c5);
                           playerTwoDeck.add(c6);
                        }
                     if(warWinner == 0)
                        {
                           playerOneDeck.add(c1);
                           playerTwoDeck.add(c2);
                           playerOneDeck.add(c3);
                           playerTwoDeck.add(c4);
                           playerOneDeck.add(c5);
                           playerTwoDeck.add(c6);
                        }
               }
            
        int deck1size = playerOneDeck.cardsRemaining();    
        System.out.println(deck1size);
        
        int deck2size = playerTwoDeck.cardsRemaining();    
        System.out.println(deck2size);
        i++;
        

        playerOneDeck.shuffle();
        playerTwoDeck.shuffle();
        
      }
        if (playerOneDeck.cardsRemaining() > playerTwoDeck.cardsRemaining())
         System.out.println("Player One Wins!!!!");
        else if (playerTwoDeck.cardsRemaining()>playerOneDeck.cardsRemaining())
         System.out.println("Player Two Wins!!!!");   
   }
      
   public int Turn(Card c1, Card c2)
   {
    int high = 3;
      if (c1.getRank() > c2.getRank())
         {
            high = 1;
         }
      else if (c2.getRank() > c1.getRank())
         {
            high = 2;
         }
      else if (c1.getRank() == c2.getRank())
         {
            high = 0;
         }
         
      return high;
   }
   

   
}