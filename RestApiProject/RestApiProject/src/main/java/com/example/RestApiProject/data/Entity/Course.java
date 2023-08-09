package com.example.RestApiProject.data.Entity;

public class Course {
    private int id;
    private String title;
    private String description;
    // Shift + select all you want to create constructors for
    public Course(int id, String title, String description) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
    }
    // default constructor
    public Course(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + '}';
    }
    // Entity class is ready
}