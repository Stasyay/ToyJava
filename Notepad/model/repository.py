from datetime import *

from model.note_mapper import NoteMapper
from model.work_with_file import FileOperation
from model.note import Note


class RepositoryNote:
    def __init__(self, file: FileOperation, mapper: NoteMapper):
        self.file = file
        self.mapper = mapper

    def get_all_notes(self):
        notes = []
        lines = self.file.read_file()
        for line in lines:
            note = self.mapper.mapper_for_load(line)
            notes.append(note)
        return notes

    def create_note(self, new_note: Note):
        notes = self.get_all_notes()
        max_id = 0
        for note in notes:
            id_note = int(note.get_id())
            if max_id < id_note:
                max_id = id_note

        id_new_note = max_id + 1
        new_note.set_id(str(id_new_note))
        new_note.set_date(datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
        notes.append(new_note)
        self.save_notes(notes)

    def save_notes(self, notes: list[Note]):
        lines = []
        for note in notes:
            line = self.mapper.mapper_for_safe(note)
            lines.append(line)
        self.file.write_file(lines)


