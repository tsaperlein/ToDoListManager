import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Class used to edit Ttsk data to the ToDoList
public class EditWindow extends JFrame implements ActionListener{
	
	private static JLabel taskName;
	private static JLabel startDate;
	private static JLabel endDate;
	private static JLabel priority;
	private static JLabel percComp;
	private static JLabel category;
	private static JLabel note;
	private static JTextField taskNameDisplay;
	private static JPanel startDatePanel;
	private static JPanel endDatePanel;
	private static JComboBox<String> priorityCombo;
	private static JTextField percCompDisplay;
	private static JComboBox<String> categoryCombo;
	private static JTextField noteDisplay;
	private static JPanel mainPanel;
	private static JPanel lowerPanel;
	private static JButton save;
	private static JButton cancel;
	
	private static JComboBox<String> dayCombo;
	private static JComboBox<String> monthCombo;
	private static JComboBox<String> yearCombo;
	private static JComboBox<String> endDayCombo;
	private static JComboBox<String> endMonthCombo;
	private static JComboBox<String> endYearCombo;

	private static String[] priorityList = {"Low", "Medium", "High", "Other"};
	private static String[] categoryList = {"Personal", "Business", "School", "Social", "Household Chore", "Other"};
	private static String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private static String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private static String[] year = { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022","2023", "2024" };

	// Method used to create the edit window
	EditWindow()
	{
		this.setLayout(new BorderLayout());
		this.setTitle("Edit Task");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null); // Centers the window on the screen

		// Add task labels
		taskName = new JLabel("Task Name: ");
		startDate = new JLabel("Start Date: ");
		endDate = new JLabel("End Date: ");
		priority = new JLabel("Priority: ");
		percComp = new JLabel("Percent Complete: ");
		category = new JLabel("Category: ");
		note = new JLabel("Note: ");
		taskNameDisplay = new JTextField();

		// Start Date Panel
		startDatePanel = new JPanel(new GridLayout(1, 3));
		dayCombo = new JComboBox<String>(day);
		monthCombo = new JComboBox<String>(month);
		yearCombo = new JComboBox<String>(year);
		startDatePanel.add(dayCombo);
		startDatePanel.add(monthCombo);
		startDatePanel.add(yearCombo);

		// End Date Panel
		endDatePanel = new JPanel(new GridLayout(1, 3));
		endDayCombo = new JComboBox<String>(day);
		endMonthCombo = new JComboBox<String>(month);
		endYearCombo = new JComboBox<String>(year);
		endDatePanel.add(endDayCombo);
		endDatePanel.add(endMonthCombo);
		endDatePanel.add(endYearCombo);

		priorityCombo = new JComboBox<String>(priorityList);
		percCompDisplay = new JTextField();
		categoryCombo = new JComboBox<String>(categoryList);
		noteDisplay = new JTextField();

		// Add the labels and text fields to the main panel
		mainPanel = new JPanel(new GridLayout(7, 2)); // Create a panel with a grid layout
		mainPanel.add(taskName);
		mainPanel.add(taskNameDisplay);
		mainPanel.add(startDate);
		mainPanel.add(startDatePanel);
		mainPanel.add(endDate);
		mainPanel.add(endDatePanel);
		mainPanel.add(priority);
		mainPanel.add(priorityCombo);
		mainPanel.add(percComp);
		mainPanel.add(percCompDisplay);
		mainPanel.add(category);
		mainPanel.add(categoryCombo);
		mainPanel.add(note);
		mainPanel.add(noteDisplay);
		this.getContentPane().add(BorderLayout.CENTER, mainPanel); // Add the panel to the CENTER of the BorderLayout

		save = new JButton("Save");
		cancel = new JButton("Cancel");
		save.addActionListener(this);
		cancel.addActionListener(this);

		lowerPanel = new JPanel(new FlowLayout());
		lowerPanel.add(save);
		lowerPanel.add(cancel);
		this.getContentPane().add(BorderLayout.SOUTH, lowerPanel); // Add the panel to the SOUTH of the BorderLayout

		this.addWindowListener(new WindowAdapter() {
			// Method used to manage variables when the task window is closed
			public void windowClosing(WindowEvent we) {
				ToDoList.listenerOn = true; // Turn the JList listener on as editing has ended
			}
		});

		validate();
	}
	
