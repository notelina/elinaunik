#include <iostream>
#include <unordered_map>

int main() {
    std::unordered_map<std::string, int> grades;
    grades["Alice"] = 5;
    grades["Bob"] = 4;
    
    std::cout << "Alice: " << grades["Alice"] << std::endl;
    std::cout << "Bob: " << grades["Bob"] << std::endl;
    
    return 0;
