
public class Notbooks {
    int ram; // Oперативная память (ОЗУ)
    int hdd; // объем жесткого диска
    String os; // Операционная система
    String colour; // Цвет
    double price; // Стоимость
    double rating; // Рейтинг по 5-бальной шкале

    
  public String toString() {
        return  "Оперативная память: " + ram + " GB"
                + "\nОбъем жесткого диска: " + hdd + " GB"
                + "\nОперационная система: " + os
                + "\nЦвет: " + colour
                + "\nЦена: " + price + " руб."
                + "\nРейтинг покупателей: " + rating;   
}
}