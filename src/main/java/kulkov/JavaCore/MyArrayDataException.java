package kulkov.JavaCore;

public class MyArrayDataException extends NumberFormatException {
    private String mes;

    public String getMes() {
        return mes;
    }

    public MyArrayDataException() {
    }

    public MyArrayDataException(int i, int j) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(' ');
        sb.append(j);
        mes = sb.toString();
    }

    public MyArrayDataException(String message) {
        super(message);
    }

}
