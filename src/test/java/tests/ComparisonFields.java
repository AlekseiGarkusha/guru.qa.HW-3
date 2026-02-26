package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComparisonFields {

  public void comparisonFieldsPositiveTest() {
    assertAll(
      () -> $(byText("Thanks for submitting the form")).shouldBe(visible.because("❌ Форма с результирующими данными пользователя - не загрузилась")),

      () -> $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail)),
      () -> $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(userGenderMale)),
      () -> $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber)),
      () -> $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(userDay + " " + userMonth + "," + userYear)),
      () -> $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(userSubjectHistory + ", " + userSubjectEnglish + ", " + userSubjectMaths)),
      () -> $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(userHobbiesSports + ", " + userHobbiesReading + ", " + userHobbiesMusic)),
      () -> $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(userPhoto)),
      () -> $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(userCurrentAddress)),
      () -> $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(userState + " " + userCity))
    );
  }
}
