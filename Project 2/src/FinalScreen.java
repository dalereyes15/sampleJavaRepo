import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalScreen extends JFrame implements ActionListener {

    public FinalScreen(String finalValues) {

        int numberBallLandedOn = getRandomInteger(36,1);


        String numberString = String.valueOf(numberBallLandedOn);

        JFrame frame = new JFrame("Final Message");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        // Set border for the panel
        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        /**
         * Label declarations and assignments
         */
        JLabel yourBetsAreMessage = new JLabel("Your Bets Are: ");
        JLabel actualBets = new JLabel(finalValues);
        actualBets.setBorder(BorderFactory.createLineBorder(Color.black,4, true));
        JLabel finalMessage = new JLabel("The Ball landed on...");
        JLabel ballLandedOn = new JLabel(numberString);
        ballLandedOn.setBorder(BorderFactory.createLineBorder(Color.black,4, true));
        JLabel winningMessage = new JLabel("You WON!!!");
        JLabel losingMessage = new JLabel("YOU LOST :(");
        JButton playAgain = new JButton("Play Again");

        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                SelectBet selectBet = new SelectBet();
            }
        });

        /**
         * Setting fonts and borders of of the the given JLabels
         */
        yourBetsAreMessage.setFont(new Font("Serif", Font.BOLD, 36));



        actualBets.setFont(new Font("Serif", Font.BOLD, 36));

        if(finalValues.contains("Reds")) {
            actualBets.setForeground(Color.red);
        }
        else if(finalValues.contains("Blacks")) {
            actualBets.setForeground(Color.black);
        }

        finalMessage.setFont(new Font("Serif", Font.BOLD, 36));
        ballLandedOn.setFont(new Font("Serif", Font.BOLD, 36));

        /**
         * Display the color of the number
         */
        if((numberBallLandedOn %2) == 0) {
            ballLandedOn.setForeground(Color.BLACK);
        }
        else {
            ballLandedOn.setForeground(Color.RED);
        }

        /**
         * Adding JLabels to the Panel
         */
        panel.add(yourBetsAreMessage);
        panel.add(actualBets);
        panel.add(finalMessage);
        panel.add(ballLandedOn);

        /**
         * Cases if user selected an Even or Odd type of bet
         */
        if((finalValues.contains("Evens"))&& (numberBallLandedOn % 2) == 0 ) {
            winningMessage.setFont(new Font("Serif", Font.BOLD, 36));
            winningMessage.setForeground(Color.green);
            losingMessage.setVisible(false);
            panel.add(winningMessage);
        }
        else if ((finalValues.contains("Odds"))&& (numberBallLandedOn % 2) != 0 ) {
            winningMessage.setFont(new Font("Serif", Font.BOLD, 36));
            winningMessage.setForeground(Color.green);
            losingMessage.setVisible(false);
            panel.add(winningMessage);
        }

        /**
         * Cases if user did Reds or Blacks
         */
        if((finalValues.contains("Reds"))&& (numberBallLandedOn % 2) != 0 ) {
            winningMessage.setFont(new Font("Serif", Font.BOLD, 36));
            winningMessage.setForeground(Color.green);
            losingMessage.setVisible(false);
            panel.add(winningMessage);
        }
        else if ((finalValues.contains("Blacks"))&& (numberBallLandedOn % 2) == 0 ) {
            winningMessage.setFont(new Font("Serif", Font.BOLD, 36));
            winningMessage.setForeground(Color.green);
            losingMessage.setVisible(false);
            panel.add(winningMessage);
        }
        /**
         * Cases if user did Direct, Double, or Triple Bet
         */
        if(finalValues.contains(numberString)) {
            winningMessage.setFont(new Font("Serif", Font.BOLD, 36));
            winningMessage.setForeground(Color.green);
            panel.add(winningMessage);
        }
        else if(!(finalValues.contains(numberString))            ){
            losingMessage.setFont(new Font("Serif", Font.BOLD, 36));
            losingMessage.setForeground(Color.red);
            panel.add(losingMessage);
        }

        panel.add(playAgain);

        // Set size for the frame
        frame.setSize(300, 300);

        // Set the window to be visible as the default to be false
        frame.add(panel,SwingConstants.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
