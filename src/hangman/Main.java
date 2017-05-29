package hangman;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
	static String[] words = new String[356000];
	static int lives = 6;
	static ArrayList<Character> wrongLetters = new ArrayList<>();
	static boolean[] letters;
	static String word = null;

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(new File("src/hangman/words2.txt"));
		for (int c = fr.read(), l = 0; c != -1; c = fr.read())
			if (c == (int) '\n')
				l++;
			else
				words[l] += (char) c;
		fr.close();
		newWord();

		new Thread(Main::launch).start();
	}

	public static void newWord() {
		Random r = new Random();
		do
			word = words[r.nextInt(356000)];
		while (word == null);
		if(word.substring(0, 4).equals("null"))
			word = word.substring(4);
		letters = new boolean[word.length()];
		for (int i = 0; i < letters.length; i++)
			letters[i] = false;
		wrongLetters.clear();
		System.out.println(word);
	}

	public void start(Stage stage) {
		Group root = new Group();
		Scene s = new Scene(root);
		stage.setScene(s);
		stage.show();
		s.getWindow().setWidth(1000);
		s.getWindow().setHeight(700);
		Canvas c = new Canvas(1000, 700);
		GraphicsContext g = c.getGraphicsContext2D();
		root.getChildren().add(c);
		paint(g);
		s.addEventHandler(KeyEvent.KEY_TYPED, (e) -> {
			boolean all = true;
			for (boolean b : letters)
				all &= b;
			if (e.getCharacter().charAt(0) == ' ')
				if (lives == 0) {
					newWord();
					lives = 6;
				} else {
					if (all)
						newWord();
				}
			if (lives > 0 && !all) {
				if (word.contains(e.getCharacter())) {
					for (int i = 0; i < word.length(); i++)
						if (word.charAt(i) == e.getCharacter().charAt(0))
							letters[i] = true;
				} else if (Character.isAlphabetic(e.getCharacter().charAt(0))
						&& !wrongLetters.contains(e.getCharacter().charAt(0))) {
					wrongLetters.add(e.getCharacter().charAt(0));
					lives--;
				}
			}
			paint(g);
		});
	}

	public static void paint(GraphicsContext g) {
		g.setFill(new Color(1, 1, 1, 1));
		g.fillRect(0, 0, 1000, 700);
		g.setFill(new Color(0, 0, 0, 1));
		switch (lives) {
		default:
			g.strokeOval(335, 200, 71, 71);
		case 1:
			g.strokeLine(370, 271, 370, 421);
		case 2:
			g.strokeLine(370, 271, 420, 321);
		case 3:
			g.strokeLine(370, 271, 320, 321);
		case 4:
			g.strokeLine(370, 421, 420, 471);
		case 5:
			g.strokeLine(370, 421, 320, 471);
		case 6:
		}
		g.strokeLine(520, 100, 520, 500);
		g.strokeLine(450, 500, 590, 500);
		g.strokeLine(520, 100, 370, 200);
		String displayed = "";
		for (int i = 0; i < letters.length; i++)
			if (letters[i])
				displayed += word.charAt(i) + " ";
			else
				displayed += "_ ";
		displayed = displayed.substring(0, displayed.length() - 1);
		g.setTextAlign(TextAlignment.CENTER);
		g.setFont(Font.font(50));
		g.fillText(displayed, 500, 600);
		String wrongs = "";
		if (wrongLetters.size() > 0) {
			for (int i = 0; i < wrongLetters.size(); i++)
				wrongs += wrongLetters.get(i) + " ";
			wrongs = wrongs.substring(0, wrongs.length() - 1);
		}
		g.fillText(wrongs, 500, 650);
		if (lives == 0) {
			g.setFill(new Color(1, 0, 0, 1));
			g.fillText("You lose; press space to try again!", 500, 200);
			g.setFill(new Color(0, 0, 0, 1));
		}
		boolean all = true;
		for (boolean b : letters)
			all &= b;
		if (all) {
			g.setFill(new Color(0, 0.75, 0, 1));
			g.fillText("You win!  Press space for a new word!", 500, 200);
			g.setFill(new Color(0, 0, 0, 1));
		}

	}

}
