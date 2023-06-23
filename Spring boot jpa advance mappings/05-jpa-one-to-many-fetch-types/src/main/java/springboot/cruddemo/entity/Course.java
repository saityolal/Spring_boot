package springboot.cruddemo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "course")
public class Course {

    // define our fields

    // define constructor

    // define getters and setters

    // define toString

    // anotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})  // While we indicate @ManyToOne or @OneToMany decide first according to entity
    // we dont want to delete instructor if we delete course
    @JoinColumn(name = "instructor_id") //In a One-to-Many/Many-to-One relationship, the owning side is usually defined on the many side of the relationship. It's usually the side that owns the foreign key.
    private Instructor instructor;


    public Course() {

    }

    public Course(String title) {
        this.title = title;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {

        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
