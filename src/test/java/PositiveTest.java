/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import setup.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class PositiveTest extends TestBase {

  @Test
  public void practiceFormTest() {
    open("/automation-practice-form");

    $("#firstName").shouldBe(visible).setValue(userFirstName);
    $("#lastName").sendKeys(userLastName);
    $("#userEmail").sendKeys(userEmail);
    $("#gender-radio-1").shouldHave(value(userGenderMale)).click();
    $("#userNumber").sendKeys(userNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(userMonth);
    $(".react-datepicker__year-select").selectOption(userYear);
    $(".react-datepicker__day--" + userDay).shouldBe(visible).click();

    SelenideElement sendKeysHistory = $("#subjectsInput");
    sendKeysHistory.sendKeys(userSubjectHistory);
    sendKeysHistory.sendKeys(Keys.TAB);

    SelenideElement sendKeysEnglish = $("#subjectsInput");
    sendKeysEnglish.sendKeys(userSubjectEnglish);
    sendKeysEnglish.sendKeys(Keys.TAB);

    SelenideElement sendKeysMaths = $("#subjectsInput");
    sendKeysMaths.sendKeys(userSubjectMaths);
    sendKeysMaths.sendKeys(Keys.TAB);

    $("#hobbies-checkbox-1").shouldHave(value(userHobbiesSports)).click();
    $("#hobbies-checkbox-2").shouldHave(value(userHobbiesReading)).click();
    $("#hobbies-checkbox-3").shouldHave(value(userHobbiesMusic)).click();

    $("#uploadPicture").uploadFromClasspath(userPhoto);
    $("#currentAddress").sendKeys(userCurrentAddress);

    $("#react-select-3-input").setValue(userState).pressEnter();

    $("#react-select-4-input").shouldBe(visible).setValue(userCity).pressEnter();
    $("#submit").click();

    $(byText("Thanks for submitting the form")).shouldBe(visible.because("❌ Форма с результирующими данными пользователя - не загрузилась"));
  }
}
