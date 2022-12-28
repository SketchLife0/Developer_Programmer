import telebot
import requests
import json


bot = telebot.TeleBot("5941936023:AAHUBnzn2tj0bznYfMR5QJCZENA1sjZ7_rM")

@bot.message_handler(commands=['valute'])
def Search_valute(message):
    responce = requests.get("https://www.cbr-xml-daily.ru/daily_json.js")
    valute = json.loads(responce.text)
    valute = valute["Valute"]
    try:
        elem = message.text.split()
        search = elem[1].upper()
        output = valute[search]
    except IndexError:
        bot.reply_to(message, 'Введите команду в формате /valute трёхбуквенный код валюты')
    except KeyError:
        bot.reply_to(message, 'Валюта не найдена. Проверьте корректность ввода')
    else:
        bot.reply_to(message, f'Валюта - {output["Name"]}\nНоминал - {output["Nominal"]}\nЦена - {output["Value"]}руб')


bot.infinity_polling()
