package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author 崔家辉
 * @date 2020/08/26 10:12
 * @Description:
 */
@Data
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
