package taskmanager;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Task {
	
	private String title;
	private LocalDate dueDate;
	private boolean isCompleted;
	
	public Task(String title, LocalDate dueDate) { // Method sets task name, due date, and completion status.
		this.title = title;
		this.dueDate = dueDate;
		this.isCompleted = false;
	}
	
	public String getTitle() { // Method gets task name.
		return title;
	}
	
	public void setTitle(String title) { // Method sets task name.
		this.title = title;
	}
	
	public LocalDate getDueDate() { // Method gets task due date.
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate) { // Method sets task due date.
		this.dueDate = dueDate;
	}
	
	public boolean isCompleted() { // Method gets task completion status.
		return isCompleted;
	}
	
	public void setCompleted(boolean completed) { // Method sets task completion status.
		this.isCompleted = completed;
	}
	
	public String toString() { // Method displays task completion status.
		String status = isCompleted ? "DONE" : "PENDING";
		return String.format("[%s] %s (Due: %s)", status, title, dueDate);
	}
	
}
