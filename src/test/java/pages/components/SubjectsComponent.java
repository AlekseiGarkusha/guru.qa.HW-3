package pages.components;

import static com.codeborne.selenide.Selenide.$;
import static data.TestData.*;

public class SubjectsComponent {

  public void typeSubjects (String subject_1, String subject_2, String subject_3){
    $("#subjectsInput").setValue(userSubjectHistory).pressEnter();
    $("#subjectsInput").setValue(userSubjectEnglish).pressEnter();
    $("#subjectsInput").setValue(userSubjectMaths).pressEnter();
  }

}
