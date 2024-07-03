package View.Moderator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

class CustomScrollBarUI extends BasicScrollBarUI {
    private static final int SCROLL_BAR_WIDTH = 12;

    @Override
    protected void configureScrollBarColors() {
        this.thumbColor = new Color(100, 100, 200);
        this.trackColor = new Color(220, 220, 220);
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        return button;
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
            return;
        }

        int w = thumbBounds.width;
        int h = thumbBounds.height;

        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(thumbColor);
        g.fillRect(0, 0, w - 1, h - 1);
        g.setColor(new Color(150, 150, 255));
        g.drawRect(0, 0, w - 1, h - 1);
        g.translate(-thumbBounds.x, -thumbBounds.y);
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        return new Dimension(SCROLL_BAR_WIDTH, SCROLL_BAR_WIDTH);
    }

    @Override
    protected Dimension getMaximumThumbSize() {
        return new Dimension(SCROLL_BAR_WIDTH, SCROLL_BAR_WIDTH);
    }

    @Override
    protected void layoutVScrollbar(JScrollBar sb) {
        super.layoutVScrollbar(sb);
        sb.setPreferredSize(new Dimension(SCROLL_BAR_WIDTH, sb.getHeight()));
    }

    @Override
    protected void layoutHScrollbar(JScrollBar sb) {
        super.layoutHScrollbar(sb);
        sb.setPreferredSize(new Dimension(sb.getWidth(), SCROLL_BAR_WIDTH));
    }
}
