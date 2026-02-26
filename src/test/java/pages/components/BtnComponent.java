package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class BtnComponent {

  public void btnSubmit() {
    $("#submit").click();
  }

}
