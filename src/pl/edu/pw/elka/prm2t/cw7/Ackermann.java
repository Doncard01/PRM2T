package pl.edu.pw.elka.prm2t.cw7;

/**
 * Adam Staciwa
 * Radosław Szawłowski
 */

import static pl.edu.pw.elka.prm2t.PRM2TUtil.prn;


public class Ackermann {
    public static final int NOT_COMPUTED_YET = 0;
    public static final int M = 6;
    public static final int N = 70000;
    public static boolean VERBOSE = true;

    public enum TypeOfComputation {
        FULLY_RECURSIVE,
        PARTIALLY_RECURSIVE,
    }
    private final TypeOfComputation typeOfComputation;

    private final int m, n;
    int[][] ack_val_table = new int[M][N];
    private final int value; // = NOT_COMPUTED_YET

    private long nCalls = 0;
    private long speedup = 0;
    private long maxM = 0, maxN = 0;
    private void updateStatsEntering(int m, int n) {
        nCalls++;
        if (maxM < m) {
            maxM = m;
        }
        if (maxN < n) {
            maxN = n;
        }
    }
    private void updateStatsLeaving() {
    }

    public Ackermann(TypeOfComputation typeOfComputation, int m, int n) {
        this.typeOfComputation = typeOfComputation;
        this.m = m;
        this.n = n;

        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++) {
                ack_val_table[i][j] = NOT_COMPUTED_YET;
            }
        }

        value = computeByDefinition();
    }

    public int get_val_from_ack_table (int m, int n) {
        return ack_val_table[m][n];
    }



    private int computeByDefinition() {
        if (m < 0) {
            throw new AssertionError("m is negative!");
        }
        if (n < 0) {
            throw new AssertionError("n is negative!");
        }
        return switch (typeOfComputation) {
            case FULLY_RECURSIVE -> computeFullyRecursive(m, n);
            case PARTIALLY_RECURSIVE -> computePartiallyRecursive(m, n);
        };
    }

    private int computeFullyRecursive(final int m, final int n) {
        int rv = NOT_COMPUTED_YET;
        try {
            assert m >= 0 : "m is negative!";
            assert n >= 0 : "n is negative!";
            updateStatsEntering(m, n);
            if (VERBOSE) prn("%s(%d,%d) [%s]", "->entering", m, n, this);

            if (m == 0) {
                return rv = n + 1;
            }
            if (n == 0) { // if (m > 0 && n == 0)
                // assert m >= 0 && m == 0  -->  here m > 0 always!
                // rv = $computeByDefinition(m - 1, 1);
                return rv = computeFullyRecursive(m - 1, 1);
            }
            // if (m > 0 && n > 0)
            // assert m >= 0 && m == 0  -->  here m > 0 always!
            // assert n >= 0 && n == 0  -->  here n > 0 always!
            return rv = computeFullyRecursive(m - 1, computeFullyRecursive(m, n - 1));
        } catch (Throwable t) {
            prn("%s[%s] (%d,%d)=%s [%s]", "<--exception", t, m, n, getRVS(rv), this);
            System.exit(-1);
            return rv = NOT_COMPUTED_YET;
        } finally {
            updateStatsLeaving();
            if (VERBOSE) prn("%s(%d,%d)=%s [%s]", "<--leaving", m, n, getRVS(rv), this);
        }
    }

    private int computePartiallyRecursive(int m, int n) {

        int rv = get_val_from_ack_table(m, n);
        try {
            assert m >= 0 : "m is negative!";
            assert n >= 0 : "n is negative!";
            if (rv != NOT_COMPUTED_YET) {
                speedup++;
                return rv;
            }
            updateStatsEntering(m, n);
            if (VERBOSE) prn("%s(%d,%d) [%s]", "->entering", m, n, this);



            if (m == 0) {
                return rv = n + 1;
            }
            if (n == 0) { // if (m > 0 && n == 0)
                // assert m >= 0 && m == 0  -->  here m > 0 always!
                // rv = $computeByDefinition(m - 1, 1);
                return rv = computePartiallyRecursive(m - 1, 1);
            }
            // if (m > 0 && n > 0)
            // assert m >= 0 && m == 0  -->  here m > 0 always!
            // assert n >= 0 && n == 0  -->  here n > 0 always!
            return rv = computePartiallyRecursive(m - 1, computePartiallyRecursive(m, n - 1));
        } catch (Throwable t) {
            prn("%s[%s] (%d,%d)=%s [%s]", "<--exception", t, m, n, getRVS(rv), this);
            System.exit(-1);
            return rv = NOT_COMPUTED_YET;
        } finally {
            updateStatsLeaving();
            if (VERBOSE) prn("%s(%d,%d)=%s [%s]", "<--leaving", m, n, getRVS(rv), this);
        }
    }

    private String getRVS(int rv) {
        return rv == NOT_COMPUTED_YET ? "NOT_YET_COMPUTED" : String.valueOf(rv);
    }

    public String toString() {
        String sb = "ack(" + m + "," + n + ")=" +
                getRVS(value) +
                "  nCalls: " + nCalls + "  maxM: " + maxM + "  maxN: " + maxN;
        if (typeOfComputation == TypeOfComputation.PARTIALLY_RECURSIVE) {
            sb += " speedup: " + speedup;
        }
        return sb;
    }

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> prn("JVM exits")));

        final int m = 3, n = 4;
        Ackermann.VERBOSE = false;
        //prn("%s", new Ackermann(TypeOfComputation.FULLY_RECURSIVE, m, n));
        prn("%s", new Ackermann(TypeOfComputation.PARTIALLY_RECURSIVE, m, n));
    }
}
