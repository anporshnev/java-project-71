# Проект "Вычислитель отличий"
[![Check Status](https://github.com/anporshnev/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/anporshnev/java-project-71/actions)
[![Build Status](https://github.com/anporshnev/java-project-71/workflows/Build/badge.svg)](https://github.com/anporshnev/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/5092bd71376eaea76d2e/maintainability)](https://codeclimate.com/github/anporshnev/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5092bd71376eaea76d2e/test_coverage)](https://codeclimate.com/github/anporshnev/java-project-71/test_coverage)

Консольная утилита gendiff, сравнивающая содержимое двух текстовых файлов.

```sh
Usage: gendiff [-hV] [-f=format] filepath1 filepath2
Compares two configuration files and shows a difference.
      filepath1         path to first file
      filepath2         path to second file
  -f, --format=format   output format [default: stylish]
  -h, --help            Show this help message and exit.
  -V, --version         Print version information and exit.
```

Формат сравниваемых файлов: json, yaml (один уровень вложенности).

Формат результата сравнения: stylish, plain, json.

### Stylish
```sh
{
    chars1: [a, b, c]
  - chars2: [d, e, f]
  + chars2: false
  - checked: false
  + checked: true
  - default: null
  + default: [value1, value2]
  - id: 45
  + id: null
  - key1: value1
  + key2: value2
}
```

### Plain
```sh
Property 'chars2' was updated. From [complex value] to false
Property 'checked' was updated. From false to true
Property 'default' was updated. From null to [complex value]
Property 'id' was updated. From 45 to null
Property 'key1' was removed
Property 'key2' was added with value: 'value2'
Property 'numbers2' was updated. From [complex value] to [complex value]
Property 'numbers3' was removed
Property 'numbers4' was added with value: [complex value]
Property 'obj1' was added with value: [complex value]
```

### JSON

```json
{
"chars1":{"status":"unchanged","value1":["a","b","c"],"value2":null},
"chars2":{"status":"updated","value1":["d","e","f"],"value2":false},
"checked":{"status":"updated","value1":false,"value2":true},
"default":{"status":"updated","value1":null,
"value2":["value1","value2"]},
"id":{"status":"updated","value1":45,"value2":null},
"key1":{"status":"removed","value1":"value1","value2":null},
"key2":{"status":"added","value1":"value2","value2":null}
}
```

