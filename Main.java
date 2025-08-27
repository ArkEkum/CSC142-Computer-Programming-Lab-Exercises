package taskmanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import javafx.event.ActionEvent;
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
	int index;
	Task Task;
	TaskController TaskCon = new TaskController();
	
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
		indexField.setPromptText("Enter index");
		dueDatePicker = new DatePicker();
		dueDatePicker.setPromptText("Enter due date");
		TaskCon = new TaskController();
		addButton = new Button("Add Task");
		addButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			TaskCon.addTask(TaskTitle,TaskDueDate);
		});
		deleteButton = new Button("Delete Task");
		deleteButton.setOnAction(e -> {
			try {
				index = Integer.parseInt(indexField.getText());	
			}
			catch (NumberFormatException error) {	
				// Error message
			}
			TaskCon.deleteTask(index);
		});		
		editButton = new Button("Edit Task");
		editButton.setOnAction(e -> {
			TaskTitle = taskField.getText();
			TaskDueDate = dueDatePicker.getValue();
			try {
				index = Integer.parseInt(indexField.getText());	
			}
			catch (NumberFormatException error) {	
				// Error message
			}
			TaskCon.editTask(index, TaskTitle, TaskDueDate);
		});
		markCompletedButton = new Button("Mark Task Complete");
		markCompletedButton.setOnAction(e -> {
			try {
				index = Integer.parseInt(indexField.getText());	
			}
			catch (NumberFormatException error) {	
				// Error message
			}
			TaskCon.markTaskCompleted(index);
		});		
		sortDueDateButton = new Button("Sort Tasks By Due Date");
		sortDueDateButton.setOnAction(e -> {
			TaskCon.sortByDueDate();
		});
		sortPriorityButton = new Button("Sort Tasks By Priority");
		sortPriorityButton.setOnAction(e -> {
			TaskCon.getPendingTasks();
		});
		allTaskButton = new Button("Show All Tasks");
		allTaskButton.setOnAction(e -> {
			TaskCon.getAllTasks();
		});
		HBox inputBox = new HBox(10, taskField, indexField, dueDatePicker, addButton, deleteButton, markCompletedButton, editButton, sortDueDateButton, sortPriorityButton, allTaskButton);
		inputBox.setStyle("-fx-padding: 10px;");
		ListView<String> taskListView = new ListView<>();
		taskListView.setPrefHeight(200);
		VBox root = new VBox(10, titleLabel, inputBox, taskListView);
		root.setStyle("-fx-padding: 20px;");
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setTitle("Task Organizer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
