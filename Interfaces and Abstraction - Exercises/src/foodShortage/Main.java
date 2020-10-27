package foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Buyer> repo = new HashMap<>();

        while (n-- > 0) {
        Buyer buyer = createBuyer(scan.nextLine());
        repo.put(buyer.getName(), buyer);
        }
        String nameToBuyFood;
        while (!"End".equals(nameToBuyFood = scan.nextLine())) {
            if (repo.containsKey(nameToBuyFood)) {
                repo.get(nameToBuyFood).buyFood();
            }
        }
        System.out.println(repo.values().stream().mapToInt(Buyer::getFood).sum());
    }

    private static Buyer createBuyer(String line) {
        String[] tokens = line.split("\\s+");
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String idOrGroup = tokens[2];

        if (tokens.length == 4) {
           return new Citizen(name, age, idOrGroup, tokens[3]);
        } else {
            return  new Rebel(name, age, idOrGroup);
        }
    }
}
