package introToArrayLists;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JokeTeller implements KeyListener {
	static ArrayList<String> Jokes = new ArrayList<>();
	static ArrayList<String> Punchlines = new ArrayList<>();
	static int jokeIndex;
	static ArrayList<Integer> keys = new ArrayList<>();

	public static void main(String[] args) {
		Random r = new Random();
		addJoke("Why did the chicken cross the road?", "To get to the other side.");
		addJoke("Two scientists walk into a bar, the first one says \"I'll have some H\u2082O\", the second one says \"I'll have some H\u2082O too!\"",
				"The second one dies.");

		jokeIndex = r.nextInt(Jokes.size());
		JOptionPane.showMessageDialog(null, getJoke());
		JOptionPane.showMessageDialog(null, getPunchline());
	}

	public static void addJoke(String joke, String punchline) {
		Jokes.add(joke);
		Punchlines.add(punchline);
	}

	public static String getJoke() {
		return Jokes.get(jokeIndex);
	}

	public static String getPunchline() {
		return Punchlines.get(jokeIndex);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for (int i = 0; i < keys.size(); i++)
			if (keys.get(i) == e.getKeyCode())
				keys.remove(i);
	}
}
