# Напишите программу, которая принимает на вход координаты двух точек и находит расстояние между ними в 2D пространстве.
# Пример:
# - A (3,6); B (2,1) -> 5,09
# - A (7,-5); B (1,-1) -> 7,21

from math import sqrt, pow

lsA = input("Введи X и Y координаты точки А: ").split()
lsB = input("Введи X и Y координаты точки B: ").split()
xa = int(lsA[0])
ya = int(lsA[1])
xb = int(lsB[0])
yb = int(lsB[1])
ab = round(sqrt(pow((xb - xa), 2) + pow((yb - ya), 2)), 2)
print(f"AB = √(({xb} - {xa})^2 + ({yb} - {ya})^2) = {ab}")
