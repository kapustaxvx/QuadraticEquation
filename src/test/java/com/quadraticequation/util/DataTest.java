package com.quadraticequation.util;

import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.model.entity.QuadraticValues;

import java.util.ArrayList;
import java.util.List;

public class DataTest {

    public static Request request(){
        Request request = new Request();
        request.setA(3d);
        request.setB(1d);
        request.setC(-12d);
        return request;
    }

    public static Result result(){
        Result result = new Result();
        result.setX1(-2.174);
        result.setX2(1.84);
        return result;
    }
    public static QuadraticAnswers quadraticAnswers(){
        QuadraticAnswers quadraticAnswers = new QuadraticAnswers();
        quadraticAnswers.setX1(-2.174);
        quadraticAnswers.setX2(1.84);
        return quadraticAnswers;
    }

    public static QuadraticValues quadraticValues(){
        QuadraticValues quadraticValues = new QuadraticValues();
        quadraticValues.setA(3d);
        quadraticValues.setB(1d);
        quadraticValues.setC(-12d);
        quadraticValues.setAnswers(quadraticAnswers());
        return quadraticValues;
    }

    public static List<ValuesAndResults> createValuesAndResultsList(){
        List<ValuesAndResults> valuesAndResultsList = new ArrayList<>();

        ValuesAndResults valuesAndResults1 = new ValuesAndResults();
        ValuesAndResults valuesAndResults2 = new ValuesAndResults();
        ValuesAndResults valuesAndResults3 = new ValuesAndResults();
        ValuesAndResults valuesAndResults4 = new ValuesAndResults();

        valuesAndResults1.setA(3d);
        valuesAndResults1.setB(1d);
        valuesAndResults1.setC(-12d);
        valuesAndResults1.setX1(-2.174);
        valuesAndResults1.setX2(1.84);

        valuesAndResults2.setA(-3d);
        valuesAndResults2.setB(-1d);
        valuesAndResults2.setC(5d);
        valuesAndResults2.setX1(1.135);
        valuesAndResults2.setX2(-1.468);

        valuesAndResults3.setA(-32d);
        valuesAndResults3.setB(10d);
        valuesAndResults3.setC(5d);
        valuesAndResults3.setX1(0.581);
        valuesAndResults3.setX2(-0.269);

        valuesAndResults4.setA(-3d);
        valuesAndResults4.setB(0d);
        valuesAndResults4.setC(5d);
        valuesAndResults4.setX1(1.291);
        valuesAndResults4.setX2(-1.291);

        valuesAndResultsList.add(valuesAndResults1);
        valuesAndResultsList.add(valuesAndResults2);
        valuesAndResultsList.add(valuesAndResults3);
        valuesAndResultsList.add(valuesAndResults4);
        return valuesAndResultsList;
    }
    public static List<QuadraticValues> createQuadraticList(){
        List<QuadraticValues> quadraticValuesList = new ArrayList<>();

        QuadraticValues quadraticValues1 = new QuadraticValues();
        QuadraticValues quadraticValues2 = new QuadraticValues();
        QuadraticValues quadraticValues3 = new QuadraticValues();
        QuadraticValues quadraticValues4 = new QuadraticValues();

        QuadraticAnswers quadraticAnswers1 = new QuadraticAnswers();
        QuadraticAnswers quadraticAnswers2 = new QuadraticAnswers();
        QuadraticAnswers quadraticAnswers3 = new QuadraticAnswers();
        QuadraticAnswers quadraticAnswers4 = new QuadraticAnswers();

        quadraticValues1.setA(3d);
        quadraticValues1.setB(1d);
        quadraticValues1.setC(-12d);
        quadraticAnswers1.setX1(-2.174);
        quadraticAnswers1.setX2(1.84);
        quadraticValues1.setAnswers(quadraticAnswers1);

        quadraticValues2.setA(-3d);
        quadraticValues2.setB(-1d);
        quadraticValues2.setC(5d);
        quadraticAnswers2.setX1(1.135);
        quadraticAnswers2.setX2(-1.468);
        quadraticValues2.setAnswers(quadraticAnswers2);

        quadraticValues3.setA(-32d);
        quadraticValues3.setB(10d);
        quadraticValues3.setC(5d);
        quadraticAnswers3.setX1(0.581);
        quadraticAnswers3.setX2(-0.269);
        quadraticValues3.setAnswers(quadraticAnswers3);

        quadraticValues4.setA(-3d);
        quadraticValues4.setB(0d);
        quadraticValues4.setC(5d);
        quadraticAnswers4.setX1(1.291);
        quadraticAnswers4.setX2(-1.291);
        quadraticValues4.setAnswers(quadraticAnswers4);

        quadraticValuesList.add(quadraticValues1);
        quadraticValuesList.add(quadraticValues2);
        quadraticValuesList.add(quadraticValues3);
        quadraticValuesList.add(quadraticValues4);
        return quadraticValuesList;
    }
}