	// Method used to take task information and populate the window using the information
	public static void populate()
	{
		taskNameDisplay.setText(ToDoList.myTasks.get(ToDoList.currentEditIndex).getName());

		dayCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getStartDate().getDay());
		monthCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getStartDate().getMonth());
		yearCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getStartDate().getYear());

		endDayCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getEndDate().getDay());
		endMonthCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getEndDate().getMonth());
		endYearCombo.setSelectedItem("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getEndDate().getYear());

		priorityCombo.setSelectedItem(ToDoList.myTasks.get(ToDoList.currentEditIndex).getPriority());
		percCompDisplay.setText("" + ToDoList.myTasks.get(ToDoList.currentEditIndex).getPercentComplete());
		categoryCombo.setSelectedItem(ToDoList.myTasks.get(ToDoList.currentEditIndex).getCategory());
		noteDisplay.setText(ToDoList.myTasks.get(ToDoList.currentEditIndex).getNote());
	}
	
	// Method to track actions performed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == save)
		{
			try
			{
				// Check if the user has filled in all of the fields
				if(taskNameDisplay.getText().equals("") || percCompDisplay.getText().equals("") || noteDisplay.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please fill in all of the fields.");
				}

				// Check if the user has filled in a number from 0 to 100 in the percentage field
				else if(taskNameDisplay.getText().equals("") || Integer.parseInt(percCompDisplay.getText()) < 0 || Integer.parseInt(percCompDisplay.getText()) > 100)
				{
					JOptionPane.showMessageDialog(null, "Please fill in a number from '0' to '100' in the percentage field.");
				}

				// If the year is bicentennial, then the days for february are 1 to 29
				else if(Integer.parseInt((String) yearCombo.getSelectedItem()) % 4 == 0 && Integer.parseInt((String) monthCombo.getSelectedItem()) == 2 && Integer.parseInt((String) dayCombo.getSelectedItem()) > 29)
				{
					JOptionPane.showMessageDialog(null, "Please fill in a valid date.");
				}

				// If the year is not bicentennial, then the days for february are 1 to 28
				else if(Integer.parseInt((String) yearCombo.getSelectedItem()) % 4 != 0 && Integer.parseInt((String) monthCombo.getSelectedItem()) == 2 && Integer.parseInt((String) dayCombo.getSelectedItem()) > 28)
				{
					JOptionPane.showMessageDialog(null, "Please fill in a valid date.");
				}

				else
				{
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setName(taskNameDisplay.getText());
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setStartDate(new myDate(Integer.parseInt((String) dayCombo.getSelectedItem()), Integer.parseInt((String) monthCombo.getSelectedItem()), Integer.parseInt((String) yearCombo.getSelectedItem())));
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setEndDate(new myDate(Integer.parseInt((String) endDayCombo.getSelectedItem()), Integer.parseInt((String) endMonthCombo.getSelectedItem()), Integer.parseInt((String) endYearCombo.getSelectedItem())));
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setPriority((String) priorityCombo.getSelectedItem());
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setPercentComplete(Integer.parseInt(percCompDisplay.getText()));
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setCategory((String) categoryCombo.getSelectedItem());
					ToDoList.myTasks.get(ToDoList.currentEditIndex).setNote(noteDisplay.getText());
					
					ToDoList.listModel.remove(ToDoList.currentEditIndex);
					ToDoList.listModel.add(ToDoList.currentEditIndex, ToDoList.myTasks.get(ToDoList.currentEditIndex).getName());
					ToDoList.listenerOn = true;
					ToDoList.edit1.setVisible(false);
					ToDoList.changeOutputDetails(ToDoList.currentEditIndex);
					ToDoList.exported = false;
					JOptionPane.showMessageDialog(null, "Edit task Successful.");
				}
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "Please fill in a number from '0' to '100' in the percentage field.");
			}
		}
		if(e.getSource() == cancel)
		{
			ToDoList.listenerOn = true;
			ToDoList.edit1.setVisible(false);
		}
	}
}