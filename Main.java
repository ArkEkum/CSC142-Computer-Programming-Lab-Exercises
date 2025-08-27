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
	public void start(Stage primaryStage) {
		
		Label titleLabel = new Label("📝 Task Organizer");
		titleLabel.setStyle("-fx-font-size: 24px; -fx-padding: 10px;");
		
		taskField = new TextField();
		taskField.setPromptText("Enter task name");
		
		indexField = new TextField();
		indexField.setPromptText("Enter index (Supports -1 for last)");
		
		dueDatePicker = new DatePicker();
		dueDatePicker.setPromptText("Enter due date");
		
		TaskCon = new TaskController();
		
		addButton = new Button("Add Task");
		addButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			TaskCon.addTask(TaskTitle,TaskDueDate);
			refreshTaskList(taskListView);
		});
		
		deleteButton = new Button("Delete Task");
		deleteButton.setOnAction(e -> {
			Integer index = parseIndex(indexField.getText());
			if (index != null) {
				TaskCon.deleteTask(index);
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid index!");
			}
		});
		
		editButton = new Button("Edit Task");
		editButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			index = Integer.parseInt(indexField.getText());
			if (index != null) {
				TaskCon.editTask(index, TaskTitle, TaskDueDate);
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid Index!");
			}
		});
		
		markCompletedButton = new Button("Mark Complete");
		markCompletedButton.setOnAction(e -> {
		index = Integer.parseInt(indexField.getText());
			if (index != null) {
				TaskCon.markTaskCompleted(index);
				refreshTaskList(taskListView);
			} else {
				System.out.println("Invalid Index!");
			}
		});
		
		sortDueDateButton = new Button("Tasks By Due Date");
		sortDueDateButton.setOnAction(e -> {
			TaskCon.sortByDueDate();
			refreshTaskList(taskListView);
		});
		
		sortPriorityButton = new Button("Tasks By Priority");
		sortPriorityButton.setOnAction(e -> {
			TaskCon.getPendingTasks();
			refreshTaskList(taskListView);
		});
		
		allTaskButton = new Button("All Tasks");
		allTaskButton.setOnAction(e -> {
			TaskCon.getAllTasks();
			refreshTaskList(taskListView);
		});
		
		HBox inputBox = new HBox(10, taskField, indexField, dueDatePicker, addButton, deleteButton, markCompletedButton, editButton, sortDueDateButton, sortPriorityButton, allTaskButton);
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
	
	private Integer parseIndex(String text) {
		try {
			return Integer.parseInt(text.trim());
		} catch (Exception ex) {
			return null;
		}
	}
	
	private void refreshTaskList(ListView<String> listView) {
		
		listView.getItems().clear();
		List<Task> allTasks = TaskCon.getAllTasks();
		int n = allTasks.size();
		
		for (int i = 0; i < n; i++) {
			
			Task t = allTasks.get(i);
			int negIndex = i - n;
			String line = "Index: " + i + " (or " + negIndex + ") | Task: " + t.getTitle() + " | Due: " + t.getDueDate() + " | Completed: " + t.isCompleted();
			listView.getItems().add(line);
			
		}
		
	}

}
