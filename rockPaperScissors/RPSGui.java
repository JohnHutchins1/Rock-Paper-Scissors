package rockPaperScissors;
/*
 * @author John Hutchins
 * Gui application that uses RPSEnums to create the game
 * Rock paper Scissors
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class RPSGui extends JFrame {

	private JPanel contentPane;
	private JButton btnUserButton;
	private JButton btnComputerButton;
	private JTextField txtUserScore;
	private JTextField txtComputerScore;
	private JTextField evaluateTxbx;
	private final ButtonGroup buttonGroup = new ButtonGroup();

		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RPSGui frame = new RPSGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame, set title, sets size, set the layout to border layout
	 * adds a north, center, and southern panel.
	 */
	public RPSGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		setLocationRelativeTo(null);
		setTitle("Rock, Paper, Scissors Johns way.");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel scorePanel = createScorePanel();
		contentPane.add(scorePanel, BorderLayout.NORTH);

		JPanel buttonPanel = createButtonPanel();
		contentPane.add(buttonPanel, BorderLayout.CENTER);
		
		JPanel optionPanel = createOptionPanel();
		contentPane.add(optionPanel, BorderLayout.SOUTH);

	}

	/*
	 * creates the central button panel for gui
	 * 2 buttons, one for user, other for computer
	 * spaces them w/empty border all at 20's
	 */
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		buttonPanel.setLayout(new GridLayout(0, 2, 20, 0));
		
		btnUserButton = new JButton("");
		buttonPanel.add(btnUserButton);
		btnUserButton.setIcon(RPSEnum.ROCK.getIcon());
		btnUserButton.setBorder(new EmptyBorder(20, 20, 20, 20));

		
		btnComputerButton = new JButton("");
		buttonPanel.add(btnComputerButton);
		btnComputerButton.setIcon(RPSEnum.ROCK.getIcon());
		return buttonPanel;
	}
	
	 /*
	  * panel that handles my action listener, is southern panel
	  * creates and groups 3 radio buttons
	  * adds a button that is used for updating panel
	  * also, adds a text box that is used to display who won or who lost
	  * actionhandler checks to see which of the 3 boxes are activated
	  * whichever on is, updates
      * 	- computers button with a random enum picture, 
      * 	- users button
      * 	- updates scores
      * 	- displays who won
	  */
	private JPanel createOptionPanel() {
		JPanel optionPanel = new JPanel();
		optionPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
		optionPanel.setBackground(Color.WHITE);
		
		JRadioButton rdbtnRock = new JRadioButton("Rock");
		rdbtnRock.setBackground(Color.WHITE);
		optionPanel.add(rdbtnRock);
		
		JRadioButton rdbtnPaper = new JRadioButton("Paper");
		rdbtnPaper.setBackground(Color.WHITE);
		optionPanel.add(rdbtnPaper);
		
		JRadioButton rdbtnScissor = new JRadioButton("Scissor");
		rdbtnScissor.setBackground(Color.WHITE);
		optionPanel.add(rdbtnScissor);
		
		buttonGroup.add(rdbtnRock);
		buttonGroup.add(rdbtnPaper);
		buttonGroup.add(rdbtnScissor);
		
		JButton btnUpdate = new JButton("Play!");
		optionPanel.add(btnUpdate);
		
		evaluateTxbx = new JTextField();
		evaluateTxbx.setHorizontalAlignment(SwingConstants.CENTER);
		evaluateTxbx.setEditable(false);
		optionPanel.add(evaluateTxbx);
		evaluateTxbx.setColumns(15);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RPSEnum compChoice = RPSEnum.PAPER.getRandomEnum();
				if(rdbtnRock.isSelected()){
					btnUserButton.setIcon(RPSEnum.ROCK.getIcon());
					btnComputerButton.setIcon(compChoice.getIcon());
					evaluateTxbx.setText(RPSEnum.PAPER.evaluate(RPSEnum.ROCK.getNumVal(), compChoice.getNumVal()));
					txtComputerScore.setText("" + RPSEnum.PAPER.getComputerScore());
					txtUserScore.setText("" + RPSEnum.PAPER.getHumanScore());
				}
				if(rdbtnPaper.isSelected()){
					btnUserButton.setIcon(RPSEnum.PAPER.getIcon());
					btnComputerButton.setIcon(compChoice.getIcon());
					evaluateTxbx.setText(RPSEnum.PAPER.evaluate(RPSEnum.PAPER.getNumVal(), compChoice.getNumVal()));
					txtComputerScore.setText("" + RPSEnum.PAPER.getComputerScore());
					txtUserScore.setText("" + RPSEnum.PAPER.getHumanScore());
				}
				if(rdbtnScissor.isSelected()){
					btnUserButton.setIcon(RPSEnum.SCISSOR.getIcon());
					btnComputerButton.setIcon(compChoice.getIcon());
					evaluateTxbx.setText(RPSEnum.PAPER.evaluate(RPSEnum.SCISSOR.getNumVal(), compChoice.getNumVal()));
					txtComputerScore.setText("" + RPSEnum.PAPER.getComputerScore());
					txtUserScore.setText("" + RPSEnum.PAPER.getHumanScore());

				}
				
			}
		});

		return optionPanel;
	}

	/*
	 * creates northern panel
	 * 2 text boxes, 2 labels w/flow layout.
	 * text boxes are used to display the computers score and the users score
	 * labels display whos score box belongs to who
	 */
	private JPanel createScorePanel() {
		JPanel scorePanel = new JPanel();
		scorePanel.setBackground(Color.WHITE);
		scorePanel.setBorder(new EmptyBorder(10, 20, 0, 20));
		scorePanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblUserName = new JLabel("Player's Score");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		scorePanel.add(lblUserName);
		
		txtUserScore = new JTextField();
		txtUserScore.setHorizontalAlignment(SwingConstants.LEFT);
		txtUserScore.setText("0");
		txtUserScore.setEditable(false);
		scorePanel.add(txtUserScore);
		txtUserScore.setColumns(1);
		
		JLabel lblComputer = new JLabel("Computer's Score");
		lblComputer.setHorizontalAlignment(SwingConstants.CENTER);
		scorePanel.add(lblComputer);
		
		txtComputerScore = new JTextField();
		txtComputerScore.setHorizontalAlignment(SwingConstants.LEFT);
		txtComputerScore.setText("0");
		txtComputerScore.setEditable(false);
		scorePanel.add(txtComputerScore);
		txtComputerScore.setColumns(5);
		return scorePanel;
	}

}
