public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;

    }

    public void removeById(int removeId) {
        if(findById(removeId) == null) {
            throw new NotFoundException(removeId);
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
    private Product findById(int id) {
        for (Product product : products) {
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }
}