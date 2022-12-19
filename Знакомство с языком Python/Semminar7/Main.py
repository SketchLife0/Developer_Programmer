from Phonebook_editing import Add_txt, Output
from Phonebook_search import Search_txt


while True:
    print("Выберите действие.\n(Найти, добавить, вывести, выйти)")
    request = input().lower()
    if request == "найти":
        search = input("Что желаете найти? ")
        print(Search_txt(search))
    elif request == 'добавить':
        number = input("Введите номер телефона: ")
        name = input("Введите полное имя: ")
        print(Add_txt(number, name))
    elif request == 'вывести':
        file_name = input("Введите название файла для сохранения: ")
        object = input("Что желаете найти?: ")
        Output(file_name, object)
    elif request == "выйти":
        break
    else:
        print("Некорректное действие")

