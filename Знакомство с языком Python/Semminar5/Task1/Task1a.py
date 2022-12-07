from random import randint


def game_bot(name1):
    all_candy = 117
    max_candy = 28
    candy_player = 0
    candy_bot = 0
    a = bool(randint(0, 1))
    while all_candy > 0:
        if all_candy < max_candy:
            max_candy = all_candy
        player = name1 if a else 'Bot'
        if player == 'Bot':
            step = randint(1, max_candy)
            print(f'Bot взял {step} конфет')
        else:
            step = int(input(f"Сколько конфет хочет взять {player}? "))
            while step > max_candy:
                step = int(input(f"Перебор. Максимум {max_candy} конфет за ход. Сколько возьмёшь? "))
            while step > all_candy:
                step = int(input(f"Всего конфет осталось {all_candy}. Ты не можешь взять больше. Сколько возьмёшь? "))
        all_candy -= step
        if a:
            candy_player += step
        else:
            candy_bot += step
        if all_candy == 0:
            return print(f"Конфеты закончились. Поздравляем игрока {player} с победой!!!\n"
                   f"Все {candy_player if not a else candy_bot} конфет противника достаются {player}")
        a = not a
        print(f"Осталось {all_candy} конфет")


player1 = input("Введите имя игрока 1: ")
game_bot(player1)
