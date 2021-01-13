package gan.HomeWork7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel{

    public static final int GAME_MODE_HVA = 0;
    public static final int GAME_MODE_HVH = 1;
    private static final int HEIGHT_GAME_MAP = 440;
    private static final int WEIGHT_GAME_MAP = 688;
    private static int xSize;
    private static int ySize;

    private static int cellSizeX;
    private static int cellSizeY;

    GameMap(){
        setBackground(Color.WHITE);
    }

    void startNewGame(int mode, int sizeGameMapX, int sizeGameMapY, int winLength){
        System.out.println("mode = " + mode + " sizeGameMapX = " + sizeGameMapX +
                " sizeGameMapY = " + sizeGameMapY + " winLength = " + winLength);
        xSize = sizeGameMapX;
        ySize = sizeGameMapY;

        cellSizeX = WEIGHT_GAME_MAP / sizeGameMapX;
        cellSizeY = HEIGHT_GAME_MAP / sizeGameMapY;

        repaint();
    }

    // Переопределяем метод рисования
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i <= ySize; i++) {
            g.drawLine(0, i * cellSizeY, WEIGHT_GAME_MAP, i * cellSizeY);
            for (int j = 0; j <= xSize; j++){
                g.drawLine(j * cellSizeX, 0, j * cellSizeX, HEIGHT_GAME_MAP);
            }
        }
    }
}
