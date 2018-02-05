package lab.model.aop;

import lab.model.ioc.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer implements Person {
    private String name;
    private boolean broke;

    public Customer(String name) {
        this.name = name;
    }
}
