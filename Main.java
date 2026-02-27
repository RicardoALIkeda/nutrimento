import java.util.*;
//programa de merda pra calcular valores nutricionais e quaiquer outras merdas q eu pensar na hora, tmj
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        // separate lists for each nutrient so we can total them individually
        List<Double> proteinaList = new ArrayList<>();
        List<Double> carboList = new ArrayList<>();
        List<Double> lipidList = new ArrayList<>();
        List<Double> sodioList = new ArrayList<>();
        List<Double> fibraList = new ArrayList<>(); // nova lista de fibras

        // mudar locale não funciona bem com Scanner se o usuário digitar vírgula
        // então faremos parsing manual substituindo ',' por '.'

        System.out.println("\n=== Contador punhetinha 123 ===");
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Calcular valores do alimento");
            System.out.println("2. Total de macro nutrientes");
            System.out.println("3. pendiente");
            System.out.println("4. pendente");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("Digite o tamanho da porcao");
                    double porcao = readDouble(sc);
                    System.out.print("Proteina: ");
                    double proteina = readDouble(sc);
                    System.out.print("Carboidrato: ");
                    double carboidrato = readDouble(sc);
                    System.out.print("lipidios: ");
                    double lipidios = readDouble(sc);
                    System.out.print("Fibra: ");
                    double fibra = readDouble(sc);
                    System.out.print("Sodio: ");
                    double sodio = readDouble(sc);
                    System.out.println("_________________________________");

                    double proteinaVal = (proteina * porcao) / 100;
                    double carboVal = (carboidrato * porcao) / 100;
                    double lipidVal = (lipidios * porcao) / 100;
                    double fibraVal  = (fibra * porcao) / 100;

                    System.out.println("Valores nutricionais por porcao:");
                    System.out.println("Proteina: " + proteinaVal + "g");
                    System.out.println("Carboidrato: " + carboVal + "g");
                    System.out.println("Lipidios: " + lipidVal + "g");
                    System.out.println("Fibra: " + fibraVal + "g");
                    System.out.println("Sodio: " + (sodio * porcao) / 100 + "mg");

                    proteinaList.add(proteinaVal);
                    carboList.add(carboVal);
                    lipidList.add(lipidVal);
                    fibraList.add(fibraVal);
                    sodioList.add((sodio * porcao) / 100);
                    break;
                case 2:
                    System.out.println("________________________________");
                    System.out.println("Total de macro nutrientes:");
                    if (proteinaList.isEmpty()) {
                        System.out.println("Nenhum valor calculado ainda.");
                    } else {
                        double totalProt = 0, totalCarb = 0, totalLip = 0, totalFibra = 0, totalSod = 0;
                        for (double v : proteinaList) totalProt += v;
                        for (double v : carboList) totalCarb += v;
                        for (double v : lipidList) totalLip += v;
                        for (double v : fibraList)  totalFibra += v;
                        for (double v : sodioList) totalSod += v;
                        System.out.println("Proteina total: " + totalProt + "g");
                        System.out.println("Carboidrato total: " + totalCarb + "g");
                        System.out.println("Lipidios total: " + totalLip + "g");
                        System.out.println("Fibra total: " + totalFibra + "g");
                        System.out.println("Sodio total: " + totalSod + "mg");
                    }
                    break;
                case 3:
                    System.out.println(">> Depositing...");
                    // your code here
                    break;
                case 4:
                    System.out.println(">> Withdrawing...");
                    // your code here
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    // lê uma linha, troca vírgula por ponto e converte para double
    private static double readDouble(Scanner sc) {
        String line = sc.nextLine().trim().replace(',', '.');
        try {
            return Double.parseDouble(line);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida, por favor digite um número (use . ou , como separador):");
            return readDouble(sc);
        }
    }
}