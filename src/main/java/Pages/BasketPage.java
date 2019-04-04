package Pages;

import Util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//span[@data-test-id='total-qty-block']") // показывает количество товаров
    WebElement checkTheNumber;

    @FindBy(xpath = ("//span[@class='bottom-block']")) // нужно навести курсор на значок
    public WebElement myOzone;

    @FindBy(xpath = "//button[@data-test-id='cart-delete-selected-btn']") // кнопка удалить товары
    WebElement delete;

    @FindBy(xpath = "//button[@data-test-id='checkcart-confirm-modal-confirm-button']") //подтверждение удаления товаров
    WebElement deleteAgain;

    @FindBy(xpath = "//span[@data-test-id='header-my-ozon-logout']") //кнопка разлогиниться
    WebElement logout;

    @FindBy(xpath = "//h1[@class='cart-title']") // в корзине появляется заголовок, если она пустая
    WebElement emptyBasketTitle;

    public void checkTheGoods (String exceptedNumber){
        waitForLoadPage();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", checkTheNumber);
        Assert.assertEquals(String.format("В корзине должно быть %s. А по факту в ней %s", exceptedNumber, checkTheNumber.getText()),
                exceptedNumber, checkTheNumber.getText());
        System.out.println(String.format("В корзине %s", checkTheNumber.getText()));
    }

    public void deleteAllFromBasket(){
        click(delete);
        waitForLoadPage();
        click(deleteAgain);
    }

    public void exit(){
        waitForLoadPage();
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(myOzone).build().perform();
        click(logout);
    }

    public void checkEmptyBasket (String basketTitle){
        waitForLoadPage();
        Assert.assertEquals(String.format("Заголовок должен быть: %s. А по факту: %s", basketTitle, emptyBasketTitle.getText()),
                basketTitle, emptyBasketTitle.getText());
        System.out.println(emptyBasketTitle.getText());
    }



}
