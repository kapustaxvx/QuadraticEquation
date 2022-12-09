package com.quadraticequation.controller;

import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticValues;
import com.quadraticequation.service.QuadraticService;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class QuadraticControllerTest {

    @InjectMocks
    private QuadraticController quadraticController;
    @Mock
    QuadraticService quadraticService;

    @Test
    public void testCalculateQuadratic() {
        Result resultMock = DataTest.result();

        when(quadraticService.quadraticEquation(any(Request.class))).thenReturn(resultMock);
        Request requestMock = DataTest.request();

        ResponseEntity<Result> responseEntity = quadraticController.quadraticEquation(requestMock);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody()).isEqualTo(resultMock);
    }

    @Test
    public void getAllValuesAndResults(){
        List<ValuesAndResults> valuesAndResultsListMock = DataTest.createValuesAndResultsList();

        when(quadraticService.getAllQuadraticValuesAndAnswers()).thenReturn(valuesAndResultsListMock);

        ResponseEntity<List<ValuesAndResults>> responseEntity = quadraticController.getAllQuadraticValuesAndAnswers();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().size()).isEqualTo(valuesAndResultsListMock.size());
    }
}