package lab.model.simple;

import lab.model.Drink;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Squishee implements Drink {

    private String name;
}
