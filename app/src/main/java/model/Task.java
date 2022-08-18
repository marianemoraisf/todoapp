package model;

import java.util.Date;
import java.util.logging.Logger;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private byte status;   
    private String notes;
    private Date deadline;
    private boolean completed;
    private Date created;
    private Date updated;
    private static final Logger LOG = Logger.getLogger(Task.class.getName());

    public Task() {
        this.completed = false;
        this.created = new Date();
        this.updated = new Date();
    }

    public Task(String name, String description, byte status, String notes, Date deadline, boolean isCompleted, Date created, Date updated) {
        this.name = name;
        this.description = description;
        this.status = status;       
        this.notes = notes;
        this.deadline = deadline;
        this.completed = isCompleted;
        this.created = created;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

        public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
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

}
