package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
    private List<Question> questions;

    public Quiz(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public Quiz(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Quiz(String name, String description, String author, List<Question> questions) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.questions = questions;
    }

    public Quiz() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(name, quiz.name) &&
                Objects.equals(description, quiz.description) &&
                Objects.equals(author, quiz.author) &&
                Objects.equals(questions, quiz.questions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, author, questions);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
