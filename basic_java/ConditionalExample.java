package basic_java;

public class ConditionalExample {
  public static void main(String[] args) {
    int number = 10;

    if (number > 0) {
      System.out.println(number + " is a positive number.");
    } else if (number < 0) {
      System.out.println(number + " is a negative number.");
    } else {
      System.out.println("The number is zero.");
    }
  }
}
