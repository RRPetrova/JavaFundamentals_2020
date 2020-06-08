package FinalExam_04_April_2020_Group2;

import java.util.*;

public class _03_HeroesOfCodeAndLogixVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Integer>> heroes = new HashMap<>();
        List<Integer> points = null;

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String heroName = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);

            if (hp <= 100 && mp <= 200) {
                points = new ArrayList<>();
                points.add(hp);
                points.add(mp);

                heroes.put(heroName, points);
            }
        }

        String cmd = scanner.nextLine();
        while (!cmd.equals("End")) {
            String[] tokens = cmd.split(" - ");
            String heroName = tokens[1];
            points = heroes.get(heroName);
            if (tokens[0].equals("CastSpell")) {
                if (heroes.containsKey(heroName)) {
                    int neededMP = Integer.parseInt(tokens[2]);
                    if (neededMP <= points.get(1)) {
                        int currPoints = points.get(1);
                        points.set(1, currPoints - neededMP);
                        System.out.printf("%s has successfully cast %s and now has " +
                                "%d MP!%n", heroName, tokens[3], points.get(1));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",
                                heroName, tokens[3]);
                    }
                }
            } else if (tokens[0].equals("TakeDamage")) {
                int damage = Integer.parseInt(tokens[2]);
                int currHP = points.get(0);
                if (currHP - damage <= 0) {
                    System.out.printf("%s has been killed by %s!%n", heroName, tokens[3]);
                    heroes.remove(heroName);
                } else {
                    points.set(0, currHP - damage);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                            heroName, damage, tokens[3], points.get(0));
                }
            } else if (tokens[0].equals("Recharge")) {
                int amount = Integer.parseInt(tokens[2]);
                int recovered = 0;
                if (amount + points.get(1) > 200) {
                    recovered = 200 - points.get(1);
                    points.set(1, 200);
                } else {
                    int currPoints = points.get(1);
                    recovered = amount;
                    points.set(1, currPoints + amount);
                }
                System.out.printf("%s recharged for %d MP!%n",
                        heroName, recovered);
            } else if (tokens[0].equals("Heal")) {
                int amount = Integer.parseInt(tokens[2]);
                int recovered = 0;
                if (amount + points.get(0) > 100) {
                    recovered = 100 - points.get(0);
                    points.set(0, 100);
                } else {
                    int currPoints = points.get(0);
                    recovered = amount;
                    points.set(0, currPoints + amount);
                }
                System.out.printf("%s healed for %d HP!%n",
                        heroName, recovered);
            }
            cmd = scanner.nextLine();
        }
        heroes.entrySet().stream()
                .sorted((f, s) -> {
                    int res = s.getValue().get(0).compareTo(f.getValue().get(0));
                    if (res == 0) {
                       res = f.getKey().compareTo(s.getKey());
                    }
                    return res;
                })
                .forEach(e -> {
                    System.out.printf("%s%n", e.getKey());
                    System.out.printf("  HP: %d%n", e.getValue().get(0));
                    System.out.printf("  MP: %d%n", e.getValue().get(1));
                });
    }
}
