package com.quadraticequation.repo;

import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.model.entity.QuadraticValues;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ValuesRepositoryTest {
    @Autowired
    ValuesRepository valuesRepository;

    public void saveNewValues(){
        QuadraticAnswers quadraticAnswers = DataTest.quadraticAnswers();
        QuadraticValues quadraticValues = DataTest.quadraticValues();
        quadraticValues.setAnswers(quadraticAnswers);

        QuadraticValues quadraticValuesSave = valuesRepository.save(quadraticValues);
        QuadraticValues quadraticValuesFromDB = valuesRepository.findById(quadraticValuesSave.getId()).get();

        assertEquals(quadraticValuesFromDB.getA(), quadraticValues.getA());
        assertEquals(quadraticValuesFromDB.getB(), quadraticValues.getB());
        assertEquals(quadraticValuesFromDB.getC(), quadraticValues.getC());
        assertEquals(quadraticValuesFromDB.getAnswers(), quadraticValues.getAnswers());

        valuesRepository.deleteAll();
        assertThat(valuesRepository.findAll()).isEmpty();
    }
}