package Steps;

import Pages.MainPage;
import cucumber.api.java.en.When;

public class MainStep {
    MainPage mainPage = new MainPage();

    @When("Логинимся с помощью почты: \"(.*)\" и пароля: \"(.*)\"")
    public void stepLogin (String email, String password){
        mainPage.toLogin(email, password);
    }

    @When("Вбиваем в поисковую строку нужный нам товар: \"(.*)\"")
    public void searchForGoods(String goods){
        mainPage.toSearch(goods);
    }

    @When("Добавляем в корзину пять товаров")
    public void addToBasket(){
        mainPage.addToBasket();
    }

    @When("Нажимаем на корзину")
    public void goToBasket(){
        mainPage.goToBasket();
    }
}
