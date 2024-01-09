package demo;

import org.apache.commons.math3.linear.*;

public class LinearRegression {
    public static void main(String[] args) {
        // 创建一个线性回归模型，输入特征数量为2
        LinearRegression model = new LinearRegression(2);

        // 构建训练数据集
        double[][] X = {{1.0, 2.0}, {2.0, 3.0}, {3.0, 4.0}, {4.0, 5.0}};
        double[] y = {3.0, 4.0, 5.0, 6.0};

        // 训练模型
        model.fit(X, y);

        // 使用模型进行预测
        double[] x = {2.5, 3.5};
        double y_pred = model.predict(x);
        System.out.println("Predicted output: " + y_pred);
    }

    private final double[] weights;
    private double bias;

    public LinearRegression(int numFeatures) {
        weights = new double[numFeatures];
        bias = 0.0;
    }

    public void fit(double[][] X, double[] y) {
        double[][] Xt = transpose(X);
        double[][] XtX = multiply(Xt, X);
        double[] Xty = multiply(Xt, y);
        double[] w = solve(XtX, Xty);
        System.arraycopy(w, 0, weights, 0, weights.length);
        bias = w[w.length - 1];
    }

    public double predict(double[] x) {
        double y = bias;
        for (int i = 0; i < weights.length; i++) {
            y += weights[i] * x[i];
        }
        return y;
    }

    private double[][] transpose(double[][] X) {
        int m = X.length;
        int n = X[0].length;
        double[][] Xt = new double[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Xt[j][i] = X[i][j];
            }
        }
        return Xt;
    }

    private double[][] multiply(double[][] A, double[][] B) {
        int m = A.length;
        int n = B[0].length;
        int k = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    C[i][j] += A[i][l] * B[l][j];
                }
            }
        }
        return C;
    }

    private double[] multiply(double[][] A, double[] b) {
        int m = A.length;
        int n = b.length;
        double[] c = new double[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i] += A[i][j] * b[j];
            }
        }
        return c;
    }

    private double[] solve(double[][] A, double[] b) {
        RealMatrix matrix = new Array2DRowRealMatrix(A, false);
        DecompositionSolver solver = new LUDecomposition(matrix).getSolver();
        RealVector vector = new ArrayRealVector(b, false);
        return solver.solve(vector).toArray();
    }
}
