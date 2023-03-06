package votingproject;
// written by 5c1
// Abstract class for Political Party with common properties and methods
public abstract class PoliticalParty 
{
    public String name;
    public String color;

    // Constructor to initialize common properties
    public PoliticalParty(String name, String color) 
    {
        this.name = name;
        this.color = color;
    }
// written by 5c1
    // Method to display party details
    public void displayDetails() 
    {
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
    }
}
