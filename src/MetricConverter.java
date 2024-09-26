import java.util.Scanner;

public class MetricConverter {

    public static String convertUnits(String query) {
        String[] parts = query.split(" ");
        if (parts.length != 4 || !parts[2].equals("to")) {
            return "1 kg to lb.";
        }

        double value;
        try {
            value = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            return "1 kg to lb.";
        }

        String unitFrom = parts[1];
        String unitTo = parts[3];
        double result = 0;

        switch (unitFrom + " to " + unitTo) {
            case "kg to lb":
                result = value * 2.20462;
                break;
            case "g to oz":
                result = value * 0.035274;
                break;
            case "km to mile":
                result = value * 0.621371;
                break;
            case "mm to inch":
                result = value * 0.0393701;
                break;
            default:
                return " 1 kg to lb.";
        }

        return String.format("%.2f %s = %.2f %s", value, unitFrom, result, unitTo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to metric converter!");
        System.out.println("Please input your query. For example, 1 kg to lb.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            System.out.print("Your query: ");
            String query = scanner.nextLine();
            if (query.equals("exit") || query.equals("-1")) {
                break;
            }
            String response = convertUnits(query);
            System.out.println(response);
        }

        scanner.close();
    }
}
