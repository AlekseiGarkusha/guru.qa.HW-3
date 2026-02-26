package tests; /**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

import org.junit.jupiter.api.*;
import setup.TestBase;
import static com.codeborne.selenide.Condition.*;
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
    $(".react-datepicker__day--0" + userDay).shouldBe(visible).click();

    $("#subjectsInput").setValue(userSubjectHistory).pressEnter();
    $("#subjectsInput").setValue(userSubjectEnglish).pressEnter();
    $("#subjectsInput").setValue(userSubjectMaths).pressEnter();

    $$(".form-check-label").findBy(text(userHobbiesSports)).click();
    $$(".form-check-label").findBy(text(userHobbiesReading)).click();
    $$(".form-check-label").findBy(text(userHobbiesMusic)).click();

    $("#uploadPicture").uploadFromClasspath(userPhoto);
    $("#currentAddress").sendKeys(userCurrentAddress);

    $("#react-select-3-input").setValue(userState).pressEnter();

    $("#react-select-4-input").shouldBe(visible).setValue(userCity).pressEnter();
    $("#submit").click();

    new ComparisonFields().comparisonFieldsPositiveTest();
  }
}
