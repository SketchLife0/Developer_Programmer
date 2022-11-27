# Напишите программу для проверки истинности утверждения ¬(X ⋁ Y ⋁ Z) = ¬X ⋀ ¬Y ⋀ ¬Z для всех значений предикат.
# ¬ - Отрицание ⋁ - логическое "Или" ⋀ - логическое "И"

ls = [True, True, True]
for i in range(2):
    ls[0] = True if ls[0] == False else False
    for j in range(2):
        ls[1] = True if ls[1] == False else False
        for h in range(2):
            ls[2] = True if ls[2] == False else False
            x = ls[0]
            y = ls[1]
            z = ls[2]
            print(f'X = {x} Y = {y} Z = {z}')
            a = not (x or y or z)
            print(f"¬(X ⋁ Y ⋁ Z) = {a}")
            b = (not x) and (not y) and (not z)
            print(f'¬X ⋀ ¬Y ⋀ ¬Z = {b}')
            result = a == b
            print(f"¬({x} ⋁ {y} ⋁ {z}) = ¬{x} ⋀ ¬{y} ⋀ ¬{z} is {result}\n")
