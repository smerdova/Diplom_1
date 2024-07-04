import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Test
    public void setBunsSuccess() {
        Bun bun = mock(Bun.class);
        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientSuccess() {
        Ingredient ingredient = mock(Ingredient.class);
        Burger burger = new Burger();

        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientSuccess() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        Burger burger = new Burger();
        burger.ingredients = ingredients;

        burger.removeIngredient(1);

        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
        assertNotEquals(ingredient2, burger.ingredients.get(1));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void moveIngredientSuccess() {
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);
        Ingredient ingredient3 = mock(Ingredient.class);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);

        Burger burger = new Burger();
        burger.ingredients = ingredients;

        burger.moveIngredient(0, 1);

        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
        assertEquals(ingredient3, burger.ingredients.get(2));
    }

    @Test
    public void getPriceSuccess() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn((float)10.33);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn((float)100.22);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn((float)1000.77);

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients = ingredients;

        float price = burger.getPrice();

        assertEquals(1121.65 ,price, 1);
    }

    @Test
    public void getReceiptSuccess() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn((float)10);
        when(bun.getName()).thenReturn("булочка");

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn((float)100);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getName()).thenReturn("наполнение");

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn((float)1000);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getName()).thenReturn("соус");

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients = ingredients;

        String receipt = burger.getReceipt();

        assertEquals(
                "(==== булочка ====)\r\n" +
                "= filling наполнение =\r\n" +
                "= sauce соус =\r\n" +
                "(==== булочка ====)\r\n" +
                "\r\nPrice: 1120,000000\r\n"
                , receipt);
    }
}
