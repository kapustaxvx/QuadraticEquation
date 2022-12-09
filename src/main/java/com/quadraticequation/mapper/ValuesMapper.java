package com.quadraticequation.mapper;

import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticValues;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ValuesMapper {
    QuadraticValues toQuadraticValues(Request quadraticRequest);

    @Mapping(target = "a", source = "quadraticValues.a")
    @Mapping(target = "b", source = "quadraticValues.b")
    @Mapping(target = "c", source = "quadraticValues.c")
    @Mapping(target = "x1", source = "quadraticValues.answers.x1")
    @Mapping(target = "x2", source = "quadraticValues.answers.x2")
    ValuesAndResults toValuesAndAnswers(QuadraticValues quadraticValues);


    List<ValuesAndResults> listValuesAndResults(List<QuadraticValues> quadraticValuesList);
}
