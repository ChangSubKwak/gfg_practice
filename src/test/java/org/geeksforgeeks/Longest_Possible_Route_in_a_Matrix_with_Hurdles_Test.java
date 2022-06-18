package org.geeksforgeeks;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Longest_Possible_Route_in_a_Matrix_with_Hurdles_Test {
    Longest_Possible_Route_in_a_Matrix_with_Hurdles test = new Longest_Possible_Route_in_a_Matrix_with_Hurdles();

    @Test
    void test() {
        assertThat(test.longestPath(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}}, 3, 10, 0, 0, 1, 7)).isEqualTo(24);
        assertThat(test.longestPath(new int[][]{{1, 1, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1}}, 2, 6, 0, 0, 1, 3)).isEqualTo(4);
        assertThat(test.longestPath(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 0, 1}, {1, 1, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}}, 7, 4, 3, 2, 4, 0)).isEqualTo(-1);
    }
}
