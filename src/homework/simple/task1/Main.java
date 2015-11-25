package homework.simple.task1;

import java.util.Scanner;

// Если Java 8, stream API то для среднего из массива можно использовать
// import java.util.stream.IntStream;

/**
 * Created by Iaroslav on 25.11.2015.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        final String GREETINGS  = "Welcome to program from task1. It is works only with int values.";
        final String EXIT       = "exit";
        final String FIRSTINT   = "Please, enter first int, or " + EXIT + " to finish.";
        final String SECONDINT  = "Please, enter second int, or " + EXIT + " to finish.";
        final String THIRDINT   = "Please, enter third int, or " + EXIT + " to finish.";
        final String REPEAT     = "Enter int please, or " + EXIT + " to finish.";
        final String NONINTEGER = "You've entered non-integer number";
        final String AVERAGE    = "The average is: ";
        final String CLOSESTINT = "The closest Integer is: ";

        //массив хранения чисел
        int[] intArray = new int[3];

        //среднее арифметическое
        float average = 0;

        //ближайшее целое
        int closestInteger;

        //заносим в массив запросы к вводу чисел
        String[] inputArray = new String[3];
        inputArray[0] = FIRSTINT;
        inputArray[1] = SECONDINT;
        inputArray[2] = THIRDINT;

        System.out.println(GREETINGS);
        System.out.println("");

        //цикл обработки ввода трех чисел
        for (int i = 0; i < 3; i++){

            //приглашение на ввод текущего по счету числа
            System.out.println(inputArray[i]);

            //обнуление переменной повтора цикла
            boolean Circle = true;

            while(Circle) {

                Scanner CircleScanner = new Scanner(System.in);

                String temp = CircleScanner.nextLine();

                //проверка на число
                boolean isInt = CheckForInt.isInteger(temp);

                /*
                проверка на переменную ВЫХОД
                проверка на пределы интовости
                иначе повторное приглашение на ввод и повтор цикла
                */
                if (temp.equals(EXIT)){
                    System.exit(0);
                } else if(isInt){
                    try {
                        intArray[i] = Integer.parseInt(temp);
                        Circle = false;
                    } catch (NumberFormatException e) {
                        System.out.println(NONINTEGER);
                        System.out.println(REPEAT);
                    }
                } else {
                    System.out.println(NONINTEGER);
                    System.out.println(REPEAT);
                }
            }

        }


        // Если Java 8, stream API то для среднего из массива можно использовать
        // double average = IntStream.of(intArray).average().getAsDouble();

        // нахождение среднего арифметического
        if (intArray.length > 0)
        {
            float sum = 0;
            for (int anIntArray : intArray) {     // for (int j = 0; j < intArray.length; j++)
                sum += anIntArray;                // sum += intArray[j];
            }
            average = sum / intArray.length;
        }

        // вывод результата поиска среднего арифметического
        System.out.print(AVERAGE);
        System.out.println(average);

        // нахождение ближайшего целого
        closestInteger = Math.round(average);

        // вывод результата поиска ближайшего целого
        System.out.print(CLOSESTINT);
        System.out.println(closestInteger);
    }
}
