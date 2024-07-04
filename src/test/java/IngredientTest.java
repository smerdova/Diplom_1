import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private static final String NAME = "какое то название";
    private static final float PRICE = 333;

    @Test
    public void getNameSuccessReturnsName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, NAME, PRICE);

        String actualName = ingredient.getName();

        Assert.assertEquals(NAME, actualName);
    }

    @Test
    public void getPriceSuccessReturnsPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, NAME, PRICE);

        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(PRICE, actualPrice, 0);
    }

    @Test
    public void getTypeSuccessReturnsSauce() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, NAME, PRICE);

        IngredientType actualType = ingredient.getType();

        Assert.assertEquals(IngredientType.SAUCE, actualType);
    }

    @Test
    public void getTypeSuccessReturnsFilling() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, NAME, PRICE);

        IngredientType actualType = ingredient.getType();

        Assert.assertEquals(IngredientType.FILLING, actualType);
    }
}
