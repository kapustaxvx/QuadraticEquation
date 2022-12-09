package com.quadraticequation.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Request {
    @NotNull
    @ApiModelProperty(notes = "a variable", example = "3", required = true)
    private Double a;
    @NotNull
    @ApiModelProperty(notes = "b variable", example = "1", required = true)
    private Double b;
    @NotNull
    @ApiModelProperty(notes = "c variable", example = "-5", required = true)
    private Double c;

    public Request() {
    }

    public Request(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(a, request.a) && Objects.equals(b, request.b) && Objects.equals(c, request.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
