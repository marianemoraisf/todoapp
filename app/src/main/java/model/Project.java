package model;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Project {

    private int id;
    private String name;
    private String description;
    private List<Task> tasks;
    private Date created;
    private Date updated;
    private static final Logger LOG = Logger.getLogger(Project.class.getName());

    public Project(int id, String name, String description, List<Task> tasks, Date created, Date updated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.created = created;
        this.updated = updated;
    }

    public Project() {
        this.created = new Date();
        this.updated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
