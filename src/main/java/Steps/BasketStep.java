package Steps;

import Pages.BasePage;
import Pages.BasketPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasketStep {
    BasketPage basketPage = new BasketPage();

    @Then("Количество товаров в корзине должно быть равно \"(.*)\"")
    public void chekTheBasket(String numberOfGoods){
        basketPage.checkTheGoods(numberOfGoods);
    }

    @When("Удаляем все товары из корзины")
    public void removeFromBasket(){
        basketPage.deleteAllFromBasket();
    }

    @When("Разлогиниваемся с сервера")
    public void logout(){
        basketPage.exit();
    }

    @Then("Проверяем, что корзина пустая. Ищем заголовок \"(.*)\"")
    public void chechTheEmptyBasket(String title){
        basketPage.checkEmptyBasket(title);
    }
}
