package pokemon.tests;

import static org.junit.jupiter.api.Assertions.*;



import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pokemon.controller.Controller;
import pokemon.view.PokedexPanel;

public class PokedexPanel extends JPanel
{
	private Controller app;
	private SpringLayout appLayout;
	
	private JButton changeButton;
	private JComboBox<String>pokedexDropdown;
	
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
}

public PokedexPanel(Controller app)
{
	super();
	
	this.app = app;
	
	this.appLayout = new SpringLayout();
	
	numberField = new JTextField("0");
	nameField = new JTextField("My Pokename");
	evolveField = new JTextField("false");
	attackField = new JTextField("0");
	enhancementField = new JTextField("0");
	healthField = new JTextField("0");
	
	healthLabel = new JLabel("This pokemon health is");
	pokedexDropdown = new JComboBox<String>();
	
	setupDropdown();
	setupPanel();
	setupLayout();
	setupListeners();
	
}
private void setupDropdown()
{
	DefaultComboBoxModel<String> temp = new DefaultComboBoxModel<String>(app.buildPokedexText());
	pokedexDropdown.setModel(temp);
}

public void setupPanel()
{
	this.setupLayout(appLayout);
	this.add(pokedexDropdown);
	this.add(healthField);
	this.add(numberField);
	this.add(evolveField);
	this.add(enhancementField);
	
}
class PanelTest
{
	private PokedexPanel testedPanel;

	@BeforeEach
	void setUp() throws Exception
	{
		testedPanel = new PokedexPanel(new Controller());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		testedPanel = null;
	}

	@Test
	void testPokedexPanel()
	{
		assertNotNull(testedPanel.getComponents(), "Your panel must have components");
		assertTrue(testedPanel.getComponents().length > 10, "You need way more than 5 components in this app" );
		
	}
	
	@Test
	void testSetupPanel()
	{
		assertTrue(testedPanel.getLayout() instanceof SpringLayout, "You should be using a SpringLayout");
		int enabledCount = 0;
		int disabledCount = 0;
		int fieldCount = 0;
		for(Component examined : testedPanel.getComponents())
		{
			if (examined instanceof JTextField)
			{
				if (((JTextField)examined).isEnabled())
				{
					enabledCount++;
				}
				else
				{
					disabledCount++;
				}
				fieldCount++;
			}
			
		}
		assertTrue(fieldCount > 5, "You need a textfield for each of the data members");
		assertTrue(enabledCount > 4, "At least four of the textfields need to be editable");
		assertTrue(disabledCount == 1, "Exactly ONE of the textfields need to be non-editable");
	}
	
	@Test
	void testSetupListeners()
	{
		for(Component examined : testedPanel.getComponents())
		{
			if (examined instanceof JButton)
			{
				assertTrue( ((JButton)examined).getActionListeners().length == 1, "Your button must have a listener");
			}
			
		}
	}

}
