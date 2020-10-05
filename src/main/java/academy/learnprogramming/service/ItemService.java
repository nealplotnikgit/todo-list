package academy.learnprogramming.service;

import academy.learnprogramming.model.Item;
import academy.learnprogramming.model.ToDoData;

public interface ItemService {

    void addItem(Item item);
    void removeItem(int id);
    Item getItem(int id);
    void updateItem(Item item);
    ToDoData getData();

}
