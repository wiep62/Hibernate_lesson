package com.skillbox.hibernate.manyToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "universities")
@NamedQueries({
        @NamedQuery(name = "withStudents", query = "SELECT u FROM University u JOIN FETCH u.students WHERE u.id = :id")
})
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Transient
    private String test;

    @OneToMany(mappedBy = "university"/*,fetch = fetchType.EAGER - если так будет то вытащим всю БД*/)  //todo 1 универ ко многим студентам
    private List<Student> students; //TODO СПИСОК СТУДЕНТОВ. если зайдем в студенты то увидим поля студентов, присоединяем ДЖОЙН М к 1 . ЛИСТ УНИВЕРСИТЕТ ВСЕГДА БУДЕТ ОДИН
//todo если достанем 1-го студента то у него достанем только 1 универ к которому он принадлежит. Но если достанем универ, мы достанем всех студентов которые там учатся
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University() {
    }

    @Override
    public String toString() {
        return String.format("University [id = %d, title = %s, students_count = %d]", id, title, students.size());
    }
}
