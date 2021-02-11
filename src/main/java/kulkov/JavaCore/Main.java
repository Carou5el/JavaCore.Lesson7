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
    public static int PERS_QNTY = 5;
    public static int BARRIERS_QNTY = 5;

    public static void main(String[] args) {
        Random generator = new Random();
        // Матрица результатов.
        boolean[][] results = new boolean[BARRIERS_QNTY][PERS_QNTY];
        // Массив препятствий.
        Barrier[] barriers = new Barrier[BARRIERS_QNTY];
        // Массив персонажей.
        Human[] humans = new Human[PERS_QNTY];
        // Инициализация массива персонажей.
        for(int i = 0; i < humans.length; i++)  {
            humans[i] = new Human();
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
                    results[i][j] = humans[j].jump((Wall) barriers[i]);
                } else if(barriers[i] instanceof RunTrack)  {
                    results[i][j] = humans[j].run((RunTrack) barriers[i]);
                }

            }
        }
    }
}
