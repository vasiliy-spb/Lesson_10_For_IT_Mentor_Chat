## Coordinates — представлять точку на карте

- int x
- int y

## Section — отсек корабля — хранить состояние (живой/подбит)

- isHit 
- hit()

## Unit — материальный объект на карте

## Miss — обозначать промах

## Ship — корабль

- Section[] body

- hit(int sectionNumber)
- isHit(int sectionNumber)
- isSunk()
- int size()


## Board — хранить игровые объекты и выполнять связанные с этим операции

- int sideSize
- Map<Coordinates, Unit> units

- вставить Unit
- Получить Unit по координате
- Получить все координаты Unit
- Проверить, занята ли ячейка

## Renderer — печатать карту

















