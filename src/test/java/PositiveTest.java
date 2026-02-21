/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

import org.junit.jupiter.api.*;
import setup.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTest extends TestBase {

  public static String userFirstName = "Гуров";
  public static String userLastName = "Иван";
  public static String userEmail = "test@ya.ru";
  public static String userNumber = "1234567890";

  public static String userPhoto = "Code.png";
  public static String userCurrentAddress = "Florida";

  @Test
  public void practiceFormTest() {
    openForm("https://demoqa.com/");

    $x("//a[@data-discover='true']").click();
    $("Forms").scrollIntoView(true).shouldBe(visible).click();
    $(byText("Practice Form")).scrollIntoView(true).shouldBe(visible).click();

    $(byText("Student Registration Form")).shouldBe(visible.because("❌ Форма 'Practice Form' - не загрузилась"));

    $( "#firstName").shouldBe(visible).setValue(userFirstName);
    $("#lastName").sendKeys(userLastName);
    $(byText("Male")).click();
    $("#userEmail").sendKeys(userEmail);
    $("#userNumber").sendKeys(userNumber);
    $("#dateOfBirthInput").shouldBe(visible).click();

    $(byText("March")).shouldBe(visible).click();
    $(byText("1991")).shouldBe(visible).click();
    $(byText("29")).click();

    $(byText("Sports")).shouldBe(visible).click();
    $(byText("Reading")).shouldBe(visible).click();
    $(byText("Music")).shouldBe(visible).click();
    $("#uploadPicture").uploadFromClasspath(userPhoto);
    $("#currentAddress").sendKeys(userCurrentAddress);
    $("#state").shouldBe(visible).click();
    $(byText("NCR")).shouldBe(visible).click();
    $("#city").shouldBe(visible).click();
    $(byText("Noida")).shouldBe(visible).click();

    $("#submit").click();

    $(byText("Thanks for submitting the form")).shouldBe(visible.because("❌ Форма с результирующими данными пользователя - не загрузилась"));
  }
}

