#include <iostream>
#include <unordered_map>
#include <string>

int main() {
    // Создание хеш-таблицы для хранения цен продуктов
    std::unordered_map<std::string, int> product_prices;
    
    // Добавление элементов в хеш-таблицу
    product_prices["apple"] = 50;
    product_prices["banana"] = 30;
    product_prices["orange"] = 40;
    product_prices["milk"] = 80;
    
    // Вывод цен продуктов
    std::cout << "=== Prices of products ===" << std::endl;
    std::cout << "Apple: " << product_prices["apple"] << " rubles" << std::endl;
    std::cout << "Banana: " << product_prices["banana"] << " rubles" << std::endl;
    std::cout << "Orange: " << product_prices["orange"] << " rubles" << std::endl;
    std::cout << "Milk: " << product_prices["milk"] << " rubles" << std::endl;
    
    // Проверка существования продукта
    std::string product_to_check = "bread";
    if (product_prices.find(product_to_check) != product_prices.end()) {
        std::cout << "\n" << product_to_check << " is available for " 
                  << product_prices[product_to_check] << " rubles" << std::endl;
    } else {
        std::cout << "\n" << product_to_check << " is not available" << std::endl;
    }
    
    // Вывод всех продуктов с использованием range-based for loop
    std::cout << "\n=== All products in database ===" << std::endl;
    for (const auto& product : product_prices) {
        std::cout << "Product: " << product.first 
                  << ", Price: " << product.second << " rubles" << std::endl;
    }
    
    // Информация о хеш-таблице
    std::cout << "\n=== Hash table information ===" << std::endl;
    std::cout << "Total products: " << product_prices.size() << std::endl;
    std::cout << "Bucket count: " << product_prices.bucket_count() << std::endl;
    
    return 0;
}
