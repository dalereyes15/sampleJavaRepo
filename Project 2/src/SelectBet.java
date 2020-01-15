import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectBet extends JFrame implements ActionListener{

    String typeOfBet = "Direct Bet";
    public SelectBet(){
        JFrame frame = new JFrame("Select Bet");
        frame.setVisible(true);
        frame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);


        JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(1000,300));
        frame.add(panel);

        JLabel lbl = new JLabel("Select one of the possible bets and click OK");
        lbl.setVisible(true);

        panel.add(lbl);

        String[] choices = { "Direct Bet","Double Bet", "Triple Bet","Odds","Evens","Reds","Blacks"};

        JComboBox<String> cb = new JComboBox<String>(choices);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeOfBet = cb.getSelectedItem().toString();
                System.out.println(typeOfBet);
            }
        });
        cb.setVisible(true);
        panel.add(cb);

        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                BettingTable bettingTable = new BettingTable(typeOfBet);
            }
        });
        panel.add(btn);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
