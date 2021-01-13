package gan.HomeWork7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WIDTH_WINDOW = 400;
    private static final int HEIGHT_WINDOW = 400;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_GAME_MAP_SIZE = 3;
    private static final int MAX_GAME_MAP_SIZE = 10;
    private static final String GAME_MAP_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_PREFIX = "Выигрышная длина: ";

    private MainWindow mainWindow;
    JRadioButton humVsAI;
    JRadioButton humVsHum;
    JSlider slGameMapSize;
    JSlider slWinLength;

    Settings(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        setSize(WIDTH_WINDOW, HEIGHT_WINDOW);

        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WIDTH_WINDOW / 2;
        int posY = (int)gameWindowBounds.getCenterY() - WIDTH_WINDOW / 2;
        setLocation(posX,posY);
        setResizable(false);

        setTitle("Настройки");
        setLayout(new GridLayout(10,1));
        addGameModeSetting();
        addGameMapSizeControl();

        JButton btnStartGame = new JButton("Начать новую игру");
        btnStartGame.setBackground(Color.yellow);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });

        add(btnStartGame);

    }

    private void addGameModeSetting(){
        add(new JLabel("Выберите режим игры"));

        humVsAI = new JRadioButton("Человек против ПК",true);
        humVsHum = new JRadioButton("Человек против человека");

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVsAI);
        gameMode.add(humVsHum);

        add(humVsAI);
        add(humVsHum);

    }

    private void addGameMapSizeControl(){
        JLabel lbGameMapSize = new JLabel(GAME_MAP_SIZE_PREFIX + MIN_GAME_MAP_SIZE);
        JLabel lbWinLength = new JLabel(WIN_PREFIX + MIN_WIN_LENGTH);

        slGameMapSize = new JSlider(MIN_GAME_MAP_SIZE, MAX_GAME_MAP_SIZE, MIN_GAME_MAP_SIZE);
        slWinLength = new JSlider(MIN_WIN_LENGTH, MIN_GAME_MAP_SIZE, MIN_GAME_MAP_SIZE);

        slGameMapSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slGameMapSize.getValue();
                lbGameMapSize.setText(GAME_MAP_SIZE_PREFIX + currentValue);
                slWinLength.setMaximum(currentValue);
            }
        });

        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_PREFIX + slWinLength.getValue());
            }
        });

        add(new JLabel("Выберите размер поля: "));
        add(lbGameMapSize);
        add(slGameMapSize);
        add(new JLabel("Выберите длину выигрышной комбинации: "));
        add(lbWinLength);
        add(slWinLength);
    }
    private void btnStartClick(){
        int gameMode;
        if (humVsAI.isSelected()){
            gameMode = GameMap.GAME_MODE_HVA;
        }else if (humVsHum.isSelected()){
            gameMode = GameMap.GAME_MODE_HVH;
        }else{
            throw new RuntimeException("Неизвестный игрок");
        }

        int gameMapSize = slGameMapSize.getValue();
        int winLength  = slWinLength.getValue();

        mainWindow.startNewGame(gameMode, gameMapSize, gameMapSize, winLength);

        setVisible(false);
    }

}
