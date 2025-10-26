#include <vector>
#include <iostream>
#include <algorithm>

namespace ArrayProcessor {
    class ElementManager {
    private:
        static void exchangeValues(int& val1, int& val2) {
            val1 = val1 ^ val2;
            val2 = val1 ^ val2;
            val1 = val1 ^ val2;
        }
        
        static int findSmallestIndex(const std::vector<int>& data, int start) {
            int smallestPos = start;
            for (int k = start + 1; k < data.size(); ++k) {
                if (data[k] < data[smallestPos]) {
                    smallestPos = k;
                }
            }
            return smallestPos;
        }
        
    public:
        static void arrangeElements(std::vector<int>& data) {
            for (int i = 0; i < data.size() - 1; ++i) {
                int minPos = findSmallestIndex(data, i);
                if (minPos != i) {
                    exchangeValues(data[i], data[minPos]);
                }
            }
        }
        
        static void displayElements(const std::vector<int>& data) {
            for (int elem : data) {
                std::cout << elem << " ";
            }
            std::cout << std::endl;
        }
    };
}

namespace DivideAndConquer {
    class PartitionHandler {
    private:
        static int arrangeAroundPivot(std::vector<int>& data, int low, int high) {
            int pivotValue = data[high];
            int divider = low - 1;
            
            for (int current = low; current < high; ++current) {
                if (data[current] <= pivotValue) {
                    ++divider;
                    std::swap(data[divider], data[current]);
                }
            }
            std::swap(data[divider + 1], data[high]);
            return divider + 1;
        }
        
    public:
        static void recursiveArrange(std::vector<int>& data, int low, int high) {
            if (low < high) {
                int pivotIndex = arrangeAroundPivot(data, low, high);
                recursiveArrange(data, low, pivotIndex - 1);
                recursiveArrange(data, pivotIndex + 1, high);
            }
        }
    };
}

namespace SearchAlgorithms {
    class HalfIntervalSearcher {
    public:
        static int locateElement(const std::vector<int>& data, int target) {
            int start = 0, end = data.size() - 1;
            
            while (start <= end) {
                int center = start + (end - start) / 2;
                
                if (data[center] == target) return center;
                if (data[center] > target) end = center - 1;
                else start = center + 1;
            }
            return -1;
        }
    };
    
    class ProportionalSearcher {
    public:
        static int locateElement(const std::vector<int>& data, int target) {
            int low = 0, high = data.size() - 1;
            
            while (low <= high && target >= data[low] && target <= data[high]) {
                if (low == high) {
                    return (data[low] == target) ? low : -1;
                }
                
                int estimate = low + ((target - data[low]) * (high - low)) / (data[high] - data[low]);
                
                if (data[estimate] == target) return estimate;
                if (data[estimate] < target) low = estimate + 1;
                else high = estimate - 1;
            }
            return -1;
        }
    };
}

int main() {
    // Демонстрация сортировки выбором
    std::vector<int> sample1 = {64, 25, 12, 22, 11};
    std::cout << "Начальный набор: ";
    ArrayProcessor::ElementManager::displayElements(sample1);
    ArrayProcessor::ElementManager::arrangeElements(sample1);
    std::cout << "Упорядоченный набор: ";
    ArrayProcessor::ElementManager::displayElements(sample1);
    
    // Демонстрация быстрой сортировки
    std::vector<int> sample2 = {10, 7, 8, 9, 1, 5};
    DivideAndConquer::PartitionHandler::recursiveArrange(sample2, 0, sample2.size() - 1);
    std::cout << "\nБыстро упорядоченный набор: ";
    ArrayProcessor::ElementManager::displayElements(sample2);
    
    // Демонстрация поисковых алгоритмов
    std::vector<int> sortedData = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int searchTarget = 23;
    
    int binaryResult = SearchAlgorithms::HalfIntervalSearcher::locateElement(sortedData, searchTarget);
    std::cout << "\nПоловинный поиск: элемент " << (binaryResult != -1 ? "обнаружен" : "не обнаружен");
    
    int interpolationResult = SearchAlgorithms::ProportionalSearcher::locateElement(sortedData, searchTarget);
    std::cout << "\nПропорциональный поиск: элемент " << (interpolationResult != -1 ? "обнаружен" : "не обнаружен");
    
    return 0;
}
