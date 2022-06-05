package entity;

import javax.persistence.*;

@Entity
@Table(name = "todolist", schema = "module5")
public class TodolistEntity {
    @Basic
    @Column(name = "tasks")
    private String tasks;
    @Id
    private Long id;

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodolistEntity that = (TodolistEntity) o;

        if (tasks != null ? !tasks.equals(that.tasks) : that.tasks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tasks != null ? tasks.hashCode() : 0;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
