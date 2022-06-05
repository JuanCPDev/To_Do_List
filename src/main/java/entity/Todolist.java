package entity;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "listTasks", query = "SELECT t from Todolist t ")
public class Todolist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "task")
    private String task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Todolist todolist = (Todolist) o;

        if (id != null ? !id.equals(todolist.id) : todolist.id != null) return false;
        if (task != null ? !task.equals(todolist.task) : todolist.task != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Todolist{" +
                "id=" + id +
                ", task='" + task + '\'' +
                '}';
    }
}
