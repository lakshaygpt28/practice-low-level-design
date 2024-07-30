package Questions.TaskManagementSystem;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private Priority priority;
    private User assignedUser;

    public Task(int id, String title, String description, LocalDate dueDate, Priority priority, User assignedUser) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignedUser = assignedUser;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(User assignedUser) {
        this.assignedUser = assignedUser;
    }
}
