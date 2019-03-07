package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.Controller;

public class PokedexFrame extends JFrame
{
	private Controller appController;
	private PokedexPanel appPanel;
	
	public PokedexFrame(Controller app)
	{
		super(); //when you have an extends
		this.appController = appController;
		this.appPanel = new PokedexPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("My Pokedex App!");
		this.setSize(1000, 500);
		this.setResizable(false);
		this.setVisible(true);
	}
}
