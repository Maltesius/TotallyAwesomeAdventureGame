import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private JFrame gameWindow;
    private ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/poe.jpg"));
    private JLabel myLabel, titleNameLabel;
    private Container con;
    private JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel;
    private Font titleFont = new Font("Times New Roman", Font.BOLD, 70), normalFont = new Font("Times New Roman", Font.BOLD, 30);
    private JButton startButton,quitButton, choice1, choice2, choice3,choice4;
    private JTextArea mainTextArea;
    private TitleScreenHandler tsHandler = new TitleScreenHandler();
    private QuitHandler qHandler = new QuitHandler();

    public static void main(String[] args) {
        new Game();
    }

    /**
     * Constructor used for creating our game window
     */
    public Game() {

        myLabel = new JLabel(backgroundImage);                          //Used for the idea of having a background image instead of a color. WIP
        myLabel.setSize(1920,1080);

        gameWindow = new JFrame("Totally Awesome Adventure Game");  //Creates the window carrying the game
        gameWindow.setSize(1920,1080);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.getContentPane().setBackground(Color.gray);
        gameWindow.setLayout(null);
        gameWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gameWindow.setUndecorated(true);
        gameWindow.setVisible(true);
        con = gameWindow.getContentPane();

        titleNamePanel = new JPanel();                                  //Creates the title on our home screen
        titleNamePanel.setBounds(350,200,1200,100);
        titleNamePanel.setBackground(Color.darkGray);
        titleNameLabel = new JLabel("Totally Awesome Adventure Game");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();                                //Creates a panel for buttons on the home page
        startButtonPanel.setBounds(825, 500, 250, 100);
        startButtonPanel.setBackground(Color.gray);

        startButton = new JButton("PLAY GAME");                     //Creates a "play" button that takes the player into the game
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        quitButton = new JButton("Quit");                           //Creates a quit button terminating the program
        quitButton.setBackground(Color.black);
        quitButton.setForeground(Color.white);
        quitButton.setFont(normalFont);
        quitButton.addActionListener(qHandler);

        titleNamePanel.add(titleNameLabel);                             //Adds all of our buttons to the panels
        startButtonPanel.add(startButton);
        startButtonPanel.add(quitButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
    }

    /**
     * Method used for switching to the game screen, when the "Play" button has been pressed
     */
    public void createGameScreen(){

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        gameWindow.getContentPane().setBackground(Color.DARK_GRAY);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(650,300,600,200);
        mainTextPanel.setBackground(Color.darkGray);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area. This game is going to be great. I'm sure of it!");        //Main text area for the game
        mainTextArea.setBounds(300,300,600,450);
        mainTextArea.setBackground(Color.darkGray);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setEditable(false);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();                       //Panel in which the buttons for the game are
        choiceButtonPanel.setBounds(800, 550, 300, 300);
        choiceButtonPanel.setBackground(Color.darkGray);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");                  //Button creation for the actual game
        choice1.setBackground(Color.GRAY);
        choice1.setForeground(Color.WHITE);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.GRAY);
        choice2.setForeground(Color.WHITE);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.GRAY);
        choice3.setForeground(Color.WHITE);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.GRAY);
        choice4.setForeground(Color.WHITE);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);



    }

    /**
     * Method for terminating the program
     */
    public void quitGame(){
        System.exit(0);
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class QuitHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            quitGame();
        }
    }
}
