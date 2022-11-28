# 3'. Задайте список из n чисел последовательности (1+1/n)^n и выведите на экран их сумму.
# *Пример:*
# - Для n = 6: [2.0, 2.25, 2.37037037037037, 2.44140625, 2.4883199999999994, 2.5216263717421135]

a = int(input("Введите число: "))
result = 0
result_ls = []
for i in range(a):
    formula = (1 + 1 / (i + 1)) ** (i + 1)
    result += formula
    result_ls.append(formula)
print(result_ls)
print(f"Сумма всех чисел = {result}")
