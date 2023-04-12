from controller.note_controller import NoteController
from model.note import Note


class ViewNotepad:
    def __init__(self, note_controller: NoteController):
        self.note_controller = note_controller

    def menu(self):

        while True:
            com = input(f"\nВведите комманду: \n1 - Вывести все записи \n2 - Создать запись "
                        f"\n3 - Изменить запись \n4 - Прочесть запись \n5 - Удалить запись"
                        f"\nEXIT - Выход \n").upper()

            match com:
                case "1":
                    self.view_read_all_notes()
                case "2":
                    self.view_add_new_note()
                case "3":
                    self.view_update_note()
                case "4":
                    self.view_read_note()
                case "5":
                    self.view_delete_note()
                case "EXIT":
                    return

    def view_read_all_notes(self):
        notes = self.note_controller.controller_read_all_notes()

        if not notes:
            print("В записной книжке нет записей")
        for note in notes:
            print(note)

    def view_add_new_note(self):
        self.note_controller.controller_add_note(self.create_note())

    def view_update_note(self):
        id_note = input("Введите номер записи, которую хотите изменить: ")
        self.note_controller.controller_update_note(id_note=id_note, update_note=self.create_note())

    def view_read_note(self):
        id_note = input("Введите номер записи, которую хотите прочитать: ")
        found_note = self.note_controller.controller_read_note(id_note=id_note)
        if found_note is not None:
            print(found_note)

    def view_delete_note(self):
        id_note = input("Введите номер записи, которую хотите удалить: ")
        self.note_controller.controller_delete_note(id_note)

    @staticmethod
    def create_note():

        title_note = input("Заголовок: ")
        text_note = input("Содержание: ")

        new_note = Note(title=title_note, text=text_note)

        return new_note
