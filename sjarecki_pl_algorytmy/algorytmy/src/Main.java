import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wpisz wysokość paczki w cm:");
    float wysokoscPaczki = scanner.nextFloat();
    if (wysokoscPaczki <= 8)
        System.out.println("Gabaryt A został wybrany 12.00 PLN");
    else
        System.out.println("Gabaryt B został wybrany 16.00 PLN");
    System.out.println("Podaj wagę paczki:");
    float wagaPaczki = scanner.nextFloat();
    System.out.println("Podaj wysokość paczki:");
    float wysokosc = scanner.nextFloat();
    if (wagaPaczki > 25) {
        IO.println("Paczka odrzucona maksymalna waga to 25 kg.");
        return;
    }
    if (wysokosc <= 8) {
        System.out.println("Gabaryt A cena 12.00 PLN");
    } else if (wysokosc <= 19) {
        System.out.println("Gabaryt B cena 16.00 PLN");
    } else if (wysokosc <= 41) {
        System.out.println("Gabaryt C cena 20.00 PLN");
    } else {
        System.out.println("Paczka odrzucona maksymalna wysokość to 40 cm.");
    }
    int lacznaWaga = 0;
    int iloscPaczek = 0;
    while (true) {
        System.out.println("Podaj wagę następnej paczki (0 kończy):");
        int paczka = scanner.nextInt();
        if (paczka == 0)
            break;
        if (lacznaWaga + paczka <= 100) {
            lacznaWaga += paczka;
            iloscPaczek++;
            System.out.println("Paczka przyjęta, aktualna waga: "
                    + lacznaWaga + " kg/100 kg");
        } else {
            System.out.println("Paczka odrzucona przekroczono limit 100 kg.");
        }
    }
    System.out.println("Przyjętych paczek: " + iloscPaczek
            + "\nŁączna waga: " + lacznaWaga
            + "\nWolny limit: " + (100 - lacznaWaga) + " kg");
    List<Float> listaPaczek = new ArrayList<>();
    float aktualnaWaga = 0;
    float limit = 100;
    while (true) {
        System.out.println("Wprowadź wagę kolejnej paczki (0 kończy):");
        float nowaPaczka = scanner.nextFloat();
        if (nowaPaczka == 0)
            break;
        if (nowaPaczka < 0) {
            System.out.println("Waga paczki nie może być mniejsza od zera.");
            continue;
        }
        if (czyWejdzie(aktualnaWaga, nowaPaczka, limit)) {
            aktualnaWaga += nowaPaczka;
            listaPaczek.add(nowaPaczka);
            System.out.println("Paczka przyjęta. Waga: "
                    + aktualnaWaga + "/" + limit + " kg");
        } else {
            System.out.println("Paczka odrzucona przekroczono limit.");
        }
    }
    pokazRaport(listaPaczek);
}
boolean czyWejdzie(float obecnaWaga, float wagaPaczki, float limit) {
    if (obecnaWaga + wagaPaczki <= limit)
        return true;
    return false;
}
void pokazRaport(List<Float> lista) {
    if (lista.isEmpty()) {
        System.out.println("Skrzynka jest pusta.");
        return;
    }
    float najwieksza = lista.getFirst();
    float najlzejsza = lista.getFirst();
    float razem = 0;
    for (int i = 0; i < lista.size(); i++) {
        float waga = lista.get(i);
        if (waga > najwieksza)
            najwieksza = waga;
        if (waga < najlzejsza)
            najlzejsza = waga;
        razem += waga;
    }
    double sredniaWaga = razem / lista.size();
    sredniaWaga = Math.round(sredniaWaga * 100) / 100.0;
    System.out.println("Najcięższa paczka: " + najwieksza + " kg");
    System.out.println("Średnia waga: " + sredniaWaga + " kg");
    System.out.println("Najlżejsza paczka: " + najlzejsza + " kg");
}