package PackageLesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int G_MODEL_HVH = 0;
    public static final int G_MODEL_HVA = 0;

    public static final int personChar = 1;
    public static final int aiChar = 2;
    public static final int emptyChar = 0;

    private static final Random random = new Random();

    private int[][] map;
    private int mapSizeX;
    private int mapSizeY;
    private int winLength;
    private int modelGame;

    private int cellWidth;
    private int cellHeight;

    private boolean initMap;
    private boolean isGameOver;

    private int currentWinEvent;

    private static final int EVENT_DRAW = 0;
    private static final int EVENT_WIN_HUMAN = 1;
    private static final int EVENT_WIN_AI = 2;

    private static final String TEXT_EVENT_WIN_HUMAN = "Human Win!";
    private static final String TEXT_EVENT_WIN_AI = "AI Win!";
    private static final String TEXT_EVENT_WIN_DRAW = "DRAW!";

    GameMap() {

        setBackground(Color.BLUE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
        initMap = false;
    }

    void startGameWithParams(int mapSizeX, int mapSizeY, int winLength, int modelGame) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.winLength = winLength;
        this.modelGame = modelGame;
        this.map = new int[mapSizeY][mapSizeX];
        initMap = true;
        isGameOver = false;
        repaint();


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void update(MouseEvent e) {
        if (!initMap) return;
        if (isGameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }
        map[cellY][cellX] = personChar;

        if (checkWin(personChar)) {
           setGameOverEvent(EVENT_WIN_HUMAN);
            return;
        }

        if (isFullMap()) {
            setGameOverEvent(EVENT_DRAW);
            return;
        }

        aiTurn();
        repaint();

        if (checkWin(aiChar)) {
            setGameOverEvent(EVENT_WIN_AI);
            return;
        }
        if (isFullMap()) {
            setGameOverEvent(EVENT_DRAW);
            return;
        }

    }

    private void setGameOverEvent (int valueEvent){
        isGameOver = true;
        currentWinEvent = valueEvent;
        repaint();
    }


    private void render(Graphics g) {
        if (!initMap) return;

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapSizeX;
        cellHeight = height / mapSizeY;

        g.setColor(Color.BLACK);

        for (int i = 0; i < mapSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < mapSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {

                if (isEmptyCell(x, y)) {
                    continue;
                }
                if (map[y][x] == personChar) {
                    g.setColor(new Color(84, 232, 32));
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else if (map[y][x] == aiChar) {
                    g.setColor(new Color(182, 10, 10));
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else {
                    throw new RuntimeException("Invalid render player in y = " + y + " x=" + x);
                }

            }
        }
        if (isGameOver){
            showMessageGameOverEvent(g);


        }
    }

    private void showMessageGameOverEvent(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,200,getWidth(),70);
        g.setColor(Color.cyan);
        g.setFont(new Font("Times New Roman", Font.BOLD,40));
        switch (currentWinEvent){
            case EVENT_DRAW:
                g.drawString(TEXT_EVENT_WIN_DRAW,180,getHeight() / 2);
                break;
            case EVENT_WIN_HUMAN:
                g.drawString(TEXT_EVENT_WIN_HUMAN,150,getHeight() / 2);
                break;
            case EVENT_WIN_AI:
                g.drawString(TEXT_EVENT_WIN_AI,180,getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Invalid WinEvent " + currentWinEvent);
        }
    }

    public void aiTurn() {
        if (turnAIWinCell()) {
            return;
        }
        if (turnHumanWinCell()) {
            return;
        }
        int x;
        int y;

        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        } while (!isEmptyCell(x, y));

        map[y][x] = aiChar;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = aiChar;
                    if (checkWin(aiChar)) {
                        return true;
                    }
                    map[i][j] = emptyChar;
                }
            }
        }
        return false;
    }

    private boolean turnHumanWinCell() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    map[i][j] = personChar;
                    if (checkWin(personChar)) {
                        map[i][j] = aiChar;
                        return true;
                    }
                    map[i][j] = emptyChar;
                }
            }
        }
        return false;

    }

    private boolean checkWin(int player) {
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, player)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, winLength, player)) {
                    return true;
                }
                if (checkLine(i, j, 0, 1, winLength, player)) {
                    return true;
                }
                if (checkLine(i, j, 1, -1, winLength, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int player) {
        final int farX = x + (len - 1) * vx;
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (map[y + i * vy][x + i * vx] != player) {
                return false;
            }
        }
        return true;
    }

    public boolean isFullMap() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (map[i][j] == emptyChar) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }

    public boolean isEmptyCell(int x, int y) {
        return map[y][x] == emptyChar;
    }










}

