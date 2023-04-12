import datetime


class Note:
    def __init__(self, id: str = "", title: str = "", text: str = "", date: datetime = ""):
        self.id = id
        self.title = title
        self.text = text
        self.date = date

    def get_id(self):
        return self.id

    def set_id(self, id: str):
        self.id = id

    def get_title(self):
        return self.title

    def set_title(self, title: str):
        self.title = title

    def get_text(self):
        return self.text

    def set_text(self, text: str):
        self.text = text

    def get_date(self):
        return self.date

    def set_date(self, date: datetime):
        self.date = date

    def __str__(self):
        return f" \nНомер записи: {self.id}\nЗаголовок: {self.title} \n{self.text}  \nДата создания/изменения: {self.date}"
