def Add(info: str):
    with open("database.csv", 'r+', encoding="UTF-8") as f:
        elem = f.readlines()
        index = 0
        if len(elem) > 0:
            index = elem[-1].split(";")
            index = int(index[0]) + 1
        f.write(f"{index};{info}")
        return "Добавлено успешно"


def Search(a):
    with open("database.csv", "r", encoding='UTF-8') as f:
        elem = f.readlines()
    for line in elem:
        if line.find(a) > -1:
            print(line.replace(';', " ").strip())
    return "Поиск завершён"


def Edition(indx:str, line='', mode=True):
    Comlete = False
    with open("database.csv", "r", encoding='UTF-8') as f:
        elems = f.readlines()
    for i in range(len(elems)):
        elem = elems[i].split(';')
        if elem[0] == indx:
            if mode:
                elems[i] = f"{indx};{line}"
            else:
                elems.remove(elems[i])
            Comlete = True
            break
    if Comlete:
        with open("database.csv", "w", encoding='UTF-8') as f:
            for i in elems:
                f.write(i)
            return "Complete"
    else:
        return "Bad"
