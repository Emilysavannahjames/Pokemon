package controller;

import java.util.ArrayList;

public class Controller
{
	private ArrayListt<Pokemon> pokemonList;
	private PokedexFrame appFrame;
	
	public Controller()
	{
		pokemonList = new ArrayList<Pokemon>();
		addPokemon();
		appFrame = new PokedexFrame(this);
		
	}
	
	public void addPokemon()
	{
		pokemonList.add(new Eeevee());
		//pokemonList.add(new ());
		
		
	}
	
	public void start()
	{
		
	}
	
	public ArrayList<Pokemon> getPokemonList()
	{
		
	}
}
