import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


// Natalia Palej A00279259

@SuppressWarnings("serial")
public class StudentGUI extends JFrame implements ActionListener {
	
	static Student studentClass = new Student();
	private StudentController studentController = new StudentController();

	Container cp;
	GridBagLayout gridBag = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	JButton getAllBtn = new JButton("GET *all*");
	JButton getByIDBtn = new JButton("GET by ID");
	JButton getByNameBtn = new JButton("GET by name");
	JButton addBtn = new JButton("ADD");
	JButton updateBtn = new JButton("UPDATE");
	JButton deleteBtn = new JButton("DELETE");
	JButton exitBtn = new JButton("EXIT");
	
	JLabel title = new JLabel("Students", SwingConstants.CENTER);
	JLabel emptyLine = new JLabel("", SwingConstants.CENTER);
	JLabel searchLabel = new JLabel("Search:", SwingConstants.CENTER);
	JTextField searchInput = new JTextField(" ", 20);
	JTextField selectStudent = new JTextField(" ", 20);
	
	JTextArea studentListField = new JTextArea(" ", 20, 80);
	
	public StudentGUI() {
		setTitle("Natalia Palej A0027959");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp = getContentPane();
		cp.setLayout(gridBag);
		cp.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Title
		title.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 1;
        c.gridy = 1;
        // span over 4 columns
        c.gridwidth = 4; 
        gridBag.setConstraints(title, c);
        cp.add(title);
        
        // Search Label
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;
        gridBag.setConstraints(searchLabel, c);
        cp.add(searchLabel);
        
        // Search Input
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 2;
        gridBag.setConstraints(searchInput, c);
        cp.add(searchInput);
        
        // GET by name button
        getByNameBtn.setBackground(Color.darkGray);
		getByNameBtn.setForeground(Color.white);
		getByNameBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 2;
        gridBag.setConstraints(getByNameBtn, c);
        cp.add(getByNameBtn);
        
        // GET by ID button
        getByIDBtn.setBackground(Color.darkGray);
		getByIDBtn.setForeground(Color.white);
		getByIDBtn.addActionListener(this);
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 2;
        gridBag.setConstraints(getByIDBtn, c);
        cp.add(getByIDBtn);
        
        // Empty space for student list
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 4;
        gridBag.setConstraints(studentListField, c);
        cp.add(studentListField);
        
        // GET *all* button
        getAllBtn.setBackground(Color.DARK_GRAY);
		getAllBtn.setForeground(Color.white);
		getAllBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 4;
        gridBag.setConstraints(getAllBtn, c);
        cp.add(getAllBtn);
        
        // ADD button
        addBtn.setBackground(Color.green);
		addBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 4;
        gridBag.setConstraints(addBtn, c);
        cp.add(addBtn);
        
        // Second search
        JLabel searchLabel2 = new JLabel("Search:", SwingConstants.CENTER);
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 2;
        gridBag.setConstraints(searchLabel2, c);
        cp.add(searchLabel2);
        
        // Second search
        c.gridx = 3;
        c.gridy = 8;
        c.gridwidth = 2;
        gridBag.setConstraints(selectStudent, c);
        cp.add(selectStudent);
        
        // UPDATE button
        updateBtn.setBackground(Color.yellow);
		updateBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth = 2;
        gridBag.setConstraints(updateBtn, c);
        cp.add(updateBtn);
        
        // DELETE button
        deleteBtn.setBackground(Color.red);
		deleteBtn.addActionListener(this);
        c.gridx = 3;
        c.gridy = 9;
        c.gridwidth = 2;
        gridBag.setConstraints(deleteBtn, c);
        cp.add(deleteBtn);
        
        // EXIT button
        exitBtn.setBackground(Color.black);
        exitBtn.setForeground(Color.white);
        exitBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 10;
        c.gridwidth = 4;
        gridBag.setConstraints(exitBtn, c);
        cp.add(exitBtn);
        
        // Set the same size to all buttons
        Dimension buttonSize = new Dimension(150, 40);
        getAllBtn.setPreferredSize(buttonSize);
        getByIDBtn.setPreferredSize(buttonSize);
        getByNameBtn.setPreferredSize(buttonSize);
        addBtn.setPreferredSize(buttonSize);
        updateBtn.setPreferredSize(buttonSize);
        deleteBtn.setPreferredSize(buttonSize);
        exitBtn.setPreferredSize(buttonSize);
        studentListField.setPreferredSize(new Dimension(500, 500));
        
        // Add margin
        JLabel topMargin = new JLabel(" ");
        topMargin.setPreferredSize(new Dimension(20, 50));
        JLabel bottomMargin = new JLabel(" ");
        bottomMargin.setPreferredSize(new Dimension(20, 50));
        JLabel rightMargin = new JLabel(" ");
        rightMargin.setPreferredSize(new Dimension(50, 20));
        JLabel leftMargin = new JLabel(" ");
        leftMargin.setPreferredSize(new Dimension(50, 20));
     
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        gridBag.setConstraints(topMargin, c);
        cp.add(topMargin);
        
        c.gridx = 0;
        c.gridy = 12;
        c.gridwidth = 1;
        gridBag.setConstraints(bottomMargin, c);
        cp.add(bottomMargin);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        gridBag.setConstraints(leftMargin, c);
        cp.add(leftMargin);
        
        c.gridx = 5;
        c.gridy = 0;
        c.gridwidth = 1;
        gridBag.setConstraints(rightMargin, c);
        cp.add(rightMargin);
        

        
        pack();
        // Put frame in the center
        setLocationRelativeTo(null); 
        setSize(1000, 1000);
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAllBtn)) {
			System.out.println("\nactionPerformed(): GET ALL button clicked.");
			
			// Retrieve list of students from the controller
			List<Student> studentList = getStudentList();
	        
	        if (!studentList.isEmpty()) {
	        	// Clear existing student list
                studentListField.setText("");
                studentListField.setText(studentController.getAll());
                System.out.println(studentController.getAll());
            } else {
                studentListField.setText("List not found or empty. Cannot Deserialize!");
            }
		} else if (e.getSource().equals(getByIDBtn)) {
			System.out.println("\nactionPerformed(): GET BY ID button clicked.");
			List<Student> studentList = getStudentList();
			
			if(studentList.isEmpty()) {
				System.out.println("getByIDBtn(): Student list is empty.");
			} else {
				 // Get the text from the selectStudent text field
			    String searchStudent = selectStudent.getText();
			    Student studentExist = studentController.getByName(searchStudent);
			    
			    if (studentExist != null) {
			    	System.out.println("getByIDBtn(): Student " + searchStudent + " in the list");
		            studentListField.setText(studentExist.printDetails());
			    } else {
			    	System.out.println("getByIDBtn(): Name not in the studentList");
			    }
			}
		} else if (e.getSource().equals(getByNameBtn)) {
			System.out.println("\nactionPerformed(): GET BY NAME button clicked.");
		} else if (e.getSource().equals(addBtn)) {
			System.out.println("\nactionPerformed(): ADD button clicked.");
		} else if (e.getSource().equals(updateBtn)) {
			System.out.println("\nactionPerformed(): UPDATE button clicked.");
		} else if (e.getSource().equals(deleteBtn)) {
			System.out.println("\nactionPerformed(): DELETE button clicked.");
		} else if (e.getSource().equals(exitBtn)) {
			System.out.println("\nactionPerformed(): EXIT button clicked.");
		} else {
			System.out.println("\nactionPerformed(): No action available");
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
