package primary.array;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j != i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
        //reverse per line
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                matrix[i][j] ^= matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][matrix.length - 1 - j];
            }
        }
    }

    void print(int[][] matrix) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) stringBuffer.append("{\n\t");
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    stringBuffer.append("{").append(matrix[i][j]).append(",");
                } else {
                    if (j == matrix[i].length - 1) {
                        stringBuffer.append(matrix[i][j]).append(i == matrix.length - 1 ? "}\n" : "},\n\t");
                    } else {
                        stringBuffer.append(matrix[i][j]).append(",");
                    }
                }
            }
            if (i == matrix.length - 1) stringBuffer.append("}");
        }
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateMatrix rotateMatrix = new RotateMatrix();
        System.out.println("the origin matrix is ......");
        rotateMatrix.print(matrix1);
        System.out.println("after rotate......");
        rotateMatrix.rotate(matrix1);
        rotateMatrix.print(matrix1);

    }
}
