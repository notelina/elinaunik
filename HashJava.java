#include <iostream>
#include <unordered_map>

int main() {
    std::unordered_map<std::string, int> studentAges;
    studentAges["Alice"] = 20;
    studentAges["Bob"] = 22;
    
    std::cout << "Alice: " << studentAges["Alice"] << std::endl;
    std::cout << "Bob: " << studentAges["Bob"] << std::endl;
    
    return 0;
}
