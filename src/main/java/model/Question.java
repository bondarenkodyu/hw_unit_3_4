package model;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "body")
    private String body;

    @Column(name = "is_right")
    private boolean isRight;

    @JoinColumn(name = "quiz_id")
    private int quizId;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                isRight == question.isRight &&
                Objects.equals(body, question.body);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, body, isRight);
    }


}
