package pages.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class CalenderComponent {

  public void setDate(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(userMonth);
    $(".react-datepicker__year-select").selectOption(userYear);
    $(".react-datepicker__day--0" + userDay).shouldBe(visible).click();
  }

}
