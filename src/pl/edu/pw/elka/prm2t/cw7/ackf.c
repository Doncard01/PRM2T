#include <stdio.h>
#include <signal.h>

#define M 6
#define N 70000
int ackf_val_table[M][N];

#define NOT_COMPUTED_YET 0
void init_ackf_val_table() {
    for (int m = 0; m < M; m++) {
        for (int n = 0; n < N; n++) {
            ackf_val_table[m][n] = NOT_COMPUTED_YET;
        }
    }
}

#define RAISE_SIGILL(m, n) {        \
    if ((m) >= M || (n) >= N) {     \
        printf("about to signal SIGILL, m=%d, n=%d\n", (m), (n)); \
        raise(SIGILL);              \
    }                               \
}

void update_ackf_val_table(const int m, const int n, const int val) {
    RAISE_SIGILL(m, n);
    ackf_val_table[m][n] = val;
}

int get_ackf_val_from_table(const int m, const int n) {
    RAISE_SIGILL(m, n);
    return ackf_val_table[m][n];
}

typedef struct {
    long long int nCalls;
    long long int num_mG0_nG0;
    long long int num_mG0_nE0;
    long long int num_mE0;
    int max_m;
    int max_n;
    int recursion_depth;
    int max_recursion_depth;
    int speedup;
} ACKF_STAT;

ACKF_STAT ackf_stat;

void init_ackf_stat() {
    ackf_stat.nCalls = 0;
    ackf_stat.num_mG0_nG0 = 0;
    ackf_stat.num_mG0_nE0 = 0;
    ackf_stat.num_mE0 = 0;
    ackf_stat.max_m = 0;
    ackf_stat.max_n = 0;
    ackf_stat.recursion_depth = 0;
    ackf_stat.max_recursion_depth = 0;
    ackf_stat.speedup = 0;
}

void print_stat() {
    printf("nCalls: %lld   m>0 && n>0: %lld   m>0 && n==0: %lld   m==0: %lld   max_m: %d   max_n: %d   "
           "max_recursion_depth: %d   speedup: %d\n",
           ackf_stat.nCalls, ackf_stat.num_mG0_nG0, ackf_stat.num_mG0_nE0, ackf_stat.num_mE0,
           ackf_stat.max_m, ackf_stat.max_n, ackf_stat.max_recursion_depth, ackf_stat.speedup);
}

#define update_max(current, current_max) {  \
    if ((current) > (current_max)) {        \
        (current_max) = (current);          \
    }                                       \
}

void update_stat_entering(int m, int n) {
    ackf_stat.nCalls++;
    ackf_stat.recursion_depth++;
    update_max(ackf_stat.recursion_depth, ackf_stat.max_recursion_depth);
    update_max(m, ackf_stat.max_m);
    update_max(n, ackf_stat.max_n);
}

void update_stat_leaving() {
    ackf_stat.recursion_depth--;
}

int ack_fully_recursive(int m, int n) {
    update_stat_entering(m, n);

    int rv = 0;
    if (m == 0) {
        ackf_stat.num_mE0++;
        rv = n + 1;
        goto exit;
    }
    if (m > 0 && n == 0) {
        ackf_stat.num_mG0_nE0++;
        rv = ack_fully_recursive(m - 1, 1);
        goto exit;
    }
    if (m > 0 && n > 0) {
        ackf_stat.num_mG0_nG0++;
        rv = ack_fully_recursive(m - 1, ack_fully_recursive(m, n - 1));
        goto exit;
    }

    exit:
    update_stat_leaving();
    return rv;
}

int ack_partially_recursive(int m, int n) {
    int rv = get_ackf_val_from_table(m, n);
    if (rv != NOT_COMPUTED_YET) {
        ackf_stat.speedup++;
        return rv;
    }

    update_stat_entering(m, n);
    if (m == 0) {
        ackf_stat.num_mE0++;
        rv = n + 1;
        goto exit;
    }
    if (n == 0) {// if (m > 0 && n == 0) {
        ackf_stat.num_mG0_nE0++;
        rv = ack_partially_recursive(m - 1, 1);
        goto exit;
    }
    //if (m > 0 && n > 0) {
        ackf_stat.num_mG0_nG0++;
        rv = ack_partially_recursive(m - 1, (int) ack_partially_recursive(m, n - 1));
        goto exit;
    //}

    exit:
    if (get_ackf_val_from_table(m, n) == NOT_COMPUTED_YET) {
        update_ackf_val_table(m, n, rv);
    }
    update_stat_leaving();
    return rv;
}

void print_ackfv(int ms, int ns) {
    printf("\t");
    for (int i = 0; i < ns; i++) {
        printf("%d\t", i);
    }
    printf("\n");
    for (int i = 0; i < ns; i++) {
        printf("--------", i);
    }
    printf("--\n");

    for (int i = 0; i < ms; i++) {
        printf("%d |\t", i);
        for (int j = 0; j < ns; j++) {
            printf("%d\t", ackf_val_table[i][j]);
        }
        printf("\n");
    }
    for (int i = 0; i < ns; i++) {
        printf("========", i);
    }
    printf("==\n");
}

void signal_handler(int signum);

// pure C --> no boolean type
typedef int BOOLEAN;
#define TRUE (1)
#define FALSE (0)

int main(int argc, char** argv) {
    for (int i = 0; i < NSIG; i++) {
        signal(i, signal_handler);
    }

    BOOLEAN compute_fully_recursive = FALSE;
    int m = 3, n = 4;
    int value;

    if (compute_fully_recursive) {
        init_ackf_stat();
        value = ack_fully_recursive(m, n);
        printf("akc_fully_recursive(%d,%d)=%d\n", m, n, value);
    } else {
        init_ackf_val_table();
        init_ackf_stat();
        value = ack_partially_recursive(m, n);
        printf("ack_partially_recursive(%d,%d)=%d\n", m, n, value);
    }
    print_stat();
}

char sig_name_buffer[BUFSIZ];
char *get_SIG_name(int signum) {
    char *name;
    switch (signum) {
        case SIGINT: name = "SIGINT"; break;
        case SIGILL: name = "SIGILL"; break;
        case SIGABRT_COMPAT: name = "SIGABRT_COMPAT"; break;
        case SIGFPE: name = "SIGFPE"; break;
        case SIGSEGV: name = "SIGSEGV"; break;
        case SIGTERM: name = "SIGTERM"; break;
        case SIGBREAK: name = "SIGBREAK"; break;
        case SIGABRT: name = "SIGABRT (SIGABRT2)"; break;
        default: name = "???"; break;
    }
    sprintf(sig_name_buffer, "%s %d", name, signum);
    return sig_name_buffer;
}

void signal_handler(int signum) {
    printf("signal: %s\n", get_SIG_name(signum));
    print_stat();
}