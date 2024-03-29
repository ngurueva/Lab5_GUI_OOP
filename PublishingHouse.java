package L5_GUI.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class PublishingHouse {
    private ArrayList<PrinteredEdition> list = new ArrayList<>();

    public PublishingHouse(){
        list.add(new Book("Поле из снов", "Лайкин Михаил", 2001, 100, "Драма"));
        list.add(new Book("Вот это дааа", "Пеймиров Глеб", 2002, 1010, "Мистика"));
        list.add(new Textbook("Математика для малышей", "Ябов Павел Александрович", 2017, 513, "Математика"));
        list.add(new Magazine("Садоводы нашего поселка", "Попов Павел", 2020, 12, 13));
        list.add(new Book("Горы", "Рогов Максим", 2001, 100, "Драма"));
        list.add(new Book("Ложь ради тебя", "Пеймиров Глеб", 2010, 1010, "Драма"));
        list.add(new Textbook("Физика 10-11 класс", "Шишкин Роман", 2019, 113, "Физика"));
        list.add(new Magazine("Сегодня", "Ложкина Мария", 2023, 53, 1));
        list.add(new Book("Скажи кто ты?", "Очигов Матвей", 2016, 450, "Ужасы"));
        list.add(new Book("Дорога жизни", "Лайкин Михаил", 2002, 1010, "Драма"));
        list.add(new Textbook("Биология 8 класс", "Ломинова Лариса", 2017, 513, "Биология"));
        list.add(new Magazine("Шик", "Лимуров Дмитрий", 2021, 38, 10));
    }

    public int getSizeList(){
        return this.list.size();
    }

    public PrinteredEdition getEdition(int index){
        return list.get(index);
    }

    public void addEdition(PrinteredEdition edition){
        list.add(edition);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public int getCount() {
        return this.list.size();
    }

    public ArrayList<PrinteredEdition> sort(String option) {
        if (Objects.equals(option, "по названию")){
            list.sort(Comparator.comparing(PrinteredEdition::getTitle));
            return list;
        }
        if (Objects.equals(option, "по году издания")){
            list.sort(Comparator.comparing(PrinteredEdition::getYear).reversed());
            return list;
        }
        if (Objects.equals(option, "по типу издания")){
            list.sort(Comparator.comparing(PrinteredEdition::getType));
            return list;
        }
        return list;
    }

    public void setEdition(int index, PrinteredEdition edition) {
        this.list.set(index, edition);
    }
}
