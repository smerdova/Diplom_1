import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BunTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Кириллица"                       , 100},
                { "English"                         , 100},
                { ""                                , 100},
                { null                              , 100},
                { "1234567"                         , 100},
                { "!@#$%^&*()_+-=\\|'\"/?.><,"      , 100},

                { "Имя"                             , 100},
                { "Имя"                             , 0},
                { "Имя"                             , Float.MAX_VALUE},
                { "Имя"                             , Float.MAX_VALUE},
        });
    }

    private final String name;

    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Test
    public void getNameSuccessReturnsName() {
        Bun bun = new Bun(name, price);

        String actualName = bun.getName();

        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getPriceSuccessReturnsPrice() {
        Bun bun = new Bun(name, price);

        float actualPrice = bun.getPrice();

        Assert.assertEquals(price, actualPrice, 0);
    }
}
