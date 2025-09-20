#include <iostream>
#include <stack>
#include <string>
#include <cctype>

using namespace std;

int main() {
    string input = "AaBbCcDd";
    stack<char> uppercaseStack;
    stack<char> lowercaseStack;
    
    // Проходим по каждому символу строки
    for (char c : input) {
        if (isupper(c)) {
            // Если символ заглавный - добавляем в стек заглавных букв
            uppercaseStack.push(c);
        } else if (islower(c)) {
            // Если символ строчный - добавляем в стек строчных букв
            lowercaseStack.push(c);
        }
    }
    
    // Извлекаем заглавные буквы из стека (в обратном порядке)
    string uppercaseStr;
    while (!uppercaseStack.empty()) {
        uppercaseStr = uppercaseStack.top() + uppercaseStr;
        uppercaseStack.pop();
    }
    
    // Извлекаем строчные буквы из стека (в обратном порядке)
    string lowercaseStr;
    while (!lowercaseStack.empty()) {
        lowercaseStr = lowercaseStack.top() + lowercaseStr;
        lowercaseStack.pop();
    }
    
    // Выводим результаты
    cout << "Исходная строка: " << input << endl;
    cout << "Заглавные буквы: " << uppercaseStr << endl;
    cout << "Строчные буквы: " << lowercaseStr << endl;
    
    return 0;
}