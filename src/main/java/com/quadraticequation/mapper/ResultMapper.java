package com.quadraticequation.mapper;

import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.entity.QuadraticAnswers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResultMapper {
    Result toResult(QuadraticAnswers quadraticAnswers);
    QuadraticAnswers toQuadraticAnswers(Result result);
}
