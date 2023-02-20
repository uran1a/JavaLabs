package realise;
import console.reader.ConsoleReader;
class LabFive {
    public static void main(String[] args){
        final ConsoleReader reader = new ConsoleReader();
        System.out.println(createTriangleInsideTriangle(reader.readInt("Введите высоту треугольника: ")));
        System.out.println(createSolidTriangle(reader.readInt("Введите высоту треугольника: ")));
    }
    private static String createTriangleInsideTriangle(int height){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            str.append(" ".repeat(i));
            for (int g = i; g < height; g++) {
                if (g == i || g == height - 1 || i == 0)
                    str.append("*");
                else
                    str.append("$");
            }
            str.append("\n");
        }
        return str.toString();
    }
    private static String createSolidTriangle(int height){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            str.append(" ".repeat(i));
            for (int g = 0; g < height-i; g++)
                str.append(g % 2 == 0 ? "\\" : " ");
            str.append("\n");
        }
        return str.toString();
    }
}
