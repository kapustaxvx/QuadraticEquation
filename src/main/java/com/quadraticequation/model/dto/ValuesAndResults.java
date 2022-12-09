package com.quadraticequation.model.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class ValuesAndResults {
    @NotNull
    @ApiModelProperty(notes = "a variable", example = "3", required = true)
    private Double a;
    @NotNull
    @ApiModelProperty(notes = "b variable", example = "1", required = true)
    private Double b;
    @NotNull
    @ApiModelProperty(notes = "c variable", example = "-5", required = true)
    private Double c;
    @NotNull
    @ApiModelProperty(notes = "x1 result", example = "-1.468", required = true)
    private Double x1;
    @NotNull
    @ApiModelProperty(notes = "x2 result", example = "1.135", required = true)
    private Double x2;

    public ValuesAndResults() {
    }

    public ValuesAndResults(Double a, Double b, Double c, Double x1, Double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1 = x1;
        this.x2 = x2;
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
}
