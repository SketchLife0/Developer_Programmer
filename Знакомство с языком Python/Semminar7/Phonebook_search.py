from Logger import Log
import os


path_txt = "E:\Учёба\Разработчик. Программист\Developer_Programmer\Знакомство с языком Python\Semminar7\Phonebook\Phonebook.txt"


def Search_txt(a):
    result = os.stat(path_txt)
    with open(path_txt, "r", encoding='UTF-8') as f:
        if result.st_size:
            for line in f:
                if line.find(a) > -1:
                    Log("Поиск", "Успех")
                    return line
        Log("Поиск", "Провал")
        return "Объект не найден"


