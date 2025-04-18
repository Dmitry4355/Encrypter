import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

@UtilityClass
public class ConsoleHelper {

    private static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public void writeMessage(String message) {
        System.out.println(message);
    }

    @SneakyThrows
    public String readString() {
        return console.readLine();
    }

    public int readInt() {
        return Integer.parseInt(readString());
    }

    public Path buildFileName(String path, String suffix) {
        Path fullPath = Path.of(path);
        Path parent = fullPath.getParent();
        String fileName = fullPath.getFileName().toString();
        String newFileName;
        if (fileName.contains(".")) {
            int index = fileName.lastIndexOf(".");
            newFileName = fileName.substring(0, index) + suffix + fileName.substring(index);
        } else {
            newFileName = fileName + suffix;
        }
        return parent.resolve(newFileName);
    }
}


// Закомитить все. Выложить в гит. Зарефакторить.