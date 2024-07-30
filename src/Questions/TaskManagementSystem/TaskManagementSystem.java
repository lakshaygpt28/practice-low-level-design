package Questions.TaskManagementSystem;

import java.time.LocalDate;
import java.util.List;

public class TaskManagementSystem {
    public static void main (String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User user1 = new User(1, "User1");
        User user2 = new User(2, "User2");

        Task task1 = new Task(1, "Title 1", "Description 1", LocalDate.now(), Priority.MEDIUM, user1);
        Task task2 = new Task(2, "Title 2", "Description 2", LocalDate.now(), Priority.LOW, user1);
        Task task3 = new Task(3, "Title 3", "Description 3", LocalDate.now(), Priority.HIGH, user2);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        // Update a task
        task2.setDescription("Updated description");
        taskManager.updateTask(task2);

        // Search tasks
        List<Task> searchResults = taskManager.searchTasks("Title");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter tasks
        List<Task> filteredTasks = taskManager.filterTasks(TaskStatus.NOT_STARTED, LocalDate.parse("2023-01-01"), LocalDate.parse("2025-01-01"), Priority.HIGH);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as completed
        taskManager.markTaskAsCompleted(1);

        // Get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskManager.deleteTask(3);

        searchResults = taskManager.searchTasks("Title");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

    }
}
