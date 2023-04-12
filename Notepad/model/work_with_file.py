import csv


class FileOperation:
    def __init__(self, file_name: str = ""):
        self.file_name = file_name + ".csv"
        create_file = open(f"{file_name + '.csv'}", "a+")
        create_file.close()

    def write_file(self, data: list[str]):
        with open(self.file_name, "w", newline="") as file:
            writer = csv.writer(file, delimiter=";")
            writer.writerows(data)

    def read_file(self):
        all_lines = []
        with open(self.file_name, "r", newline="") as file:
            csvreader = csv.reader(file, delimiter=";")
            for line in csvreader:
                record = [line[0], line[1], line[2], line[3]]
                all_lines.append(record)
        return all_lines
