public class Main {

    public static void main(String[] args) {

        // ===== INVENTARIO =====
        Inventario inventario = new Inventario();

        Vehiculo v1 = VehiculoFactory.crearVehiculo("auto", "ABC123", 300);
        Vehiculo v2 = VehiculoFactory.crearVehiculo("van", "XYZ789", 250);
        Vehiculo v3 = VehiculoFactory.crearVehiculo("camion", "LMN456", 400);

        inventario.agregar(v1);
        inventario.agregar(v2);
        inventario.agregar(v3);

        System.out.println("=== Vehículos antes de ordenar ===");
        inventario.mostrar();

        inventario.ordenarPorAutonomia();

        System.out.println("\n=== Vehículos ordenados por autonomía ===");
        inventario.mostrar();

        // ===== BUSCAR =====
        Vehiculo buscado = inventario.buscar("XYZ789");
        if (buscado != null) {
            System.out.println("\nVehículo encontrado: " + buscado.tipo());
        }

        // ===== CONTRATO (BUILDER) =====
        Contrato contrato = new ContratoBuilder()
                .setCliente("Juan")
                .setVehiculo(v1)
                .setPlan("Premium")
                .agregarGPS()
                .agregarSeguro()
                .build();

        System.out.println("\n=== Contrato ===");
        System.out.println(contrato);
    }
}

// ===== CLASE ABSTRACTA =====
abstract class Vehiculo {
    String placa;
    int autonomia;

    public Vehiculo(String placa, int autonomia) {
        this.placa = placa;
        this.autonomia = autonomia;
    }

    public abstract String tipo();

    public int getAutonomia() {
        return autonomia;
    }
}

// ===== CLASES CONCRETAS =====
class Auto extends Vehiculo {
    public Auto(String placa, int autonomia) {
        super(placa, autonomia);
    }

    public String tipo() {
        return "Auto";
    }
}

class Van extends Vehiculo {
    public Van(String placa, int autonomia) {
        super(placa, autonomia);
    }

    public String tipo() {
        return "Van";
    }
}

class Camion extends Vehiculo {
    public Camion(String placa, int autonomia) {
        super(placa, autonomia);
    }

    public String tipo() {
        return "Camión";
    }
}

// ===== FACTORY METHOD =====
class VehiculoFactory {

    public static Vehiculo crearVehiculo(String tipo, String placa, int autonomia) {

        switch (tipo.toLowerCase()) {
            case "auto":
                return new Auto(placa, autonomia);
            case "van":
                return new Van(placa, autonomia);
            case "camion":
                return new Camion(placa, autonomia);
            default:
                throw new IllegalArgumentException("Tipo no válido");
        }
    }
}

// ===== INVENTARIO =====
class Inventario {
    Vehiculo[] vehiculos = new Vehiculo[10];
    int contador = 0;

    public void agregar(Vehiculo v) {
        vehiculos[contador++] = v;
    }

    public Vehiculo buscar(String placa) {
        for (int i = 0; i < contador; i++) {
            if (vehiculos[i].placa.equals(placa)) {
                return vehiculos[i];
            }
        }
        return null;
    }

    public void ordenarPorAutonomia() {
        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {
                if (vehiculos[j].getAutonomia() > vehiculos[j + 1].getAutonomia()) {
                    Vehiculo temp = vehiculos[j];
                    vehiculos[j] = vehiculos[j + 1];
                    vehiculos[j + 1] = temp;
                }
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < contador; i++) {
            System.out.println(vehiculos[i].tipo() +
                    " - Placa: " + vehiculos[i].placa +
                    " - Autonomía: " + vehiculos[i].autonomia);
        }
    }
}

// ===== CONTRATO =====
class Contrato {
    String cliente;
    Vehiculo vehiculo;
    String plan;
    boolean gps;
    boolean seguro;

    public String toString() {
        return "Cliente: " + cliente +
                "\nVehículo: " + vehiculo.tipo() +
                "\nPlan: " + plan +
                "\nGPS: " + gps +
                "\nSeguro: " + seguro;
    }
}

// ===== BUILDER =====
class ContratoBuilder {
    private Contrato contrato;

    public ContratoBuilder() {
        contrato = new Contrato();
    }

    public ContratoBuilder setCliente(String cliente) {
        contrato.cliente = cliente;
        return this;
    }

    public ContratoBuilder setVehiculo(Vehiculo vehiculo) {
        contrato.vehiculo = vehiculo;
        return this;
    }

    public ContratoBuilder setPlan(String plan) {
        contrato.plan = plan;
        return this;
    }

    public ContratoBuilder agregarGPS() {
        contrato.gps = true;
        return this;
    }

    public ContratoBuilder agregarSeguro() {
        contrato.seguro = true;
        return this;
    }

    public Contrato build() {
        return contrato;
    }
}