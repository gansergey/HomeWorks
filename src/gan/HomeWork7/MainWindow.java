package gan.HomeWork7;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame {

    private static final int WIDTH_WINDOW = 700;
    private static final int HEIGHT_WINDOW = 500;
    private static final int POS_WINX = 600;
    private static final int POS_WINY = 300;
    private Settings settings;
    private GameMap gameMap;

    MainWindow(){
        setTitle("Крестики нолики");
        setSize(WIDTH_WINDOW,HEIGHT_WINDOW);
        setLocation(POS_WINX,POS_WINY);
        setTitleIcon();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        settings = new Settings(this);
        gameMap = new GameMap();

        setVisible(true);

        JButton btnStartGame = new JButton("Начать игру");
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JButton btnExit = new JButton("Выход");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStartGame.setBackground(Color.yellow);
        btnExit.setBackground(Color.yellow);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1,1));
        panelBottom.add(btnStartGame);
        panelBottom.add(btnExit);
        add(panelBottom,BorderLayout.SOUTH);

        add(gameMap);
    }

    private void setTitleIcon(){
        try {
            Image imIconTitle = ImageIO.read(MainWindow.class.getResource("/title_icon.png"));
            setIconImage(imIconTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void startNewGame(int mode, int sizeGameMapX, int sizeGameMapY, int winLength){
         gameMap.startNewGame(mode,sizeGameMapX,sizeGameMapY,winLength);
    }
}
