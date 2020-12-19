package gan.homeworks;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static final char HUMAN = 'X';
    public static final char PC = '0';
    public static final char EMPTY_VALUE = '_';
    public static final Scanner SCANNER  = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public static char[][] gameMapArr;
    public static int mapSizeX;
    public static int mapSizeY;
    public static int winCombination;
    public static int skipStep;
    public static int skipStepWin = 0;

    public static void main(String[] args) {

        setSizeGameMap();
        fillArray();
        printGameMap();

        while(true){
            turnOnHuman();
            printGameMap();
            if (chekWin(HUMAN)){
                System.out.println("\n\nВы, выиграли!");
                break;
            }
            if (checkMapFull()){
                System.out.println("\n\nКонец игры. Ничья!");
                break;
            }
            checkWinForAi();
            printGameMap();
            if (chekWin(PC)){
                System.out.println("\n\nКомпьютер выиграл!");
                break;
            }
            if (checkMapFull()){
                System.out.println("\n\nКонец игры. Ничья!");
                break;
            }
        }
    }

    public static void setSizeGameMap(){
        mapSizeX = 5;
        mapSizeY = 5;
        winCombination = 4;//условие победы. Должно лежать в границах игрового поля!
        skipStep = 2; //Уровень сложности. Чем выше тем проще.
        gameMapArr = new char[mapSizeY][mapSizeX];
    }

    public static void fillArray(){
        for(int y = 0; y < mapSizeY; y++){
            for (int x = 0; x < mapSizeX; x++){
                gameMapArr[y][x] = EMPTY_VALUE;
            }
        }
    }

    public static void printGameMap(){

        for(int y = 0; y < mapSizeY + 1; y++){
            System.out.println(" ");
            System.out.print(y + "|");
            for (int x = 0; x < mapSizeX; x++){
                if (y == 0){
                    System.out.print(x + 1 + "|" );
                }else{
                    System.out.print(gameMapArr[y - 1][x]);
                    System.out.print("|");
                }
            }
        }
    }

    public static void turnOnHuman(){
        int y;
        int x;
        System.out.println("\n\nХодит человек, введите координаты: ");
        do {
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;
            if (checkRange(y, x) || checkEmpty(y, x)){
                System.out.println("Данная ячейка уже занята или значение вне границ диапазона. Необходимо выбрать другие координаты!");
            }
        }while(checkRange(y, x) || checkEmpty(y, x));
        gameMapArr[y][x] = HUMAN;
    }

    public static void turnOnPC(){
        int y;
        int x;
        System.out.println("\n\nХод компьютера: ");
        do {
            y = RANDOM.nextInt(mapSizeY);
            x = RANDOM.nextInt(mapSizeX);
        }while(checkEmpty(y, x));
        gameMapArr[y][x] = PC;
    }

    public static boolean checkRange(int y, int x){
        return (y >= mapSizeY || x >= mapSizeX || y < 0 || x < 0);
    }

    public static boolean checkEmpty(int y,int x){
        return (gameMapArr[y][x] != EMPTY_VALUE);
    }

    public static boolean checkMapFull(){
        for(int i = 0;i < mapSizeY;i++){
            for(int j = 0;j < mapSizeX;j++){
                if (gameMapArr[i][j] == EMPTY_VALUE){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean chekWin(char gamer){
        int horLine = 0;
        int verLine = 0;
        int slLine = 0;
        int slLine2 = 0;

        for(int i = 0; i < mapSizeY; i++){
            for(int j = 0; j < mapSizeX; j++){
                if (gameMapArr[i][j] == gamer){
                    for(int x = 0;x < winCombination;x++){
                        if (j <= mapSizeX - winCombination){ //Совпадение по горизонтали
                            if (gameMapArr[i][j + x] == gamer) horLine += 1;
                        }
                        if (i <= mapSizeY - winCombination){//Совпадения по вертикали
                            if (gameMapArr[i + x][j] == gamer) verLine += 1;
                        }
                        if (i <= mapSizeY - winCombination && j <= mapSizeX - winCombination ){//Совп. наклону влево.
                            if (gameMapArr[i + x][j + x] == gamer) slLine += 1;
                        }
                        if (i >= winCombination - 1 && j <= mapSizeX - winCombination ){//Совп. по наклону вправо.
                            if (gameMapArr[i - x][j + x] == gamer) slLine2 += 1;
                        }
                    }
                    if (horLine == winCombination || verLine == winCombination ||
                            slLine == winCombination || slLine2 == winCombination){
                        return true;
                    }else{
                        horLine = 0;
                        verLine = 0;
                        slLine = 0;
                        slLine2 = 0;
                    }
                }
            }
        }
        return false;
    }

    public static void checkWinForAi(){

        if (skipStepWin > skipStep){
            for (int i = 0; i < mapSizeY; i++){
                for (int j = 0; j < mapSizeX; j++){
                    if (gameMapArr[i][j] == EMPTY_VALUE){
                        gameMapArr[i][j] = HUMAN;
                        if(chekWin(HUMAN)){
                            gameMapArr[i][j] = PC;
                            break;
                        }else{
                            gameMapArr[i][j] = EMPTY_VALUE;
                        }
                    }
                }
            }
        }
        turnOnPC();
        skipStepWin += 1;
    }

//    public static void aiPC(){
//        int horLine = 0;
//        int verLine = 0;
//        int slLine = 0;
//        int slLine2 = 0;
//
//        for(int i = 0; i < mapSizeY; i++){
//            for(int j = 0; j < mapSizeX; j++){
//
//                if (gameMapArr[i][j] == HUMAN){
//                        //тут 2 счётчика?
//                    for(int x = 0;x < winCombination;x++){
//
//                        //По горизонтали
//                        if (j < mapSizeX - x){
//                            if (gameMapArr[i][j + x] == HUMAN){
//                                horLine += 1;
//                                if (horLine == winCombination - 1){
//                                    if (j + x + 1 < mapSizeX && gameMapArr[i][j + x + 1] == EMPTY_VALUE){
//                                            gameMapArr[i][j + x + 1] = PC;
//                                            break;
//                                    }else if(j - 1 > 0){
//                                            if(gameMapArr[i][j - 1] == EMPTY_VALUE){
//                                                gameMapArr[i][j - 1] = PC;
//                                                break;
//                                            }
//                                    }
//                                }
//                            }else{
//                                horLine = 0;
//                            }
//                        }
//
//                        //По вертикали
//                        if (i < mapSizeY - x){
//                            if (gameMapArr[i + x][j] == HUMAN){
//                                verLine += 1;
//                                if (verLine == winCombination - 1){
//                                    if (i + x + 1 < mapSizeX && gameMapArr[i + x + 1][j] == EMPTY_VALUE){
//                                        gameMapArr[i + x + 1][j] = PC;
//                                        break;
//                                    }else if(i - 1 > 0){
//                                        if(gameMapArr[i - 1][j] == EMPTY_VALUE){
//                                            gameMapArr[i - 1][j] = PC;
//                                            break;
//                                        }
//                                    }
//                                }
//                            }else{
//                                verLine = 0;
//                            }
//                        }
//                    }
//                    horLine = 0;
//                    verLine = 0;
//                }
//            }
//        }
//    }

}
