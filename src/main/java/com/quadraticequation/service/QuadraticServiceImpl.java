package com.quadraticequation.service;

import com.quadraticequation.mapper.ResultMapper;
import com.quadraticequation.mapper.ValuesMapper;
import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.Request;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.model.entity.QuadraticValues;
import com.quadraticequation.repo.ResultRepository;
import com.quadraticequation.repo.ValuesRepository;
import com.quadraticequation.util.CalculateQuadraticEquation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadraticServiceImpl implements QuadraticService {
    private static final Logger LOG = LoggerFactory.getLogger(QuadraticServiceImpl.class);
    private final ValuesRepository valuesRepository;
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;
    private final ValuesMapper valuesMapper;

    public QuadraticServiceImpl(ValuesRepository valuesRepository, ResultRepository resultRepository,
                                ResultMapper resultMapper, ValuesMapper valuesMapper) {
        this.valuesRepository = valuesRepository;
        this.resultRepository = resultRepository;
        this.resultMapper = resultMapper;
        this.valuesMapper = valuesMapper;
    }

    @Override
    public Result quadraticEquation(Request request) {
        LOG.info("Расчитать квадратное уравнение с параметрами a = [{}], b = [{}], c = [{}]",
                request.getA(), request.getB(), request.getC());

        final Result result = CalculateQuadraticEquation
                .calculate(request.getA(), request.getB(), request.getC());
        final QuadraticAnswers quadraticAnswers = resultMapper.toQuadraticAnswers(result);
        LOG.info("Результат x1 = [{}], x2 = [{}]", result.getX1(), result.getX2());
        resultRepository.save(quadraticAnswers);
        LOG.info("Сохраняем ответ: [{}] в БД", quadraticAnswers);

        final QuadraticValues quadraticValues = valuesMapper.toQuadraticValues(request);
        quadraticValues.setAnswers(quadraticAnswers);
        valuesRepository.save(quadraticValues);
        LOG.info("Сохраняем переменные: [{}] в БД", quadraticValues);

        return result;
    }

    @Override
    public List<ValuesAndResults> getAllQuadraticValuesAndAnswers() {
        LOG.info("Выводим список всех переменных и их результаты");
        return valuesMapper.listValuesAndResults(valuesRepository.findAll());
    }
}
