package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name)
                .isEqualTo("Tetrahedron");
    }

    @Test
    void NumberOfVerticesIsFour() {
        Box box = new Box(4, 10);
        int numbers = box.getNumberOfVertices();
        assertThat(numbers)
                .isEqualTo(4)
                .isEven();
    }

    @Test
    void NumberOfVerticesIsZero() {
        Box box = new Box(0, 5);
        int numbers = box.getNumberOfVertices();
        assertThat(numbers)
                .isZero();
    }

    @Test
    void isExitTrue() {
        Box box = new Box(4, 10);
        boolean numbers = box.isExist();
        assertThat(numbers)
                .isTrue()
                .isNotNull();
    }

    @Test
    void isExitFalse() {
        Box box = new Box(7, 10);
        boolean numbers = box.isExist();
        assertThat(numbers)
                .isFalse();
    }

    @Test
    void isAreaSix() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area)
                .isEqualTo(6)
                .isLessThan(8);
    }

    @Test
    void isArea() {
        Box box = new Box(8, 2);
        double rsl = box.getArea();
        assertThat(rsl)
                .isEqualTo(24)
                .isGreaterThan(15);
    }
}