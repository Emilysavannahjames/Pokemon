package pokemon.controller;

import java.io.*;
import java.swing.JOptionPane;
import java.util.ArrayList;
import pokemon.model.*;
import pokemon.model.Pokemon;
import pokemon.view.PokedexFrame;



public class Controller
{
	private ArrayList<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public Controller()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
		
	}
	
	public void addPokemon()
	{
		pokemonList.add(new Eevee());
		pokemonList.add(new Pikachu());
		pokemonList.add(new Charmander());
		pokemonList.add(new Squirtle());
		pokemonList.add(new Charizard());
		pokemonList.add(new GrizzlyBear());
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		
	}
	
	public void updatePokemon(int index, String [] data)
	{
		if(data.length == 5)
		{
			Pokemon current = pokemonList.get(index);
			current.setAttackPoints(Integer.parseInt(data[0]));
			current.setEnhancementModifier(Double.parseDouble(data[1]));
			current.setHealthPoints(Integer.parseInt(data[2]));
			current.setName(data[3]);
			current.setCanEvolve(Boolean.parseBoolean(data[4]));
			
		}
	}
	
	public String [] getPokeData(int index)
	{
		String [] data = new String [6];
		Pokemon current = pokemonList.get(index);
		data[0] = current.getAttackPoints() + "";
		data[1] = current.getEnhancementModifier() + "";
		data[2] = current.getHealthPoints() + "";
		data[3] = current.getName() + "";
		data[4] = current.isCanEvolve() + "";
		data[5] = current.getNumber() + "";
		return data;
		
	}
	
	public String[] buildPokedexText()

	{
		String [] names = new String [pokemonList.size()];
		
		for(int index = 0; index < pokemonList.size(); index++)
		{
			names[index] = pokemonList.get(index).getName();
		}
		return names;
	}
	
	public void savePokedex()
	{
		try
		{
			FileOutputStream saveStream = new FileOutputStream(saveFile);
			ObjectOutputStream output = new ObjectOutputStream(saveStream);
			output.writeObject(pokemonList);
			output.close();
			saveStream.close();
		}
		
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, error.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void loadPokedex()
	{
		try
		{
			ArrayList<Pokemon> saved = new ArrayList<Pokemon>();
			FileInputStream inputStream = new FileInputStream(saveFile);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			saved = (ArrayList<Pokemon>)input.readObject();
			input.close();
			inputStream.close();
			pokemonList = saved;
			
		}
		
		catch(IOException error)
		{
			JOptionPane.showMessageDialog(appFrame, "No Save file", "Loading Pokemon", JOptionPane.INFORMATION_MESSAGE);
		}
		
		catch(ClassNotFoundException pokemonError)
		{
			JOptionPane.showMessageDialog(appFrame, pokemonError.getMessage(), "Type Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
