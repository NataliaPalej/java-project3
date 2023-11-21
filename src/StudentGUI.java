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

	JButton getAllBtn = new JButton("GET *all*");
	JButton getByIDBtn = new JButton("GET by ID");
	JButton getByNameBtn = new JButton("GET by name");
	JButton addBtn = new JButton("ADD");
	JButton updateBtn = new JButton("UPDATE");
	JButton deleteBtn = new JButton("DELETE");
	
	JLabel title = new JLabel("Students", SwingConstants.CENTER);
	JLabel l2 = new JLabel(" ", SwingConstants.CENTER);
	JLabel l3 = new JLabel(" ", SwingConstants.CENTER);
	JLabel searchLabel = new JLabel("Search: ", SwingConstants.CENTER);
	
	JTextField searchInput = new JTextField(" ", 20);
	
	JPanel studentPanel = new JPanel();
	
	public StudentGUI() {
		setTitle("Natalia Palej A0027959");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp = getContentPane();
		cp.setLayout(gridBag);
		cp.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;

		getAllBtn.setBackground(Color.DARK_GRAY);
		getAllBtn.setForeground(Color.white);
		getAllBtn.addActionListener(this);
		getByIDBtn.setBackground(Color.darkGray);
		getByIDBtn.setForeground(Color.white);
		getByIDBtn.addActionListener(this);
		getByNameBtn.setBackground(Color.darkGray);
		getByNameBtn.setForeground(Color.white);
		getByNameBtn.addActionListener(this);
		addBtn.setBackground(Color.green);
		addBtn.addActionListener(this);
		updateBtn.setBackground(Color.yellow);
		updateBtn.addActionListener(this);
		deleteBtn.setBackground(Color.red);
		deleteBtn.addActionListener(this);

		// Title
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		c.gridx = 0;
		c.gridy = 0;
		gridBag.setConstraints(title, c);
		cp.add(title);
		
		// Search
		c.gridx = 0;
		c.gridy = 1;
		gridBag.setConstraints(searchLabel, c);
		cp.add(searchLabel);
		c.gridx = 1;
		c.gridy = 1;
		gridBag.setConstraints(searchInput, c);
		cp.add(searchInput);

		// Empty line between
		c.gridx = 0;
		c.gridy = 2;
		gridBag.setConstraints(l2, c);
		cp.add(l2);

		// Students panel
		studentPanel.setLayout(new BoxLayout(studentPanel, BoxLayout.Y_AXIS));
		c.gridx = 0;
		c.gridy = 3;
		gridBag.setConstraints(studentPanel, c);
		cp.add(studentPanel);

		// GET *all* button
		c.gridx = 0;
		c.gridy = 4;
		gridBag.setConstraints(getAllBtn, c);
		cp.add(getAllBtn);

		// GET by name button
		c.gridx = 0;
		c.gridy = 5;
		gridBag.setConstraints(getByNameBtn, c);
		cp.add(getByNameBtn);
		
		// GET by ID button
		c.gridx = 0;
		c.gridy = 6;
		gridBag.setConstraints(getByIDBtn, c);
		cp.add(getByIDBtn);
		
		// ADD button
		c.gridx = 0;
		c.gridy = 7;
		gridBag.setConstraints(addBtn, c);
		cp.add(addBtn);

		// UPDATE button
		c.gridx = 0;
		c.gridy = 8;
		gridBag.setConstraints(updateBtn, c);
		cp.add(updateBtn);
		
		// DELETE button
		c.gridx = 0;
		c.gridy = 9;
		gridBag.setConstraints(deleteBtn, c);
		cp.add(deleteBtn);

		setSize(900, 900);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAllBtn)) {
			System.out.println("Show button clicked.");
			title.setText("Students Table");
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
				l2.setText("\nactionPerformed(): List not found or empty. Cannot Deserialise!");
			}
		} else if (e.getSource().equals(deleteBtn)) {
			System.out.println("\nactionPerformed(): Clear button clicked.");
			title.setText("Students");
			l2.setText("-Students List Cleared-");
			// Delete students list
			studentPanel.removeAll();
			studentPanel.setVisible(false);
		} else {
			System.out.println("\nactionPerformed(): Something's wrong");
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
