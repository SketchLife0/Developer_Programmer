# 3'. Задайте список из n чисел последовательности (1+1/n)^n и выведите на экран их сумму.
# *Пример:*
# - Для n = 6: [2.0, 2.25, 2.37037037037037, 2.44140625, 2.4883199999999994, 2.5216263717421135]

formula = lambda elem: (1 + 1 / (elem + 1)) ** (elem + 1)

a = int(input("Введите число: "))
result_ls = [formula(i) for i in range(a)]
print(result_ls)

result = 0
for i in range(a):
    result += formula(i)
print(f"Сумма всех чисел = {result}")
