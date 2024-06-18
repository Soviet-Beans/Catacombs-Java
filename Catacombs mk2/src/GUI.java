import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class GUI extends JFrame implements ActionListener {
	
	//Universal Components
	Font titleFont = new Font("Yu Gothic UI", Font.PLAIN, 20);
	Font ButtonFont = new Font("Yu Gothic UI", Font.PLAIN, 15);
	int[] playerData;
	SaveFile saveFile = new SaveFile(playerData);
	
	//Main Menu Components
	JPanel mainPanel;
	JLabel mainText1, mainText2;
	JButton shopButton, battleButton, inventoryButton, saveButton;
	
	//Shop Menu Components
	JLabel shopText1, shopText2;
	JButton exit;
	JPanel shopPanel, armourPanel, weaponPanel, itemPanel, materialPanel;
	JScrollPane armourPane, weaponPane, itemPane, materialPane;
	
	public GUI() {
		
		//Frame
		this.setTitle("Catacombs");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		//Main Menu
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		
		this.mainPanel = new JPanel();
		this.mainPanel.setSize(400, 300);
		this.mainPanel.setLayout(null);
		
		this.mainText1 = new JLabel("Welcome to the Catacombs, Adventurer");
		this.mainText1.setHorizontalAlignment(JLabel.CENTER);
		this.mainText1.setBounds(22, 10, 350, 30);
		this.mainText1.setFont(titleFont);
		this.mainPanel.add(mainText1);
		
		this.mainText2 = new JLabel("Please choose your action");
		this.mainText2.setHorizontalAlignment(JLabel.CENTER);
		this.mainText2.setBounds(22, 45, 350, 30);
		this.mainText2.setFont(titleFont);
		this.mainPanel.add(mainText2);
		
		this.shopButton = new JButton("Shop");
		this.shopButton.setFont(ButtonFont);
		this.shopButton.setBounds(72, 100, 125, 75);
		this.shopButton.addActionListener(this);
		this.mainPanel.add(shopButton);
		
		this.battleButton = new JButton("Catacombs");
		this.battleButton.setFont(ButtonFont);
		this.battleButton.setBounds(202, 100, 125, 75);
		this.battleButton.addActionListener(this);
		this.mainPanel.add(battleButton);
		
		this.inventoryButton = new JButton("Inventory");
		this.inventoryButton.setFont(ButtonFont);
		this.inventoryButton.setBounds(72, 181, 125, 75);
		this.inventoryButton.addActionListener(this);
		this.mainPanel.add(inventoryButton);
		
		this.saveButton = new JButton("Save");
		this.saveButton.setFont(ButtonFont);
		this.saveButton.setBounds(202, 181, 125, 75);
		this.saveButton.addActionListener(this);
		this.mainPanel.add(saveButton);
		
		//Shop Menu
		this.shopPanel = new JPanel();
		this.shopPanel.setSize(800, 500);
		this.shopPanel.setLayout(null);
		
		this.shopText1 = new JLabel("Welcome to the Catacombs, Adventurer");
		this.shopText1.setHorizontalAlignment(JLabel.CENTER);
		this.shopText1.setBounds(225, 10, 350, 30);
		this.shopText1.setFont(titleFont);
		this.shopPanel.add(shopText1);
		
		this.shopText2 = new JLabel("What would you like to purchase?");
		this.shopText2.setHorizontalAlignment(JLabel.CENTER);
		this.shopText2.setBounds(225, 45, 350, 30);
		this.shopText2.setFont(titleFont);
		this.shopPanel.add(shopText2);
		
		this.exit = new JButton("Leave shop");
		
		this.armourPanel = new JPanel();
		this.armourPanel.setSize(154, 1000);
		
		this.weaponPanel = new JPanel();
		this.weaponPanel.setSize(154, 1000);
		
		this.itemPanel = new JPanel();
		this.itemPanel.setSize(154, 1000);
		
		this.materialPanel = new JPanel();
		this.materialPanel.setSize(154, 1000);
		
		this.armourPane = new JScrollPane();
		this.armourPane.setBounds(2, 84, 790, 68);
		this.armourPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.armourPane.add(armourPanel);
		this.armourPane.setViewportView(armourPanel);
		this.shopPanel.add(armourPane, BorderLayout.CENTER);
		
		this.weaponPane = new JScrollPane();
		this.weaponPane.setBounds(2, 152, 790, 68);
		this.weaponPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.weaponPane.add(weaponPanel);
		this.weaponPane.setViewportView(weaponPanel);
		this.shopPanel.add(weaponPane, BorderLayout.CENTER);
		
		this.itemPane = new JScrollPane();
		this.itemPane.setBounds(2, 220, 790, 68);
		this.itemPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.itemPane.add(itemPanel);
		this.itemPane.setViewportView(itemPanel);
		this.shopPanel.add(itemPane, BorderLayout.CENTER);
		
		this.materialPane = new JScrollPane();
		this.materialPane.setBounds(2, 288, 790, 68);
		this.materialPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.materialPane.add(materialPanel);
		this.materialPane.setViewportView(materialPanel);
		this.shopPanel.add(materialPane, BorderLayout.CENTER);
		
		//Startup
		this.add(mainPanel);
		this.setSize(400, 300);
		this.mainPanel.setVisible(true);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == shopButton) {
			
			this.mainPanel.setVisible(false);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.remove(mainPanel);
			this.add(shopPanel);
			this.shopPanel.setVisible(true);
		}
		
		else if(e.getSource() == battleButton) {
			
			System.out.println("catacombs");
		}
		
		else if(e.getSource() == inventoryButton) {
			
			System.out.println("inventory");
		}
		
		else if(e.getSource() == saveButton) {
			
			System.out.println("save");
		}
	}
	
	public static void main(String[] args) {
		
		new GUI();
	}
}

class SaveFile {
	
	int[] p;
	File playerData = new File("src/playerData.txt");
	
	SaveFile(int[] player) {
		
		p = player;
	}
	
	void save() {
		
		try(FileWriter w = new FileWriter(playerData)) {
			
			String data = p.toString();
			w.append(data);
		} catch(Exception e){};
	}
}