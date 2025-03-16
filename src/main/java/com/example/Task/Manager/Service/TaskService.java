package com.example.Task.Manager.Service;

import com.example.Task.Manager.Entity.Tasks;
import com.example.Task.Manager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Fetch all tasks
    public List<Tasks> fetchAllTasks() {
        return taskRepository.findAll();
    }

    // Save a new task (replacing addToTask for clarity)


    // Remove a task by ID
    public void removeTask(Long id) {
        Tasks task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }


    public void saveTask(Tasks task) {
        taskRepository.save(task); // Save new task
    }

    public void updateTask(Tasks task) {
        Tasks existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        taskRepository.save(existingTask);
    }
}