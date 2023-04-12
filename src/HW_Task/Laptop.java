package HW_Task;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;
    private double price;

    // конструктор, геттеры и сеттеры

    @Override
    public String toString() {
        return brand + " " + model + ", " + ram + "GB RAM, " + storage + "GB storage, " + os + ", " + color + ", $" + price;
    }
}

List<Laptop> laptops = new ArrayList<>();
laptops.add(new Laptop("Apple", "MacBook Pro", 16, 512, "macOS", "Silver", 1999.99));
laptops.add(new Laptop("Dell", "XPS 13", 8, 256, "Windows 10", "Black", 1099.99));
laptops.add(new Laptop("Lenovo", "ThinkPad X1 Carbon", 16, 1_000, "Windows 10", "Black", 1499.99));
// и т.д.


public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
   return laptops.stream().filter(laptop -> {
   for (Map.Entry<String, Object> entry : filters.entrySet()) {
   String key = entry.getKey();
   Object value = entry.getValue();
   switch (key) {
     case "ram":
        if (laptop.getRam() < (int) value) {
            return false;
        }
        break;
     case "storage":
        if (laptop.getStorage() < (int) value) {
            return false;
        }
        break;
     case "os":
        if (!laptop.getOs().equals(value)) {
            return false;
        }
        break;
     case "color":
        if (!laptop.getColor().equals(value)) {
            return false;
        }
        break;
     case "price":
        if (laptop.getPrice() > (double) value) {
            return false;
        }
        break;
        }
     }
     return true;
   }).collect(Collectors.toSet());
}

Map<String, Object> filters = new HashMap<>();
filters.put("ram", 16);
filters.put("os", "Windows 10");
filters.put("price", 1500.0);

Set<Laptop> filteredLaptops = filterLaptops(laptops, filters);
filteredLaptops.forEach(System.out::println);

//Здесь мы задали критерии фильтрации (минимальный объем ОЗУ, операционную систему и максимальную цену) и вывели на экран ноутбуки,
//проходящие по этим критериям.
