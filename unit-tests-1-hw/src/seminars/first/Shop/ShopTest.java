package seminars.first.Shop;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

/* Домашнее задание к семинару №1 */

public class ShopTest {
    public static void main(String[] args) {
            /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
        Product apple = new Product();
        apple.setCost(50);
        apple.setTitle("apple");
        Product orange = new Product();
        orange.setCost(75);
        orange.setTitle("orange");
        Product melon = new Product();
        melon.setCost(100);
        melon.setTitle("melon");
        ArrayList<Product> products = new ArrayList<>();
        products.add(melon);
        products.add(apple);
        products.add(orange);
        Shop shop = new Shop();
        shop.setProducts(products);
        Shop.printProducts(shop.getProducts());
        shop.sortProductsByPrice();
        Shop.printProducts(shop.getProducts());
        assertThat(shop.getProducts())
                .hasSize(3)
                .contains(melon, apple, orange);
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(melon);
        assertThat(shop.sortProductsByPrice()).containsExactly(apple, orange, melon);

    }
}