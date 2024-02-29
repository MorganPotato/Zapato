import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Producto {
    private static Map<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Bienvenidos Al Almacen de Zapatos");
            System.out.println("Seleccione un numero mostrado en pantalla de esta forma: 1 2 3");

            System.out.println("1. Desea agregar un nuevo producto");
            System.out.println("2. Mostrar el inventario");
            System.out.println("3. Duplicar el producto");
            System.out.println("4. Vender el producto");
            System.out.println("5. Salir");

            int escoger = scanner.nextInt();
            scanner.nextLine();
            System.out.println("esperando resultado de opcion. "+escoger);


            switch (escoger) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    displayInventory();
                    break;
                case 3:
                    duplicateInventory(scanner);
                    break;
                case 4:
                    sellProduct(scanner);
                    break;
                case 5:
                    if (escoger >= 5){
                        System.out.println("Gracias y vuelva pronto :D");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("\n\tIngrese el tipo de zapato que quiere añadir: ");
        String nombreProduct = scanner.nextLine().trim();
        System.out.print("\n\tIngrese la cantidad de zapatos(producto): ");
        int inicialProduct = scanner.nextInt();
        scanner.nextLine();
        inventory.put(nombreProduct, inicialProduct);
        System.out.println("\n\tProducto agregado exitosamente al inventario.");
    }

    private static void displayInventory() {
        System.out.println("Mostrando inventario...");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void duplicateInventory(Scanner scanner) {
        System.out.print("\n\tColoca el nombre del producto (zapatos) que desea duplicar: ");
        String nombreProduct = scanner.nextLine().trim();
        if (!inventory.containsKey(nombreProduct)) {
            System.out.println("\n\tEl producto no está en el inventario.");
            return;
        }
        int initialQuantity = inventory.get(nombreProduct);
        inventory.put(nombreProduct, initialQuantity * 2);
        System.out.println("\n\tInventario duplicado exitosamente para el producto '" + nombreProduct + "'.");
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("\t\nIngrese el nombre del producto a vender: ");
        String nombreProduct = scanner.nextLine().trim();
        if (!inventory.containsKey(nombreProduct)) {
            System.out.println("\t\nEl producto no está en el inventario.");
            return;
        }
        System.out.print("\t\nIngrese la cantidad a vender: ");
        int calidadpro = scanner.nextInt();
        scanner.nextLine();
        int abiertacalidad = inventory.get(nombreProduct);
        if (calidadpro > abiertacalidad) {
            System.out.println("\t\nNo hay suficiente stock disponible para esta venta.");
        } else {
            inventory.put(nombreProduct, abiertacalidad - calidadpro);
            System.out.println("\t\nVenta realizada correctamente. Inventario actualizado.");
        }
    }
}
