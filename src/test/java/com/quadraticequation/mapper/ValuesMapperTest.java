package com.quadraticequation.mapper;

import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticValues;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValuesMapperTest {

    private ValuesMapper mapper = Mappers.getMapper(ValuesMapper.class);

    @Test
    void toQuadraticValues() {
        Request request = DataTest.request();
        QuadraticValues quadraticValues = mapper.toQuadraticValues(request);
        assertEquals(request.getA(), quadraticValues.getA());
        assertEquals(request.getB(), quadraticValues.getB());
        assertEquals(request.getC(), quadraticValues.getC());
    }

    @Test
    void toValuesAndAnswers() {
        QuadraticValues quadraticValues = DataTest.quadraticValues();
        ValuesAndResults valuesAndResults = mapper.toValuesAndAnswers(quadraticValues);
        assertEquals(quadraticValues.getA(), valuesAndResults.getA());
        assertEquals(quadraticValues.getB(), valuesAndResults.getB());
        assertEquals(quadraticValues.getC(), valuesAndResults.getC());
        assertEquals(quadraticValues.getAnswers().getX1(), valuesAndResults.getX1());
        assertEquals(quadraticValues.getAnswers().getX2(), valuesAndResults.getX2());
    }

    @Test
    void listValuesAndResults() {
        List<QuadraticValues> quadraticValuesList = DataTest.createQuadraticList();
        List<ValuesAndResults> valuesAndResultsList = mapper.listValuesAndResults(quadraticValuesList);

        assertEquals(quadraticValuesList.size(), valuesAndResultsList.size());
    }
}