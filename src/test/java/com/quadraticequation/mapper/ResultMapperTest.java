package com.quadraticequation.mapper;

import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMapperTest {
    private ResultMapper resultMapper = Mappers.getMapper(ResultMapper.class);
    @Test
    public void toResult(){
        Result result = DataTest.result();
        QuadraticAnswers quadraticAnswers = resultMapper.toQuadraticAnswers(result);
        assertThat(quadraticAnswers.getX1()).isEqualTo(result.getX1());
        assertThat(quadraticAnswers.getX2()).isEqualTo(result.getX2());
    }

    @Test
    public void toQuadraticAnswers(){
        QuadraticAnswers quadraticAnswers = DataTest.quadraticAnswers();
        Result result = resultMapper.toResult(quadraticAnswers);
        assertThat(result.getX1()).isEqualTo(quadraticAnswers.getX1());
        assertThat(result.getX2()).isEqualTo(quadraticAnswers.getX2());
    }
}