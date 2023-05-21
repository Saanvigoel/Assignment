import java.time.Year;
import java.util.ArrayList;
import java.util.List;
class Product
{
    private String name;
    private String type;
    private String place;
    private int warranty;
    public Product(String name, String type, String place, int warranty)
    {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }

    public String getName() 
    {
        return name;
    }

    public String getType() 
    {
        return type;
    }

    public String getPlace() 
    {
        return place;
    }

    public int getWarranty() 
    {
        return warranty;
    }
}

public class ProductManagement
{
    public static void main(String[] args)
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Type C", "Cable", "Black Drawer", 2024));
        products.add(new Product("Mac Studio", "Computer", "White Table", 2025));
        products.add(new Product("Focusrite Mixer", "Audio System", "White Table", 2025));
        products.add(new Product("Asus Vivobook", "Laptop", "Brown Drawer", 2021));
        products.add(new Product("Asus Rog", "Laptop", "Black Table", 2021));
        products.add(new Product("Macbook pro", "Laptop", "Brown Drawer", 2022));
        products.add(new Product("Wacom Pad", "Writing Pad", "Black Drawer", 2020));
        products.add(new Product("Apple Keyboard", "Keyboard", "White Table", 2022));
        products.add(new Product("Logitech Keyboard", "Keyboard", "Black Table", 2024));
        products.add(new Product("Hdmi cable", "Cable", "Black Drawer", 2024));
        products.add(new Product("Java Black Book", "Cable", "Shelf", 2024));
        products.add(new Product("Logi Mouse", "Mouse", "Black Table", 2022));
        products.add(new Product("Apple Mouse", "Mouse", "White Table", 2022));
        products.add(new Product("Lenovo Mouse", "Mouse", "Black Drawer", 2022));
        products.add(new Product("BlackBeast", "Computer", "White Table", 2020));

        //1: Search products by their place
        searching_Place(products, "Shelf");

        System.out.println();

        //2: Search products by warranty
        searching_Warranty(products);

        System.out.println();

        //3: Assignment via Stream API
        API(products);
    }
    
    private static void API(List<Product> products)
    {
        products.stream()
        .filter(product -> product.getType().equals("Mouse"))
        .map(product -> product.getName())
        .forEach(System.out::println);
    }

    private static void searching_Place(List<Product> products, String place)
    {
        for (Product product : products) 
        {
            if (product.getPlace().equals(place)) 
            {
                System.out.println("Name of the product is: " + product.getName());
                System.out.println("Type of the product is: " + product.getType());
                System.out.println("Place of the product is: " + product.getPlace());
                System.out.println("Warranty of the product is: " + product.getWarranty());
                System.out.println();
            }
        }
    }

    private static void searching_Warranty(List<Product> products) 
    {
        int latestYear = Year.now().getValue();
        for (Product product : products) 
        {
            if (product.getWarranty() < latestYear) 
            {
                System.out.println("Name: " + product.getName());
                System.out.println("Type: " + product.getType());
                System.out.println("Place: " + product.getPlace());
                System.out.println("Warranty: " + product.getWarranty());
                System.out.println();
            }
        }
    }
}