package kulkov.JavaCore;

import java.time.Period;
import java.util.Random;

/*
    Задание 7.
    Создать классы людей, котов, роботов без наследования.
    Персонажи могут бегать и прыгать (вывести в консоль текстом).

    Создать  классы стен, беговых дорожек.
    Препятствия имеют высоту и длину.
    Персонажи имеют ограничения по высоте прыжка и дистанции бега.

    Создаём массив препятствий и массив персонажей.

    Каждый персонаж должен преодолеть препятствия.
    Не прошедшие препятствие - останавливаются.

 */
public class Main {
    public static int PERS_QNTY = 10;
    public static int BARRIERS_QNTY = 4;
    public static String[][] testString = {
                                            {"234", "234", "34", "324"},
                                            {"234", "234", "34", "324"},
                                            {"234", "234", "dddd", "324"},
                                            {"234", "234", "34", "324"}
                                        };

    public static Integer[][] testResultArray;

    public static void main(String[] args) {
//        Task1();
        try {
            testResultArray = Task2(testString);
        } catch(MyArraySizeException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch(MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getMes());
        }
    }

    public static void Task1()  {
        Random generator = new Random();
        // Матрица результатов.
        boolean[][] result_humans = new boolean[BARRIERS_QNTY][PERS_QNTY];
        boolean[][] result_robots = new boolean[BARRIERS_QNTY][PERS_QNTY];
        boolean[][] result_cats = new boolean[BARRIERS_QNTY][PERS_QNTY];
        // Массив препятствий.
        Barrier[] barriers = new Barrier[BARRIERS_QNTY];
        // Массив персонажей.
        Human[] humans = new Human[PERS_QNTY];
        Robot[] robots = new Robot[PERS_QNTY];
        Cat[] cats = new Cat[PERS_QNTY];
        // Инициализация массива персонажей.
        for(int i = 0; i < humans.length; i++)  {
            humans[i] = new Human();
        }
        for(int i = 0; i < robots.length; i++)  {
            robots[i] = new Robot();
        }
        for(int i = 0; i < cats.length; i++)  {
            cats[i] = new Cat();
        }

        // Массив разнообразных препятствий.
        for(int i = 0; i < BARRIERS_QNTY; i++) {
            switch(generator.nextInt(2))    {
                case 0:
                    barriers[i] = new Wall();
                    break;
                case 1:
                    barriers[i] = new RunTrack();
                    break;
            }
        }

        // Прохождение каждым персонажем очереди из препятствий.
        // Запись в матрицу результатов.
        for(int i = 0; i < BARRIERS_QNTY; i++) {
            // Вызов преодолевания препятствий персонажем для каждого препятствия.
            for(int j = 0; j < PERS_QNTY; j++) {
                if(barriers[i] instanceof Wall) {
                    result_humans[i][j] = humans[j].jump((Wall) barriers[i]);
                } else if(barriers[i] instanceof RunTrack)  {
                    result_humans[i][j] = humans[j].run((RunTrack) barriers[i]);
                }
            }
            for(int j = 0; j < PERS_QNTY; j++) {
                if(barriers[i] instanceof Wall) {
                    result_robots[i][j] = robots[j].jump((Wall) barriers[i]);
                } else if(barriers[i] instanceof RunTrack)  {
                    result_robots[i][j] = robots[j].run((RunTrack) barriers[i]);
                }
            }
            for(int j = 0; j < PERS_QNTY; j++) {
                if(barriers[i] instanceof Wall) {
                    result_cats[i][j] = cats[j].jump((Wall) barriers[i]);
                } else if(barriers[i] instanceof RunTrack)  {
                    result_cats[i][j] = cats[j].run((RunTrack) barriers[i]);
                }
            }
        }

        // Вывод результатов в консоль.
        // Для Human.
        for(int i = 0; i < PERS_QNTY; i++)  {
            System.out.printf("hum[%d]\t", i);
            for(int j = 0; j < BARRIERS_QNTY; j++)  {
                System.out.printf("%b\t", result_humans[j][i]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        // Для Robot.
        for(int i = 0; i < PERS_QNTY; i++)  {
            System.out.printf("rob[%d]\t", i);
            for(int j = 0; j < BARRIERS_QNTY; j++)  {
                System.out.printf("%b\t", result_robots[j][i]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        // Для Cat.
        for(int i = 0; i < PERS_QNTY; i++)  {
            System.out.printf("cat[%d]\t", i);
            for(int j = 0; j < BARRIERS_QNTY; j++)  {
                System.out.printf("%b\t", result_cats[j][i]);
            }
            System.out.printf("\n");
        }
    }

    public static Integer[][] Task2(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        /*
            Метод, на вход которого подаётся 2-мерный массив строк размером 4х4.
            При подаче массива иной размерности - исключение MyArraySizeException.

            После преобразовать поэлементно строки в целые числа.
            При невозможности - исключение MyArrayDataException с информацией о проблемной ячейке.

            В методе main обработать данные исключения.
         */
        final int X_SIZE_MY_ARRAY = 4;
        final int Y_SIZE_MY_ARRAY = 4;

        boolean checkInputArray = true;

        checkInputArray &= (strings.length == Y_SIZE_MY_ARRAY);

        for(int i = 0; i < strings.length; i++) {
            checkInputArray &= (strings[i].length == X_SIZE_MY_ARRAY);
        }

        if(!checkInputArray)   {
            throw new MyArraySizeException("Не верная размерность массива.");
        }
        Integer[][] resultArray = new Integer[Y_SIZE_MY_ARRAY][X_SIZE_MY_ARRAY];

        for(int i = 0; i < Y_SIZE_MY_ARRAY; i++) {
            for(int j = 0; j < X_SIZE_MY_ARRAY; j++)    {
                try {
                    resultArray[i][j] = Integer.parseInt(strings[i][j]);
                } catch(NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return resultArray;
    }
}
