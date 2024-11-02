import java.util.*;
import java.lang.*;

public class Program {
    public static void main(String[] args) {
        int[] R1 = { 0, 1, 2, 3 };
        int[] R2 = { 1, 2, 3, 4, 5 };
        int[] Rx = { 1, 2, 3, 4 };

        new Resistor(Rx, R1, R2);
    }
}

 /*
    Дан массив Rx, он соответсвует одному резистору. Rx, R1 и R2 имеют постоянные диапзоны
    По формуле поэлеметно сложить и умножить найти Z
    Выбрать числа из Z,
 */

class Resistor{
    List<Integer> ARx;
    List<Integer> B;
    List<Integer> D;

    List<Integer> numerator;

    List<Integer> Z;

    public Resistor(int[] Rx, int[] R1, int[] R2) {
        ARx = calculateARx(R1, R2, Rx);
        B = calculateB(R1, R2);

        D = calculateRxR2(Rx, R2);

        numerator = calculateNumerator(ARx, B);

        Z = divide(numerator, D);

        printZ(Z, Rx);
    }

    private static List<Integer> calculateARx(int[] R1, int[] R2, int[] Rx){
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i : R1){
            for(int n : R2)
                temp.add(i + n);
        }

        for(int i : temp) {
            for(int n : Rx)
                result.add(i * n);
        }

        return result;
    }

    private static List<Integer> calculateB(int[] R1, int[] R2) {
        List<Integer> result = new ArrayList<>();

        for(int i : R1){
            for(int n : R2){
                result.add(i * n);
            }
        }

        return result;
    }

    private static List<Integer> calculateRxR2(int[] Rx, int[] R2) {
        List<Integer> result = new ArrayList<>();

        for(int i : Rx){
            for(int n : R2)
                result.add(i + n);
        }

        return result;
    }

    private static List<Integer> calculateNumerator(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();

        for(int i : a){
            for(int n : b)
                result.add(i + n);
        }

        return result;
    }

    private static List<Integer> divide(List<Integer> numerator, List<Integer> D) {
        List<Integer> result = new ArrayList<>();

        for(int i : numerator){
            for(int n : D)
                result.add(i / n);
        }

        return result;
    }

    private static void printZ(List<Integer> z, int[] Rx) {
        List<Integer> uniqueElements =
                z.stream().distinct().toList();

        for(int i : uniqueElements){
            for(int n : Rx){
                if(i == n)
                    System.out.print(i + " ");
            }
        }
    }
}