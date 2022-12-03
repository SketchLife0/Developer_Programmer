# 3'. Задайте список из вещественных чисел. Напишите программу, которая найдёт разницу между максимальным и минимальным
# значением дробной части элементов.
# *Пример:*
# - [1.1, 1.2, 3.1, 5, 10.01] => 0.19


work_ls = input("Введите элементы списка (вещественные числа через .) через пробел: ").split(' ')
print(work_ls)

max_len = 1  # Переменная для сведения всех чисел к одним десяткам
result_ls = []
for elem in work_ls:
    start = elem.find('.') + 1
    if start > 0:
        result_ls.append(elem[start:])  # В результирующий список добавляются строки с тем что было после .
    if len(elem[start:]) > max_len:
        max_len = len(elem[start:])

for i in range(len(result_ls)):
    difference = max_len - len(result_ls[i])
    result_ls[i] += '0' * difference  # Привидение всех чисел к одним десяткам
    result_ls[i] = int(result_ls[i])

print(max(result_ls) - min(result_ls))
