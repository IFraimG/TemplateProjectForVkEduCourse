# Домашние работы | Курс "Основы Android-разработки от RuStore" | VK Education

В репозитории представлено Android-приложение, разработанное в рамках курса VK Education. Каждое домашнее задание выполнялось в отдельной ветке (`hw1`–`hw5`).

## Изученные технологии

- Kotlin
- Jetpack Compose + Material 3
- Jetpack Navigation Compose
- Jetpack ViewModel
- Hilt (Dagger)
- Retrofit
- Room
- Coil
- Gradle
- JUnit + Espresso

---

## Домашние задания

### HW2 — Основы Android: Activity, Intent, UI-компоненты
**Ветка:** `hw2`

Первое задание с нуля: изучение жизненного цикла Activity и механизма Intent. Реализован экран с `TextField` и кнопкой — по вводу текста запускается `SecondActivity` через явный Intent с передачей данных через `putExtra`. Дополнительно реализован запуск звонилки через `Intent.ACTION_DIAL`.

**Технологии:** Kotlin, Jetpack Compose (Material 3), Activity, Intent, `remember` / `mutableStateOf`.

---

### HW3 — Создание UI в Android: верстка по макету, навигация
**Ветка:** `hw3`

> *«Сверстан экран по макету (список приложений). Верстка в Jetpack Compose. По отступам ориентировался на визуальное соответствие макету. Данные захардкожены. По клику на элемент списка открывается экран карточки приложения. Для навигации используется Jetpack Compose Navigation (с элементами NavHost / composable / navController).»*

Практика декларативной верстки и экранной навигации. Реализован список приложений через `LazyColumn` и карточка приложения — отдельный экран, переход на который осуществляется через `NavController`.

**Технологии:** Jetpack Compose, `LazyColumn`, Navigation Compose (`NavHost`, `composable`, `navController`), Coil.

---

### HW4 — Паттерны Presentation слоя: ViewModel
**Ветка:** `hw4`

> *«Внедрен presentation pattern Jetpack ViewModel к списку приложений. Добавлен Snackbar при клике на логотип. При перевороте экрана контент остается и не вызывается повторно. Snackbar не показывается повторно.»*

Изучение паттерна MVVM на уровне Presentation. ViewModel сохраняет состояние при смене конфигурации (поворот экрана). Для управления одноразовыми событиями используется `Sealed Class` + события (событийная модель). Добавлен компонент `Snackbar`, показываемый ровно один раз.

**Технологии:** Jetpack ViewModel, `StateFlow` / state, Sealed Class для событий, Snackbar, Jetpack Compose.

---

### HW5 — Слоистая архитектура: Data / Domain / Presentation
**Ветка:** `hw5`

> *«Созданы data, domain, presentation слои. Созданы в Presentation верстка и ViewModel. Вынесены в Data хардкод-данные. Создан Repository, который возвращает данные. Изначальные данные из DTO конвертируются через Mapper в Domain model.»*

Рефакторинг под трёхслойную архитектуру (Clean Architecture lite):
- **Data** — DTO, Mock-API с имитацией задержек (`delay`), Repository implementation
- **Domain** — Domain-модели, интерфейсы Repository и UseCase
- **Presentation** — ViewModel, UI-состояние через `Enum Class` (лоадер), верстка

**Технологии:** Clean Architecture (Data / Domain / Presentation), Repository pattern, UseCase, DTO → Domain Mapper, ViewModel state, Enum Class для состояний загрузки, Jetpack Compose.

---

### `main`: полный стек с сетью, DI и БД

Cостояние проекта, объединяющее прошлые наработки с добавлением production-зависимостей:
- **Hilt** — инъекция зависимостей во все слои
- **Retrofit + kotlinx.serialization** — работа с реальным REST API
- **Room** — локальное кэширование данных
- **Coil + OkHttp** — загрузка изображений по сети

**Технологии:** Hilt, Retrofit, OkHttp, kotlinx.serialization, Room, Coil.
