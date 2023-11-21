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
	
	JLabel emptyField = new JLabel(" ", SwingConstants.CENTER);
	JLabel title = new JLabel("Students", SwingConstants.CENTER);
	JLabel emptyLine = new JLabel("", SwingConstants.CENTER);
	JLabel searchLabel = new JLabel("Search:", SwingConstants.CENTER);
	JTextField searchInput = new JTextField(" ", 20);
	
	JTextArea studentListField = new JTextArea(" ", 20, 80);
	
	public StudentGUI() {
		// Set initial data for the list
		List<Student> studentList = getStudentList();
        this.studentController = new StudentController(studentList);
		
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
        
        // Empty field for messages
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 4;
        gridBag.setConstraints(emptyField, c);
        cp.add(emptyField);
        
        // Empty space for student list
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 4;
        gridBag.setConstraints(studentListField, c);
        cp.add(studentListField);
        
        // GET *all* button
        getAllBtn.setBackground(Color.DARK_GRAY);
		getAllBtn.setForeground(Color.white);
		getAllBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 4;
        gridBag.setConstraints(getAllBtn, c);
        cp.add(getAllBtn);
        
        // ADD button
        addBtn.setBackground(Color.green);
		addBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 4;
        gridBag.setConstraints(addBtn, c);
        cp.add(addBtn);
        
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
			getAll();
		} else if (e.getSource().equals(getByIDBtn)) {
			System.out.println("\nactionPerformed(): GET BY ID button clicked.");
			getByID();
		} else if (e.getSource().equals(getByNameBtn)) {
			System.out.println("\nactionPerformed(): GET BY NAME button clicked.");
			getByName();
		} else if (e.getSource().equals(addBtn)) {
			System.out.println("\nactionPerformed(): ADD button clicked.");
			add();
		} else if (e.getSource().equals(updateBtn)) {
			System.out.println("\nactionPerformed(): UPDATE button clicked.");
			update();
		} else if (e.getSource().equals(deleteBtn)) {
			System.out.println("\nactionPerformed(): DELETE button clicked.");
			delete();
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
	
	// Separate methods for CRUD operations handling
	private void getAll() {
		// Retrieve list of students from the controller
		List<Student> studentList = getStudentList();
        
        if (!studentList.isEmpty()) {
        	// Clear existing student list
            studentListField.setText("");
            studentListField.setText(studentController.getAll());
            emptyField.setText("\"success\" : List of all students");
            System.out.println("\"success\" : getAll() \n" + studentController.getAll());
        } else {
        	emptyField.setText("\"error\" : getAll() List not found or empty. Cannot Deserialize!");
        }
	}
	
	private void getByID() {
		List<Student> studentList = getStudentList();
		
		if(studentList.isEmpty()) {
			System.out.println("getByID(): Student list is empty.");
			emptyField.setText("List of Students is empty!");
		} else {
			 // Get the text from the selectStudent text field
		    String searchStudent = searchInput.getText();
		    Student studentExist = studentController.getByID(searchStudent);
		    
		    if (studentExist != null) {
		    	System.out.println("getByID(): Student " + searchStudent + " in the list");
		    	System.out.println(studentExist.getStudentDetails());
		    	emptyField.setText("\"success\" : Student " + searchStudent + " was successfully found.");
	            studentListField.setText(studentExist.getStudentDetails());
		    } else {
		    	emptyField.setText("\"error\" : Student " + searchStudent + " not in studentsList.");
		    	System.out.println("getByID(): ID " + searchStudent + " not in the studentList");
		    }
		}
	}
	
	private void getByName() {
		List<Student> studentList = getStudentList();
		
		if(studentList.isEmpty()) {
			System.out.println("getByName(): Student list is empty.");
			emptyField.setText("List of Students is empty!");
		} else {
			 // Get the text from the selectStudent text field
		    String searchStudent = searchInput.getText();
		    Student studentExist = studentController.getByName(searchStudent);
		    
		    if (studentExist != null) {
		    	System.out.println("getByName(): Student " + searchStudent + " in the list");
		    	System.out.println(studentExist.getStudentDetails());
		    	emptyField.setText("\"success\" : Student " + searchStudent + " was successfully found.");
	            studentListField.setText(studentExist.getStudentDetails());
		    } else {
		    	System.out.println("getByNameBtn(): Name " + searchStudent + " not in the studentList.");
		    	emptyField.setText("\"error\" : Student " + searchStudent + " not in the list");
		    }
		}
	}
	
	private void add() {
		// Create input fields for a new student
		JTextField id = new JTextField(10);
		JTextField name = new JTextField(10);
		JTextField surname = new JTextField(10);
		JTextField address = new JTextField(10);
		JTextField course = new JTextField(10);
		JTextField grade1 = new JTextField(10);
		JTextField grade2 = new JTextField(10);
		JTextField grade3 = new JTextField(10);
		JTextField grade4 = new JTextField(10);		
		
		// Create array with labels and their fields
		Object[] fields = {
				"ID: ", id,
				"Name: ", name,
				"Surname: ", surname,
				"Address: ", address,
				"Course: ", course,
				"Grade1: ", grade1,
				"Grade2: ", grade2,
				"Grade3: ", grade3,
				"Grade4: ", grade4
		};
		
		// Show the input dialog and get the user's input
	    int result = JOptionPane.showConfirmDialog(null, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
	    
	    // Check if the user clicked OK
	    if (result == JOptionPane.OK_OPTION) {
	        // Get inputs
	        String idInput = id.getText();
	        String nameInput = name.getText();
	        String surnameInput = surname.getText();
	        String addressInput = address.getText();
	        String courseInput = course.getText();

	        // Parse grades to doubles
	        // Parsing to doubles throws unexpected error? Parsed to floats instead
	        double grade1Input = Float.parseFloat(grade1.getText());
	        double grade2Input = Float.parseFloat(grade2.getText());
	        double grade3Input = Float.parseFloat(grade3.getText());
	        double grade4Input = Float.parseFloat(grade4.getText());

	        // ADd new Student
	        Student newStudent = new Student(idInput, nameInput, surnameInput, addressInput, courseInput, 
	        		grade1Input, grade2Input, grade3Input, grade4Input);
	        studentController.add(newStudent);

	        // showMessageDialog to notify user
	        JOptionPane.showMessageDialog(null, "Student added successfully!");
	    }
		
		
	}
	
	private void update() {
		
	}
	
	private void delete() {
		String deleteStudent = searchInput.getText();
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + deleteStudent + "?");
			if (result == JOptionPane.YES_OPTION) {
				studentController.delete(deleteStudent);
				emptyField.setText("\"success\" : Student " + deleteStudent + " was successfully deleted.");
				studentListField.setText(studentController.getAll());
			} else if (result == JOptionPane.NO_OPTION) {
				emptyField.setText("\"success\" : Delete student cancelled.");
				studentListField.setText(studentController.getAll());
			} 			
		} catch (Exception e) {
			emptyField.setText("\"error\" : Couldn't delete student " + deleteStudent + ".");
		}
		
	}
	
	
	public static void main(String[] args) {
		new StudentGUI();
	}
}
