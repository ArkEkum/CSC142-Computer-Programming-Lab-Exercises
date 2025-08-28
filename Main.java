package taskmanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.List;

public class Main extends Application {
	
	Button addButton;
	Button deleteButton;
	Button editButton;
	Button markCompletedButton;
	Button sortDueDateButton;
	Button sortPriorityButton;
	Button allTaskButton;
	
	TextField taskField;
	TextField indexField;
	
	DatePicker dueDatePicker;
	LocalDate TaskDueDate;
	String TaskTitle;
	Integer index;
	Task Task;
	
	TaskController TaskCon;
	ListView<String> taskListView;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) { // Method creates a UI and calls methods from other classes.
		
		Label titleLabel = new Label("📝 Task Organizer"); // Title of UI is created.
		titleLabel.setStyle("-fx-font-size: 24px; -fx-padding: 10px;");
		
		taskField = new TextField(); // TextField for user to input task name.
		taskField.setPromptText("Enter task name");
		
		indexField = new TextField(); // TextField for user to input task index.
		indexField.setPromptText("Enter index (Supports -1 for last)");
		
		dueDatePicker = new DatePicker(); // DatePicker for user to input task due date.
		dueDatePicker.setPromptText("Enter due date");
		
		TaskCon = new TaskController();
		
		addButton = new Button("Add Task"); // Add button for user to add tasks.
		addButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			TaskCon.addTask(TaskTitle,TaskDueDate); // Method called to add task to ArrayList.
			refreshTaskList(taskListView);
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		deleteButton = new Button("Delete Task"); // Delete button for user to delete tasks.
		deleteButton.setOnAction(e -> {
			Integer index = parseIndex(indexField.getText());
			if (index != null) {
				TaskCon.deleteTask(index); // Method called to delete task from ArrayList.
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid index!"); // Error message for empty index value.
			}
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		editButton = new Button("Edit Task"); // Edit button for user to edit tasks.
		editButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			index = Integer.parseInt(indexField.getText());
			if (index != null) {
				TaskCon.editTask(index, TaskTitle, TaskDueDate); // Method called to edit task from ArrayList.
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid Index!"); // Error message for empty index value.
			}
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		markCompletedButton = new Button("Mark Complete"); // Task complete button for user to mark task complete.
		markCompletedButton.setOnAction(e -> {
		index = Integer.parseInt(indexField.getText());
			if (index != null) {
				TaskCon.markTaskCompleted(index); // Method called to mark task complete in ArrayList.
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid Index!"); // Error message for empty index value.
			}
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		sortDueDateButton = new Button("Tasks By Due Date"); // Sort by due date button for user to sort tasks by due date.
		sortDueDateButton.setOnAction(e -> {
			TaskCon.sortByDueDate(); // Method called to sort tasks by due date in ArrayList.
			refreshTaskList(taskListView);
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		sortPriorityButton = new Button("Tasks By Priority"); // Sort by priority button for user to sort tasks by incomplete tasks.
		sortPriorityButton.setOnAction(e -> {
			TaskCon.getPendingTasks(); // Method called to sort tasks by incomplete tasks in ArrayList.
			refreshTaskList(taskListView);
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		allTaskButton = new Button("All Tasks"); // All tasks button for user to show all tasks.
		allTaskButton.setOnAction(e -> {
			TaskCon.getAllTasks(); // Method called to show all tasks in ArrayList.
			refreshTaskList(taskListView);
			taskField.clear();
			indexField.clear();
			dueDatePicker.setValue(null);
		});
		
		HBox inputBox = new HBox(10, taskField, indexField, dueDatePicker, addButton, deleteButton, markCompletedButton, editButton, sortDueDateButton, sortPriorityButton, allTaskButton); // TextFields and Buttons are set.
		inputBox.setStyle("-fx-padding: 10px;");
		taskListView = new ListView<>();
		taskListView.setPrefHeight(260);
		VBox root = new VBox(10, titleLabel, inputBox, taskListView);
		root.setStyle("-fx-padding: 20px;");
		Scene scene = new Scene(root, 1200, 400);
		primaryStage.setTitle("Task Organizer");
		primaryStage.setScene(scene);
		primaryStage.show();
		refreshTaskList(taskListView);
		
	}
	
	private Integer parseIndex(String text) { // Method converts String to int.
		try {
			return Integer.parseInt(text.trim());
		} catch (Exception ex) {
			return null;
		}
	}
	
	private void refreshTaskList(ListView<String> listView) { // Method shows tasks with their positive indices and equivalent negative indices.
		
		listView.getItems().clear();
		List<Task> allTasks = TaskCon.getAllTasks();
		int n = allTasks.size();
		
		for (int i = 0; i < n; i++) {
			
			Task t = allTasks.get(i);
			int negIndex = i - n;
			String line = "Index: " + i + " (or " + negIndex + ") | Task: " + t.getTitle() + " | Due: " + t.getDueDate() + " | Completed: " + t.isCompleted(); // Displays task index, name, due date, and completion status.
			listView.getItems().add(line);
			
		}
		
	}

}
