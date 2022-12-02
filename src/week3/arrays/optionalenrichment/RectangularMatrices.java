package week3.arrays.optionalenrichment;
/*********************************************************************************
 * 1.4.18  Write a code fragment to multiply two rectangular matrices that 
 * are not necessarily square. Note: For the dot product to be well defined, 
 * the number of columns in the first matrix must be equal to the number of 
 * rows in the second matrix. Print an error message if the dimensions do not
 * satisfy this condition.
 *******************************************************************************/
public class RectangularMatrices {
    public static void main(String[] args) {
        // The matrices have to be rectangular that means that 
        // all inner arrays have to be the same length.
        /*
        double[][] matrixA = {
            {.70, .20, .10},
            {.30, .60, .10},
            {.50, .10, .40}
        };

        double[][] matrixB = {
            {.80, .30, .50},
            {.10, .40, .10},
            {.10, .30, .40}
        };
        */
        double[][] matrixC = {
            {.70, .20, .10, .40},
            {.30, .60, .10, .20},
        };

        double[][] matrixD = {
            {.80, .30},
            {.10, .40},
            {.10, .30},
            {.60, .70}
        };

        // Multiply two rectangular (non-square) matrices. 
        double[][] firstMat = matrixC;
        double[][] secondMat = matrixD;

        // Row and column number for the result matrix
        int nRowMatrixResult = firstMat.length;         // First matrix row number
        int nColMatrixResult = secondMat[0].length;     // Second matrix col number
        double[][] result = new double[nRowMatrixResult][nColMatrixResult];

        // Verification for first matrix number of columns and second matrix number of rows 
        int colFirstMat = firstMat[0].length;
        int rowSecondMat = secondMat.length;
        if (colFirstMat != rowSecondMat) {
            System.out.println("Error: The number of columns in the first matrix"
            + " must be equal to the number of rows in the second matrix.");
        } else {
            // colFirstMat must be equal to rowSecondMat that is the number  
            // of multiplications to be computed.
            int nProducts = colFirstMat; 
            // Matrix Multiplication   
            for (int row = 0; row < nRowMatrixResult; row++) {
                for (int col = 0; col < nColMatrixResult; col++) {
                    for (int k = 0; k < nProducts; k++) {
                        result[row][col] += firstMat[row][k] * secondMat[k][col];
                    }
                }
            }
            // Print the Result Matrix
            for (int i = 0; i < nRowMatrixResult; i++) {
                for (int j = 0; j < nColMatrixResult; j++) {
                    System.out.printf("%.2f ", result[i][j]);
                }
                System.out.println();
            }
        }
    }
}
