package Questions.TaskManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskManager {
    private static TaskManager instance;
    private final Map<Integer, User> users;
    private final Map<Integer, Task> tasks;
    private final Map<Integer, List<Task>> userTask;
    private TaskManager() {
        users = new ConcurrentHashMap<>();
        tasks = new ConcurrentHashMap<>();
        userTask = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
        assignUserToTask(task.getAssignedUser(), task);
    }

    public void updateTask(Task updatedTask) {
        Task oldTask = tasks.get(updatedTask.getId());
        if (oldTask != null) {
            tasks.put(updatedTask.getId(), updatedTask);
        }
    }

    public void deleteTask(int taskId) {
        Task task = tasks.remove(taskId);
        if (task != null) {
            unassignTaskFromUser(task.getAssignedUser(), task);
        }
    }

    public List<Task> searchTasks(String keyword) {
        List<Task> searchedTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.getTitle().contains(keyword) || task.getDescription().contains(keyword)) {
                searchedTasks.add(task);
            }
        }
        return searchedTasks;
    }

    public List<Task> filterTasks(TaskStatus taskStatus, LocalDate startDate, LocalDate endDate, Priority priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks.values()) {
            int startDateComparison = task.getDueDate().compareTo(startDate);
            int endDateComparison = task.getDueDate().compareTo(endDate);
            if (task.getStatus().equals(taskStatus)
            && startDateComparison >= 0
            && endDateComparison <= 0
            && task.getPriority().equals(priority)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    public void assignUserToTask(User user, Task task) {
        unassignTaskFromUser(task.getAssignedUser(), task);
        task.setAssignedUser(user);
        userTask.computeIfAbsent(user.getId(), k -> new CopyOnWriteArrayList<>()).add(task);
    }

    public void unassignTaskFromUser(User user, Task task) {
        List<Task> userTasks = userTask.get(user.getId());
        if (userTasks != null) {
            userTasks.remove(task);
        }
    }

    public void markTaskAsCompleted(int taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setStatus(TaskStatus.COMPLETED);
        }
    }

    public List<Task> getTaskHistory(User user) {
        return userTask.getOrDefault(user.getId(), new ArrayList<>());
    }
}
