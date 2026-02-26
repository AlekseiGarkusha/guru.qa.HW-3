package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static data.TestData.*;

public class HobbyComponent {

  public void userHobbies(String hobby_1, String hobby_2, String hobby_3) {
    $$(".form-check-label").findBy(text(userHobbiesSports)).click();
    $$(".form-check-label").findBy(text(userHobbiesReading)).click();
    $$(".form-check-label").findBy(text(userHobbiesMusic)).click();
  }

}
