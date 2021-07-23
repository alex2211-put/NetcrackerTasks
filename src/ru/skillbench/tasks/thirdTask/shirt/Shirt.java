package ru.skillbench.tasks.thirdTask.shirt;


public class Shirt {
    private final String id;
    private final String description;
    private final String color;
    private final String size;

    /**
     * Принимает параметры, значения которых записывает в соответствующие поля
     *
     * @param id          id рубашки
     * @param description описание
     * @param color       цвет
     * @param size        размер
     */
    public Shirt(String id, String description, String color, String size) {
        this.id = id.strip();
        this.description = description.strip();
        this.color = color.strip();
        this.size = size.strip();
    }

    /**
     * Принимает массив, соответствующие элементы которого записывает в поля объекта
     *
     * @param args массив параметров
     */
    public Shirt(String[] args) {
        this(args[0], args[1], args[2], args[3]);
    }

    /**
     * Конструктор по умолчанию - все поля инициализирует пустой строкой
     */
    public Shirt() {
        this.id = "";
        this.description = "";
        this.size = "";
        this.color = "";
    }

    /**
     * Из массива строк получает массив объектов класса Shirt
     *
     * @param string массив строк, где параметры разделяются запятыми
     */
    public static Shirt[] getShirtArray(String[] string) {
        Shirt[] ans = new Shirt[string.length];
        for (int i = 0; i < string.length; i++) {
            String[] tmp = string[i].split(",");
            ans[i] = new Shirt(tmp);
        }
        return ans;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\ndescription: " + this.description +
                "\ncolor: " + this.color + "\nsize: " + this.size;
    }


}
