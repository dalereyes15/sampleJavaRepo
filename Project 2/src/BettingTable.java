import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BettingTable extends JFrame implements ActionListener {

    String selectedValues = "";

    public BettingTable(String typeOfBet){
        /**
         * Check to see the number of bets the user will get
         */
        if(typeOfBet.equals(null)) {
            createBettingTable(100);
        }
        else if (typeOfBet.equals("Direct Bet")) {
            createBettingTable(100);
        }
        else if(typeOfBet.equals("Double Bet")) {
            createBettingTable(2);
        }
        else if (typeOfBet.equals("Triple Bet")) {
            createBettingTable(3);
        }
        else if (typeOfBet.equals("Evens")){
            dispose();
            FinalScreen finalScreen = new FinalScreen("Evens");
        }
        else if (typeOfBet.equals("Odds")){
            dispose();
            FinalScreen finalScreen = new FinalScreen("Odds");
        }
        else if(typeOfBet.equals("Reds")) {
            dispose();
            FinalScreen finalScreen = new FinalScreen("Reds");
        }
        else if(typeOfBet.equals("Blacks")) {
            dispose();
            FinalScreen finalScreen = new FinalScreen("Blacks");
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    int betCounter = 0;

    public void createBettingTable(int amountOfBets) {

        boolean[] selected = new boolean[39];
        JFrame bettingTableFrame = new JFrame("Betting Table");
        JPanel bettingTable = new JPanel();
        JTextArea spacesSelected = new JTextArea();
        GridLayout gridLayout = new GridLayout(13,3,4,5);
        bettingTable.setLayout(gridLayout);
        JButton placeBet = new JButton("Place Bet");
        placeBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bettingTableFrame.dispose();
                FinalScreen finalScreen = new FinalScreen(selectedValues);
            }
        });

        for(int i = 1; i <=38; i++) {
            selected[i] = false;
            String buttonNumber = String.valueOf(i);
            JButton currentButton;
            if(i<= 36) {
                currentButton = new JButton(buttonNumber);
                currentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String s = e.getActionCommand();
                        int arrayIndex = Integer.valueOf(s);
                        if (selected[arrayIndex] == true) {
                            betCounter--;
                            currentButton.setBorder(BorderFactory.createEmptyBorder());
                            selected[arrayIndex] = false;
                            selectedValues = selectedValues.substring(0, (selectedValues.length() - (s.length()+1)));
                            spacesSelected.setText(selectedValues);

                        }
                        else{
                            if(betCounter < amountOfBets) {
                                betCounter++;
                                currentButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 12));
                                selected[arrayIndex] = true;
                                selectedValues = selectedValues + s + " ";
                                spacesSelected.setText(selectedValues);
                            }

                        }
                    }
                });
                if ((i % 2) != 0) {
                    currentButton.setBackground(Color.RED);
                    currentButton.setForeground(Color.WHITE);
                } else {
                    currentButton.setBackground(Color.BLACK);
                    currentButton.setForeground(Color.WHITE);
                }
                bettingTable.add(currentButton);
            }
            else {
                bettingTable.add(placeBet);
                spacesSelected.setText(selectedValues);
                bettingTable.add(spacesSelected);
            }

        }

        bettingTableFrame.add(bettingTable);
        bettingTableFrame.setSize(400, 800);
        bettingTableFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bettingTableFrame.setVisible(true);
    }

}
