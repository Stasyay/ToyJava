from datetime import *

from model.note import Note
from model.repository import RepositoryNote


class NoteController:
    def __init__(self, notepad: RepositoryNote):
        self.notepad = notepad

    def controller_read_all_notes(self):
        return self.notepad.get_all_notes()

    def controller_add_note(self, new_note: Note):
        self.notepad.create_note(new_note)

    def controller_update_note(self, id_note: str, update_note: Note):
        notes = self.notepad.get_all_notes()
        found_note = self.controller_search_note(id_note=id_note, notes=notes)

        try:
            found_note.set_id(id_note)
            found_note.set_title(update_note.get_title())
            found_note.set_text(update_note.get_text())
            found_note.set_date(datetime.now())
        except:
            print("Запись не изменена")
        finally:
            self.notepad.save_notes(notes)
            print(f"Запись №{id_note} изменена!")

    def controller_read_note(self, id_note: str):
        notes = self.notepad.get_all_notes()
        return self.controller_search_note(id_note=id_note, notes=notes)

    def controller_delete_note(self, id_note: str):
        notes = self.notepad.get_all_notes()
        try:
            found_note = self.controller_search_note(id_note=id_note, notes=notes)
            notes.remove(found_note)
        except:
            print("Запись не удалена!")
        finally:
            self.notepad.save_notes(notes)
            print(f"Запись №{id_note} удалена!")

    def controller_sort_datetime(self, notes: list[Note]):
        for note in notes:
            var = notes.sorted


    @staticmethod
    def controller_search_note(id_note: str, notes: list[Note]):
        for note in notes:
            if id_note == note.get_id():
                return note

        print("Запись не нейдена")
