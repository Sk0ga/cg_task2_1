package cs.vsu.ru.skogorev_m_a.gr12;

//действия с фигурой
public class Convert {

    Shape shape;

    double[][] matrix;

    public Convert(Shape shape) {
        this.shape = shape;
        this.matrix = getM();
    }

    public Shape getShape() {
        return shape;
    }

//заполнение матрицы
    private double[][] getM() {
        this.matrix = new double[shape.getPeaks().length][];
        for (int i = 0; i < matrix.length; i++) {
            Point p = shape.getPeaks()[i];
            this.matrix[i] = new double[]{p.getX(), p.getY(), 1};
        }
        return this.matrix;
    }
//для перемещение матрицы
    private void movingMatrix(double[][] B) {
        double[][] A = getM();
        double[][] res = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        shape.setPeaks(res);
    }
//для вращение, сжатие\растяжение, масштабирование матрицы
    public void srcMatrix(double[][] B) {
        double[][] A = getM();
        double[][] point = new double[A.length][B[0].length];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < B[0].length; col++) {
                double cell = 0;
                for (int i = 0; i < B.length; i++) {
                    cell += (A[row][i] - A[0][i]) * B[i][col];
                }
                point[row][col] = (int)Math.round(cell + A[0][col]);
            }
        }
        shape.setPeaks(point);
    }

//сжатие\растяжение, масштабирование матрицы
    public void scalingShape(double a, double b) {
        srcMatrix(new double[][]{
                {a, 0, 0},
                {0, b, 0},
                {0, 0, 1}
        });
    }

//перемещение матрицы
    public void movingShape(double a, double b) {
        movingMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {a, b, 1}
        });
    }

//вращение матрицы
    public void rotateShape(double alpha){
        alpha = -(alpha * Math.PI / 180);
        srcMatrix(new double[][] {
                {Math.cos(alpha), Math.sin(alpha), 0},
                {-Math.sin(alpha), Math.cos(alpha), 0},
                {0, 0, 1},
        });
    }
}
