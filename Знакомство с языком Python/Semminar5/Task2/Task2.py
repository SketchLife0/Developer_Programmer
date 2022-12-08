# 2. Создайте программу для игры в ""Крестики-нолики"".(в консоли происходит выбор позиции)

from random import randint

win = [[1, 2, 3], [4, 5, 6], [7, 8, 9], [1, 4, 7], [2, 5, 8], [3, 6, 9], [1, 5, 9], [3, 5, 7]]  # Все победные комбинации
position_player1 = []  # Все занятые кетки первого игрока
position_player2 = []
a = "   "  # Заполнение клеток
b = " X "
c = " O "
state = [a, a, a, a, a, a, a, a, a]  # Наполнение игрового поля
playing_map = lambda: print(f"{state[0]}|{state[1]}|{state[2]}\n——— ——— ———\n"  # Само поле
                            f"{state[3]}|{state[4]}|{state[5]}\n——— ——— ———\n"
                            f"{state[6]}|{state[7]}|{state[8]}")
random_player = bool(randint(0, 1))  # Случайный выбор игрока что начинает
iteration = 1  # Ограничение количества шагов
while iteration < 10:
    playing_map()
    player = "Игрок1" if random_player else "Игрок2"  # Выбор игрока для хода
    print(f"Ход {player}")
    position = int(input("Где поставите символ? "))  # Заполнение клетки игроков
    while state[position - 1] != a:  # Проверка не занята ли уже эта клетка
        position = int(input("Эта позиция занята. Какую позицию выберите: "))
    state[position - 1] = b if player == "Игрок1" else c  # Выбор заполнения Х или О
    position_player1.append(position) if player == "Игрок1" else position_player2.append(position)  # Сохранение всех позиций игрока
    who_player = position_player1 if player == "Игрок1" else position_player2  # Необходимая переменная для проверки победы
    for i in range(len(win)):  # Проверка победы
        yes = 0  # Если совпадёт 3 числа то игрок выиграл
        if len(who_player) > 2:  # Сокращения количества итераций
            for j in range(len(who_player)):
                if who_player[j] in win[i]:  # Совпадают ли занятые клетки с победными комбинациями
                    yes += 1
                if yes == 3:  # Вывод победного сообщения и завершение игры
                    playing_map()
                    print(f"Win {player}")
                    exit()
    random_player = not random_player  # Переход хода если игра не закончилась
    iteration += 1
print("Ничья!")  # Вывод если никто не выиграл
