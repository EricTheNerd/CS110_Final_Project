//Eric M. Casavant
//CS110
//War game (With GUI)


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WarGameGUI 
{
   public static void main(String [] args) 
   {
      JFrame frame = new WarFrame();
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(200,200);
      frame.pack();
      frame.setVisible(true);
      
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
}

class WarFrame extends JFrame
{
   public int i, deck1size;
   private JButton flip = new JButton("Flip Button");
   private JButton quit = new JButton("Quit Button");
   private JPanel p1,p2,p3,p4,p5,p6;
   private JLabel label1,label2,computerLabel,centerLabel,footerLabel,backImage,backImage2,deckSizeLabel,deck2size;
   final ImageIcon back = new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\back.jpg");
   
   WarFrame() {
      setLayout(new BorderLayout());
      
      //Button Section
      flip.setText("Flip");
      flip.setSize(100, 180);
      flip.addActionListener(new FlipHandler());
      
      quit.setText("Quit");
      quit.setSize(100, 180);
      quit.addActionListener(new QuitHandler());
      
      //Main Section
      //Panel One: Title Section
      p1 = new JPanel();
      p1.setBackground(Color.gray);
      p1.setPreferredSize(new Dimension(900, 60));

      label1 = new JLabel("Eric's Game of WAR");
      label1.setFont(new Font("Sans-Serif", Font.BOLD, 32));
      p1.add(label1);

      add(p1,BorderLayout.NORTH);
      
      
      //Panel two: player section
      p2 = new JPanel();
      p2.setBackground(Color.orange);
      p2.setLayout(new BorderLayout());
      p2.setPreferredSize(new Dimension(300, 300));
      
      label2 = new JLabel("Turn:  \n Player Hand:");
      backImage = new JLabel(back);
      deckSizeLabel = new JLabel("Cards in Deck:"+String.valueOf(deck1size));
      
      p2.add(label2,BorderLayout.NORTH);
      p2.add(backImage,BorderLayout.WEST);
      p2.add(deckSizeLabel,BorderLayout.SOUTH);
      

      add(p2,BorderLayout.WEST);
      
      
      //Panel three: button section
      p3 = new JPanel();
      p3.setBackground(Color.white);
      p3.setLayout(new GridLayout(3, 1));
      p3.setPreferredSize(new Dimension(300, 300));

      centerLabel = new JLabel("What would you like to do?", SwingConstants.CENTER);
      centerLabel.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
      
      p3.add(centerLabel);
      p3.add(flip);
      p3.add(quit);

      add(p3,BorderLayout.CENTER);
      
      
      //Panel four: computer section
      p4 = new JPanel();
      p4.setBackground(Color.yellow);
      p4.setLayout(new BorderLayout());
      p4.setPreferredSize(new Dimension(300, 300));
      
     computerLabel = new JLabel("Computer Hand:");
      backImage2 = new JLabel(back);
      
      p4.add(computerLabel,BorderLayout.NORTH);
      p4.add(backImage2,BorderLayout.EAST);

      add(p4,BorderLayout.EAST);
      
      
      //Panel five: footer
      p5 = new JPanel();
      p5.setBackground(Color.red);

      footerLabel = new JLabel("Eric M. Casavant - CS110 Final");
      p5.add(footerLabel);
      add(p5,BorderLayout.SOUTH);
   }
   
  class QuitHandler implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        System.exit(0);
    }
  }
  
  class FlipHandler implements ActionListener {

    public void actionPerformed(ActionEvent f) {
      i++;
      label2.setText("Turn: "+String.valueOf(i)+"  \nPlayer Hand: ");
      

    }
  }

}  