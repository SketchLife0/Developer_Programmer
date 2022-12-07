# 5'. Даны два файла, в каждом из которых находится запись многочлена. Задача - сформировать файл,
# содержащий сумму многочленов.
# В file1.txt :
# 2*x**2 + 4*x + 5
# В file2.txt:
# 4*x**2 + 1*x + 4
# Результирующий файл:
# 6*x**2 + 5*x + 9

with open('file1.txt', "r") as f:
    a = f.readline()

with open('file2.txt', "r") as f:
    b = f.readline()

result = ''
separators = ['*x**2 + ', '*x + ', ""]

for sep in separators:
    if a.isdigit():
        elem1 = int(a)
        elem2 = int(b)
        result += f"{elem1 + elem2}"
    else:
        elem1 = int(a[:a.find(sep)])
        elem2 = int(b[:b.find(sep)])
        result += f"{elem1+elem2}{sep}"
        a = a[a.find(sep) + len(sep):]
        b = b[b.find(sep) + len(sep):]


with open('result.txt', "w") as f:
    f.write(result)
