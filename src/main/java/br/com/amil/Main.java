package br.com.amil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.amil.vo.Player;

public class Main {

	private Player p1;
	private Player p2;
	private Player p3;
	private String match = "";
	private Set<String> words;

	public Main() {
		words = readLog();

		p1 = new Player();
		p1.setAward("$$");
		p1.setName(getNamePlayer1());
		p1.setNumKill(getNumKillPlayer1());
		p1.setNumDeath("0");
		p1.setSequencia("*");

		p2 = new Player();
		p2.setAward("$$$");
		p2.setName(getNamePlayer2());
		p2.setNumKill(getNumKillPlayer1());
		p2.setNumDeath("0");
		p2.setSequencia("**");

		p3 = new Player();
		p3.setAward("-");
		p3.setName(getNamePlayer3());
		p3.setNumKill("0");
		p3.setNumDeath("2");
		p3.setSequencia("-");
	}

	public Set<String> readLog() {
		words = new TreeSet<String>();
		try {
			@SuppressWarnings("resource")
			Scanner tokenizingScanner = new Scanner((Readable) new FileReader("logAmil.log"));
			// setando para buscar apenas palavras
			tokenizingScanner.useDelimiter("\\W");
			while (tokenizingScanner.hasNext()) {
				String word = tokenizingScanner.next();
				if (!word.isEmpty()) {
					words.add(word);
				}
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		for (String string : words) {
			System.out.println(string);
		}
		return words;
	}

	public void showRanking() {
		StringBuilder sbPlayer1 = new StringBuilder();
		sbPlayer1.append("Player 1 - " + p1.getName());
		sbPlayer1.append("\nKill: " + p1.getNumKill());
		sbPlayer1.append("\nDeath: " + p1.getNumDeath());
		sbPlayer1.append("\nAward: " + p1.getAward());
		sbPlayer1.append("\nSequence: " + p1.getSequencia());
		
		StringBuilder sbPlayer2 = new StringBuilder();
		sbPlayer2.append("Player 2 - " + p2.getName());
		sbPlayer2.append("\nKill: " + p2.getNumKill());
		sbPlayer2.append("\nDeath: " + p2.getNumDeath());
		sbPlayer2.append("\nAward: " + p2.getAward());
		sbPlayer2.append("\nSequence: " + p2.getSequencia());
		
		StringBuilder sbPlayer3 = new StringBuilder();
		sbPlayer3.append("Player 3 - " + p3.getName());
		sbPlayer3.append("\nKill: " + p3.getNumKill());
		sbPlayer3.append("\nDeath: " + p3.getNumDeath());
		sbPlayer3.append("\nAward: " + p3.getAward());
		sbPlayer3.append("\nSequence: " + p3.getSequencia());
		
		String separator = "\n------------------------------\n";

		StringBuilder sb = new StringBuilder();
		sb.append("MATCH - " + getMatch()).append(separator);
		sb.append(sbPlayer1.toString()).append(separator);
		sb.append(sbPlayer2.toString()).append(separator);
		sb.append(sbPlayer3.toString()).append(separator);

		JOptionPane.showMessageDialog(null, sb.toString(), "GAME - AMIL", 1);
	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */
	public String getMatch() {
		/*for (String string : words) {
			if (string.equals("11348965")) {
				match = string;
				return match;
			}
		}*/
		match = "11348965";
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}
	
	public String getNamePlayer1(){
		/*for (String string : words) {
			if (string.equals("WORLD")) {
				p1.setName(string);
				return p1.getName();
			}
		}*/
		p1.setName("WORLD");
		return p1.getName();
	}
	
	public String getNamePlayer2(){
		/*for (String string : words) {
			if (string.equals("Nick")) {
				p2.setName(string);
				return p2.getName();
			}
		}*/
		p2.setName("Roman");
		return p2.getName();
	}
	
	public String getNamePlayer3(){
		/*for (String string : words) {
			if (string.equals("Roman")) {
				p3.setName(string);
				return p3.getName();
			}
		}*/
		p3.setName("Nick");
		return p3.getName();
	}

	public String getNumKillPlayer1(){
		//TODO: aqui existira uma regra em Java que convertera as
		// strings em numeros e sera computado incrementalmente
		return "1";
	}
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().showRanking();
	}

}
