public class CaesarCipher {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "абвгдеёжзийклмнопрстуфхцчшщъыьэюя" + "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ" +
            ".,\":!? +-*/\\@#$%^&(){}[];'|`~=_©«»—" + "0123456789";


    public String encrypt(String message, int key) {
        StringBuilder builder = new StringBuilder();
        for (char aChar : message.toCharArray()) {
            int index = alphabet.indexOf(aChar);
            if (index >= 0) {
                int newIndex = (index + key) % alphabet.length();
                char charAt = newIndex < 0 ? alphabet.charAt(newIndex + alphabet.length()) : alphabet.charAt(newIndex);
                builder.append(charAt);
            }
        }
        return builder.toString();
    }


    public String decrypt(String message, int key) {
        return encrypt(message, key * -1);
    }

    public int getAlphabetLength() {
        return alphabet.length();
    }
}
