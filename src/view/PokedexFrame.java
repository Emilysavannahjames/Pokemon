package view;

import javax.swing.JFrame;
import controller.Controller;

public class PokedexFrame extends JFrame
{
	private Controller app;
	private PokedexPanel appPanel;
	
	public PokedexFrame(Controller app)
	{
		super();
		this.app = app;
		this.appPanel = new PokedexPanel(app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{

	}
}
