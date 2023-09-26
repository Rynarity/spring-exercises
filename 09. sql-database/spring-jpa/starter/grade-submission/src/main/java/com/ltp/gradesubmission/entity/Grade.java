package com.ltp.gradesubmission.entity;

import javax.persistence.*;

@Entity
@Table(name = "grade", uniqueConstraints = {
        @UniqueConstraint(columnNames =  {"student_id", "course_id"})
})
public class Grade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne(optional = false)
    @JoinColumns({
            @JoinColumn(name="student_id", referencedColumnName = "id"),
            @JoinColumn(name="student_name", referencedColumnName = "name")
    })
    private Student student;

    @ManyToOne(optional = false)
//    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @JoinColumns({
            @JoinColumn(name="course_id", referencedColumnName = "id"),
            @JoinColumn(name="course_name", referencedColumnName = "subject")
    })
    private Course course;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
