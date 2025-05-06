import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JLabel statusLabel, playerChoiceLabel, computerChoiceLabel;
    private Random random = new Random();

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors ✊✋✌️");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(30, 30, 30));
        
        // Title
        JLabel titleLabel = new JLabel("Rock, Paper, Scissors", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        rockButton = createButton("Rock ✊");
        paperButton = createButton("Paper ✋");
        scissorsButton = createButton("Scissors ✌️");

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Status Panel
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(3, 1));
        statusPanel.setBackground(new Color(30, 30, 30));

        playerChoiceLabel = createStatusLabel("Your Choice: ");
        computerChoiceLabel = createStatusLabel("Computer Choice: ");
        statusLabel = createStatusLabel("Result: ");

        statusPanel.add(playerChoiceLabel);
        statusPanel.add(computerChoiceLabel);
        statusPanel.add(statusLabel);

        add(statusPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(100, 200, 250));
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        return button;
    }

    private JLabel createStatusLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.WHITE);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerMove = "";
        if (e.getSource() == rockButton) {
            playerMove = "Rock";
        } else if (e.getSource() == paperButton) {
            playerMove = "Paper";
        } else if (e.getSource() == scissorsButton) {
            playerMove = "Scissors";
        }

        String computerMove = getComputerMove();

        playerChoiceLabel.setText("Your Choice: " + playerMove);
        computerChoiceLabel.setText("Computer Choice: " + computerMove);

        String winner = determineWinner(playerMove, computerMove);
        statusLabel.setText("Result: " + winner);
    }

    private String getComputerMove() {
        String[] moves = { "Rock", "Paper", "Scissors" };
        return moves[random.nextInt(3)];
    }

    private String determineWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw!";
        }
        switch (player) {
            case "Rock":
                return (computer.equals("Scissors")) ? "You Win!" : "Computer Wins!";
            case "Paper":
                return (computer.equals("Rock")) ? "You Win!" : "Computer Wins!";
            case "Scissors":
                return (computer.equals("Paper")) ? "You Win!" : "Computer Wins!";
        }
        return "Error!";
    }

    public static void main(String[] args) {
        new RockPaperScissorsGame();
    }
}
