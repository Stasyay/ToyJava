from model.repository import RepositoryNote
from model.note_mapper import NoteMapper
from model.work_with_file import FileOperation
from controller.note_controller import NoteController
# from view.validation_input_data import ValidationInputData
from view.view_notepad import ViewNotepad


data = FileOperation("data")
mapper = NoteMapper()
# validation = ValidationInputData()
repository = RepositoryNote(data, mapper)
controller = NoteController(repository)
view = ViewNotepad(controller)
view.menu()
