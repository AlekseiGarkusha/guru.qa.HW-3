package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class StateAndCityComponent {

  public void userStateAndCity(String state, String city) {
    $("#react-select-3-input").setValue(userState).pressEnter();
    $("#react-select-4-input").shouldBe(visible).setValue(userCity).pressEnter();
  }

}
