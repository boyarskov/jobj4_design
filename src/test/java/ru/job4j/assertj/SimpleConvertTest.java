package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List list = simpleConvert.toList("first", "second", "three", "four");
        assertThat(list).hasSize(4)
                .contains("first")
                .containsExactly("first", "second", "three", "four")
                .containsAnyOf("three", "six", "ten");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set set = simpleConvert.toSet("first", "first", "three", "four", "five");
        assertThat(set)
                .element(3)
                .isNotNull();
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map map = simpleConvert.toMap("1", "2", "3", "7");
        assertThat(map)
                .isNotEmpty()
                .hasSize(4);
    }
}