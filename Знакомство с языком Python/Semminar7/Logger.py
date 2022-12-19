from datetime import datetime
from platform import platform, node


def Log(name_func: str, status: str):
    t = datetime.now()
    pc = platform()
    system = node()
    with open('log.txt', 'a', encoding="UTF-8") as f:
        f.write(f'{t} {pc} {system} {name_func} {status}\n')
