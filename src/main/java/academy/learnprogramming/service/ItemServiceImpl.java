package academy.learnprogramming.service;

import academy.learnprogramming.model.Item;
import academy.learnprogramming.model.ToDoData;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{

    final ToDoData toDoData = new ToDoData();

    @Override
    public void addItem(Item item) {
        toDoData.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        toDoData.deleteItem(id);
    }

    @Override
    public Item getItem(int id) {
        return toDoData.getItem(id);
    }

    @Override
    public void updateItem(Item item) {
        toDoData.updateItem(item);
    }

    @Override
    public ToDoData getData() {
        return toDoData;
    }
}
