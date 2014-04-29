
import javax.swing.*;
import java.awt.*;
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
      
//      frame.Images();


   }
}

class WarFrame extends JFrame 
{
   private JButton flip = new JButton("Flip Button");
   private JButton quit = new JButton("Quit Button");
   private JPanel p1,p2,p3,p4,p5,p6;
   private JLabel label1,label2,centerLabel,footerLabel,backImage,backImage2;
   final ImageIcon back = new ImageIcon("C:\\Users\\Eric\\Documents\\GitHub\\CS110_Final_Project\\cardPics\\back.jpg");
   
   WarFrame() {
      setLayout(new BorderLayout());
      
      //Button Section
      flip.setText("Flip");
      flip.setSize(100, 180);
      
      quit.setText("Quit");
      quit.setSize(100, 180);
      
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
      
      label2 = new JLabel("Player:");
      backImage = new JLabel(back);
      
      p2.add(label2,BorderLayout.NORTH);
      p2.add(backImage,BorderLayout.WEST);
      

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
      
      label2 = new JLabel("Computer");
      backImage2 = new JLabel(back);
      
      p4.add(label2,BorderLayout.NORTH);
      p4.add(backImage2,BorderLayout.EAST);

      add(p4,BorderLayout.EAST);
      
      
      //Panel five: footer
      p5 = new JPanel();
      p5.setBackground(Color.red);

      footerLabel = new JLabel("Eric M. Casavant - CS110 Final");
      p5.add(footerLabel);
      add(p5,BorderLayout.SOUTH);
   }

}  