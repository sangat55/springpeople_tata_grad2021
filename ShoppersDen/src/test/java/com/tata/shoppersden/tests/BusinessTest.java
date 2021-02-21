package com.tata.shoppersden.tests;

import com.tata.shoppersden.business.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


public class BusinessTest {
    private AddCategoryAction addCategoryAction;
    private AddProductAction addProductAction;
    private DeleteProductAction deleteProductAction;
    private UpdateCategoryNameAction updateCategoryNameAction;
    private AddToCartAction addToCartAction;
    private PlaceOrderAction placeOrderAction;
    private UpdateProductNameAction updateProductNameAction;
    private ForgetPasswordAction forgetPasswordAction;
    private UpdateProductPriceAction updateProductPriceAction;
    private UpdateProductDescAction updateProductDescAction;
    private UpdateProductImageAction updateProductImageAction;
    private UpdateProductDomAction updateProductDomAction;
    private UpdateCustomerNameAction updateCustomerNameAction;
    private UpdateCustomerAddressAction updateCustomerAddressAction;
    private UpdateCustomerEmailAction updateCustomerEmailAction;
    private UpdateCustomerPhoneAction updateCustomerPhoneAction;
    private RemoveFromCartAction removeFromCartAction;
    private CancelOrderAction cancelOrderAction;

    @BeforeEach
    public void setUp()
    {
        addCategoryAction = new AddCategoryAction();
        addProductAction = new AddProductAction();
        deleteProductAction = new DeleteProductAction();
        updateCategoryNameAction = new UpdateCategoryNameAction();
        addToCartAction = new AddToCartAction();
        placeOrderAction = new PlaceOrderAction();
        updateProductNameAction = new UpdateProductNameAction();
        forgetPasswordAction = new ForgetPasswordAction();
        updateProductPriceAction = new UpdateProductPriceAction();
        updateProductDomAction = new UpdateProductDomAction();
        updateProductImageAction = new UpdateProductImageAction();
        updateProductDescAction = new UpdateProductDescAction();
        updateCustomerNameAction = new UpdateCustomerNameAction();
        updateCustomerAddressAction =  new UpdateCustomerAddressAction();
        updateCustomerEmailAction = new UpdateCustomerEmailAction();
        updateCustomerPhoneAction = new UpdateCustomerPhoneAction();
        removeFromCartAction = new RemoveFromCartAction();
        cancelOrderAction =new CancelOrderAction();
    }

    @Test
    public void testAddCategoryAction()
    {
        assertThrows(NullPointerException.class,()-> addCategoryAction.addCategoryAction(null));
    }

    @Test
    public void testAddProductAction()
    {
        assertThrows(NullPointerException.class,()->addProductAction.addProductAction(null));
    }

    @Test
    public void testDeleteProductAction()
    {
        assertThrows(Exception.class,()->deleteProductAction.deleteProductAction(0));
    }

    @Test
    public void testUpdateCategoryAction() throws Exception {
        assertEquals(updateCategoryNameAction.updateCategoryNameAction(-11),false);
    }

    @Test
    public void testAddToCartAction() throws SQLException {
        assertEquals(addToCartAction.addToCartAction(-1,-1),false);
    }

    @Test
    public void testPlaceOrderAction()
    {
        assertThrows(Exception.class,()->placeOrderAction.placeOrderAction(-12,-12));
    }

    @Test
    public void testUpdateProductAction() throws Exception {
        assertEquals(updateProductNameAction.updateProductName(-1),false);
        assertEquals(updateProductPriceAction.updateProductPrice(-1),false);
        assertThrows(Exception.class,()->updateProductDescAction.updateProductDesc(-11));
        assertThrows(Exception.class,()->updateProductImageAction.updateProductImage(-11));
        assertThrows(Exception.class,()->updateProductDomAction.updateProductDom(-11));

    }

    @Test
    @DisplayName("Test Forget Password")
    public void testForgetPassword()
    {
        assertThrows(Exception.class,()->forgetPasswordAction.forgetPasswordAction("",1000));

    }

    @Test
    public void testUpdateCustomerDetails()
    {
        assertThrows(Exception.class,()->updateCustomerAddressAction.updateCustomerAddress("",10));
        assertThrows(Exception.class,()->updateCustomerEmailAction.updateCustomerEmail("",-10));
        assertThrows(Exception.class,()->updateCustomerNameAction.updateCustomerName("",-111));
        assertThrows(Exception.class,()->updateCustomerPhoneAction.updateCustomerPhone(98463633,-10));
    }

    @Test
    public void testRemoveFromCart()
    {
        assertThrows(Exception.class,()->removeFromCartAction.removeFromCart(-11,-11));
    }


    @Test
    public void testCancelOrder()
    {
        assertThrows(Exception.class,()->cancelOrderAction.cancelOrder(-11));
    }
}
