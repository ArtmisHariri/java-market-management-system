# Market Management System (Java, CLI)

A command-line market/store management system in plain Java. Supports
markets, admins, sellers, members and products through simple text
commands typed into stdin.

## Project structure
```
market-management-system/
├── src/
│   ├── Main.java          # entry point — reads commands from stdin
│   ├── Market.java        # singleton holding members/products/admins
│   ├── Member.java
│   ├── Admin.java
│   ├── Seller.java
│   ├── Product.java
│   ├── ProductType.java
│   ├── BuyStatus.java
│   └── UI.java             # simple response/message wrapper
└── README.md
```

## Build & run
```bash
cd src
javac *.java
java Main
```

## Example commands
The program reads one command per line from stdin, e.g.:
```
addMarket
printMembers
printProducts
addProduct
deleteMember firstName lastName password
```
See `Main.java` for the full list of supported commands.

## Known issues / possible improvements
- `Market.java` compares some `String` fields with `==` instead of
  `.equals()`, which can give incorrect results — worth fixing before
  relying on the delete/lookup logic.
- No unit tests yet; consider adding JUnit tests for `Market` and
  `Product`.


