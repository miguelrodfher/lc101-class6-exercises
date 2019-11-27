package org.launchcode.lesson6.studio;

import org.junit.Test;
import org.launchcode.lesson6.studio.generator.QuizGenerator;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

public class QuizGeneratorTest {

    @Test
    public void testGenerateQuiz() throws FileNotFoundException {
        Quiz quiz = QuizGenerator.generateQuiz();

        assertTrue(quiz.isQuizLoaded());
    }
}
