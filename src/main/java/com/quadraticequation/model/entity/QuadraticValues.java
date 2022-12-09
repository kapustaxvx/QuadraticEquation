package com.quadraticequation.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "quadratic_values")
public class QuadraticValues {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "quadratic_values_sequence",
            sequenceName = "quadratic_values_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "quadratic_values_sequence")
    private Long id;

    @Column(name = "a", nullable = false)
    private Double a;
    @Column(name="b", nullable = false)
    private Double b;
    @Column(name="c", nullable = false)
    private Double c;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_answer_id", referencedColumnName = "id")
    private QuadraticAnswers answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public QuadraticAnswers getAnswers() {
        return answers;
    }

    public void setAnswers(QuadraticAnswers answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuadraticValues{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", answers=" + answers +
                '}';
    }
}
