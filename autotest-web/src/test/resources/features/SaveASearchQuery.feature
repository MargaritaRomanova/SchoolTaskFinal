#language:ru
@query
Функционал: Сохранение поискового запроса

  Сценарий: Открытие страницы at-sandbox.workbench.lanit.ru, создание и сохранение тикета

    * открыть url "https://at-sandbox.workbench.lanit.ru/"

    * инициализация страницы "Helpdesk Base"
    * инициализация страницы "Main Menu"
    * кликнуть на элемент "кнопка 'Login'"
    * переход на страницу "Login"
    * ввести в поле "поле 'Username'" значение "admin"
    * ввести в поле "поле 'Password'" значение "adminat"
    * кликнуть на элемент "кнопка 'Login'"

    * инициализация страницы "Helpdesk Base"
    * инициализация страницы "Main Menu"
    * кликнуть на элемент "кнопка 'All Tickets'"
    * переход на страницу "Tickets"
    * проскроллить страницу до элемента "кнопка 'Apply Filters'"
    * кликнуть на элемент "кнопка 'delete Status'"
    * кликнуть на элемент "Status" в списке Drop-Down "список Drop-Down 'Add Filter'"
    * кликнуть на элемент с текстом "Closed" из списка "поле 'Status'"
    * кликнуть на элемент "кнопка 'Apply Filters'"
    * проскроллить страницу до элемента "кнопка 'Apply Filters'"
    * кликнуть на элемент "кнопка 'Save Query' more information"
    * ввести в поле "поле 'Query Name'" значение "newFil"
    * кликнуть на элемент "кнопка 'Save Query'"
    * инициализация страницы "Main Menu"
    * кликнуть на элемент "кнопка 'Saved Queries'"

    * кликнуть на элемент с текстом "newFil" из списка "elements Saved Query"
    * переход на страницу "Tickets"
    * проскроллить страницу до элемента "кнопка 'Apply Filters'"

    * из списка "поле 'Status'" выбран элемент "Closed"
    * проскроллить страницу до элемента "кнопка 'Save Query' more information"
    * на странице имеется элемент "текст с 'Query Name'"

    * кликнуть на элемент "кнопка 'Delete Save Query'"
    * кликнуть на элемент "кнопка 'Yes I Understand - Delete It Anyway'"
    * закрыть страницу