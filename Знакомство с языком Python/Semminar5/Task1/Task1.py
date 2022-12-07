# 1. Создайте программу для игры с конфетами человек против человека.
# *' Условие задачи: На столе лежит 117 конфета. Играют два игрока делая ход друг после друга. '
# 'Первый ход определяется жеребьёвкой. За один ход можно забрать не более чем 28 конфет.
# Все конфеты оппонента достаются сделавшему последний ход.

from random import randint


def game(name1, name2):
    all_candy = 117
    max_candy = 28
    candy_player1 = 0
    candy_player2 = 0
    a = bool(randint(0, 1))
    while all_candy > 0:
        if all_candy < max_candy:
            max_candy = all_candy
        player = name1 if a else name2
        step = int(input(f"Сколько конфет хочет взять {player}? "))
        while step > max_candy:
            step = int(input(f"Перебор. Максимум {max_candy} конфет за ход. Сколько возьмёшь? "))
        all_candy -= step
        if a:
            candy_player1 += step
        else:
            candy_player2 += step
        if all_candy == 0:
            return print(f"Конфеты закончились. Поздравляем игрока {player} с победой!!!\n"
                   f"Все {candy_player1 if not a else candy_player2} конфет противника достаются игроку {player}")
        a = not a
        print(f"Осталось {all_candy} конфет")


player1 = input("Введите имя игрока 1: ")
player2 = input("Введите имя игрока 2: ")
game(player1, player2)
