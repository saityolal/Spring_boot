package springboot.mvc;


import jakarta.validation.constraints.*;
import springboot.mvc.validation.CourseCode;

public class Customer {
    private String firstName;

    @NotNull(message = "is Required!")
    @Size(min = 1, message = "is Required!")
    private String lastName;

    @NotNull(message = "is Required!")
    @Min(value = 0, message = "must be equal or greater than 0")
    @Max(value = 10, message = "must be equal or less than 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message="only 5 char/digits are allowed")
    private String postalCode;

    @CourseCode(value = "CRS", message = "must start with CRS")
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    private String courseCode;
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
