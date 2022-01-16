#language:ru
@test

Функционал: Создание тикета с высоким приоритетом

  Сценарий: Открытие страницы at-sandbox.workbench.lanit.ru, создание тикета с высоким приоритетом,
            проверка, что он находится в системе

    * сгенерировать переменные
      | id              |                           |
      | due_date        | 2022-01-16                |
      | assigned_to     | admin                     |
      | title           | EEEEEEEE                  |
      | created         | 2022-01-16T17:46:03.914Z  |
      | modified        | 2022-01-16T17:46:03.914Z  |
      | submitter_email | EEEEEEE@EEEDDD.EE         |
      | status          | 1                         |
      | on_hold         | false                     |
      | description     | EEEEEEEEEEEEEEEEEEEEEEEEE |
      | resolution      |                           |
      | priority        | 5                         |
      | secret_key      | 1                         |
      | queue           | 1                         |
      | kbitem          | 1                         |
      | merged_to       | 1                         |

    * создать запрос
      | method | path          |body              |
      | POST   | /api/tickets/ |createTicket.json |

    * добавить header
      | Content-Type | application/json |

    * отправить запрос
    * статус код 201
    * извлечь данные
      | id | $.id |

    * создать запрос
      | method | path               |body              |
      | GET    | /api/tickets//${id}|createTicket.json |

    * добавить header
      | accept | application/json |

    * отправить запрос
    * статус код 200
