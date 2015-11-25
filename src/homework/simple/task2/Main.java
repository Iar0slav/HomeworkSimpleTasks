package homework.simple.task2;

import java.util.Scanner;


/**
 * Created by Iaroslav on 25.11.2015.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        final String EXIT       = "exit";
        final String GREETINGS  = "Welcome to program from task2. It is works only with int values with 3 digits. \nIf you want to exit, type " + EXIT;
        final String INTEGER    = "Please, enter int with 3 digits, or " + EXIT + " to finish.";
        final String REPEAT     = "Enter int with 3 digits please, or " + EXIT + " to finish.";
        final String NONINTEGER = "You've entered non-integer number";
        final String OUTOFRANGE = "Integer out of range of 3 digits.";
        final String SUM        = "Sum of digits is: ";
        final String SQRT       = "The square root is: ";
        final String CLOSESTINT = "The closest Integer is: ";

        // рабочие переменные
        int x = 0;
        int intValue = 0;
        String workString;

        // массив для работы с числом
        int [] myArray = new int [3];

        // корень числа
        double sqareRoot = 0;

        //ближайшее целое
        int closestInteger;

        System.out.println(GREETINGS);
        System.out.println("");

        //приглашение на ввод числа
        System.out.println(INTEGER);

        //обнуление переменной повтора цикла
        boolean Circle = true;

        do {

            Scanner CircleScanner = new Scanner(System.in);

            String temp = CircleScanner.nextLine();

            //проверка на число
            boolean isInt = CheckForInt.isInteger(temp);

            /*
            проверка на переменную ВЫХОД
            проверка на пределы интовости
            проверка на диапазон трехзначности интового числа
            иначе повторное приглашение на ввод и повтор цикла
            */
            if (temp.equals(EXIT)){
                System.exit(0);
            } else if(isInt){
                try {
                    intValue = Integer.parseInt(temp);

                    if(intValue > 99 && intValue < 1000){
                        Circle = false;
                    } else if(intValue < -99 && intValue > -1000){
                        Circle = false;
                        intValue = Math.abs(intValue);
                    } else {
                        System.out.println(OUTOFRANGE);
                    }

                } catch (NumberFormatException e) {
                    System.out.println(NONINTEGER);
                    System.out.println(REPEAT);
                }
            } else {
                System.out.println(NONINTEGER);
                System.out.println(REPEAT);
            }
        } while(Circle);

        // получаем содержимое правильного числа в виде строки
        workString = Integer.toString(intValue);

        // перебираем строку
        // и получаем в массив чисел соответвенно порядковому номеру
        // суммируем числа из массива чисел
        for (int i=0; i < 3; i++)
        {
            myArray[i]=Integer.parseInt(String.valueOf(workString.charAt(i)));
            x = x + myArray[i];
        }

        //выводим сумму чисел
        System.out.print(SUM);
        System.out.println(x);

        // находим корень и выводим результат
        sqareRoot = Math.sqrt(x);
        System.out.print(SQRT);
        System.out.println((float)sqareRoot);

        // нахождение ближайшего целого и вывод результата
        closestInteger = Math.round((float)sqareRoot);
        System.out.print(CLOSESTINT);
        System.out.println(closestInteger);

    }
}
