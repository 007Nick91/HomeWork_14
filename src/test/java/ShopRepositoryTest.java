import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    // Задание 1
    @Test
    public void testProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Door", 1000);
        Product product2 = new Product(2, "Window", 2000);
        Product product3 = new Product(3, "Chair", 3000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Door", 1000);
        Product product2 = new Product(2, "Window", 2000);
        Product product3 = new Product(3, "Chair", 3000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(4);
        });

    }

    // Задание 2
    @Test
    public void testProductPlus() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Door", 1000);
        Product product2 = new Product(2, "Window", 2000);
        Product product3 = new Product(3, "Chair", 3000);
        Product product4 = new Product(4, "Chairs", 4000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testProductAgain() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Door", 1000);
        Product product2 = new Product(2, "Window", 2000);
        Product product3 = new Product(3, "Chair", 3000);
        Product product4 = new Product(3, "Chairs", 4000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.tmp(3);
        });

    }
}
