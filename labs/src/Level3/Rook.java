package Level3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MyLocation {

    private int row;
    private int column;

    public MyLocation(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}

public class Rook {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[8][8];

        MyLocation king = new MyLocation(0, 0);

        ArrayList<MyLocation> rooks = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                int piece = Integer.parseInt(st.nextToken());

                if (piece == 1) {
                    king.setRow(i);
                    king.setColumn(j);
                } else if (piece == 2) {
                    rooks.add(new MyLocation(i, j));
                }

                arr[i][j] = piece;
            }
        }

        String result = "0";

        all:
        for (MyLocation rook : rooks) {
            if (king.getRow() == rook.getRow()) {
                int max = Math.max(king.getColumn(), rook.getColumn());
                int min = Math.min(king.getColumn(), rook.getColumn());

                for (int j = min; j < max; j++) {
                    if (arr[king.getRow()][j] == 3) {
                        result = "0";
                        break all;
                    } else {
                        result = "1";
                    }
                }
            } else if (king.getColumn() == rook.getColumn()) {
                int max = Math.max(king.getRow(), rook.getRow());
                int min = Math.min(king.getRow(), rook.getRow());

                for (int j = min; j < max; j++) {
                    if (arr[j][king.getColumn()] == 3) {
                        result = "0";
                        break all;
                    } else {
                        result = "1";
                    }
                }
            }
        }

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();

    }

}
