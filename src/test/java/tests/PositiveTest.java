/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

package tests;

import org.junit.jupiter.api.*;
import pages.RegistrationPage;
import setup.TestBase;

import static data.TestData.*;

public class PositiveTest extends TestBase {

  @Test
  public void practiceFormTest() {
    RegistrationPage registrationPage = new RegistrationPage();

    registrationPage
      .openPage()

      .typeUserName(userFirstName, userLastName)
      .typeUserEmail(userEmail)
      .typeUserGenderMale()
      .typeUserNumber(userNumber)
      .setDateOfBirth(userDay, userMonth, userYear)
      .setUserSubjets(userSubjectHistory, userSubjectEnglish, userSubjectMaths)
      .setUserHobbies(userHobbiesSports, userHobbiesReading, userHobbiesMusic)
      .uploadPicture(userPicture)
      .typeUserCurrentAddress(userCurrentAddress)
      .setStateAndCity(userState, userCity)

      .clickBtnSubmit()

      .comparisonResultFields();
  }
}
