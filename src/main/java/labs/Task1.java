package labs;
public class Task1  {
    public String calculateFigure1(int height) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++)
                str.append(" ");
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
    public String calculateFigure2(int height) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < i; j++)
                str.append(" ");
            for (int g = 0; g < height-i; g++) {
                str.append(g % 2 == 0 ? "\\" : " ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
