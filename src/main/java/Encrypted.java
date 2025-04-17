import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encrypted {

    public void encrypt(boolean flag) {
        ConsoleHelper.writeMessage("Введите адрес к файлу для его " + (flag ? "зашифровки." : "расшифровки."));
        String src = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ключ.");
        int key = ConsoleHelper.readInt();
        Path dst = ConsoleHelper.buildFileName(src, (flag ? "_encrypted" : "_decrypted"));
        CaesarCipher caesarCipher = new CaesarCipher();
        try (BufferedReader fileBufReader = Files.newBufferedReader(Path.of(src));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(dst)) {
            while (fileBufReader.ready()) {
                String line = fileBufReader.readLine();

                String result = flag ? caesarCipher.encrypt(line, key) : caesarCipher.decrypt(line, key);

                bufferedWriter.write(result);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при ввводе/выводе данных из файла.");
        }
    }
}


