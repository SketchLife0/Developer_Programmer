from Control import Add, Search, Edition
from Employee import Info


while True:
    print("Выберите действие.\n(Найти, добавить, удалить, редактировать, выйти)")
    request = input().lower()
    if request == "найти":
        search = input("Что желаете найти? ")
        print(Search(search))
    elif request == 'добавить':
        info = Info()
        print(Add(info))
    elif request == "редактировать":
        index = input("Индекс сотрудника: ")
        info = Info()
        print(Edition(index, info))
    elif request == "удалить":
        index = input("Индекс сотрудника: ")
        print(Edition(index, mode=False))
    elif request == "выйти":
        break
    else:
        print("Некорректное действие")
