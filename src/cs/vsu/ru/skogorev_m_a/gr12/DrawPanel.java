package cs.vsu.ru.skogorev_m_a.gr12;

import javax.swing.*;
import java.awt.*;
//описание панели для рисования 
public class DrawPanel extends JPanel {

    int width;
    int height;

    Shape shape;
    Lines axes;

//параметры панели
    public DrawPanel(Shape shape) {
        this.width = 700;
        this.height = 700;
        this.axes = new Lines(this.getWidth(), this.getHeight());
        this.shape = shape;
    }

//отрисовка компонентов в панели
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(243, 243, 243));
        g2.fillRect(0, 0, 900, 900);
        setSize(900, 900);
        drawAxes(g2);
        g2.setColor(new Color(248, 47, 47));
        g2.fillPolygon(shape.getPeaksX(), shape.getPeaksY(), shape.getPeaks().length);
    }

//рисую оси
    public void drawAxes(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(0, height / 2, width, height / 2);
        graphics2D.drawLine(width / 2, 0, width / 2, height);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
