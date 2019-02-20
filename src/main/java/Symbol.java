import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Symbol {
    private String stringValue;
    private Integer integerValue;
    private Boolean isOperator;


    public Symbol(String stringValue, Integer integerValue, Boolean isOperator) {
        this.stringValue = stringValue;
        this.integerValue = integerValue;
        this.isOperator = isOperator;
    }

    @Override
    public boolean equals(Object object) {
//        List<Character> chars = new ArrayList<>();
        if (object instanceof String){
            isTwinChars(stringValue, String.valueOf(object));
        }

        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Symbol symbol = (Symbol) object;
        return Objects.equals(stringValue, symbol.stringValue) &&
                Objects.equals(integerValue, symbol.integerValue) &&
                Objects.equals(isOperator, symbol.isOperator);
    }


    public static boolean isTwinChars (String a, String b) {
        char[] aca = a.toLowerCase().toCharArray();
        char[] bca = b.toLowerCase().toCharArray();
        Arrays.sort(aca);
        Arrays.sort(bca);
        return new String(aca).equals(new String(bca));
    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(stringValue, integerValue, isOperator);
//    }
}
