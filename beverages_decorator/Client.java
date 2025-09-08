package beverages_decorator;

public class Client {
    public static void main(String[] args) {
        Beverage coffee = new Cappuccino();
        System.out.println("Cappuccino cost: " + coffee.cost());


        Beverage fancyLatte = new ChocolateDecorator(new SugarDecorator(new Latte()));
        System.out.println("Latte + Sugar + Chocolate cost: " + fancyLatte.cost());

        Beverage deluxeCoffee = new ChocolateDecorator(new SugarDecorator(new Cappuccino()));
        System.out.println("Cappuccino + Milk + Sugar + Chocolate cost: " + deluxeCoffee.cost());
    }
}
