# Parrot Refactoring Kata

Este projeto é uma implementação e refatoração do exercício conhecido como *Parrot Refactoring Kata*, cujo objetivo principal é treinar boas práticas de programação orientada a objetos (POO) por meio de um exemplo com diferentes tipos de papagaios.

---

## Projeto Original

O código original consiste em uma única classe `Parrot` que utiliza um atributo `ParrotTypeEnum` para representar o tipo do papagaio. Os comportamentos de cada tipo (cálculo de velocidade e som emitido) são definidos através de um `switch` baseado nesse enum.

### Principais características:
- Uma única classe com múltiplos comportamentos condicionais.
- Uso de `switch` para alterar lógica com base no tipo de papagaio.
- Violações de princípios de design, como o Open/Closed Principle (OCP) e o Single Responsibility Principle (SRP).

---

## Refatoração Realizada

A refatoração consistiu em aplicar **polimorfismo** para eliminar a lógica condicional. Foram criadas subclasses específicas para cada tipo de papagaio:

- `EuropeanParrot`
- `AfricanParrot`
- `NorwegianParrot`

Além disso:
- A classe `Parrot` foi transformada em uma classe abstrata.
- O método `createParrot(...)` foi mantido no `enum` como um *factory method*, delegando a criação ao tipo correto.
- Cada subclasse implementa seus próprios métodos `getSpeed()` e `getCry()`.

---

## Justificativas Técnicas

### Polimorfismo no lugar de `switch`
Evita o "*code smell*" conhecido como "*type code with conditionals*" e melhora a extensibilidade.

### Aplicação de princípios SOLID
- **SRP**: Cada classe agora possui apenas uma responsabilidade — o comportamento do tipo específico de papagaio.
- **OCP**: A lógica de criação e comportamento pode ser estendida (ex: adicionando um novo tipo de papagaio) sem modificar as classes existentes.

### Maior legibilidade e manutenibilidade
O código está mais limpo, testável e de fácil compreensão, além de reduzir a complexidade.

---
## Testes
Os testes originais foram mantidos e adaptados à nova arquitetura, garantindo que todos os comportamentos dos diferentes tipos de papagaios fossem preservados após a refatoração. Cada subclasse foi testada individualmente por meio do factory method `createParrot(...)`, garantindo compatibilidade e consistência de resultados.

Além disso, foi adicionado um **teste extra** para validar o lançamento da exceção em casos de tipo inválido. Esse teste foi necessário para atingir **100% de cobertura de código**, cobrindo o caso de `default` no `switch` do factory method:

```java
@Test
public void testCreateParrotWithUnknownEnumThrowsException() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        ParrotTypeEnum.createParrot(ParrotTypeEnum.BRAZILIAN, 0, 0, false);
    });

    assertEquals("Invalid Parrot type: BRAZILIAN", exception.getMessage());
}
```

Esse tipo de validação garante que o código se comporta corretamente mesmo em situações não previstas, fortalecendo a robustez da solução.

---

## 📂 Estrutura

```
parrot/
├── Parrot.java                # Classe abstrata base
├── EuropeanParrot.java        # Subclasse
├── AfricanParrot.java         # Subclasse
├── NorwegianParrot.java       # Subclasse
├── ParrotTypeEnum.java        # Enum com factory de instâncias
└── ParrotTest.java            # Testes unitários (JUnit 5)
```

---

## 📚 Referência

Este projeto se baseia no exercício original de refatoração proposto por [Emily Bache](https://github.com/emilybache/Parrot-Refactoring-Kata).
