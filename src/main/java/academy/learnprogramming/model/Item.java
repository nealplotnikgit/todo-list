package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@EqualsAndHashCode(of={"id"})
@Getter
@Setter
public class Item {

    private int id;
    private String title;
    private LocalDate deadline;
    private String details;

    public Item(String title, LocalDate deadline, String details){
        this.title = title;
        this.deadline = deadline;
        this.details = details;
    }


}
