import java.io.*;

public class PolynomialConstantFinder {

    // Decode y value from given base to decimal
    public static long decodeBaseN(String value, int base) {
        return Long.parseLong(value, base);
    }

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: java PolynomialConstantFinder <input.json>");
                return;
            }

            // Read JSON file into a single string
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }
            br.close();

            String json = sb.toString();
            json = json.replaceAll("\\s+", ""); // remove spaces

            // Extract n and k
            int n = Integer.parseInt(getJsonValue(json, "\"n\""));
            int k = Integer.parseInt(getJsonValue(json, "\"k\""));

            if (k < 3) {
                System.out.println("At least 3 points are required for a quadratic equation.");
                return;
            }

            // Store first k points
            double[] x = new double[k];
            double[] y = new double[k];
            int count = 0;

            for (int i = 1; i <= n && count < k; i++) {
                String keyStr = "\"" + i + "\":\\{";
                int idx = json.indexOf(keyStr);
                if (idx != -1) {
                    String obj = json.substring(idx, json.indexOf("}", idx) + 1);
                    String baseStr = getJsonValue(obj, "\"base\"");
                    String valStr = getJsonValue(obj, "\"value\"");
                    long yDecoded = decodeBaseN(valStr, Integer.parseInt(baseStr));
                    x[count] = i;
                    y[count] = yDecoded;
                    count++;
                }
            }

            // Debug: print the points used
            System.out.println("n = " + n + ", k = " + k);
            for (int i = 0; i < count; i++) {
                System.out.println("Point " + (i + 1) + ": x=" + x[i] + ", y=" + y[i]);
            }

            // Solve using first 3 points (quadratic)
            double[][] A = {
                {x[0]*x[0], x[0], 1},
                {x[1]*x[1], x[1], 1},
                {x[2]*x[2], x[2], 1}
            };
            double[] B = {y[0], y[1], y[2]};

            double detA = det3x3(A);

            // Matrix for c
            double[][] Ac = {
                {x[0]*x[0], x[0], B[0]},
                {x[1]*x[1], x[1], B[1]},
                {x[2]*x[2], x[2], B[2]}
            };
            double detC = det3x3(Ac);

            double c = detC / detA;

            System.out.println("Constant term (c) = " + (long)c);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Extract value from JSON-like string without libraries
    public static String getJsonValue(String json, String key) {
        int idx = json.indexOf(key);
        if (idx == -1) return "";
        int start = json.indexOf(":", idx) + 1;
        int endComma = json.indexOf(",", start);
        int endBrace = json.indexOf("}", start);
        if (endComma == -1 || (endBrace != -1 && endBrace < endComma)) endComma = endBrace;
        String val = json.substring(start, endComma).replaceAll("\"", "");
        return val;
    }

    // Determinant of 3x3 matrix
    public static double det3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }
}