import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Book book1 = new Book(
            "John",
            201,
            3000,
            "Мах");
    Book book2 = new Book(
            "Alex",
            259,
            5_000,
            "Smith");
    Smartphone phone1 = new Smartphone(
            "Pear",
            231,
            56_000,
            "Vendor"
    );
    Smartphone phone2 = new Smartphone(
            "Cherry",
            321,
            64_000,
            "Black"
    );

    @Test
    public void exceptionsTest() {
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(phone1);
        repo.addProduct(phone2);
        Assertions.assertThrows(NotFoundExceptions.class, () -> {
            repo.deleteById(120);
        });
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.addProduct(book1);
        repo.addProduct(book2);
        repo.addProduct(phone1);
        repo.addProduct(phone2);
        Product[] expected = {book2, phone1, phone2};
        Product[] actual = repo.deleteById(201);
        Assertions.assertArrayEquals(expected, actual);
    }
}

//    @Test
//    public void shouldFindAllProducts() {
//        ProductRepository repo = new ProductRepository();
//
//        repo.addProduct(book1);
//        repo.addProduct(book2);
//        repo.addProduct(phone1);
//        repo.addProduct(phone2);
//
//        Product[] expected = {book1, book2, phone1, phone2};
//        Product[] actual = repo.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
//
//    @Test
//    public void shouldFindBookByName() {
//        ProductRepository repo = new ProductRepository();
//        Manager manager = new Manager(repo);
//        manager.add(book1);
//        manager.add(book2);
//        manager.add(phone1);
//        manager.add(phone2);
//
//        Product[] expected = {book2};
//        Product[] actual = manager.searchBy("Alex");
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldNoFindProduct() {
//        ProductRepository repo = new ProductRepository();
//        Manager manager = new Manager(repo);
//        manager.add(book1);
//        manager.add(book2);
//        manager.add(phone1);
//        manager.add(phone2);
//
//        Product[] expected = {};
//        Product[] actual = manager.searchBy("Pearl");
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldDeleteById() {
//        ProductRepository repo = new ProductRepository();
//        Manager manager = new Manager(repo);
//        manager.add(book1);
//        manager.add(book2);
//        manager.add(phone1);
//        manager.add(phone2);
//        repo.deleteById(231);
//
//        Product[] expected = {book1, book2, phone2};
//        Product[] actual = repo.findAll();
//        Assertions.assertArrayEquals(expected, actual);
//
//    }




