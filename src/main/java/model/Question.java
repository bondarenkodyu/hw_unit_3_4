package model;

import java.util.Objects;

public class Question {

    private int id;
    private String body;
    private boolean isRight;

    public Question(int id, String body, boolean isRight) {
        this.id = id;
        this.body = body;
        this.isRight = isRight;
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