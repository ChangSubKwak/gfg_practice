package org.geeksforgeeks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SmallestDistinctWindowTest {
    SmallestDistinctWindow smallestDistinctWindow;

    @BeforeEach
    void setUp() {
        smallestDistinctWindow = new SmallestDistinctWindow();
    }

    @Test
    void test1() {
        assertThat(smallestDistinctWindow.findSubString("AABBBCBBAC")).isEqualTo(3);
        assertThat(smallestDistinctWindow.findSubString("aaab")).isEqualTo(2);
        assertThat(smallestDistinctWindow.findSubString("GEEKSGEEKSFOR")).isEqualTo(8);
    }
}
