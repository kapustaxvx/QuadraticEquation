package com.quadraticequation.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Result {
    @NotNull
    @ApiModelProperty(notes = "x1 result", example = "-1.468", required = true)
    private Double x1;
    @NotNull
    @ApiModelProperty(notes = "x2 result", example = "1.135", required = true)
    private Double x2;

    public Result() {
    }

    public Result(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(x1, result.x1) && Objects.equals(x2, result.x2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2);
    }

    @Override
    public String toString() {
        return "Result{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }
}
