import enum


class Commands(enum.Enum):
    list = 1
    create = 2
    update = 3
    read = 4
    delete = 5
    exit = "EXIT"

    def __init__(self, command):
        self.command = command