# 4'. Задайте список из N элементов, заполненных числами из промежутка [-N, N]. Найдите произведение элементов на
# указанных позициях. Позиции хранятся в файле file.txt в одной строке одно число.(для продвинутых - с файлом, вариант
# минимум - ввести позиции в консоли)
# -2 -1 0 1 2

input_range = int(input("Введите число: "))
work_ls = [i for i in range(-input_range, input_range+1)]  # Создание рабочего списка элементов
print(work_ls)

with open('file.txt', 'r') as f:  # Считывание индексов из файла в этой директории
    index_ls = f.readlines()

start = int(index_ls[0])  # Поиск произведения элементов по считанным индексам
finish = int(index_ls[1]) + 1
if finish >= len(work_ls):
    print("Список слишком мал для подобных идексов")
    exit()
result = 1
for i in range(start, finish):
    result *= work_ls[i]
print(start, finish - 1)
print(result)
