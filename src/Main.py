from collections import deque

#решение с использованием списка
# Сохраним строку в переменной.
str_1 = 'AaBbCcDd'
# Выводим на экран требуемые строки.
print('str_1[::2] ->', str_1[::2], end='\n\n')
# Смещаем вывод на единицу.
print('str_1[1::2]->', str_1[1::2])

#решение с использованием стека
stack = deque()
stack.append('a')
stack.append('b')
stack.append('c')

print(f'Stack: {list(stack)}')
