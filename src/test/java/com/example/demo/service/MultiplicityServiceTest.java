package com.example.demo.service;

import com.example.demo.exception.StartWithZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
 class MultiplicityServiceTest {

    private MultiplicityService multiplicityService;

    @BeforeEach
    void init() {
        multiplicityService = new MultiplicityService();
    }

    @Test
    void testRangeOneToHundred() {
        List<String> stringList = multiplicityService.checkNumbersInRange(1, 100);

        Assertions.assertEquals(14, stringList.stream().filter(s -> s.equals("Nuts")).count());
        Assertions.assertEquals(27, stringList.stream().filter(s -> s.equals("Visual")).count());
        Assertions.assertEquals(6, stringList.stream().filter(s -> s.equals("Visual Nuts")).count());
    }

    @Test
    void testRangeZeroToHundred() {
        Assertions.assertThrows(StartWithZeroException.class, ()-> multiplicityService.checkNumbersInRange(0, 100));
    }

}
