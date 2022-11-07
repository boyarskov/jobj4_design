package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;
    private List<Integer> input2;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
        input2 = new ArrayList<>(Arrays.asList(4, 2, 3, 5, 2, 1));
    }

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBefore2() {
        ListUtils.addBefore(input2, 3, 9);
        assertThat(input2).hasSize(7).containsSequence(4, 2, 3, 9, 5, 2, 1);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input2, x -> x < 3);
        assertThat(input2).hasSize(3).containsSequence(4, 3, 5);
    }

    @Test
    void whenReplaceIf() {
        ListUtils.replaceIf(input2, x -> x > 4, 77);
        assertThat(input2).hasSize(6).containsSequence(4, 2, 3, 77, 2, 1);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, new ArrayList<>(Arrays.asList(1, 3)));
        assertThat(input).hasSize(0);
    }


}