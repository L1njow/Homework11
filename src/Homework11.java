import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Homework11 {
    public static void main(String[] args) {

        //Завдання 1
        List<String> list = new ArrayList<>();
        list.add("Ivan");
        list.add("Vlad");
        list.add("Olga");
        list.add("Katerina");
        list.add("Bill");

        System.out.println("Завдання 1:\n" + exercise1(list));

        //Завдання 2
        System.out.println("\nЗавдання 2:\n" + exercise2(list));

        //Завдання 3
        List<String> numbers = new ArrayList<>();
        numbers.add("1, 2, 0");
        numbers.add("4, 5");

        System.out.println("\nЗавдання 3:\n" + exercise3(numbers));

        //Задання 4
        Stream<Long> test = Random.generateStream(25214903917L, 11L, 2 ^ 48);
        System.out.println("\nЗавдання 4:");
        test.limit(10).collect(Collectors.toList()).forEach(number -> System.out.print(number + " "));
        System.out.println("\n");

        //Завдання 5
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 67, 32, -1, 0);
        Stream<Integer> stream2 = Stream.of(0, -5, 89, 4);
        System.out.println("Завдання 5:\n" + zip(stream1, stream2).collect(Collectors.toList()));
    }

    public static String exercise1(List<String> list) {
        StringJoiner result = new StringJoiner(", ");
        List<String> changedList = list.stream().filter(name -> list.indexOf(name) % 2 != 0).collect(Collectors.toList());

        for (int i = 0; i < changedList.size(); i++) {
            result.add((2 * i + 1) + ". " + changedList.get(i));
        }
        return result.toString();
    }

    public static List<String> exercise2(List<String> list) {
        return list.stream().map(String::toUpperCase).sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static String exercise3(List<String> list) {
        List<Integer> newList = new ArrayList<>();

        for (String element : list) {
            String[] splitElement = element.split(", ");

            for (String number : splitElement) {
                newList.add(Integer.parseInt(number));
            }
        }

        List<Integer> resultList = newList.stream().sorted().collect(Collectors.toList());
        StringJoiner result = new StringJoiner(", ");

        for (Integer element : resultList) {
            result.add(element.toString());
        }
        return result.toString();
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        List<T> result = new ArrayList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            result.add(firstList.get(0));
            result.add(secondList.get(0));
            firstList.remove(0);
            secondList.remove(0);
        }
        return result.stream();
    }
}