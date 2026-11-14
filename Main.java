package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book("Кобзар", "Тарас Шевченко", "А-БА-БА-ГА-ЛА-МА-ГА", 2018, 720, 450.00),
                new Book("Тіні забутих предків", "Михайло Коцюбинський", "Фоліо", 2019, 256, 210.50),
                new Book("Захар Беркут", "Іван Франко", "А-БА-БА-ГА-ЛА-МА-ГА", 2020, 288, 280.00),
                new Book("1984", "Джордж Орвелл", "Видавництво Жупанського", 2015, 312, 320.00),
                new Book("Колгосп тварин", "Джордж Орвелл", "Видавництво Жупанського", 2021, 152, 240.00),
                new Book("Відьмак. Останнє бажання", "Анджей Сапковський", "КСД", 2016, 288, 350.00),
                new Book("Відьмак. Меч призначення", "Анджей Сапковський", "КСД", 2017, 368, 370.00),
                new Book("Місто", "Валер'ян Підмогильний", "Основи", 2017, 238, 290.00),
                new Book("Тигролови", "Іван Багряний", "Фоліо", 2022, 320, 260.00),
                new Book("Чорний ворон", "Василь Шкляр", "КСД", 2014, 384, 310.00)
        };

        LibraryService service = new LibraryService();
        LibraryView view = new LibraryView();
        Scanner scanner = new Scanner(System.in);

        view.printBooks(books, "Початковий масив книг");

        boolean running = true;
        while (running) {
            view.printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    view.printBooks(books, "Усі книги в бібліотеці");
                    break;
                case "2":
                    System.out.print("Введіть автора (наприклад, Джордж Орвелл або Анджей Сапковський): ");
                    String author = scanner.nextLine();
                    Book[] byAuthor = service.getBooksByAuthor(books, author);
                    view.printBooks(byAuthor, "Книги автора: " + author);
                    break;
                case "3":
                    System.out.print("Введіть видавництво (наприклад, КСД або Фоліо): ");
                    String publisher = scanner.nextLine();
                    Book[] byPublisher = service.getBooksByPublisher(books, publisher);
                    view.printBooks(byPublisher, "Книги видавництва: " + publisher);
                    break;
                case "4":
                    System.out.print("Введіть рік (наприклад, 2018): ");
                    try {
                        int year = Integer.parseInt(scanner.nextLine());
                        Book[] afterYear = service.getBooksAfterYear(books, year);
                        view.printBooks(afterYear, "Книги, видані після " + year + " року");
                    } catch (NumberFormatException e) {
                        view.printMessage("Помилка: введіть коректне ціле число для року!");
                    }
                    break;
                case "5":
                    Book[] sorted = service.sortBooksByPublisher(books);
                    view.printBooks(sorted, "Книги, відсортовані за видавництвами");
                    break;
                case "0":
                    running = false;
                    view.printMessage("Роботу програми завершено.");
                    break;
                default:
                    view.printMessage("Невірний вибір. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }
}
