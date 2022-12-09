package com.quadraticequation.service;

import com.quadraticequation.mapper.ResultMapper;
import com.quadraticequation.mapper.ValuesMapper;
import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.model.entity.QuadraticValues;
import com.quadraticequation.repo.ResultRepository;
import com.quadraticequation.repo.ValuesRepository;
import com.quadraticequation.util.CalculateQuadraticEquation;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuadraticServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(QuadraticServiceTest.class);
    @InjectMocks
    QuadraticServiceImpl quadraticService;
    @Mock
    private ValuesRepository valuesRepository;
    @Mock
    private ResultRepository resultRepository;
    @Mock
    private ResultMapper resultMapper;
    @Mock
    private ValuesMapper valuesMapper;

    @Test
    void calculateTest() {
        Request request = DataTest.request();
        Result result = new Result();
        result.setX1(-2.174d);
        result.setX2(1.84d);
        Result resultTest = CalculateQuadraticEquation.calculate(request.getA(), request.getB(), request.getC());
        assertThat(resultTest).isEqualTo(result);
    }

    @Test
    void quadraticEquation(){
        QuadraticValues quadraticValuesMock1 = mock(QuadraticValues.class);
        Request requestMock = DataTest.request();
        Result resultMock = DataTest.result();
        QuadraticAnswers quadraticAnswersMock = DataTest.quadraticAnswers();
        QuadraticValues quadraticValuesMock = DataTest.quadraticValues();

        when(resultMapper.toQuadraticAnswers(any(Result.class))).thenReturn(quadraticAnswersMock);
        when(resultRepository.save(any(QuadraticAnswers.class))).thenReturn(quadraticAnswersMock);
        when(valuesMapper.toQuadraticValues(any(Request.class))).thenReturn(quadraticValuesMock);
        when(valuesRepository.save(any(QuadraticValues.class))).thenReturn(quadraticValuesMock);

        Result result = quadraticService.quadraticEquation(requestMock);

        verify(resultMapper, times(1)).toQuadraticAnswers(any());
        verify(resultRepository, times(1)).save(any());
        verify(valuesMapper, times(1)).toQuadraticValues(any());
        verify(valuesRepository, times(1)).save(any());

        assertEquals(result.getX1(), resultMock.getX1());
        assertEquals(result.getX2(), resultMock.getX2());
    }

    @Test
    public void getAllQuadraticValuesAndAnswers() {
        List<ValuesAndResults> valuesAndResultsListMock = DataTest.createValuesAndResultsList();
        List<QuadraticValues> quadraticValuesListMock = DataTest.createQuadraticList();

        when(valuesRepository.findAll()).thenReturn(quadraticValuesListMock);
        when(valuesMapper.listValuesAndResults(any())).thenReturn(valuesAndResultsListMock);

        List<ValuesAndResults> valuesAndResultsList = quadraticService.getAllQuadraticValuesAndAnswers();

        verify(valuesRepository, times(1)).findAll();
        verify(valuesMapper, times(1)).listValuesAndResults(anyList());

        assertEquals(valuesAndResultsList.size(), valuesAndResultsListMock.size());
    }
}