import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleHelper.writeMessage("""
                    Выберите действие, введя его номер:
                    1. Зашифровать текст в файле.
                    2. Расшифровать текст в файле.
                    3. Подобрать ключ, воспользовавшись перебором.
                    4. Расшифровать текст в файле, с помощью синтаксического анализа текста.
                    5. Выйти из программы.""");
            int answer = scanner.nextInt();
            if (answer == 1) {
                Encrypted encrypted = new Encrypted();
                encrypted.encrypt(true);
            } else if (answer == 2) {
                Encrypted encrypted = new Encrypted();
                encrypted.encrypt(false);
            } else if (answer == 3) {
                Bruteforce bruteforce = new Bruteforce();
                bruteforce.bruteforce();
            } else if (answer == 4) {
                System.out.println("Action");
            } else if (answer == 5) {
                return;
            }
        }
    }
}