package springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


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
    // we don't want to delete instructor if we delete course
    @JoinColumn(name = "instructor_id") //In a One-to-Many/Many-to-One relationship, the owning side is usually defined on the many side of the relationship. It's usually the side that owns the foreign key.
    private Instructor instructor;

    @OneToMany(
          //  mappedBy = "course", if it is used here then might not have course_id in review table and can't use with @JoinColumn annotation at the same time
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")  // refers to course_id in Review table also its foreign key
    private List<Review> reviews;


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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void setInstructor(Instructor instructor) {

        this.instructor = instructor;
    }

    // add convenience method
    public void addReview(Review theReview){

        if(reviews == null){
            reviews = new ArrayList<>();
        }

        reviews.add(theReview);

    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
