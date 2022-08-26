package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Пётр", "Сергеич", "serg@mail.ru");
      User user2 = new User("Андрей", "Иваныч", "ai@mail.ru");
      User user3 = new User("Alex", "Mercer", "am@mail.ru");
      User user4 = new User("Andrew", "Garfield", "ag@mail.ru");


      Car car1 = new Car("mazda", 23);
      Car car2 = new Car("benz", 223);
      Car car3 = new Car("ewe", 232);
      Car car4 = new Car("tigr", 22223);
      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("mazda", 23));

      context.close();
   }
}
