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
    while (true)
    {
        auto *results = new struct record[TABLE_SIZE];
        auto *three_best = new struct record[3];
        int number_of_results = 3;
        std::cout << "Select an option:\n 1 - calculate\n 2 - exit program\n";
        int option;
        std::cin >> option;
        switch (option)
        {
            case 1:
                std::cout << "Three best:\n";
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

                three_best = compute_three_best(results, number_of_results);
                std::cout << "Trzy najlepsze rezultaty:\n";
                for (int i=0; i < number_of_results; i++) {
                    std::cout << three_best[i].name << " " << three_best[i].time << "\n";
                }
                break;
            case 2:
                std::cout << "Exiting program\n";
                return 0;
            default:
                std::cout << "Wrong option, choose once again\n";
        }
    }
}
