package meli.dh.com.finalmeliproject.service.shoppingCart;

import meli.dh.com.finalmeliproject.dto.shoppingCart.ResponseShoppingCartDto;
import meli.dh.com.finalmeliproject.exception.BadRequestExceptionImp;
import meli.dh.com.finalmeliproject.exception.NotFoundExceptionImp;
import meli.dh.com.finalmeliproject.mocks.GeneratePurchaseOrderDTO;
import meli.dh.com.finalmeliproject.mocks.GenerateShoppingCart;
import meli.dh.com.finalmeliproject.mocks.GenerateWareHouseCategoryDTO;
import meli.dh.com.finalmeliproject.mocks.repo.BuyerRepoMock;
import meli.dh.com.finalmeliproject.mocks.repo.ProductShoppingCartRepoMock;
import meli.dh.com.finalmeliproject.mocks.repo.ShoppingCartRepoMock;
import meli.dh.com.finalmeliproject.mocks.service.BuyerServiceMock;
import meli.dh.com.finalmeliproject.mocks.service.ProductServiceMock;
import meli.dh.com.finalmeliproject.model.ShoppingCart;
import meli.dh.com.finalmeliproject.model.WareHouseCategory;
import meli.dh.com.finalmeliproject.repository.IProductShoppingCartRepo;
import meli.dh.com.finalmeliproject.repository.IShoppingCartRepo;
import meli.dh.com.finalmeliproject.service.buyer.BuyerService;
import meli.dh.com.finalmeliproject.service.buyer.IBuyerService;
import meli.dh.com.finalmeliproject.service.product.IProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Mock
    private IProductService productService;

    @Mock
    private IShoppingCartRepo shoppingCartRepo;

    @Mock
    private IProductShoppingCartRepo productShoppingCartRepo;

    @Mock
    private IBuyerService buyerService;


    @Test
    void shoppingCart() {
        BDDMockito.when(
                shoppingCartRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(ShoppingCartRepoMock.findById());

        BDDMockito.when(
                buyerService.findById(ArgumentMatchers.anyLong())
        ).thenReturn(BuyerServiceMock.findById());

        BDDMockito.when(
                productService.findByProductId(ArgumentMatchers.anyString())
        ).thenReturn(ProductServiceMock.findProductById());

        BDDMockito.when(
                productService.save(ArgumentMatchers.any())
        ).thenReturn(ProductServiceMock.save());

        BDDMockito.when(
                shoppingCartRepo.save(ArgumentMatchers.any())
        ).thenReturn(ShoppingCartRepoMock.save());

        BDDMockito.when(
                productShoppingCartRepo.saveAll(ArgumentMatchers.any())
        ).thenReturn(ProductShoppingCartRepoMock.saveAll());

        ResponseShoppingCartDto response = shoppingCartService.shoppingCart(GeneratePurchaseOrderDTO.newPurchaseOrder());

        assertThat(response.getTotalPrice()).isEqualTo(2);

    }

    @Test
    void findShoppingCartProductsById() {
        BDDMockito.when(
                shoppingCartRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(ShoppingCartRepoMock.findById());

        ShoppingCart sc = shoppingCartService.findShoppingCartProductsById(ArgumentMatchers.anyLong());

        verify(shoppingCartRepo, atLeastOnce()).findById(ArgumentMatchers.anyLong());
    }

    @Test
    void findShoppingCartProductsByIdNotExist() {
        BDDMockito.when(
                shoppingCartRepo.findById(ArgumentMatchers.anyLong())
        ).thenReturn(ShoppingCartRepoMock.findByIdException());

        BadRequestExceptionImp exceptionImp = assertThrows(
                BadRequestExceptionImp.class,
                () -> {
                    ShoppingCart sc = shoppingCartService.findShoppingCartProductsById(1);
                }
        );
    }

}
