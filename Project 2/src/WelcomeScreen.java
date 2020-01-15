import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame implements ActionListener {

    /**
     * Welcome screen Constructor
     */
    public WelcomeScreen(){
        JLabel welcomeText = new JLabel("Welcome to Middaugh's Mclovin Casino");
        JLabel playtext = new JLabel("Are you ready to play ROULETTE??");
        JButton playButton = new JButton("Play");

        playButton.setPreferredSize(new Dimension(500, 200));
        playButton.setHorizontalAlignment(SwingConstants.CENTER);

        welcomeText.setFont(new Font("Serif", Font.BOLD, 36));
        welcomeText.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeText.setForeground(Color.white);

        playtext.setFont(new Font("Serif",Font.BOLD, 36));
        playtext.setHorizontalAlignment(SwingConstants.CENTER);
        playtext.setForeground(Color.white);

        playButton.setHorizontalAlignment(SwingConstants.CENTER);


        JFrame frame = new JFrame("Welcome Screen");
        frame.setDefaultLookAndFeelDecorated(true);


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SelectBet selectBet = new SelectBet();
            }
        });
        frame.setBackground(Color.decode("#467A42"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#467A42"));
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        panel.add(welcomeText);
        panel.add(playtext);
        panel.add(playButton);

        frame.setPreferredSize(new Dimension(700,500));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
