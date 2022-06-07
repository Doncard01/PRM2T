#include <string>
#include <iostream>

#define TABLE_SIZE 10

struct record {
    std::string name;
    int time{};
};

std::string names[TABLE_SIZE] = {
        "Jan", "Krystyna", "Barbara", "Pawel", "Luiza", "Stefan", "Monika",
        "Maria", "Tadeusz", "Konrad"};

int times[TABLE_SIZE] = {
        56, 60, 51, 44, 66, 50, 49, 62, 43, 70};
struct record* compute_three_best(struct record results[], int number_of_results) {
    auto *best_results = new struct record[number_of_results];

    for (int i = 0; i < number_of_results; i++) {
        best_results[i].name = results[i].name;
        best_results[i].time = results[i].time;
    }

    return best_results;
}

int main()
{
    auto *results = new struct record[TABLE_SIZE];
    int number_of_results = 3;

    for (int i =0; i < TABLE_SIZE; i++) {
        for (int j = 0; j < TABLE_SIZE; j++)
        {
            if (times[i] > times[j])
            {
                int temp = times[i];
                times[i] = times[j];
                times[j] = temp;
                std::string temp2 = names[i];
                names[i] = names[j];
                names[j] = temp2;
            }
        }
    }

    for (int i = 0; i < TABLE_SIZE; i++) {
        results[i].name = names[i];
        results[i].time = times[i];
    }

    auto three_best = compute_three_best(results, number_of_results);
    std::cout << "Trzy najlepsze rezultaty:\n";
    for (int i=0; i < number_of_results; i++) {
        std::cout << three_best[i].name << " " << three_best[i].time << "\n";
    }




}
