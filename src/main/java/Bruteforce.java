import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Bruteforce {
    private static final int MAX_LENGTH_WORD = 28;

    public void bruteforce() {
        ConsoleHelper.writeMessage("Введите путь к файлу для его расшифровки");
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите путь, куда зписать результат");
        String dst = ConsoleHelper.readString();
        CaesarCipher caesarCipher = new CaesarCipher();
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {
            StringBuilder builder = new StringBuilder();
            while (reader.ready()) {
                builder.append(reader.readLine());
            }
            for (int i = 0; i < caesarCipher.getAlphabetLength(); i++) {
                String decrypt = caesarCipher.decrypt(builder.toString(), i);
                if (isValidateText(decrypt)) {
                    writer.write(decrypt);
                    ConsoleHelper.writeMessage("Содержимое расшифровано. Ключ шифрования = " + i);
                    break;
                }
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при ввводе/выводе данных из файла.");
        }

    }

    private boolean isValidateText(String text) {
        for (String next : text.split(" ")) {
            if (next.length() > MAX_LENGTH_WORD) {
                return false;
            }
        }
        boolean isValidate = false;
        if (text.contains(". ") || text.contains(", ") || text.contains("! ") || text.contains("? ")) {
            isValidate = true;
        }

        while (isValidate) {
            ConsoleHelper.writeMessage(text.substring(0, Math.min(150, text.length())));
            ConsoleHelper.writeMessage("Понятен ли данный текст? y/n");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                isValidate = false;
            } else {
                ConsoleHelper.writeMessage("Ответ возможно только y/n");
            }
        }
        return false;
    }
}
