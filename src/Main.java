import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
            " ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore" +
            " eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        System.out.println(" Программа определения, какая буква встречалась" +
                " в тексте чаще всего и какая реже всего.");
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) { //цикл for
            char key = text.charAt(i); //получение символа по индексу
            if (Character.isLetter(key)) { // проверка является ли символ буквой
                if (!map.containsKey(key)) { // Его нет в мапе. Значит, мы встретили его в первый (значение 1, тк встретили его всего один раз).
                    map.put(key, 1);
                } else { //Он есть в мапе. Значит он нам уже встречался (увеличиваем это число на 1 и вставляем обратно в мапу).
                    int value = map.get(key) + 1; // возврат значения по ключу
                    map.put(key, value); //добавляем элемент value с ключом key
                }
            }
        }

        System.out.println("Список букв встречаемых в тексте и их кол-во: " + "\n" + map);
        Map.Entry<Character, Integer> maxEntry = getMaxEntry(map); //возвращаем метод расчета мак кол-ва букв
        System.out.println("Буква встречаемая в тексте чаще всего: " + "\n" + maxEntry.getKey() + " кол-во раз в тексе: " + maxEntry.getValue());
        Map.Entry<Character, Integer> minEntry = getMinEntry(map);//возвращаем метод расчета мин кол-ва букв
        System.out.println("Буква встречаемая в тексте реже всего: " + "\n" + minEntry.getKey() + " кол-во раз в тексте: " + minEntry.getValue());
        System.out.println("Программа завершина");
    }

    public static Map.Entry<Character, Integer> getMaxEntry(Map<Character, Integer> map) { //поиск максимального значения через перебор значения (Map.Entry)
        Map.Entry<Character, Integer> maxEntry = null;

        for (Map.Entry<Character, Integer> max : map.entrySet()) {
            if (maxEntry == null || max.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = max;
            }
        }
        return maxEntry;
    }

    public static Map.Entry<Character, Integer> getMinEntry(Map<Character, Integer> map) { //поиск минимального значения через перебор значения (Map.Entry)
        Map.Entry<Character, Integer> minEntry = null;

        for (Map.Entry<Character, Integer> min : map.entrySet()) {
            if (minEntry == null || min.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = min;
            }
        }
        return minEntry;
    }
}
