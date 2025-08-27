package taskmanager;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Task {
	
	private String title;
	private LocalDate dueDate;
	private boolean isCompleted;
	
	public Task(String title, LocalDate dueDate) {
		this.title = title;
		this.dueDate = dueDate;
		this.isCompleted = false;
	}
	
	public String getTitle() {	
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(LocalDate dueDate) {	
		this.dueDate = dueDate;
	}
	
	public boolean isCompleted() {	
		return isCompleted;
	}
	
	public void setCompleted(boolean completed) {
		this.isCompleted = completed;
	}
	
	public String toString() {	
		String status = isCompleted ? "DONE" : "PENDING";
		return String.format("[%s] %s (Due: %s)", status, title, dueDate);
	}
	
}
