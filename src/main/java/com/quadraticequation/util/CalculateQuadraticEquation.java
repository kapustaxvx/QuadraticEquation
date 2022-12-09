package com.quadraticequation.util;

import com.quadraticequation.exception.CalculateException;
import com.quadraticequation.model.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateQuadraticEquation {
    private static Logger LOG = LoggerFactory.getLogger(CalculateQuadraticEquation.class);
    public static Result calculate(Double a, Double b, Double c){
        final double descr = b * b - 4 * a * c;
        final double x1, x2;
        if (descr > 0) {
            x1 = (-b - Math.sqrt(descr)) / (2 * a);
            x2 = (-b + Math.sqrt(descr)) / (2 * a);
        }
        else if (descr == 0) {
            x1 = -b / (2 * a);
            x2 = -b / (2 * a);
        }
        else {
            throw  new CalculateException("Уравнение не имеет действительных корней!");
        }

        return new Result(mapper(x1), mapper(x2));
    }

    private static double mapper(double value) {
        return new BigDecimal(value).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
    }
}
