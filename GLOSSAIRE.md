# Domain Entities

## Room
- Attributes : ID, Capacity, **projector**, state(**RoomState**)
- Rules:
    - Can only start if **READY** in state
    - Ending a session automatically transistions the states to **IN_CLEANING**
    - Transistions back to **READY** only when cleaning is done
- Enum : **RoomState** (READY, IN_SESSION, IN_CLEANING)

## Projector (Abstract)
- Attributes : Serial Number(ID)
- Subtypes: **ProjectorDigital**, **Projector35mm**

## Movie
- Attributes : Title, duration (minutes)

## Media (Abstract)
- Reference a **Movie**
- Subtypes:
    - **DCP** : Read-only by Digital **Projector**, invalid if screening date > key expiration date
    - **Film35mm** : Read-only by 35mm **Projector**, invalid if number of projection reaches 50 

## Ticket (Interface)
- Compute price based on session base price:
    - **FullPrice**: 100% of base price
    - **Student**: 25% discount
    - **Child**: 5€ fixed price

## Cinema (Composition)
- Owns Room and schedule sessions
- Rules: 
    - Schedules sessions (reject any room not belonging to Cinema)
    - Compute total daily revenue

## Session
- Attributes : Room, Media, date, base price, list of tickets
- Responsabilities:
    - Validate room avaibility (**RoomState**) and **Media** compability before starting a session
    - Compute remaining seats, occupancy rate and session revenue

# Class Diagram

```mermaid
classDiagram
    Cinema *-- Room
    Cinema --> Session

    Room --> Projector
    Room --> RoomState

    Projector <|-- ProjectorDigital
    Projector <|-- Projector35mm

    Media --> Movie
    Media <|-- DCP
    Media <|-- Film35mm

    Session --> Media
    Session --> Room
    Session --> Ticket
    
    Ticket <|.. Student
    Ticket <|.. Child
    Ticket <|.. FullPrice
```