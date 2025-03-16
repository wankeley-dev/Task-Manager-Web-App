package com.example.Task.Manager.Repository;

import com.example.Task.Manager.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Tasks, Long> {


}
