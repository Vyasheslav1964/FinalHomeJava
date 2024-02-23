import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CompStory {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Приглашаем выбрать ноутбук! \n");
        Scanner keyboard = new Scanner(System.in);
        Map<Integer, String> resultFilter = new HashMap<>(); // словарь, куда будем заносить выбранные пользователем критерии фильтрации
        int search;
        boolean Flag;
        do {
            resultFilter.clear();
            System.out.println("Выберите ноутбук по критериям для поиска");
            for (Integer i : NoteFilter().keySet()) {
                System.out.println(i + " - " + NoteFilter().get(i));
            }
            do {
                System.out.print("Введите номер критерия или 0 для продолжения поиска: => ");
                search = keyboard.nextInt();
                if (search != 0 ) {
                    System.out.print(NoteFilter().get(search) + "=> ");
                    //if (search == 3 || search == 4) {
                        resultFilter.put(search, keyboard.nextLine()); 
                    //}
                    //else {
                    resultFilter.put(search, keyboard.next());
                    //}
                    System.out.println(resultFilter);
                }
            } while (search != 0);
            Set<Notbooks> filteredNotebooks = filterSet(resultFilter);
            if (filteredNotebooks.isEmpty()) {
                System.out.print("К сожалению, по выбранным характеристикам ничего не нашлось,\nпоказать Вам ноутбуки с самым высоким рейтингом? (Y/N) => ");
                if ("YyДадаYesyesнН".contains(keyboard.next())) {
                    resultFilter.clear();
                    resultFilter.put(7, "4.5");
                    for (Notbooks rate_notes : filterSet(resultFilter)) {
                        System.out.println(rate_notes.toString());
                        System.out.println();
                    }
                    System.out.print("Поищем что-то еще? (Y/N) => ");
                    Flag = "YyДадаYesyesнН".contains(keyboard.next());

                } else {
                    System.out.print("Поищем что-то еще? (Y/N) => ");
                    Flag = "YyДадаYesyesнН".contains(keyboard.next());
                }
            } else {
                System.out.println("\nПо Вашему запросу удалось найти " + filteredNotebooks.size()+ " ноутбуков:\n");
                for (Notbooks nots : filteredNotebooks) {
                    System.out.println(nots.toString());
                    System.out.println();
                }
                System.out.print("Поищем что-то еще? (Y/N) => ");
                Flag = "YyДадаYesyesнН".contains(keyboard.next());
            }
        } while (Flag);

        System.out.println("До свидания, спасибо что зашли!");

        keyboard.close();
    }


    static Set<Notbooks> addNotebooks() {
        Notbooks notebook1 = new Notbooks();
        notebook1.ram = 16; // ОЗУ
        notebook1.hdd = 512; // объем жесткого диска
        notebook1.os = "Linux"; //Операционная система
        notebook1.colour = "Black"; //Цвет
        notebook1.price = 105_999.00; //Стоимость
        notebook1.rating = 4.7; //Рейтинг по 5-бальной шкале

        Notbooks notebook2 = new Notbooks();
        notebook2.ram = 8; // ОЗУ
        notebook2.hdd = 256; // объем жесткого диска
        notebook2.os = "Win10"; //Операционная система
        notebook2.colour = "Grey"; //Цвет
        notebook2.price = 70_800.40; //Стоимость
        notebook2.rating = 4.9; //Рейтинг по 5-бальной шкале

        Notbooks notebook3 = new Notbooks();
        notebook3.ram = 16; // ОЗУ
        notebook3.hdd = 512; // объем жесткого диска
        notebook3.os = "BIOS"; //Операционная система
        notebook3.colour = "Grey"; //Цвет
        notebook3.price = 40_000.20; //Стоимость
        notebook3.rating = 4.6; //Рейтинг по 5-бальной шкале

        Notbooks notebook4 = new Notbooks();
        notebook4.ram = 8; // ОЗУ
        notebook4.hdd = 256; // объем жесткого диска
        notebook4.os = "Linux"; //Операционная система
        notebook4.colour = "Grey"; //Цвет
        notebook4.price = 52_698.10; //Стоимость
        notebook4.rating = 4.8; //Рейтинг по 5-бальной шкале

        Notbooks notebook5 = new Notbooks();
        notebook5.ram = 16; // ОЗУ
        notebook5.hdd = 512; // объем жесткого диска
        notebook5.os = "Linux"; //Операционная система
        notebook5.colour = "White"; //Цвет
        notebook5.price = 74_699.10; //Стоимость
        notebook5.rating = 4.7; //Рейтинг по 5-бальной шкале

        Notbooks notebook6 = new Notbooks();
        notebook6.ram = 8; // ОЗУ
        notebook6.hdd = 256; // объем жесткого диска
        notebook6.os = "Win10"; //Операционная система
        notebook6.colour = "Grey"; //Цвет
        notebook6.price = 99_999.10; //Стоимость
        notebook6.rating = 4.9; //Рейтинг по 5-бальной шкале

        Notbooks notebook7 = new Notbooks();
        notebook7.ram = 8; // ОЗУ
        notebook7.hdd = 256; // объем жесткого диска
        notebook7.os = "Win10"; //Операционная система
        notebook7.colour = "Red"; //Цвет
        notebook7.price = 68_698.10; //Стоимость
        notebook7.rating = 4.8; //Рейтинг по 5-бальной шкале

       

        Set<Notbooks> notebook = new HashSet<>();

        notebook.add(notebook1);
        notebook.add(notebook2);
        notebook.add(notebook3);
        notebook.add(notebook4);
        notebook.add(notebook5);
        notebook.add(notebook6);
        notebook.add(notebook7);
        
        return notebook;
    }

    static Set<Notbooks> filterSet(Map<Integer, String> map) {
        if (map.isEmpty()) return addNotebooks();
        Set<Notbooks> notebooks = addNotebooks();
        Set<Notbooks> set = new HashSet<>(notebooks);
        Map<String, String> colours = new HashMap<>();
        colours.put("чёрный", "Black");
        colours.put("белый", "White");
        colours.put("серый", "Grey");
        colours.put("красный", "Red");
        System.out.println(colours);

        Map<String, String> osystem = new HashMap<>();
        osystem.put("линукс", "Linux");
        osystem.put("линакс", "Linux");
        osystem.put("виндоус", "Win10");
        osystem.put("винда", "Win10");
        osystem.put("вин", "Win10");
        osystem.put("win", "Win10");
        osystem.put("windows", "Win10");
        osystem.put("биос", "BIOS");
        System.out.println(osystem);
        for (Notbooks notebook : notebooks) {
            System.out.println(map.get(1));

            if (map.containsKey(1) && notebook.ram != Integer.parseInt(map.get(1))
                    || map.containsKey(2) && notebook.hdd != Integer.parseInt(map.get(2))
                    || map.containsKey(3) && !(notebook.os.equalsIgnoreCase(map.get(3)))
                    && !(notebook.os.equalsIgnoreCase(osystem.get(map.get(3).toLowerCase())))
                    || map.containsKey(4) && !(notebook.colour.equalsIgnoreCase(colours.get(map.get(4).toLowerCase())))
                    && (!(notebook.colour.equalsIgnoreCase(map.get(4))))
                    || map.containsKey(5) && notebook.price >= Double.parseDouble(map.get(5))
                    || map.containsKey(6) && notebook.rating <= Double.parseDouble(map.get(6))) {
                set.remove(notebook);
                     
                //System.out.println(notebook.hdd);
                //System.out.println(map.get(3));

            }

        }
        return set;
    }

    static Map<Integer, String> NoteFilter() {
        Map<Integer, String> noteFilter = new HashMap<>(); // словарь критериев фильтрации
        noteFilter.put(1, "Объем оперативной памяти");
        noteFilter.put(2, "Объем жесткого диска");
        noteFilter.put(3, "Операционная система");
        noteFilter.put(4, "Цвет");
        noteFilter.put(5, "Максимальная цена");
        noteFilter.put(6, "Минимальный рейтинг покупателей");
        noteFilter.put(0, "Поиск");
        return noteFilter;
    }


    
}
