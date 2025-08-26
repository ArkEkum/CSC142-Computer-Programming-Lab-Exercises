package taskmanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class TaskController {
	
	private List<Task> tasks = new ArrayList<>();
	
	public void addTask(String title, LocalDate dueDate) {
		
		tasks.add(new Task(title, dueDate));
		System.out.println("Task added: " + title);
		
	}
	
	public void deleteTask(int index) {	
		
		if (index >= 0 && index < tasks.size()) {
			
			Task removed = tasks.remove(index);
			System.out.println("Task deleted: " + removed.getTitle());
			
		}
		
	}
	
	public void editTask(int index, String newTitle, LocalDate newDueDate) {
		
		if (index >= 0 && index < tasks.size()) {
			
			Task task = tasks.get(index);
			task.setTitle(newTitle);
			task.setDueDate(newDueDate);
			System.out.println("Task updated: " + newTitle);
			
		}
		
	}
	
	public void markTaskCompleted(int index) {	
		
		if (index >= 0 && index < tasks.size()) {
			
			tasks.get(index).setCompleted(true);
			System.out.println("Task completed!");
			
		}
		
	}
	
	public List<Task> getAllTasks() {	
		
		return new ArrayList<>(tasks);
		
	}
	
	public List<Task> getPendingTasks() {	
		
		return tasks.stream().filter(t -> !t.isCompleted()).collect(Collectors.toList());
		
	}
	
	public List<Task> getCompletedTasks() {	
		
		return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
		
	}
	
	public void sortByDueDate() {	
		
		tasks.sort(Comparator.comparing(Task::getDueDate));
		
	}
	
}
