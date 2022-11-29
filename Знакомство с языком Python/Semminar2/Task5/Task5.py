# 5'. Реализуйте алгоритм перемешивания списка.

from random import shuffle

a = input("Введите элементы через запятую: ").split(", ")
print(a)
shuffle(a)
print(a)
