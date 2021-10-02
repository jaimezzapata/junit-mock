package co.com.sofka.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class BasicCalculatorTest {
    private BasicCalculator cal;

    @BeforeEach
    public void setup(){
        cal = new BasicCalculator();
    }

    @ParameterizedTest(name="{0}+{1}={2}")
    @CsvSource({"3,4,7","5,5,10","10,5,15","-10,-5,-15","-10,8,-2"})
    void sum(long one,long two, long expect) {
        long result = cal.sum(one,two);
        Assertions.assertEquals(expect,result);
    }

    @ParameterizedTest(name="{0}-{1}={2}")
    @CsvSource({"3,4,-1","5,5,0","10,5,5","-10,-5,-5","-10,8,-18"})
    void sub(long one,long two, long expect) {
        long result = cal.sub(one,two);
        Assertions.assertEquals(expect,result);
    }

    @ParameterizedTest(name="{0}*{1}={2}")
    @CsvSource({"4,4,16","10,5,50","-5,2,-10","5,0,0","-1,-1,1"})
    void multiply(long one,long two, long expect) {
        long result = cal.multiply(one,two);
        Assertions.assertEquals(expect,result);
    }

    @ParameterizedTest(name="{0}/{1}={2}")
    @CsvSource({"4,4,1","10,5,2","-9,-3,3","0,8,0"})
    void divide(long one,long two, long expect) {
        long result = cal.divide(one,two);
        Assertions.assertEquals(expect,result);
    }

    @ParameterizedTest(name="{0}/{1}={2}")
    @CsvSource({"4,0","0,0"})
    void divideError(long one,long two) {
       var response=  Assertions.assertThrows(RuntimeException.class, ()->{
            long result = cal.divide(one,two);
        });
    }
}