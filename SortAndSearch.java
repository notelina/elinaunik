class DataProcessor:
    
    @staticmethod
    def organize_by_swapping(collection):
        size = len(collection)
        for pass_num in range(size):
            was_swapped = False
            for position in range(0, size - pass_num - 1):
                if collection[position] > collection[position + 1]:
                    collection[position], collection[position + 1] = collection[position + 1], collection[position]
                    was_swapped = True
            if not was_swapped:
                break
        return collection
    
    @staticmethod
    def organize_by_insertion(sequence):
        for current_idx in range(1, len(sequence)):
            current_value = sequence[current_idx]
            compare_idx = current_idx - 1
            while compare_idx >= 0 and current_value < sequence[compare_idx]:
                sequence[compare_idx + 1] = sequence[compare_idx]
                compare_idx -= 1
            sequence[compare_idx + 1] = current_value
        return sequence

class TreeSorter:
    
    @staticmethod
    def _adjust_tree_structure(data, size, root_idx):
        main_node = root_idx
        left_child = 2 * root_idx + 1
        right_child = 2 * root_idx + 2
        
        if left_child < size and data[left_child] > data[main_node]:
            main_node = left_child
            
        if right_child < size and data[right_child] > data[main_node]:
            main_node = right_child
            
        if main_node != root_idx:
            data[root_idx], data[main_node] = data[main_node], data[root_idx]
            TreeSorter._adjust_tree_structure(data, size, main_node)
    
    @staticmethod
    def organize_tree_structure(data):
        length = len(data)
        
        # Build initial tree structure
        for idx in range(length // 2 - 1, -1, -1):
            TreeSorter._adjust_tree_structure(data, length, idx)
            
        # Extract elements from tree
        for idx in range(length - 1, 0, -1):
            data[idx], data[0] = data[0], data[idx]
            TreeSorter._adjust_tree_structure(data, idx, 0)
        
        return data

class SearchMethods:
    
    @staticmethod
    def find_sequential(items, target_item):
        for index, item in enumerate(items):
            if item == target_item:
                return index
        return None
    
    @staticmethod
    def find_with_fibonacci_sequence(items, target_value):
        fib_prev_prev = 0
        fib_prev = 1
        fib_current = fib_prev_prev + fib_prev
        
        items_count = len(items)
        
        # Find Fibonacci number greater than or equal to items count
        while fib_current < items_count:
            fib_prev_prev = fib_prev
            fib_prev = fib_current
            fib_current = fib_prev_prev + fib_prev
        
        offset_value = -1
        
        while fib_current > 1:
            check_index = min(offset_value + fib_prev_prev, items_count - 1)
            
            if items[check_index] == target_value:
                return check_index
                
            elif items[check_index] < target_value:
                fib_current = fib_prev
                fib_prev = fib_prev_prev
                fib_prev_prev = fib_current - fib_prev
                offset_value = check_index
                
            else:
                fib_current = fib_prev_prev
                fib_prev = fib_prev - fib_prev_prev
                fib_prev_prev = fib_current - fib_prev
        
        if fib_prev and offset_value + 1 < items_count and items[offset_value + 1] == target_value:
            return offset_value + 1
            
        return None

def demonstrate_operations():
    # Test swapping organization
    test_data_1 = [64, 34, 25, 12, 22, 11, 90]
    print("Исходные данные для обменной организации:", test_data_1)
    result_1 = DataProcessor.organize_by_swapping(test_data_1.copy())
    print("После обменной организации:", result_1)
    
    # Test insertion organization
    test_data_2 = [12, 11, 13, 5, 6]
    print("\nИсходные данные для вставной организации:", test_data_2)
    result_2 = DataProcessor.organize_by_insertion(test_data_2.copy())
    print("После вставной организации:", result_2)
    
    # Test tree structure organization
    test_data_3 = [12, 11, 13, 5, 6, 7]
    print("\nИсходные данные для древовидной организации:", test_data_3)
    result_3 = TreeSorter.organize_tree_structure(test_data_3.copy())
    print("После древовидной организации:", result_3)
    
    # Test search methods
    search_data = [4, 2, 7, 1, 9]
    target_1 = 7
    print(f"\nПоиск элемента {target_1} в данных:", search_data)
    search_result_1 = SearchMethods.find_sequential(search_data, target_1)
    print(f"Результат последовательного поиска: {'Найден на позиции ' + str(search_result_1) if search_result_1 is not None else 'Не найден'}")
    
    fibonacci_search_data = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
    target_2 = 85
    print(f"\nПоиск элемента {target_2} в данных:", fibonacci_search_data)
    search_result_2 = SearchMethods.find_with_fibonacci_sequence(fibonacci_search_data, target_2)
    print(f"Результат поиска Фибоначчи: {'Найден на позиции ' + str(search_result_2) if search_result_2 is not None else 'Не найден'}")

if __name__ == "__main__":
    demonstrate_operations()
