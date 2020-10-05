package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ToDoData {

    private static int idValue = 1;
    private final List<Item> items = new ArrayList<>();

    public ToDoData() {
        //dummy data
        addItem(new Item(
                "Brush Teeth",
                LocalDate.of(2020,
                        10,20),
                "Use Crest"));
        addItem(new Item(
                "Wash Hands",
                LocalDate.of(2020,
                        10,21),
                "Use Soap"));
        addItem(new Item(
                "Dress",
                LocalDate.of(2020,
                        10,22),
                "Clothes"));
        addItem(new Item(
                "shop",
                LocalDate.of(2020,
                        10,22),
                "food"));
    }

    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull Item item){
        //nonnull makes sure the param is not null, otherwise throws a nullpointer
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void deleteItem(int id){
        ListIterator<Item> iterator = items.listIterator();
        while (iterator.hasNext()){
            Item test = iterator.next();
            if (test.getId() == id){
                iterator.remove();
                break;
            }
        }
    }

    public Item getItem(int id){
        for (Item item:items){
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull Item item){
       ListIterator<Item> iterator = items.listIterator();
       while(iterator.hasNext()){
           Item test = iterator.next();
           if (test.equals(item)){
               iterator.set(item);
               break;
           }
       }
    }

}
