package com.library;

public class LibraryView {

    public void printBooks(Book[] books, String headerMessage) {
        System.out.println("\n=== " + headerMessage + " ===");
        if (books == null || books.length == 0) {
            System.out.println("Книг за вказаним критерієм не знайдено.");
            return;
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.printf("| %-25s | %-18s | %-15s | %-4s | %-11s | %-11s |\n",
                "Назва", "Автор", "Видавництво", "Рік", "Сторінок", "Ціна");
        System.out.println("---------------------------------------------------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public void printMenu() {
        System.out.println("\n--- МЕНЮ ---");
        System.out.println("1. Показати всі книги");
        System.out.println("2. Отримати список книг зазначеного автора");
        System.out.println("3. Отримати список книг зазначеного видавництва");
        System.out.println("4. Отримати список книг, виданих пізніше вказаного року");
        System.out.println("5. Відсортувати книги за видавництвами");
        System.out.println("0. Вихід");
        System.out.print("Оберіть дію: ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
