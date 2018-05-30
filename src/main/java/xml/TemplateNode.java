package xml;

import dao.Operation;

import java.util.Objects;


public class TemplateNode {
    private Operation operation;
    private String statement;

    public TemplateNode(Operation operation, String statement) {
        this.operation = operation;
        this.statement = statement;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemplateNode that = (TemplateNode) o;
        return operation == that.operation &&
                Objects.equals(statement, that.statement);
    }

    @Override
    public int hashCode() {

        return Objects.hash(operation, statement);
    }
}
