from Logger import Log
from Phonebook_search import Search_txt
import os


path_txt = "E:\Учёба\Разработчик. Программист\Developer_Programmer\Знакомство с языком Python\Semminar7\Phonebook\Phonebook.txt"


def Add_txt(number, name):
    result = os.stat(path_txt)
    with open(path_txt, 'r+', encoding="UTF-8") as f:
        if result.st_size:
            for line in f:
                if line.find(number) > -1:
                    Log("Добавление", "Провал")
                    return 'Такой номер уже есть'
        f.write(f"{number} — {name}\n")
        Log("Добавление", "Успех")
        return "Добавлено успешно"


def Output(file_name, object):  # Ну в целом оно выводит, но я делал базу на русском так что не всё корректно выводит
    with open(path_txt, "r", encoding="UTF-8") as f:
        with open(f"{file_name}.csv", "w", encoding="UTF-8") as fs:
            a = Search_txt(object).replace(" ", ";")
            fs.write(a)
