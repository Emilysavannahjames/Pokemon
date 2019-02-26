package pokemon.view;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pokemon.controller.Controller;


public class PokedexPanel extends JPanel
{

	private Controller app;
	private SpringLayout appLayout;
	private JButton changeButton;
	private JComboBox pokedexDropdown;

	

	private JTextField numberField;
	private JTextField nameField;
	private JTextField evolveField;
	private JTextField attackField;
	private JTextField enhancementField;
	private JTextField healthField;

	

	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel evolveLabel;
	private JLabel attackLabel;
	private JLabel enhanceLabel;
	private JLabel healthLabel;
	private JLabel imageLabel;

	private ImageIcon pokemonIcon;

public PokedexPanel(Controller app)
{
		super();
		this.app = app;
		
		this.appLayout = new SpringLayout();

		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/charizard.png"));
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/Charmeleon.png"));
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/evee.png"));
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/pikachu.png"));
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/squirtle.png"));

		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("fasle");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		healthField = new JTextField("0");

		healthLabel = new JLabel("This pokemon health is");
		numberLabel = new JLabel("This pokemon number is");

		evolveLabel = new JLabel("This pokemon can evolve");
		attackLabel = new JLabel("This pokemon's attack level is");
		enhanceLabel = new JLabel("This pokemon enhancement level is");
		nameLabel = new JLabel("My name is");
		imageLabel = new JLabel("pokemon goes here", pokemonIcon, JLabel.CENTER);
		changeButton = new JButton("click here to change the pokevalues");
		pokedexDropdown = new JComboBox<String>(); 
		// stub

		setupDropDown();
		setupPanel();
		setupLayout();
		setupListeners();

}
	
	private ImageIcon pokemonIcon;
	
	
	public PokedexPanel(Controller app)
	{
		super();
		this.appController = app;
		
		this.appLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/dinoTurtle.jpeg"));
		
		numberField = new JTextField("0");
		nameField = new JTextField("My pokename");
		evolveField = new JTextField("false");
		attackField = new JTextField("0");
		enhancementField = new JTextField("0");
		
	}
	
	private void setupDropdown()
	{
		DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
		pokemonDropdown.setModel(temp);
		
	}
	
	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.add(changeButton);
		this.add(pokedexDropdown);
		this.add(healthField);
		this.add(numberField);
		this.add(evolveField);
		this.add(enhancementField);
		this.add(attackField);
		this.add(nameField);
		
		this.add(healthLabel);
		this.add(numberLabel);
		this.add((numberLabel);
		this.add(evolveLabel);
		this.add(enhancementLabel);
		this.add(attackLabel);
		
	}
	
	private void sendDataToController()
	{
		int index = pokedexDropdown.getSelectedIndex();
		
		if(app.isInt(attackField.getText()) && app.isDouble(enhancementField.getText()) && app.isInt(healthField.getText()))
		{
			String [] data = new String[5];
			app.updatePokemon(index,data);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/pokemon/view/images/";
		String defaultName = "ultraball";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name.toLowerCase() + extension));
		}
		catch(NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass.getResources(path + defaultName + extension));
			
		}
		
		imageLabel.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupListeners()
	{
		changeButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				sendDataToController();
			}
		});
		
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String name = pokedexDropdown.getSelectedItem().toString();
				changeImageDisplay(name);
				
			}
		});
	}
}
