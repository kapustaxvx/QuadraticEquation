package com.quadraticequation.controller;

import com.quadraticequation.model.dto.Result;
import com.quadraticequation.model.dto.ValuesAndResults;
import com.quadraticequation.service.QuadraticService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quadraticequation.model.dto.Request;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/api")
public class QuadraticController {

    private final QuadraticService quadraticService;

    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @ApiOperation(value = "Calculate quadratic equation ", notes = "Returns an answer of this equation")
    @PostMapping(value = "/calculate")
    public ResponseEntity<Result> quadraticEquation(@Valid @RequestBody Request request){
        return ok(quadraticService.quadraticEquation(request));
    }

    @ApiOperation(value = "Get all values and results ", notes = "Returns all calculations and answers of them")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ValuesAndResults>> getAllQuadraticValuesAndAnswers(){
        return ok(quadraticService.getAllQuadraticValuesAndAnswers());
    }
}

