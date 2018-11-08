package class_03;

public class Code_06_PrintMatrixSpiralOrder {

	public static void spiralOrderPrint(int[][] matrix) {
		int tR = 0; //左上角横坐标
		int tC = 0; //左上角纵坐标
		int dR = matrix.length - 1; //右下角横坐标
		int dC = matrix[0].length - 1; //右下角纵坐标
		while (tR <= dR && tC <= dC) {  //当左上角横纵坐标都没有超过右下角横纵坐标，就需要打印边框
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) { //在同一行上时，打印规则
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) { //在同一列上时，打印规则
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else { //不在同一行也不在同一列的打印规则
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		spiralOrderPrint(matrix);

	}

}
