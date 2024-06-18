import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class GUI extends JFrame implements ActionListener {
	
	//Player Data
	int gold;
	int exp;
	int nxtExp;
	int dmg;
	int arm;
	int lvl;
	int nxtLvl;
	int equippedWeapon;
	int equippedWeaponDmg() {
		
		if(equippedWeapon == 1) {
			return 1;
		}
		
		return 0;
	}
	int[] playerData = new int[7];
	
	//Universal Components
	Font titleFont = new Font("Yu Gothic UI", Font.PLAIN, 20);
	Font buttonFont = new Font("Yu Gothic UI", Font.PLAIN, 15);
	Font subTitleFont = new Font("Yu Gothic UI", Font.PLAIN, 13);
	SaveFile saveFile = new SaveFile(playerData);
	JButton exit;
	
	//Items
	//Weapons
	Weapon club = new Weapon(1, 1);
	Boolean clubOwned = false;
	
	//Main Menu Components
	JPanel mainPanel;
	JLabel mainText1, mainText2;
	JButton shopButton, battleButton, inventoryButton, saveButton;
	
	//Shop Menu Components
	JPanel shopPanel, armourPanel, weaponPanel, itemPanel, materialPanel;
	JScrollPane armourPane, weaponPane, itemPane, materialPane;
	JLabel shopText1, shopText2, goldText;
	JButton buyClub;
	
	//Inventory Menu Components
	JPanel inventoryPanel, backpackPanel;
	JScrollPane backpackPane;
	JLabel goldLabel, lvlLabel, expLabel, dmgLabel, armLabel;
	
	
	public GUI() {
		
		//Frame
		this.setTitle("Catacombs");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		//Player Data
		gold = saveFile.load()[0];
		exp = saveFile.load()[1];
		nxtExp = 100;
		dmg = saveFile.load()[2];
		arm = saveFile.load()[3];
		lvl = saveFile.load()[4];
		if(saveFile.load()[6] == 1) clubOwned = true;
			
		nxtLvl = lvl + 1;
		
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
		this.shopButton.setFont(buttonFont);
		this.shopButton.setBounds(72, 100, 125, 75);
		this.shopButton.addActionListener(this);
		this.mainPanel.add(shopButton);
		
		this.battleButton = new JButton("Catacombs");
		this.battleButton.setFont(buttonFont);
		this.battleButton.setBounds(202, 100, 125, 75);
		this.battleButton.addActionListener(this);
		this.mainPanel.add(battleButton);
		
		this.inventoryButton = new JButton("Inventory");
		this.inventoryButton.setFont(buttonFont);
		this.inventoryButton.setBounds(72, 181, 125, 75);
		this.inventoryButton.addActionListener(this);
		this.mainPanel.add(inventoryButton);
		
		this.saveButton = new JButton("Save");
		this.saveButton.setFont(buttonFont);
		this.saveButton.setBounds(202, 181, 125, 75);
		this.saveButton.addActionListener(this);
		this.mainPanel.add(saveButton);
		
		//Shop Menu
		this.shopPanel = new JPanel();
		this.shopPanel.setSize(800, 500);
		this.shopPanel.setLayout(null);
		
		this.exit = new JButton("Leave");
		this.exit.setBounds(2, 419, 100, 50);
		this.exit.setFont(buttonFont);
		this.exit.addActionListener(this);
		
		this.shopText1 = new JLabel("Welcome to the Catacombs, Adventurer");
		this.shopText1.setHorizontalAlignment(JLabel.CENTER);
		this.shopText1.setBounds(215, 10, 370, 30);
		this.shopText1.setFont(titleFont);
		this.shopPanel.add(shopText1);
		
		this.shopText2 = new JLabel("What would you like to purchase?");
		this.shopText2.setHorizontalAlignment(JLabel.CENTER);
		this.shopText2.setBounds(225, 45, 350, 30);
		this.shopText2.setFont(titleFont);
		this.shopPanel.add(shopText2);
		
		this.goldText = new JLabel("Gold: " + gold);
		this.goldText.setHorizontalAlignment(JLabel.CENTER);
		this.goldText.setBounds(225, 390, 350, 30);
		this.goldText.setFont(titleFont);
		this.shopPanel.add(goldText);
		
		this.armourPanel = new JPanel();
		this.armourPanel.setSize(154, 1000);
		
		this.weaponPanel = new JPanel();
		this.weaponPanel.setSize(154, 1000);
		
		this.buyClub = new JButton("Club dmg: 1");
		this.buyClub.setPreferredSize(new Dimension(140, 40));
		this.buyClub.setFont(buttonFont);
		this.buyClub.addActionListener(this);
		this.weaponPanel.add(buyClub);
		
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
		
		//Inventory Menu
		this.inventoryPanel = new JPanel();
		this.inventoryPanel.setSize(800, 500);
		this.inventoryPanel.setLayout(null);	
		
		this.goldLabel = new JLabel("Gold: " + gold);
		this.goldLabel.setHorizontalAlignment(JLabel.LEFT);
		this.goldLabel.setBounds(5, 0, 100, 30);
		this.goldLabel.setFont(subTitleFont);
		this.inventoryPanel.add(goldLabel);
		
		this.lvlLabel = new JLabel("Level: " + lvl);
		this.lvlLabel.setHorizontalAlignment(JLabel.LEFT);
		this.lvlLabel.setBounds(5, 20, 300, 30);
		this.lvlLabel.setFont(subTitleFont);
		this.inventoryPanel.add(lvlLabel);
		
		this.expLabel = new JLabel("Exp: " + exp + "/" + nxtExp + " to level " + nxtLvl);
		this.expLabel.setHorizontalAlignment(JLabel.LEFT);
		this.expLabel.setBounds(5, 40, 300, 30);
		this.expLabel.setFont(subTitleFont);
		this.inventoryPanel.add(expLabel);
		
		this.dmgLabel = new JLabel("Damage: " + dmg);
		this.dmgLabel.setHorizontalAlignment(JLabel.LEFT);
		this.dmgLabel.setBounds(5, 60, 300, 30);
		this.dmgLabel.setFont(subTitleFont);
		this.inventoryPanel.add(dmgLabel);
		
		this.armLabel = new JLabel("Armour: " + arm);
		this.armLabel.setHorizontalAlignment(JLabel.LEFT);
		this.armLabel.setBounds(5, 80, 300, 30);
		this.armLabel.setFont(subTitleFont);
		this.inventoryPanel.add(armLabel);
			
		//Startup
		mainMenu();
	}
	
	public void mainMenu() {

		this.add(mainPanel);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.mainPanel.setVisible(true);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == exit) {
			
			if(shopPanel.isVisible() == true) {
				
				this.shopPanel.setVisible(false);
				this.remove(shopPanel);
				this.shopPanel.remove(exit);
			}
			
			if(inventoryPanel.isVisible() == true) {
				
				this.inventoryPanel.setVisible(false);
				this.remove(inventoryPanel);
				this.inventoryPanel.remove(exit);
			}
			mainMenu();
		}
		
		else if(e.getSource() == shopButton) {
			
			this.mainPanel.setVisible(false);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.remove(mainPanel);
			this.add(shopPanel);
			this.shopPanel.add(exit);
			this.shopPanel.setVisible(true);
		}
		
		else if(e.getSource() == battleButton) {
			
			System.out.println("catacombs");
		}
		
		else if(e.getSource() == inventoryButton) {
			
			this.mainPanel.setVisible(false);
			this.setSize(800, 500);
			this.setLocationRelativeTo(null);
			this.remove(mainPanel);
			this.add(inventoryPanel);
			this.inventoryPanel.add(exit);
			this.inventoryPanel.setVisible(true);
		}
		
		else if(e.getSource() == saveButton) {
			
			playerData[0] = gold;
			playerData[1] = exp;
			playerData[2] = dmg;
			playerData[3] = arm;
			playerData[4] = lvl;
			playerData[5] = equippedWeapon;
			if(clubOwned = true) playerData[6] = 1;
			saveFile.save();
		}
	}
	
	public static void main(String[] args) {
		
		new GUI();
	}
}

