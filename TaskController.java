package taskmanager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class TaskController {
	
	private List<Task> tasks = new ArrayList<>(); // ArrayList created to store all tasks.
	
	private int normalizeIndex(int index) { // Method sets negative index of tasks.
		int size = tasks.size();
		if (size == 0) {
			return -1;
		}
		if (index < 0) {	
			index = size + index;
		}
		if (index >= 0 && index < size) {	
			return index;
		}
		return -1;
	}
	
	public void addTask(String title, LocalDate dueDate) { // Method adds task name and due date.
		if (title == null || title.isBlank() || dueDate == null) {
			System.out.println("Add Failed: Title and Due Date are required."); // Error message for empty task name/due date.
			return;
		}
		tasks.add(new Task(title, dueDate)); // Task name and due date added into ArrayList.
		System.out.println();
		System.out.println("Task added: " + title + "; Due: " + dueDate); // Displays added task name and due date.
	}
	
	public void deleteTask(int index) {	// Method deletes task from ArrayList.
		int i = normalizeIndex(index);
		if (i == -1) {
			System.out.println("Delete failed: No such task index (" + index + ")."); // Error message for invalid task index.
			return;
		}
		Task removed = tasks.remove(i); // Task name and due date are removed from ArrayList.
			System.out.println();
			System.out.println("Task deleted: " + removed.getTitle()); // Displays name of task deleted.
	}
	
	public void editTask(int index, String newTitle, LocalDate newDueDate) { // Method edits task from ArrayList.
		int i = normalizeIndex(index);
		if (i == -1) {
			System.out.println("Update failed: No such task index (" + index + ")."); // Error message for invalid task index.
			return;
		}
		if (newTitle == null || newTitle.isBlank() || newDueDate == null) {
			System.out.println("Update failed: Title and Due Date are required."); // Error message for empty task name and due date.
			return;
		}
		Task task = tasks.get(i);
		task.setTitle(newTitle); // New task name added.
		task.setDueDate(newDueDate); // New task due date added.
		System.out.println();
		System.out.println("Task updated: " + newTitle + "; Due: " + newDueDate); // Displays new task name and due date.
	}
	
	public void markTaskCompleted(int index) { // Method marks task complete from ArrayList.
		int i = normalizeIndex(index);
		if (i == -1) {
			System.out.println("Complete failed: No such task index (" + index + ")."); // Error message for invalid task index.
			return;
		}
		tasks.get(i).setCompleted(true); // Task is set to complete.
		System.out.println();
		System.out.println("Task Completed: " + tasks.get(index)); // Displays name of task completed.
	}
	
	public List<Task> getAllTasks() { // Method gets all tasks from ArrayList.
		List<Task> allTasks = new ArrayList<>(tasks); // Temporary ArrayList is created.
		System.out.println();
		for (Task AllTasks : tasks) {
			System.out.println(AllTasks); // Displays all tasks in ArrayList.
		}
		return allTasks;
	}
	
	public List<Task> getPendingTasks() { // Method gets all incomplete tasks from ArrayList.
		List<Task> pendingTasks = new ArrayList<>(); // Temporary ArrayList is created.
		pendingTasks = tasks.stream().filter(t -> !t.isCompleted()).collect(Collectors.toList()); // All incomplete tasks are added into temporary ArrayList.
		System.out.println();
		for (Task PendingTasks : tasks) {
			System.out.println(PendingTasks); // Displays all incomplete tasks in ArrayList.
		}
		return pendingTasks;
	}

	public List<Task> getCompletedTasks() { // Method gets all completed tasks from ArrayList.
		List<Task> completedTasks = new ArrayList<>(); // Temporary ArrayList is created.
		completedTasks = tasks.stream().filter(Task::isCompleted).collect(Collectors.toList()); // All completed tasks are added into temporary ArrayList.
		System.out.println();
		for (Task CompletedTasks : tasks) {
			System.out.println(CompletedTasks); // Displays all completed tasks in ArrayList.
		}
		return completedTasks;
	}
	
	public void sortByDueDate() { // Method sorts all tasks in ArrayList by due date.
		tasks.sort(Comparator.comparing(Task::getDueDate)); // All tasks are sorted by due date.
		System.out.println();
		for (Task TasksByDueDate : tasks) {
			System.out.println(TasksByDueDate); // Displays all tasks by due date from ArrayList.
		}
	}
	
}
