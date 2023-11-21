import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;


// Natalia Palej A00279259

@SuppressWarnings("serial")
public class StudentGUI extends JFrame implements ActionListener, Serializable {
	
	static Student studentClass = new Student();
	
	Container cp;
	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	JButton b1 = new JButton("SHOW");
	JButton b2 = new JButton("CLEAR");
	JLabel l1 = new JLabel("Show all Students", SwingConstants.CENTER);
	JLabel l2 = new JLabel(" ", SwingConstants.CENTER);
	JLabel l3 = new JLabel(" ", SwingConstants.CENTER);
	JPanel studentPanel = new JPanel();
	
	public StudentGUI() {
		setTitle("Natalia Palej A0027959");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp = getContentPane();
		cp.setLayout(gridBag);
		cp.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;

		b1.setBackground(Color.DARK_GRAY);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b2.setBackground(Color.red);
		b2.addActionListener(this);

		// Show all Students Button
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		c.gridx = 0;
		c.gridy = 0;
		gridBag.setConstraints(l1, c);
		cp.add(l1);

		// Empty line between
		c.gridx = 0;
		c.gridy = 1;
		gridBag.setConstraints(l2, c);
		cp.add(l2);

		// Students panel
		studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
		c.gridx = 0;
		c.gridy = 2;
		gridBag.setConstraints(studentPanel, c);
		cp.add(studentPanel);

		// SHOW button
		c.gridx = 0;
		c.gridy = 3;
		gridBag.setConstraints(b1, c);
		cp.add(b1);

		// Empty line between
		c.gridx = 0;
		c.gridy = 4;
		gridBag.setConstraints(l3, c);
		cp.add(l3);

		// CLEAR button
		c.gridx = 0;
		c.gridy = 5;
		gridBag.setConstraints(b2, c);
		cp.add(b2);

		setSize(900, 900);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(b1)) {
			System.out.println("Show button clicked.");
			l1.setText("Students Table");
			l2.setText(" ");
			// Retrieve list of phones
			List<Student> studentList = getStudentList();
			if (!studentList.isEmpty()) {
				for (Student student : studentList) {
					// Create new label for each object 
					JTextField studentDetails = new JTextField(student.printDetails(), SwingConstants.CENTER);
					// Add the students panel
					studentPanel.add(studentDetails);
					System.out.println("actionPerformed():\n" + student.printDetails());
				}
				studentPanel.setVisible(true);
			} else {
				l2.setText("actionPerformed(): List not found or empty. Cannot Deserialise!");
			}
		} else if (e.getSource().equals(b2)) {
			System.out.println("actionPerformed(): Clear button clicked.");
			l1.setText("Show Student Table:");
			l2.setText("-Students Table Cleared-");
			// Delete students list
			studentPanel.removeAll();
			studentPanel.setVisible(false);
		} else {
			System.out.println("actionPerformed(): Something's wrong");
		}
	}
	
	// Call deserialiseStudents method from Student class
	public List<Student> getStudentList() {
		return studentClass.deserialiseStudents();
	}
	
	public static void main(String[] args) {
		new StudentGUI();
	}
}
