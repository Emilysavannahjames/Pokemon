package pokemon.model;
import javax.swing.JOptionPane;

public class GrizzlyBear extends Pokemon implements Water
{
	public GrizzlyBear()
	{
		super(9999, "Grizzly Bear");
	}
	
	public GrizzlyBear(String name)
	{
		super(9999, name);
	}
	
	public GrizzlyBear(int num, String name)
	{
		super(num, name);
	}
	
	public void splish()
	{
		for (int index = 0; index < 10; index++)
		{
			JOptionPane.showMessageDialog(null, "Water");
		}
	}
	
	public int soakAmount()
	{
		return 999 * 12345;
	}
}
