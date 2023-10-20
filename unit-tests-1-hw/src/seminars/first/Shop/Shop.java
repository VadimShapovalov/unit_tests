package seminars.first.Shop;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static void printProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println("Название: " + product.getTitle() + ", Стоимость: " + product.getCost());
        }
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        Collections.sort(products, Comparator.comparingInt(Product::getCost));
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        return Collections.max(products, Comparator.comparingInt(Product::getCost));
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

}