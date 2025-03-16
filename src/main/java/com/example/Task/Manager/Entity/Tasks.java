package com.example.Task.Manager.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks") // Optional: explicitly name the table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Title is required
    private String title;

    private String description;

    @Column(name = "created_at", nullable = false, updatable = false) // Immutable creation timestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at") // Last update timestamp
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Status is required
    private Status status;

    // Enum definition inside the class
    public enum Status {
        PENDING,
        COMPLETED
    }

    // Optional: Set default values or hooks
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = Status.PENDING; // Default status
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}