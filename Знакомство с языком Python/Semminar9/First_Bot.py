from random import randint
import telebot
import time

bot = telebot.TeleBot("5941936023:AAHUBnzn2tj0bznYfMR5QJCZENA1sjZ7_rM")

@bot.message_handler(commands=['start'])
def send_welcome(message):
	bot.reply_to(message, f"Hi {message.from_user.first_name}")

@bot.message_handler(commands=['game'])
def game(message):
	all_candy = 117
	max_candy = 28
	candy_player = 0
	candy_bot = 0
	a = bool(randint(0, 1))
	while all_candy > 0:
		if all_candy < max_candy:
			max_candy = all_candy
		player = message.from_user.first_name if a else 'Bot'
		if player == 'Bot':
			step = randint(1, max_candy)
			bot.send_message(message.chat.id, f'Bot взял {step} конфет')
		else:
			input = bot.send_message(message.chat.id, 'Cколько конфет хочешь взять?')
			def candy(message):
				nonlocal step
				nonlocal pause
				nonlocal max_candy
				if int(message.text) > max_candy:
					maybe_step = bot.send_message(message.chat.id, f'Перебор. Максимум {max_candy} конфет за ход. Сколько возьмёшь?')
					bot.register_next_step_handler(maybe_step, candy)
				else:
					step = int(message.text)
					pause = False
			pause = True
			bot.register_next_step_handler(input, candy)
			while pause:
				time.sleep(1)
		all_candy -= step
		if a:
			candy_player += step
		else:
			candy_bot += step
		if all_candy == 0:
			bot.send_message(message.chat.id, f"Конфеты закончились. Поздравляем игрока {player} с победой!!!\n"
				   f"Все {candy_player if not a else candy_bot} конфет противника достаются {player}")
			break
		a = not a
		bot.send_message(message.chat.id, f"Осталось {all_candy} конфет")


bot.infinity_polling()
