import java.awt.Color;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

    public static void main(String[] args) {
        // Initialize WebDriver (Firefox in this case)
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/target-practice");

        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find the 3rd header and print its text
        String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
        System.out.println("3rd Header Text: " + thirdHeaderText);

        // Find the 5th header and get its color (handle rgba format)
        String colorString = driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color");
        Color fifthHeaderColor = parseColor(colorString);
        
        // Print the color in RGB and Hex format
        System.out.println("Color as RGB: " + fifthHeaderColor.getRGB());
        System.out.println("Color as hexcode: #" + Integer.toHexString(fifthHeaderColor.getRGB()).substring(2));

        // Find the violet button and print its classes
        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
        System.out.println("Purple Button Classes: " + purpleButtonClass);

        // Find the grey button and print its text
        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
        System.out.println("Slate Button Text: " + slateButtonText);

        // Close the browser
        driver.quit();
    }

    // Method to parse color string and return a Color object
    private static Color parseColor(String colorString) {
        // If the color is in rgba(r, g, b, a) format
        if (colorString.startsWith("rgba")) {
            // Extract the rgba values
            String[] rgba = colorString.replaceAll("[rgba()]", "").split(",");
            int r = Integer.parseInt(rgba[0].trim());
            int g = Integer.parseInt(rgba[1].trim());
            int b = Integer.parseInt(rgba[2].trim());
            // Return a Color object with rgb values
            return new Color(r, g, b);
        } 
        // If it's a hex color (e.g., #RRGGBB)
        else if (colorString.startsWith("rgb")) {
            // Extract the rgb values
            String[] rgb = colorString.replaceAll("[rgb()]", "").split(",");
            int r = Integer.parseInt(rgb[0].trim());
            int g = Integer.parseInt(rgb[1].trim());
            int b = Integer.parseInt(rgb[2].trim());
            // Return a Color object with rgb values
            return new Color(r, g, b);
        } 
        // If it's a hex color
        else if (colorString.startsWith("#")) {
            return Color.decode(colorString);
        }
        
        // Return black if the format is unexpected
        return Color.BLACK;
    }
}
