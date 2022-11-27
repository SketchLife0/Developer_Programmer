# Напишите программу, которая по заданному номеру четверти,
# показывает диапазон возможных координат точек в этой четверти (x и y).

quarter = input("Введите номер четверти: ")
if not quarter.isdigit() or not int(quarter) in range(1, 5):
    print("Такой четверти несуществует")
    exit()
quarter = int(quarter)
if quarter > 2:
    print("x<0, y<0") if quarter == 3 else print("x>0, y<0")
else:
    print("x>0, y>0") if quarter == 1 else print("x<0, y>0")
