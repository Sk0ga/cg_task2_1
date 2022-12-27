package cs.vsu.ru.skogorev_m_a.gr12;

//описание фигуры
public class Shape {
    Point[] peaks;
    public Shape(Point[] peaks) {
        this.peaks = peaks;
    }
    public void setPeaks(double[][] points) {
        for (int i = 0; i < points.length; i++) {
            peaks[i].setX(points[i][0]);
            peaks[i].setY(points[i][1]);
        }
    }
    public Point[] getPeaks() {
        return peaks;
    }
    public int[] getPeaksX() {
        int[] peaksX = new int[peaks.length];
        for (int i = 0; i < peaksX.length; i++) {
            peaksX[i] = (int) peaks[i].getX();
        }
        return peaksX;
    }
    public int[] getPeaksY() {
        int[] peaksY = new int[peaks.length];
        for (int i = 0; i < peaksY.length; i++) {
            peaksY[i] = (int) peaks[i].getY();
        }
        return peaksY;
    }
}

