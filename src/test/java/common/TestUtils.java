package common;

import lab.model.Person;
import lab.model.simple.UsualPerson;
import lombok.SneakyThrows;
import lombok.val;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public interface TestUtils {

    @SneakyThrows
    static String fromSystemOut(Runnable runnable) {

        PrintStream realOut = System.out;

        try (val out = new ByteArrayOutputStream();
             val printStream = new PrintStream(out)) {

            System.setOut(printStream);
            runnable.run();

            return new String(out.toByteArray());

        } finally {
            System.setOut(realOut);
        }
    }

    /**
     * @apiNote This method use some dirty hack in reflection API for making access to private field!
     */
    @SneakyThrows
    static void setBroke(Person person, boolean broke) {
        assert person.getClass() == UsualPerson.class;
        Field brokeField = person.getClass().getDeclaredField("broke");
//        if (!brokeField.canAccess(person))
            brokeField.setAccessible(true);
        brokeField.set(person, broke);
    }
}
