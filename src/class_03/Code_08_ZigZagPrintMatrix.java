package class_03;

public class Code_08_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int tR = 0;  //A点行坐标
		int tC = 0;  //A点列坐标
		int dR = 0;  //B点行坐标
		int dC = 0;  //B点列坐标
		int endR = matrix.length - 1; //行边界
		int endC = matrix[0].length - 1; //列边界
		boolean fromUp = false;
		while (tR != endR + 1) { //当A点的行到达最后一行+1时，循环结束
			//A点先向右移动，列坐标达到最大，而后向下移动，行坐标也将达到最大。当行坐标达到最大值时，所有的斜线都被遍历完成了。
			printLevel(matrix, tR, tC, dR, dC, fromUp); //打印当前AB点构成的斜线
			tR = tC == endC ? tR + 1 : tR; //A的列坐标到达右边界时，A开始向下移动，A的行坐标+1；没到右边界时，行坐标保持不变。
			tC = tC == endC ? tC : tC + 1; //A的列坐标到达右边界时，A开始向下移动，A的列坐标不变；没到右边界时，列坐标+1。
			dC = dR == endR ? dC + 1 : dC;
			dR = dR == endR ? dR : dR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
