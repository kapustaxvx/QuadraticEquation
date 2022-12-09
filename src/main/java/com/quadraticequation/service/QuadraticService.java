package com.quadraticequation.service;

import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.ValuesAndResults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuadraticService {

    Result quadraticEquation(Request request);

    List<ValuesAndResults> getAllQuadraticValuesAndAnswers();
}
