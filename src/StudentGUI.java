import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

// Natalia Palej A00279259

@SuppressWarnings("serial")
public class StudentGUI extends JFrame implements ActionListener, StudentView  {
	
	//private StudentController studentController;

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
	
	JTable studentTable;
    DefaultTableModel tableModel;
    
	public StudentGUI(StudentController studentController) throws RemoteException {
		setTitle("Natalia Palej A0027959");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// All the GUI layouts, buttons etc in a separate method to make it more readable 
        setupGUI();
        
        pack();
        // Put frame in the center
        setLocationRelativeTo(null); 
        setSize(1000, 1000);
        setVisible(true);
        
        // Run the application
        run();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAllBtn)) {
			System.out.println("\nactionPerformed(): GET ALL button clicked.");
			try {
				getAll();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(getByIDBtn)) {
			System.out.println("\nactionPerformed(): GET BY ID button clicked.");
			getByID();
		} else if (e.getSource().equals(getByNameBtn)) {
			System.out.println("\nactionPerformed(): GET BY NAME button clicked.");
			getByName();
		} else if (e.getSource().equals(addBtn)) {
			System.out.println("\nactionPerformed(): ADD button clicked.");
			try {
				add();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(updateBtn)) {
			System.out.println("\nactionPerformed(): UPDATE button clicked.");
			try {
				update();
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(deleteBtn)) {
			System.out.println("\nactionPerformed(): DELETE button clicked.");
			delete();
		} else if (e.getSource().equals(exitBtn)) {
			System.out.println("\nactionPerformed(): EXIT button clicked.");
		} else {
			System.out.println("\nactionPerformed(): No action available");
		}
	}
	
	// GUI setup - buttons/labels/table/panel
	private void setupGUI() {
		cp = getContentPane();
		cp.setLayout(gridBag);
		cp.setBackground(Color.white);
		c.fill = GridBagConstraints.HORIZONTAL;
		
		// Title
		title.setFont(new Font("Arial", Font.PLAIN, 30));
        c.gridx = 1;
        c.gridy = 1;
        // span over 4 columns
        c.gridwidth = 10; 
        gridBag.setConstraints(title, c);
        cp.add(title);
        
        // Search Label
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 5;
        gridBag.setConstraints(searchLabel, c);
        cp.add(searchLabel);
        
        // Search Input
        c.gridx = 6;
        c.gridy = 3;
        c.gridwidth = 5;
        gridBag.setConstraints(searchInput, c);
        cp.add(searchInput);
        
        // GET by name button
        getByNameBtn.setBackground(Color.darkGray);
		getByNameBtn.setForeground(Color.white);
		getByNameBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 5;
        gridBag.setConstraints(getByNameBtn, c);
        cp.add(getByNameBtn);
        
        // GET by ID button
        getByIDBtn.setBackground(Color.darkGray);
		getByIDBtn.setForeground(Color.white);
		getByIDBtn.addActionListener(this);
        c.gridx = 6;
        c.gridy = 4;
        c.gridwidth = 5;
        gridBag.setConstraints(getByIDBtn, c);
        cp.add(getByIDBtn);
        
        // Empty field for messages
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 10;
        gridBag.setConstraints(emptyField, c);
        cp.add(emptyField);
              
        // Create table model with column names
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Name", "Surname", "Address", "Course", "Grade1", "Grade2", "Grade3", "Grade4", "GPA"});       
        // Create JTable with the table model
        studentTable = new JTable(tableModel);
        // Adjust column size
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        studentTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        studentTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        studentTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        studentTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        studentTable.getColumnModel().getColumn(5).setPreferredWidth(30);
        studentTable.getColumnModel().getColumn(6).setPreferredWidth(30);
        studentTable.getColumnModel().getColumn(7).setPreferredWidth(30);
        studentTable.getColumnModel().getColumn(8).setPreferredWidth(30);
        studentTable.getColumnModel().getColumn(9).setPreferredWidth(40);
        // Add the table to a scroll pane and adjust size
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth = 10;
        gridBag.setConstraints(scrollPane, c);
        cp.add(scrollPane);
        
        // GET *all* button
        getAllBtn.setBackground(Color.DARK_GRAY);
		getAllBtn.setForeground(Color.white);
		getAllBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 10;
        gridBag.setConstraints(getAllBtn, c);
        cp.add(getAllBtn);
        
        // ADD button
        addBtn.setBackground(Color.green);
		addBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 8;
        c.gridwidth = 10;
        gridBag.setConstraints(addBtn, c);
        cp.add(addBtn);
        
        // UPDATE button
        updateBtn.setBackground(Color.yellow);
		updateBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth = 5;
        gridBag.setConstraints(updateBtn, c);
        cp.add(updateBtn);
        
        // DELETE button
        deleteBtn.setBackground(Color.red);
		deleteBtn.addActionListener(this);
        c.gridx = 6;
        c.gridy = 9;
        c.gridwidth = 5;
        gridBag.setConstraints(deleteBtn, c);
        cp.add(deleteBtn);
        
        // EXIT button
        exitBtn.setBackground(Color.black);
        exitBtn.setForeground(Color.white);
        exitBtn.addActionListener(this);
        c.gridx = 1;
        c.gridy = 10;
        c.gridwidth = 10;
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
	}
	
	// Call deserialiseStudents method from StudentController 
	public List<Student> getStudentList() throws RemoteException {
		return StudentController.getInstance().deserialiseStudents();
	}
	
	// Separate methods for CRUD operations handling
	private void getAll() throws RemoteException {
		// Retrieve list of students from the controller
		List<Student> studentList = getStudentList();
        
        if (!studentList.isEmpty()) {
        	showAllStudents();
        	showSuccessMessage("List of all students");
            System.out.println("\"success\" : getAll()" + StudentController.getInstance().getAll());
        } else {
        	showErrorMessage("getAll() List not found or empty. Cannot Deserialize!");
        }
	}
	
	private void getByID() {
		// Get the text from the selectStudent text field
		String searchStudent = searchInput.getText();
		try {
			Student student = StudentController.getInstance().getByID(searchStudent);
			showSuccessMessage("Student " + student.getId() + " " + student.getName() + " successfully fetched");
			showStudentDetails(student);
		} catch (Exception e) {
			showErrorMessage("Student " + searchStudent + " not in the list.");
			System.out.println("Student " + searchStudent + " not in the list.");
		}
		
	}
	
	private void getByName() {
		// Get the text from the selectStudent text field
		String searchStudent = searchInput.getText();
		try {
			Student student = StudentController.getInstance().getByName(searchStudent);
			showSuccessMessage("Student " + searchStudent + " successfully fetched");		
			showStudentDetails(student);
		} catch (Exception e) {
			showErrorMessage("Student " + searchStudent + " not in the list.");
			System.out.println("Student " + searchStudent + " not in the list.");
		}
		
	}
	
	private void add() throws RemoteException {		
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
		// JOptionPane recognizes Strings and treats them as Labels
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
		
		// Show the input window and get the user input
	    int result = JOptionPane.showConfirmDialog(null, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
	    
	    // Check if the user clicked OK
	    if (result == JOptionPane.OK_OPTION) {
	        // Get inputs
	        String idText = id.getText();
	        String nameText = name.getText();
	        String surnameText = surname.getText();
	        String addressText = address.getText();
	        String courseText = course.getText();

	        // Parse grades to doubles
	        // Parsing to doubles throws unexpected error? Parsed to floats instead
	        float grade1Text = Float.parseFloat(grade1.getText());
	        float grade2Text = Float.parseFloat(grade2.getText());
	        float grade3Text = Float.parseFloat(grade3.getText());
	        float grade4Text = Float.parseFloat(grade4.getText());

	        // ADd new Student
	        Student newStudent = new Student(idText, nameText, surnameText, addressText, courseText, 
	        									grade1Text, grade2Text, grade3Text, grade4Text);
	        StudentController.getInstance().add(newStudent);

	        // showMessageDialog to notify user
	        JOptionPane.showMessageDialog(null, "Student " + nameText + " added successfully!");
	        showSuccessMessage("Student " + nameText + " added successfully!");
	        showAllStudents();
	    } else if (result == JOptionPane.OK_CANCEL_OPTION) {
	    	System.out.println("add(): Add new student cancelled.");
	    	showSuccessMessage("Add new student successfully cancelled.");
	    }	
	}
	
	private void update() throws RemoteException {
		String updateStudent = searchInput.getText();
		List<Student> studentList = getStudentList();
		
		// Find the student to update in the list
		Student studentToUpdate = null;
	    for (Student student : studentList) {
	        if (updateStudent.equalsIgnoreCase(student.getName()) || updateStudent.equalsIgnoreCase(student.getId())) {
	            studentToUpdate = student;
	            break;
	        }
	    }

	    if (studentToUpdate != null) {
	    	// Create input fields to update student
			JTextField id = new JTextField(10);
			JTextField name = new JTextField(10);
			JTextField surname = new JTextField(10);
			JTextField address = new JTextField(10);
			JTextField course = new JTextField(10);
			JTextField grade1 = new JTextField(10);
			JTextField grade2 = new JTextField(10);
			JTextField grade3 = new JTextField(10);
			JTextField grade4 = new JTextField(10);
			
			// Set student values in input fields
	        id.setText(studentToUpdate.getId());
	        name.setText(studentToUpdate.getName());
	        surname.setText(studentToUpdate.getSurname());
	        address.setText(studentToUpdate.getAddress());
	        course.setText(studentToUpdate.getCourse());
	        grade1.setText(String.valueOf(studentToUpdate.getGrade1()));
	        grade2.setText(String.valueOf(studentToUpdate.getGrade2()));
	        grade3.setText(String.valueOf(studentToUpdate.getGrade3()));
	        grade4.setText(String.valueOf(studentToUpdate.getGrade4()));
	    	
	        // Array with labels and their fields
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

	        int result = JOptionPane.showConfirmDialog(null, fields, "Update Student", JOptionPane.OK_CANCEL_OPTION);
	        if (result == JOptionPane.OK_OPTION) {
	            float grade1Text = Float.parseFloat(grade1.getText());
	            float grade2Text = Float.parseFloat(grade2.getText());
	            float grade3Text = Float.parseFloat(grade3.getText());
	            float grade4Text = Float.parseFloat(grade4.getText());
	            
	            // Create updated student
                Student updatedStudent = new Student(
                        id.getText(),
                        name.getText(),
                        surname.getText(),
                        address.getText(),
                        course.getText(),
                        grade1Text,
                        grade2Text,
                        grade3Text,
                        grade4Text
                );

                StudentController.getInstance().update(studentToUpdate, updatedStudent);

	            // Show message dialog
	            JOptionPane.showMessageDialog(null, "Student " + updateStudent + " was updated successfully!");
	            showSuccessMessage("Student " + updateStudent + " updated successfully!");
	            
	            clearTable();
		    	tableModel.addRow(new Object[]{
		    			updatedStudent.getId(),
		    			updatedStudent.getName(),
		    			updatedStudent.getSurname(),
		    			updatedStudent.getAddress(),
		    			updatedStudent.getCourse(),
		    			updatedStudent.getGrade1(),
		    			updatedStudent.getGrade2(),
		    			updatedStudent.getGrade3(),
		    			updatedStudent.getGrade4(),
		    			updatedStudent.getAverage(updatedStudent.getGrade1(), updatedStudent.getGrade2(), updatedStudent.getGrade3(), updatedStudent.getGrade4()) + "%"
	            });
	        } else if (result == JOptionPane.CANCEL_OPTION) {
	            System.out.println("update(): Update student cancelled.");
	            showSuccessMessage("Update student cancelled.");
	        }
	    } else {
	        System.out.println("update(): Student " + updateStudent + " not found for update.");
	        showErrorMessage("Student " + updateStudent + " not found for update.");
	    }
	}
	
	private void delete() {
		String deleteStudent = searchInput.getText();
		try {
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + deleteStudent + "?");
			if (result == JOptionPane.YES_OPTION) {
				StudentController.getInstance().delete(deleteStudent);
				JOptionPane.showMessageDialog(null, "Student " + deleteStudent + " deleted successfully!");
				showSuccessMessage("Student " + deleteStudent + " was successfully deleted.");
				clearTable();
				showAllStudents();
			} else if (result == JOptionPane.NO_OPTION) {
				showSuccessMessage("Delete student cancelled.");
			} 			
		} catch (Exception e) {
			showErrorMessage("Couldn't delete student " + deleteStudent + ".");
		}
		
	}
	
	private void clearTable() {
		tableModel.setRowCount(0);
	}
	
	// Initialize student controller
	public void setStudentController() throws RemoteException {
		StudentController.getInstance();
	}
	
	public void run() throws RemoteException {
        getAll();
        setVisible(true);
    }
	
	@Override
	public void showAllStudents() throws RemoteException {
		List<Student> studentList = StudentController.getInstance().getAllStudents();
		// Clear existing rows in the table
	    clearTable();
	    // Loop through the list and add students to the table
	    for (Student student : studentList) {
	        tableModel.addRow(new Object[]{
	                student.getId(),
	                student.getName(),
	                student.getSurname(),
	                student.getAddress(),
	                student.getCourse(),
	                student.getGrade1(),
	                student.getGrade2(),
	                student.getGrade3(),
	                student.getGrade4(),
	                student.getAverage(student.getGrade1(), student.getGrade2(), student.getGrade3(), student.getGrade4()) + "%"
	        });
	    }
	}

	@Override
	public void showStudentDetails(Student student) throws RemoteException {
		List<Student> studentList = getStudentList();
		if (studentList.isEmpty()) {
	        System.out.println("showStudentDetails(): Student list is empty.");
	        showMessage("List of Students is empty!");
		} else { 
			if (student != null) {
	            System.out.println("showStudentDetails(): Student " + student.getId() + " " + student.getName() + " in the list");
	            showSuccessMessage("Student " + student.getId() + " was successfully found.");
	            clearTable();
	            System.out.println(student.getStudentDetails());
	            tableModel.addRow(new Object[]{
	                    student.getId(),
	                    student.getName(),
	                    student.getSurname(),
	                    student.getAddress(),
	                    student.getCourse(),
	                    student.getGrade1(),
	                    student.getGrade2(),
	                    student.getGrade3(),
	                    student.getGrade4(),
	                    student.getAverage(student.getGrade1(), student.getGrade2(), student.getGrade3(), student.getGrade4()) + "%"
	            });
	        } else {
	        	showErrorMessage("Student not found in studentsList.");
	            System.out.println("showStudentDetails(): Student not found in the studentList.");
	        }
		}
	}

	@Override
	public void showMessage(String message) {
		emptyField.setText(message);
	}

	@Override
	public void showSuccessMessage(String message) {
		showMessage("\"success\" : " + message);
	}

	@Override
	public void showErrorMessage(String message) {
		showMessage("\"error\" : " + message);
	}
}
