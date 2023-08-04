package ru.netology.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.services.VacationCalcService;

public class VacationCalcServiceTest {
    @ParameterizedTest
    // @CsvSource({
    //         "10000,3000,20000,3",
    //         "100000,60000,150000,2"
    // })
    @CsvFileSource(files = "src/test/resources/service.csv")
    public void shouldCalculateVacation(int income, int expenses, int threshold, int expected) {
        VacationCalcService service = new VacationCalcService();

        // подготавливаем данные:
        //int income = 10_000;
        //int expenses = 3_000;
        //int threshold = 20_000;
        //int expected = 3;

        // вызываем целевой метод:
        int actual = service.calculate(income, expenses, threshold);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}