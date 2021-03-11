package PackageLesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {

    private static final int WIN_WIDTH = 350;
    private static final int WIN_HEIGHT = 250;

    private final int MIN_WIN_LENGTH = 3;
    private final int MIN_MAP_SIZE = 3;
    private final int MAX_MAP_SIZE = 10;

    private final String MAP_SIZE_MESSAGE = "Map size is: ";
    private final String WIN_LEN_MESSAGE = "Win length is: ";


    private MainWindow mainWindow;

    private JRadioButton humanVsHuman;
    private JRadioButton humanVsAi;
    private JSlider sliderSelectSizeMap;
    private JSlider sliderSelectWinLength;
    private JButton buttonStart;


    Settings(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        Rectangle mainWindowsBounds = mainWindow.getBounds();

        int posX = (int) mainWindowsBounds.getCenterX() - WIN_WIDTH / 2;
        int posY = (int) mainWindowsBounds.getCenterY() - WIN_HEIGHT / 2;

        setLocation(posX,posY);
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setTitle("Settings");
        setResizable(false);
        setLayout(new GridLayout(10,1));

        setGameModelControl();
        setSizeMapControl();
        finalSettings();


    }

    private void setGameModelControl (){
        add(new JLabel("Select your game model"));
        humanVsHuman = new JRadioButton("Human VS Human", true);
        humanVsAi = new JRadioButton("Human VS AI");

        ButtonGroup gameButtonGroup = new ButtonGroup();
        gameButtonGroup.add(humanVsHuman);
        gameButtonGroup.add(humanVsAi);

        add(humanVsHuman);
        add(humanVsAi);

    }

    private void setSizeMapControl(){
        JLabel lbMapSize = new JLabel(MAP_SIZE_MESSAGE + MIN_MAP_SIZE);
        JLabel lbWinLen = new JLabel(WIN_LEN_MESSAGE + MIN_WIN_LENGTH);

        sliderSelectSizeMap = new JSlider(MIN_MAP_SIZE, MAX_MAP_SIZE, MIN_MAP_SIZE);
        sliderSelectSizeMap.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentMapSize = sliderSelectSizeMap.getValue();
                lbMapSize.setText(MAP_SIZE_MESSAGE + currentMapSize);
                sliderSelectWinLength.setMaximum(currentMapSize);

            }
        });

        sliderSelectWinLength = new JSlider(MIN_WIN_LENGTH, MIN_MAP_SIZE,MIN_MAP_SIZE);
        sliderSelectWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLen.setText(WIN_LEN_MESSAGE + sliderSelectWinLength.getValue());
            }
        });

        add(new JLabel("Select map size"));
        add(lbMapSize);
        add(sliderSelectSizeMap);
        add(lbWinLen);
        add(sliderSelectWinLength);

    }

    private void finalSettings(){
        buttonStart = new JButton("Start Game");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNextGame();
            }
        });
        add(buttonStart);

    }

    private void startNextGame (){
        int gameModel;

        if (humanVsHuman.isSelected()){
            gameModel = GameMap.G_MODEL_HVH;
        } else if (humanVsAi.isSelected()){
            gameModel = GameMap.G_MODEL_HVA;
        } else {
            throw new RuntimeException("Invalid select game model");
        }

        int mapSize = sliderSelectSizeMap.getValue();
        int winLen = sliderSelectWinLength.getValue();

        mainWindow.getParamsFromSettingsForStartGame(mapSize,mapSize,winLen,gameModel);

        setVisible(false);
    }
}
