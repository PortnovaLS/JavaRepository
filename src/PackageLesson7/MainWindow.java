package PackageLesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MainWindow extends JFrame {

    private static final int WIN_WIDTH = 450;
    private static final int WIN_HEIGHT = 500;
    private static final int WIN_POS_X = 450;
    private static final int WIN_POS_Y = 150;

    private Settings settings;
    private GameMap gameMap;

    MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POS_X,WIN_POS_Y);
        setTitle("Game X/O");
        setResizable(false);

        settings = new Settings(this);
        gameMap = new GameMap();


        JButton buttonStartGame = new JButton("Start New Game");
        buttonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JButton buttonExitGame = new JButton("Exit Game");
        buttonExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new GridLayout(1,2));
        panelForButtons.add(buttonStartGame);
        panelForButtons.add(buttonExitGame);

        add(panelForButtons,BorderLayout.SOUTH);
        add(gameMap);

        setVisible(true);
    }

    void getParamsFromSettingsForStartGame (int mapSizeX,int mapSizeY,int winLength, int modelGame){
        gameMap.startGameWithParams(mapSizeX,mapSizeY,winLength,modelGame);
    }
}
