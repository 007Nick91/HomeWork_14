
public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }


    // Метод добавления
    public void add(Product product) {
        products = addToArray(products, product);
    }

    public void tmp(int id) {
        Product haveId = ById(id);
        if (haveId != null) {
            throw new AlreadyExistsException(id);
        }
    }

    public Product[] findAll() {
        return products;

    }

    private Product ById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    // Метод удаления
    public void remove(int id) {
        Product removePro = findById(id);
        if (removePro == null) {
            throw new NotFoundException(id);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    //Метод поиска
    private Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
