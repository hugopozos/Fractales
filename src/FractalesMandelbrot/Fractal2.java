package FractalesMandelbrot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
 
public class Fractal2 extends JFrame {
 
    private final int MAX_ITER = 570;
    private final double ZOOM = 200;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
 
    public Fractal2() {
        super("Mandelbrot Fractal 2");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx*zx*zx*zx  + zy*zy*zy*zy < 4 && iter > 0) {
                    tmp = zx*zx*zx*zx - 6.0*zx*zx*zy*zy + zy*zy*zy*zy  + cX;
                    zy = 4.0*zx*zx*zx*zy - 4.0*zx*zy*zy*zy + cY;
                    zx = tmp;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        new Fractal2().setVisible(true);
    }
}