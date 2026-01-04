package algorithm;

import javax.swing.*;
import java.awt.*;

public class GraphPanel extends JPanel {
    private int[] array;

    public GraphPanel() {
        setBackground(Color.BLACK);
    }

    public void setArray(int[] array) {
        this.array = array;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null || array.length == 0) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int maxVal = Integer.MIN_VALUE;
        for (int val : array) {
            if (val > maxVal) maxVal = val;
        }

        if (maxVal == 0) maxVal = 1;

        int barWidth = panelWidth / array.length;

        int topPadding = 50;
        int usableHeight = panelHeight - topPadding;

        for (int i = 0; i < array.length; i++) {

            int barHeight = (int) (((double) array[i] / maxVal) * usableHeight);

            int x = i * barWidth;
            int y = panelHeight - barHeight;

            g.setColor(Color.WHITE);
            g.fillRect(x, y, barWidth - 2, barHeight);

            if (barWidth > 20) {
                g.setColor(Color.CYAN);
                g.drawString(String.valueOf(array[i]), x + (barWidth/4), y - 5);
            }
        }
    }
}