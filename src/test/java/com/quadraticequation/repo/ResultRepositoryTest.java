package com.quadraticequation.repo;

import com.quadraticequation.model.entity.QuadraticAnswers;
import com.quadraticequation.util.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class ResultRepositoryTest {
    @Autowired
    ResultRepository resultRepository;

    @Test
    public void saveNewResult() {
        QuadraticAnswers quadraticAnswers = DataTest.quadraticAnswers();
        QuadraticAnswers quadraticSave = resultRepository.save(quadraticAnswers);
        QuadraticAnswers quadraticAnswersFromDB = resultRepository.findById(quadraticSave.getId()).get();

        assertEquals(quadraticAnswers.getX1(), quadraticAnswersFromDB.getX1());
        assertEquals(quadraticAnswers.getX2(), quadraticAnswersFromDB.getX2());

        resultRepository.deleteAll();
        assertThat(resultRepository.findAll()).isEmpty();
    }
}