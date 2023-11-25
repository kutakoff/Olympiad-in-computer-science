import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Fifth {

    /*
        Сломанный индикатор
    У радиолюбителя Алексея есть девятисегментный жидкокристаллический индикатор, который может показывать цифры от 0 до 9
    в виде цифр «почтового индекса». После неудачного эксперимента индикатор повредился, и часть сегментов могла перегореть.
    Когда сегмент перегорает, индикатор теряет возможность показывать цифры, использующие этот сегмент.Алексей уже выяснил
    ,что индикатор всё ещё способен показать какие-то n цифр. Однако радиолюбитель не может проверить остальные цифры,
    равно как и каждый сегмент отдельно. Поэтому он просит вас помочь найти те цифры, которые гарантированно можно показать
    на этом индикаторе.

        Входные данные
    Первая строка входных данных содержит число n (1 ≤ n ≤ 10) — количество цифр, которые смог показать на индикаторе Алексей.
    Следующие n строк содержат по одной цифре ai (0 ≤ ai ≤ 9) — сами цифры, которые Алексей смог показать. Гарантируется, что все ai различны.

        Выходные данные
    Выведите элементы искомого множества в порядке возрастания, каждую цифру в отдельной строке.
     */

    /**
     * сделано
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> segmentsMap = new HashMap<>();
        segmentsMap.put(0, "123689"); //цифра : её сегменты на табло
        segmentsMap.put(1, "348");
        segmentsMap.put(2, "2379");
        segmentsMap.put(3, "2457");
        segmentsMap.put(4, "1358");
        segmentsMap.put(5, "12589");
        segmentsMap.put(6, "45689");
        segmentsMap.put(7, "246");
        segmentsMap.put(8, "1235689");
        segmentsMap.put(9, "12357");

        int userIn = scanner.nextInt();
        int[] userInMass = new int[userIn]; //вводы пользователя
        StringBuilder availableDigits = new StringBuilder();
        for (int i = 0; i < userIn; i++) { //заполняем вводы пользователя
            userInMass[i] = scanner.nextInt();
            availableDigits.append(segmentsMap.get(userInMass[i]));
        }

        ArrayList<Integer> availableDigitsList = new ArrayList<>();
        int correctDigits = 0;
        for (int i = 0; i < segmentsMap.size(); i++) { //ищем совпадения
            for (int j = 0 ; j < segmentsMap.get(i).length(); j++) {
                for (int k = 0; k < availableDigits.length(); k++) {
                    if (segmentsMap.get(i).charAt(j) == availableDigits.charAt(k)) {
                        correctDigits++;
                        break;
                    }
                }
            }
            if (correctDigits == segmentsMap.get(i).length()) {
                availableDigitsList.add(i);
            }
            correctDigits = 0;
        }

        for (Integer digit : availableDigitsList) {
            System.out.println(digit);
        }
    }
}