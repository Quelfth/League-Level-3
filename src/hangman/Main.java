package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class Main extends Application{
	static String[] words = new String[356000];
	int lives = 6;
	
	public static void main(String[] args) throws Exception{
		new Thread(Main::launch).start();
		FileReader fr = new FileReader(new File("src/hangman/words2.txt"));
		for(int c = fr.read(), l = 0; c != -1; c = fr.read())
			if(c == (int) '\n')
				l++;
			else
				words[l] += (char) c;
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
		
	}
	
	
}
