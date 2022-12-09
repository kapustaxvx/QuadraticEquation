package com.quadraticequation.model.entity;


import javax.persistence.*;

@Entity
@Table(name = "quadratic_answers")
public class QuadraticAnswers {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "quadratic_answers_sequence",
            sequenceName = "quadratic_answers_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "quadratic_answers_sequence")
    private Long id;

    @Column(name = "x1", nullable = false)
    private Double x1;
    @Column(name = "x2", nullable = false)
    private Double x2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "QuadraticAnswers{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
