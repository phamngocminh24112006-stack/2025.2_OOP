import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main (String[] args) {
		/*int option = JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first class ticket?","Ticket Upgrade", JOptionPane.YES_NO_OPTION );
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (option== JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);*/
		
		Object[] options = {"I do", "I don't"};
        int choice = JOptionPane.showOptionDialog(null,
                "Do you want to change to first class?", "Ticket Upgrade",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        JOptionPane.showMessageDialog(
                null, "You've chosen: " + options[choice]);
	}

}
