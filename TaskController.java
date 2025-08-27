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
		System.out.println();
		System.out.println("Task added: " + title + "; Due: " + dueDate);
	}
	
	public void deleteTask(int index) {	
		if (index >= 0 && index < tasks.size()) {
			Task removed = tasks.remove(index);
			System.out.println();
			System.out.println("Task deleted: " + removed.getTitle());
		}
	}
	
	public void editTask(int index, String newTitle, LocalDate newDueDate) {
		if (index >= 0 && index < tasks.size()) {
			Task task = tasks.get(index);
			task.setTitle(newTitle);
			task.setDueDate(newDueDate);
			System.out.println();
			System.out.println("Task updated: " + newTitle + "; Due: " + newDueDate);
		}
	}
	
	public void markTaskCompleted(int index) {	
		if (index >= 0 && index < tasks.size()) {
			tasks.get(index).setCompleted(true);
			System.out.println();
			System.out.println("Task Completed: " + tasks.get(index));
		}
	}
	
	public List<Task> getAllTasks() {	
		List<Task> allTasks = new ArrayList<>(tasks);
		System.out.println();
		for (Task AllTasks : tasks) {
			System.out.println(AllTasks);
		}
		return allTasks;
	}
	
	public List<Task> getPendingTasks() {
		List<Task> pendingTasks = new ArrayList<>();
		pendingTasks = tasks.stream().filter(t -> !t.isCompleted()).collect(Collectors.toList());
		System.out.println();
		for (Task PendingTasks : tasks) {
			System.out.println(PendingTasks);
		}
		return pendingTasks;
	}

	public List<Task> getCompletedTasks() {	
		List<Task> completedTasks = new ArrayList<>();
		completedTasks = tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
		System.out.println();
		for (Task CompletedTasks : tasks) {
			System.out.println(CompletedTasks);
		}
		return completedTasks;
	}
	
	public void sortByDueDate() {
		tasks.sort(Comparator.comparing(Task::getDueDate));
		System.out.println();
		for (Task TasksByDueDate : tasks) {
			System.out.println(TasksByDueDate);
		}
	}
	
}
