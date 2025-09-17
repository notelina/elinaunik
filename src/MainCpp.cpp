#include <iostream>
#include <string>

int main() {
    // Исходная строка
    std::string str = "AaBbCcDd";

    // Создаем строки для хранения результатов
    std::string uppercase;
    std::string lowercase;

    // Проходим по строке с шагом 2
    for(size_t i = 0; i < str.length(); i += 2) {
        uppercase += str[i];    // Добавляем заглавные буквы
        lowercase += str[i+1];  // Добавляем строчные буквы
    }

    // Выводим результаты
    std::cout << "Заглавные буквы: " << uppercase << std::endl;
    std::cout << "Строчные буквы: " << lowercase << std::endl;

    return 0;
}