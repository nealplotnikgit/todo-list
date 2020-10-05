package academy.learnprogramming.controller;

import academy.learnprogramming.model.Item;
import academy.learnprogramming.model.ToDoData;
import academy.learnprogramming.service.ItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService service) {
        this.itemService = service;
    }

@ModelAttribute
public ToDoData toDoData(){
    return itemService.getData();
}

    @GetMapping(Mappings.ITEMS)
    public String items(){
        return Views.ITEMS;
    }

    @GetMapping(Mappings.VIEWITEM)
    public String viewitem(@RequestParam int id, Model model){
        Item item = itemService.getItem(id);
        model.addAttribute("viewItem",item);
        return Views.VIEWITEM;
    }

    @GetMapping(Mappings.ADDITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id,  Model model){
        log.info("addedit {}",id);
        Item item = itemService.getItem(id);
        if (item == null) {
            item = new Item("", LocalDate.now(), "");
        }  //take the item and show on screen - it may have 0 ID or the actual one
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return Views.ADD_ITEM;

    }

    @PostMapping(Mappings.ADDITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) Item todoItem){
        log.info("todoItem {}",todoItem);
        if (todoItem.getId() == 0) {
            itemService.addItem(todoItem);
        } else {
            itemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETEITEM)
    public String deleteItem(@RequestParam int id){
        log.info("deleteItem {}",id);
        itemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

}
