# Entity Relationship Diagram — CryptoTracker

Room database: `TrackerDatabase` (version 1). All foreign keys are **logical only** —
entities declare no `@ForeignKey` or `@Index` annotations, so referential integrity
is not enforced at the SQLite level.

All relationships are one-to-many, expressed both as an FK column on the child and
as a navigation property (`@Relation` POJOs: `CurrencyWithPrices`, `CurrencyWithCommissions`,
`CurrencyWithTransactions`, `PriceWithTransactions`, `CommissionWithTransactions`).

```mermaid
erDiagram
    CURRENCY ||--o{ PRICE : "currency_id"
    CURRENCY ||--o{ COMMISSION : "currency_id"
    CURRENCY ||--o{ TRANSACTION : "currency_id"
    PRICE ||--o{ TRANSACTION : "price_id"
    COMMISSION ||--o{ TRANSACTION : "commission_id"

    CURRENCY {
        int id PK "autoGenerate"
        string name
        string symbol
        long created_date
        long modified_date
    }
    PRICE {
        int id PK "autoGenerate"
        double price
        int currency_id FK
        long created_date
        long modified_date
    }
    COMMISSION {
        int id PK "autoGenerate"
        double amount
        int currency_id FK
        long created_date
        long modified_date
    }
    TRANSACTION {
        int id PK "autoGenerate"
        string date
        string platform
        string type "buy | sell"
        double amount
        int price_id FK
        int currency_id FK
        int commission_id FK
        double exchange_rate
        string notes
        long created_date
        long modified_date
    }
```

## Source entities

| Entity | Table | File |
|---|---|---|
| `Currency` | `currency` | `app/src/main/java/io/github/santiago120600/cryptotracker/data/local/entity/Currency.kt` |
| `Price` | `price` | `app/src/main/java/io/github/santiago120600/cryptotracker/data/local/entity/Price.kt` |
| `Commission` | `commission` | `app/src/main/java/io/github/santiago120600/cryptotracker/data/local/entity/Commission.kt` |
| `Transaction` | `money_transaction` | `app/src/main/java/io/github/santiago120600/cryptotracker/data/local/entity/Transaction.kt` |
