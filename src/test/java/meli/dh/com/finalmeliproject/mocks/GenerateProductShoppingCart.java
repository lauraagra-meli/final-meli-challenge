package meli.dh.com.finalmeliproject.mocks;

import meli.dh.com.finalmeliproject.model.Product;
import meli.dh.com.finalmeliproject.model.ProductShoppingCart;
import meli.dh.com.finalmeliproject.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class GenerateProductShoppingCart {

    public static  ProductShoppingCart newProductShoppingCart() {
        Product product = new Product();
        product.setId("meli");
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1);

        return ProductShoppingCart.builder()
                .id(1L)
                .product(product)
                .productQuantity(2)
                .shoppingCart(shoppingCart)
                .build();
    }
    public static List<ProductShoppingCart> newProductShoppingCartList(){
        List<ProductShoppingCart> productShoppingCartList = new ArrayList<>();
        productShoppingCartList.add(
                new ProductShoppingCart(
                        1, 1,
                        GenerateProduct.newProductToSave(),
                        new ShoppingCart()));

        return productShoppingCartList;
    }
}
