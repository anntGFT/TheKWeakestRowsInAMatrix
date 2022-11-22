import org.example.Solution;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SolutionTest {

    Solution solution;

    int[][] mat;

    int limit;

    int[] result;

    @BeforeAll
    void setup(){
        solution = new Solution();

    }

    @Test
    void matrixWithTwoRowsAndLimitOne(){

        mat = new int[][]{{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}};

        limit = 1;

        result = new int[] {0};

        assertEquals(Arrays.toString(result), Arrays.toString(solution.KWeakestRows(mat, limit)));
    }

    @Test
    void matrixWithFiveRowsAndLimitThree(){

        mat = new int[][]{{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0},{0, 0, 0, 0, 0},{1, 1, 0, 0, 0},{1, 1, 1, 1, 0}};

        limit = 3;

        result = new int[] {2,0,1};

        assertEquals(Arrays.toString(result), Arrays.toString(solution.KWeakestRows(mat, limit)));
    }
}
