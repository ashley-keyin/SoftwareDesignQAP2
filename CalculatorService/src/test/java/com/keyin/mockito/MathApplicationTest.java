package com.keyin.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTest {

    @InjectMocks //used to create and inject the mock object
    MathApplication mathApplication = new MathApplication();

    @Mock //used to create the mock object to be injected
    CalculatorService calcService;

    @Test
    public void isTrue() {
        MathApplication mathApplication = new MathApplication();
        assertTrue(mathApplication.isTrue());
    }

    @Test
    public void testAdd() {
        //add behavior of calc service to add 2 numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.00);
        //test the add functionality
        assertEquals(mathApplication.add(10.0, 20.0), 30.0);
    }

    @Test
    public void testSubtract() {
        when(calcService.subtract(50.0, 10.0)).thenReturn(30.0);
        assertNotEquals(mathApplication.subtract(50.0, 10.0), 40.0);
    }

    @Test
    public void testMultiply() {
        when(calcService.multiply(2.0, 5.0)).thenReturn(10.0);
        assertEquals(mathApplication.multiply(2.0, 5.0), 10);
    }

    @Test
    public void testDivide() {
        when(calcService.divide(30.0, 2.0)).thenReturn(15.0);
        assertEquals(mathApplication.divide(30.0, 2.0), 15.0);
    }

}