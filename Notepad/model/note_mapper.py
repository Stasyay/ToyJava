from model.note import Note


class NoteMapper:
    def __init__(self):
        pass

    def mapper_for_load(self, line: list):
        note = Note(id=line[0], title=line[1], text=line[2], date=line[3])
        return note

    def mapper_for_safe(self, note: Note):
        line = [note.get_id(), note.get_title(), note.get_text(), note.get_date()]
        return line

