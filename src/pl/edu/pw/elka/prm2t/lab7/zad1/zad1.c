#include "stdio.h"

#define TABLE_SIZE 10

char *names[TABLE_SIZE] = {
    "Jan", "Krystyna", "Barbara", "Pawel", "Luiza", "Stefan", "Monika",
    "Maria", "Tadeusz", "Konrad"};

int times[TABLE_SIZE] = {
    56, 60, 51, 44, 66, 50, 49, 62, 43, 70};

int main(int argc, char **argv)
{
    while (1)
    {
        printf("Select an option:\n 1 - calculate\n 2 - exit program\n");
        int option;
        scanf("%d", &option);
        switch (option)
        {
        case 1:
            printf("Three best:\n");

            for (int i = 0; i < TABLE_SIZE; i++)
            {
                //sortowanie
                for (int j = 0; j < TABLE_SIZE; j++)
                {
                    if (times[i] > times[j]) //mozna zmienic znak po prostu i sie odwroci sortowanie
                    {
                        int temp = times[i];
                        times[i] = times[j];
                        times[j] = temp;
                        char *temp2 = names[i];
                        names[i] = names[j];
                        names[j] = temp2;
                    }
                }

            }
            printf("%s %d\n", names[TABLE_SIZE-1], times[TABLE_SIZE-1]);
            printf("%s %d\n", names[TABLE_SIZE-2], times[TABLE_SIZE-2]);
            printf("%s %d\n", names[TABLE_SIZE-3], times[TABLE_SIZE-3]);

            break;
        case 2:
            printf("Exiting program\n");
            return 0;
        default:
            printf("Wrong option, choose once again\n");
        }
    }
}