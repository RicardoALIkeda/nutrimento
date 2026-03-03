import java.util.*;
//programa de merda pra calcular valores nutricionais e quaiquer outras merdas q eu pensar na hora, tmj
public class Main {
    static class FoodItem {
        String nome;
        double proteina, carbo, lipid, fibra, sodio;
        FoodItem(String nome, double proteina, double carbo, double lipid, double fibra, double sodio) {
            this.nome = nome;
            this.proteina = proteina;
            this.carbo = carbo;
            this.lipid = lipid;
            this.fibra = fibra;
            this.sodio = sodio;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        List<FoodItem> items = new ArrayList<>();

        System.out.println("\n=== Contador punhetinha 123 ===");
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Calcular valores do alimento");
            System.out.println("2. Total de macro nutrientes");
            System.out.println("3. Remover alimento");
            System.out.println("4. Lista de alimentos cadastrados");
            System.out.println("5. Conversao de preco");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nome do alimento: ");
                    String nome = sc.nextLine().trim();
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

                    items.add(new FoodItem(nome, proteinaVal, carboVal, lipidVal, fibraVal, (sodio * porcao)/100));
                    break;
                case 2:
                    System.out.println("________________________________");
                    System.out.println("Total de macro nutrientes:");
                    if (items.isEmpty()) {
                        System.out.println("Nenhum valor calculado ainda.");
                    } else {
                        double totalProt = 0, totalCarb = 0, totalLip = 0, totalFibra = 0, totalSod = 0;
                        for (FoodItem f : items) {
                            totalProt += f.proteina;
                            totalCarb += f.carbo;
                            totalLip += f.lipid;
                            totalFibra += f.fibra;
                            totalSod += f.sodio;
                        }
                        System.out.println("Proteina total: " + totalProt + "g");
                        System.out.println("Carboidrato total: " + totalCarb + "g");
                        System.out.println("Lipidios total: " + totalLip + "g");
                        System.out.println("Fibra total: " + totalFibra + "g");
                        System.out.println("Sodio total: " + totalSod + "mg");
                    }
                    break;
                case 3:
                    System.out.println("________________________________");
                    System.out.println("Remover alimento:");
                    if (items.isEmpty()) {
                        System.out.println("Nenhum alimento registrado.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            System.out.printf("%d. %s\n", i+1, items.get(i).nome);
                        }
                        System.out.print("Digite o número do alimento a remover: ");
                        int idx = sc.nextInt();
                        sc.nextLine();
                        if (idx >= 1 && idx <= items.size()) {
                            FoodItem removed = items.remove(idx-1);
                            System.out.println("Removido: " + removed.nome);
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("________________________________");
                    System.out.println("Alimentos cadastrados:");
                    if (items.isEmpty()) {
                        System.out.println("Nenhum alimento registrado.");
                    } else {
                        for (int i = 0; i < items.size(); i++) {
                            FoodItem f = items.get(i);
                            System.out.printf("%d. %s - P:%.2fg C:%.2fg L:%.2fg F:%.2fg S:%.2fmg\n",
                                    i+1, f.nome, f.proteina, f.carbo, f.lipid, f.fibra, f.sodio);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Medida comercializada (quantidade): ");
                    double medida = readDouble(sc);
                    System.out.print("Preço da medida: ");
                    double precoMedida = readDouble(sc);
                    System.out.print("Per capita bruto (mesma unidade da medida): ");
                    double perCapita = readDouble(sc);

                    if (medida <= 0) {
                        System.out.println("Medida deve ser maior que zero.");
                    } else {
                        double precoPerCapita = precoMedida * perCapita / medida;
                        System.out.println("---------------------------------");
                        System.out.println("Resultado:");
                        System.out.println("Medida comercializada: " + medida);
                        System.out.println("Preço da medida: R$" + precoMedida);
                        System.out.println("Per capita bruto: " + perCapita);
                        System.out.println("Preço por per capita bruto: R$" + precoPerCapita);
                    }
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 6);

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