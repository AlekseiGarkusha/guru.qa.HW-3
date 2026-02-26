package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComparisonFieldsComponent {

  public void checkField(String fieldName, String expectedValue) {
    $(".table-responsive")
      .$(byText(fieldName))
      .sibling(0)
      .shouldHave(text(expectedValue));
  }

  public void comparisonFieldsPositiveTest() {
    assertAll(
      () -> $(byText("Thanks for submitting the form"))
        .shouldBe(visible.because("❌ Форма с результирующими данными пользователя - не загрузилась")),

      () -> checkField("Student Email",userEmail),
      () -> checkField("Gender", userGenderMale),
      () -> checkField("Mobile", userNumber),
      () -> checkField("Date of Birth", userDay + " " + userMonth + "," + userYear),
      () -> checkField("Subjects", userSubjectHistory + ", " + userSubjectEnglish + ", " + userSubjectMaths),
      () -> checkField("Hobbies", userHobbiesSports + ", " + userHobbiesReading + ", " + userHobbiesMusic),
      () -> checkField("Picture", userPicture),
      () -> checkField("Address", userCurrentAddress),
      () -> checkField("State and City", userState + " " + userCity)
    );
  }

}


