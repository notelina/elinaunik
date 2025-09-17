import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Main {
    /**
     * Дан список ['a', '1', 'b', '2', 'c', '3']. Разбейте его на два списка:
     * только с буквами и только с числами.
     * Сам список затем удалите, а новые списки выведите на экран, каждый на отдельной строке.
     */
    public static void main(String[] args) {
        List<Character> baseList = Arrays.asList('a', '1', 'b', '2', 'c', '3');
        List<Character> digits = baseList.stream().filter(c -> Character.isDigit(c)).toList();
        List<Character> symbols = baseList.stream().filter(c -> !Character.isDigit(c)).toList();
        System.out.printf("digits="+digits+'\n');
        System.out.printf("symbols="+symbols);

        // тоже самое со стеком
        Stack<Character> baseStack = new Stack<>();
        baseStack.push('a');
        baseStack.push( '1');
        baseStack.push( 'b');
        baseStack.push( '2');
        baseStack.push( 'c');
        baseStack.push( '3');

        List<Character> digits2 = baseStack.stream().filter(c -> Character.isDigit(c)).toList();
        List<Character> symbols2 = baseStack.stream().filter(c -> !Character.isDigit(c)).toList();
        System.out.printf("digits2="+digits2);
    }
}