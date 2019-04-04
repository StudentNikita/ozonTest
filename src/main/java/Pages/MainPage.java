package Pages;

import Util.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(), 'Товары со скидкой')]")//до него будем скролить
    public WebElement forScroll;

    @FindBy(xpath = ("//span[@class='bottom-block']")) // нужно навести курсор на значок
    public WebElement myOzone;

    @FindBy(xpath = "//span[@data-test-id='header-my-ozon-login']") //нажать кнопку войти
    public WebElement enter;

    @FindBy(xpath = "//a[@class='link-base']")  //нажать войти через почту
    public WebElement enterWithMail;

    @FindBy(xpath = "//input[@data-test-id='emailField']") //поле для заполнения почты
    public WebElement email;

    @FindBy(xpath = "//input[@data-test-id='passwordField']") //поле для заполнения пароля
    public WebElement password;

    @FindBy(xpath = "//button[@data-test-id='loginFormSubmitButton']") //кнопка войти
    public WebElement enterButton;

    @FindBy(xpath = "//input[@data-test-id='header-search-input']") //поле поиска товаров
    public WebElement search;

    @FindBy(xpath = "//button[@data-test-id='header-search-go']") //кнопка поиска
    public WebElement searchButton;

    @FindBy(xpath = "//button[@data-test-id='tile-buy-button']") //коллекция из кнопок в корзину
    public List<WebElement> buyPhone;

    @FindBy(xpath = "//div[@data-test-id='header-cart']") //кнопка корзина
    public WebElement basket;


    public void toLogin(String myEmail, String myPass){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(myOzone).build().perform();

        click(enter);
        click(enterWithMail);
        fillfield(email,myEmail);
        fillfield(password, myPass);
        click(enterButton);
    }

    public void toSearch (String goods){
        waitForLoadPage();
        fillfield(search, goods);
        click(searchButton);
    }


    public void addToBasket () {
        waitForLoadPage();
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(false);", forScroll);
        for (int i = 0; i <5; i++){
            click(buyPhone.get(i));
        }
    }

    public void goToBasket(){
        click(basket);
    }
}
