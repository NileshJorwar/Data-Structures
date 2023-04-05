package src.generics;

import java.util.Optional;

public class Operations {
    public static void main(String[] args) {
        Optional<String> op
                = Optional.of("Value");
        Optional<String> op1 = op.map(
                val -> val + " replaced"
        );
        System.out.println(op1);

        Optional<String> optional = Optional.empty();
        String str = optional.map(x -> "Replaced").orElse("Empty");
        System.out.println(str);
        Optional<String> op2 = op.filter(val -> val.equalsIgnoreCase("Val"));
        System.out.println("---" + op2.orElse("Empty data"));
        Optional<String> op3 = op.flatMap(v -> Optional.of("Replaced"));
        System.out.println(op3.get());
    }
}
