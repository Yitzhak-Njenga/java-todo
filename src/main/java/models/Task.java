package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Task {

    private String description;
    private static ArrayList<Task> instances = new ArrayList<>();
    private boolean completed;
    private LocalDateTime createdAt;
    private int id;



    public Task(String description){
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();;
//        this.id = instances.size();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return getCompleted() == task.getCompleted() &&
                getId() == task.getId() &&
                Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getCompleted(), getId());
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Task> getAll(){
        return instances;
    }

    public static void clearAllTasks(){
        instances.clear();
    }

    public boolean getCompleted(){
        return this.completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public static Task findById(int id){
        return instances.get(id-1); //why minus 1? See if you can figure it out.
    }

    public void update(String content) {
        this.description = content;
    }

    public void deleteTask(){
        instances.remove(id-1); //same reason
    }
}
