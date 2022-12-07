# 4'. Задана натуральная степень k.
# Сформировать случайным образом список коэффициентов (значения от 0 до 100)
# многочлена и записать в файл многочлен степени k.
# Пример:
# k = 2
# 2x^2 + 4x + 5 = 0
# или
# x2 + 5 = 0
# или
# 10x^2 = 0
# k = 3
# 2x^3 + 4x^2 + 4x + 5 = 0

from random import randint


def write_file(st):
    with open('Task4.txt', 'w') as f:
        f.write(st)

def create_str(k: int) -> str:
    result = ''
    if k == 0:
        return result
    for i in range(k, -1, -1):
        a = randint(0, 100)
        if a > 0:
            if k > 1:
                    result += f"{a}x^{i} + "
            elif k == 1:
                    result += f"{a}x + "
            else:
                    result += f"{a} + "
    result = result[:-2]
    result += "= 0"
    return result


k = int(input('Введите натуральную степень k: '))
write_file(create_str(k))
