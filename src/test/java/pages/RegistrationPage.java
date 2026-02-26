package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

  private final CalenderComponent calendar = new CalenderComponent();
  private final SubjectsComponent subjects = new SubjectsComponent();
  private final HobbyComponent hobby = new HobbyComponent();
  private final StateAndCityComponent stateAndCity = new StateAndCityComponent();
  private final BtnComponent btcSubmit = new BtnComponent();
  private final ComparisonFieldsComponent comparison = new ComparisonFieldsComponent();

  private SelenideElement userFirstNameInput = $("#firstName");
  private SelenideElement userLastNameInput = $("#lastName");
  private SelenideElement userEmailInput = $("#userEmail");
  private SelenideElement userGenderMaleInput = $("#gender-radio-1");
  private SelenideElement userNumberInput = $("#userNumber");
  private SelenideElement userUploadPicture = $("#uploadPicture");
  private SelenideElement userCurrrentAddress = $("#currentAddress");

  public RegistrationPage openPage() {
    open("/automation-practice-form");
    return this;
  }

  public RegistrationPage typeUserName(String name, String lastName) {
    userFirstNameInput.setValue(name);
    userLastNameInput.setValue(lastName);
    return this;
  }

  public RegistrationPage typeUserEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public RegistrationPage typeUserGenderMale() {
    userGenderMaleInput.click();
    return this;
  }

  public RegistrationPage typeUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }

  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendar.setDate(day, month, year);
    return this;
  }

  public RegistrationPage setUserSubjets(String value_1, String value_2, String value_3) {
    subjects.typeSubjects(value_1, value_2, value_3);
    return this;
  }

  public RegistrationPage setUserHobbies(String value_1, String value_2, String value_3) {
    hobby.userHobbies(value_1, value_2, value_3);
    return this;
  }

  public RegistrationPage uploadPicture(String value) {
    userUploadPicture.uploadFromClasspath(value);
    return this;
  }

  public RegistrationPage typeUserCurrentAddress(String value) {
    userCurrrentAddress.sendKeys(value);
    return this;
  }

  public RegistrationPage setStateAndCity(String state, String city) {
    stateAndCity.userStateAndCity(state, city);
    return this;
  }

  public RegistrationPage clickBtnSubmit() {
    btcSubmit.btnSubmit();
    return this;
  }

  public RegistrationPage comparisonResultFields() {
    comparison.comparisonFieldsPositiveTest();
    return this;
  }

}
