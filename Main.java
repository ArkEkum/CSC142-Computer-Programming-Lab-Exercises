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
	Button sortButton;
	String TaskTitle;
	LocalDate TaskDueDate;
	int index;
	Task Task;
	TaskController TaskCon = new TaskController();
	List<Task> tasks = TaskCon.getAllTasks();
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		Label titleLabel = new Label("📝 Task Organizer");
		titleLabel.setStyle("-fx-font-size: 24px; -fx-padding: 10px;");
		
		TextField taskField = new TextField();
		taskField.setPromptText("Enter task name");
		
		TextField indexField = new TextField();
		indexField.setPromptText("Enter index");
		
		DatePicker dueDatePicker = new DatePicker();
		dueDatePicker.setPromptText("Enter due date");
		
		TaskTitle = taskField.getText();
		TaskDueDate = dueDatePicker.getValue();
		
		try {		
		index = Integer.parseInt(indexField.getText());		
		} catch (NumberFormatException error) {
		}
		
		TaskCon = new TaskController();
		addButton = new Button("Add Task");
		deleteButton = new Button("Delete Task");
		editButton = new Button("Edit Task");
		sortButton = new Button("Sort Task");
		
		HBox inputBox = new HBox(10, taskField, indexField, dueDatePicker, addButton, deleteButton, editButton, sortButton);
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
	
	public void AddTask(ActionEvent click) {
		
		if (click.getSource() == addButton) {
			
			TaskCon.addTask(TaskTitle,TaskDueDate);
			
		}
		
		else if (click.getSource() == deleteButton) {
			
			TaskCon.deleteTask(index);
			
		}
		
		else if (click.getSource() == editButton) {
			
			TaskCon.editTask(index, TaskTitle, TaskDueDate);
			
		}
		
	}
	
}
