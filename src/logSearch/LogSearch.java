package logSearch;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LogSearch implements ActionListener{
	static HashMap<Integer, String> log = new HashMap<>();
	static JButton a = new JButton();
	static JButton b = new JButton();
	static JButton c = new JButton();
	static JButton d = new JButton();



// 
	public static void main(String[] args){
	
//	 * Crate a HashMap of Integers for the keys and Strings for the values.
		
//	 * Create a GUI with three buttons.
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(){
		};
		
		frame.add(panel);
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
		frame.setVisible(true);
		frame.pack();
//	 * Button 1: Add Entry
		a.setText("Add Entry");
		a.addActionListener((e) -> {
			try{
				int ID = Integer.parseInt(JOptionPane.showInputDialog("ID Number:"));
				String name = JOptionPane.showInputDialog("Name:");
				log.put(ID, name);
				} catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "That wasn't a number; \"" + ex.getMessage() + "\" isn't a number.");
				}
		});
//	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
//
//	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
//
//	 * 				Add this information as a new entry to your HashMap.
//
//	 *
//
//	 * Button 2: Search by ID
		b.setText("Search by ID");
		b.addActionListener((e) -> {
			try{
				int ID = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
				if(log.get(ID) != null)
				JOptionPane.showMessageDialog(null, log.get(ID));
				else
					JOptionPane.showMessageDialog(null, "That Enty does not exist.");
			} catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null, "That's not a number...");
			}
		});
//	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
//
//
//	 * 				If that ID exists, display that name to the user.
//
//
//	 * 				Otherwise, tell the user that that entry does not exist.
//
//
//	 *
//
//
//	 * Button 3: View List
		c.setText("View List");
		c.addActionListener((e) -> {
			String str = "";
			for(int i : log.keySet())
				str += "ID: " + i + " Name: " + log.get(i) + "\n";
			JOptionPane.showMessageDialog(null, str);
		});
//
//	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
//
//
//	 * 				ID: 123  Name: Harry Howard
//
//
//	 * 				ID: 245  Name: Polly Powers
//
//
//	 * 				ID: 433  Name: Oliver Ortega
//
//
//	 * 				etc...
//
//
//	 *
//
//
//	 * When this is complete, add a fourth button to your window.
//
//
//	 * Button 4: Remove Entry
		d.setText("Remove Entry");
		d.addActionListener((e) -> {
			try{
				int ID = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
				if(log.get(ID) != null)
					log.remove(ID);
				else
					JOptionPane.showMessageDialog(null, "This entry cannot be removed, due to the fact that it does not exist.");
			} catch(NumberFormatException ex){
				
			}
		});
//
//	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
//
//
//	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
//
//
//	 * 				is not in the list.
//
//
//	 *
//
//
//	 * 
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == a){
		
		
	}
}

}

