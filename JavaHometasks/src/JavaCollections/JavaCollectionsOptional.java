package JavaCollections;

import java.awt.*;
import java.util.*;
import java.util.List;

public class JavaCollectionsOptional {
    public static void main (String[] args) {
        List <String> song = Arrays.asList (
                "Form the lines",
                "Shield by shield",
                "Side by side",
                "We're marching into destiny");

        // пункт 2 задания
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число:");
        int intForStack=in.nextInt();
        Stack stack = new Stack<>();
        String number = String.valueOf(intForStack);
        for(int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            stack.push(new Integer(j));
            System.out.println("digit: " + j);
        }
        int reverseIntForStack=0;
        Iterator iterator=stack.iterator();
        while (iterator.hasNext()) {
            int digitFromStack=(Integer)stack.pop();
            reverseIntForStack=reverseIntForStack*10+digitFromStack;
            System.out.println("Удаляем: " + digitFromStack);
        }
        System.out.println(reverseIntForStack);
        // пункт 4 задания
        System.out.println("Строки песни: "+song);
        Collections.sort(song, new Comparator <String>() {
            public int compare(String string1, String string2) {
                return string1.length () - string2.length ();
            }
        });
        System.out.println("Строки песни по возрастанию длин строк: "+song);
        // пункт 5 задания
        List <Integer> intList = Arrays.asList (new Integer(4), new Integer(-3), new Integer(2), new Integer(5), new Integer(7) );
        System.out.println("Список чисел: "+intList);
        Collections.sort(intList, new Comparator <Integer>() {
            public int compare(Integer int1, Integer int2) {
                return int2 - int1;
            }
        });
        System.out.println("Список чисел по убыванию: "+intList);
    }
}
