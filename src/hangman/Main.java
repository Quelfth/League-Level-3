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
import javafx.stage.Stage;


public class Main extends Application{
	static String[] words = new String[356000];
	static int lives = 6;
	static ArrayList<Character> wrongLetters = new ArrayList<>();
	static boolean[] letters;
	static String word = null;
	
	
	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader(new File("src/hangman/words2.txt"));
		for(int c = fr.read(), l = 0; c != -1; c = fr.read())
			if(c == (int) '\n')
				l++;
			else
				words[l] += (char) c;
		fr.close();
		newWord();
		
		new Thread(Main::launch).start();
	}
	
	public static void newWord(){
		Random r = new Random();
		while(word == null)
			word = words[r.nextInt(356000)];
		letters = new boolean[word.length()];
		for(int i = 0; i < letters.length; i++)
			letters[i] = false;
	}
	
	public void start(Stage stage){
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
			if(word.contains(e.getCharacter()))
				for(int i = 0; i < word.length(); i++)
					if(word.charAt(i) == e.getCharacter().charAt(0))
						letters[i] = true;
			else{
				wrongLetters.add(e.getCharacter().charAt(0));
				lives--;
			}
			paint(g);
		});
	}
	
	public static void paint(GraphicsContext g){
		g.setFill(new Color(1, 1, 1, 1));
		g.fillRect(0, 0, 1000, 700);
		g.setFill(new Color(0, 0, 0, 1));
		switch(lives){
			case 0:
				g.fillOval(320, 200, 100, 100);
			case 1:
				g.strokeLine(50, 55, 50, 95);
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				g.strokeLine(520, 100, 520, 500);
				g.strokeLine(450, 500, 590, 500);
				g.strokeLine(520, 100, 370, 200);
			}
	}
	
	
}
