package er.blog;

import er.blog.eof.Category;
import er.blog.eof.Post;
import er.blog.rest.controllers.PostsController;
import er.extensions.appserver.ERXApplication;
import er.extensions.appserver.navigation.ERXNavigationManager;
import er.rest.routes.ERXRoute;
import er.rest.routes.ERXRouteRequestHandler;

public class Application extends ERXApplication {
  public static void main(String[] argv) {
    ERXApplication.main(argv, Application.class);
  }

  /*
/posts.html = liste des articles
/index = liste des 5 plus récents articles + calendrier
/posts/<postTitle>.html = article
/categories.html = liste des catégories
/categories/<categoryName>.html = liste des articles par catégorie

/admin/login.html = login
/admin/index.html = page après le login, avec lien pour créer catégorie, utilisateur, article, et gérer préférences
/admin/posts.html = liste des articles
/admin/categories.html = liste des catégories
/admin/preferences.html = gestion des préférences 
/admin/posts/<id>.html = gestion d'un article
/admin/categories/<id>.html = gestion d'une catégorie
/admin/users.html = gestion des utilisateurs
/admin/users/<id>.html = gestion d'un utilisateur
   */

  public Application() {
    ERXApplication.log.info("Welcome to " + name() + " !");

    ERXRouteRequestHandler requestHandler = new ERXRouteRequestHandler();
    requestHandler.insertRoute(new ERXRoute(Post.ENTITY_NAME,"/index", ERXRoute.Method.Get, PostsController.class, "index"));
    requestHandler.addDefaultRoutes(Category.ENTITY_NAME);
    requestHandler.addDefaultRoutes(Post.ENTITY_NAME);
    ERXRouteRequestHandler.register(requestHandler);
  }

  @Override
  public void didFinishLaunching() {
    super.didFinishLaunching();
    ERXNavigationManager.manager().configureNavigation();}
}
