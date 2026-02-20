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


    // fill Fields




  }
}
