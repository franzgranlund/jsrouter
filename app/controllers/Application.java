package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public static Result plus(String num1, String num2) {
	  Integer answer = Integer.valueOf(num1) + Integer.valueOf(num2);
	  return ok(ajax_result.render(answer));
  }

  public static Result minus(String num1, String num2) {
	  Integer answer = Integer.valueOf(num1) - Integer.valueOf(num2);
	  return ok(ajax_result.render(answer));
  }

  public static Result javascriptRoutes() {
    response().setContentType("text/javascript");
    return ok(
      Routes.javascriptRouter("jsRoutes",
        // Routes
        controllers.routes.javascript.Application.plus(),
        controllers.routes.javascript.Application.minus()
      )
    );
  }

}