class SaveFile {
	
	
	int[] p;
	File playerData = new File("C:\\Users\\Potter\\Downloads\\Catacombs-Java-main\\Catacombs-Java-main\\Catacombs mk2\\bin\\playerData.txt");
	
	SaveFile(int[] player) {
		
		p = player;
	}
	
	void save() {
		
		String content = "";
		
		for(int i = 0; i <= p.length - 1; i++) {
			
			content = content + p[i] + "\n";
		}
		
		try{
			
            FileWriter fw = new FileWriter(playerData.getAbsoluteFile());
            BufferedWriter w = new BufferedWriter(fw);
            
            w.write(content);
        	w.close();
        } catch(Exception e){}
	}
	
	int[] load() {
		
		int[] data = new int[7];
		int i = 0;
		
		try {
			
			FileReader fr = new FileReader(playerData.getAbsoluteFile());
			Scanner r = new Scanner(fr);
			
			while (r.hasNextLine()) {
				
				String line = r.nextLine();
				data[i] = Integer.parseInt(line);
				i++;
			}
		} catch(Exception e){}
		
		return data;
	}
}

//Item Classes
class Weapon {
	
	int[] stats = new int[2];
	
	Weapon(int damage, int id) {
		
		stats[0] = damage;
		stats[1] = id;
	}
	
	int[] getStats() {
		
		return stats;
	}
}
