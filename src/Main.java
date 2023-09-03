
import Exceptions.InvalidException;
import Major.SelectOption;

public class Main {
    public static void main(String[] args) {

        try {
            SelectOption.selectOption();
        } catch (InvalidException e) {
            throw new RuntimeException(e);
        }
    }

}

