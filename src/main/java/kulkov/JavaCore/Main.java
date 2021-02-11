package kulkov.JavaCore;

import java.time.Period;

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
        boolean[][] results = new boolean[BARRIERS_QNTY][PERS_QNTY];
        // Массив персонажей.
        Human[] humans = new Human[PERS_QNTY];
        // Инициализация массива персонажей.
        for(int i = 0; i < humans.length; i++)  {
            humans[i] = new Human();
        }

        // Массив препятствий.
        Wall[] walls = new Wall[BARRIERS_QNTY];
        for(int i = 0; i < walls.length; i++) {
            walls[i] = new Wall();
        }
        System.out.println();

        for(int i = 0; i < BARRIERS_QNTY; i++) {
            // Вызов преодолевания препятствий персонажем для каждого препятствия.
            for(int j = 0; j < PERS_QNTY; j++) {

                results[i][j] = humans[j].jump(walls[i]);
            }
        }
    }
}
