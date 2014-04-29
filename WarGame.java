import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;   
   
public class WarGame extends Deck1
{
   public int deck1size;
   public int deck2size;
      
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
         
         game1.setDeck1Size(playerOneDeck.cardsRemaining());
         game1.setDeck2Size(playerTwoDeck.cardsRemaining());    
         
         System.out.println(game1.getDeck1Size());
         System.out.println(game1.getDeck2Size());
          

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
            
        game1.setDeck1Size(playerOneDeck.cardsRemaining());    
        System.out.println(game1.getDeck1Size());
        
        game1.setDeck2Size(playerTwoDeck.cardsRemaining());
        System.out.println(game1.getDeck2Size());
        

        playerOneDeck.shuffle();
        playerTwoDeck.shuffle();
        
      }
        if (playerOneDeck.cardsRemaining() > playerTwoDeck.cardsRemaining())
         System.out.println("Player One Wins!!!!");
        else if (playerTwoDeck.cardsRemaining()>playerOneDeck.cardsRemaining())
         System.out.println("Player Two Wins!!!!");   
         
        game1.Images(); 
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
   

   
   
   public int getDeck1Size()
   {
      return deck1size;
   }
   
      public int getDeck2Size()
   {
      return deck2size;
   }
   
      public void setDeck1Size(int d1)
   {
      deck1size = d1;
   }
      public void setDeck2Size(int d2)
   {
      deck2size = d2;
   }
   
   
   
   
   
   
      
   public ArrayList<ImageIcon> Images()
   {
    ArrayList<ImageIcon> cardImages = new ArrayList<ImageIcon>();
    
    char x = 'a';
    String y = "";
      
      for (int r = 2; r<15;r++)
      {       
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
            if(s==0)
               x='s';
            else if(s==1)
               x='h';
            else if(s==2)
               x='d';
            else if(s==3)
               x='c';
         
            
            if(r==11)
            {
               y="jack";
               cardImages.add(new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\"+ y + x +".jpg"));
            }
            else if(r==12)
            {
               y="queen";
               cardImages.add(new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\"+ y + x +".jpg"));
            }
            else if(r==13)
            {
               y="king";
               cardImages.add(new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\"+ y + x +".jpg"));
            }
            else if(r==14)
            {
               y="ace";
               cardImages.add(new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\"+ y + x +".jpg"));
            }
            else
            {
               cardImages.add(new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\"+ r + x +".jpg"));
            }
         }
      } 
         //for(int i=0;i<cardImages.size();i++)
            //System.out.println(cardImages.get(i));
    return cardImages;
   }
   

   
}