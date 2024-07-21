package Level3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

public class ColorPaper {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Rectangle> rectList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rectList.add(
                    new Rectangle(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        int[][] arr = new int[101][101];

        for (int i = 0; i < rectList.size(); i++) {
            Rectangle rect = rectList.get(i);

            int startX = rect.getX();
            int startY = rect.getY();

            for (int j = startX; j < startX + rect.getWidth(); j++) {
                for (int k = startY; k < startY + rect.getHeight(); k++) {
                    arr[j][k] = i + 1;
                }
            }
        }

        for (int i = 1; i <= rectList.size(); i++) {
            int rectNum = i;

            bw.write(
                    (int) Arrays.stream(arr)
                            .flatMapToInt(Arrays::stream)
                            .filter(value -> value == rectNum)
                            .count()
                            + "\n"
            );
        }

        br.close();
        bw.flush();
        bw.close();

    }

}
