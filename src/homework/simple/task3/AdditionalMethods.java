package homework.simple.task3;

/**
 * Created by Iaroslav on 25.11.2015.
 */
public class AdditionalMethods {

    // метод для перестановки чисел в массиве
    public static int[] reverse(int[] x) {

        int[] d = new int[x.length];


        for (int i = 0; i < x.length; i++) {
            d[i] = x[x.length - 1 -i];
        }
        return d;
    }

}
