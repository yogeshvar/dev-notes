# Prep for Interview

## CPP

---
<!-- Date: Sept 1 -->

### Data Structures & Algorithms in C++ by Michael T. Goodrich

---

- C++ quick tour
- Char - 8 bit, Int - (short, int, long), float - (float, double), enum, floating point.
- Pointers
  - Variable holds memory address
- Void, Null (pointers can be declared as void)
- Arrays, Pointers and Arrays
- Strings
- Struct
- Pointers, Dynamic Memory, New operator
  - New is create new instance from heap memory which needs to deallocated by the programmer else Memory leak
- Namespaces, Using, Scope
- Expressions, Control Flow, Operators
- Casting
- Functions (call by value/reference) | (overloadong, Inline)
- Classes
- Constructors

```
#import <iostream>

int main(int argc, char const *argv[])
{
    char x = 'a';
    int y = 1;
    std::cout << sizeof(x) << std::endl;
    std::cout << sizeof(y) << std::endl;
    return 0;
}
```

## Why not CPP

---

Personal Note for myself: Learning CPP is harder at the moment, work more on the preparation rather than learning a new language.

### AlgoExpert: 5 Big O Notation

```python
from typing import List

a = [1,2,3]

def func_one(x: List) -> int:
    return 1 + x[0]

def func_two(x: List) -> int:
    return sum(x)

def func_three(x: List) -> List:
    pairs = []
    for i in x:
        for j in x:
            pairs.append([i,j])
    return pairs

print(func_one(a))
print(func_two(a))
print(func_three(a))
```

---

### AlgoExpert 6: Log N

To put it simple, $ log_b(x) = y \implies b^y = x $, but in CS we use base 2 so $ log (N) = y \implies 2^y = N $.

Imagine doubling the size of `N` is still only increasing $ 2^{y+1} $ that is why it is better than `O(n)`

Cheatsheet:

- Am I eliminating half of the input in every step of my function?
- If size is double, it is only one step operation for it?

Yes, you are working towards `O(log n)`

---

### AlgoExpert 6: Array

- Init => `O(N)`
- Traverse => `O(N)`
- Get => `O(1)`
- Set => `O(1)`
- Copy => `O(N)`
- Insert => `O(N)` (Why? Cause we copy the array and insert n + 1 element)
  - Insert End in Dynamic => `O(1)`
  - When Size is full, the next insert is `O(n)`
- Amortized Analysis
  - Dynamic Array insertion is `O(1)`, but edge cases it is `O(n)`

--- 

### [React Interview Question](https://github.com/sudheerj/reactjs-interview-questions)

#### <i>Flashcards</i>

- JS Library
- Virutal DOM, Unidirectional, Reusable
- JSX
- Components vs Elements
- Pure vs Functional vs State Components
- State (Async) vs Props ("key" in list elements)
- HTML vs React Event Handlers & Binding
- Refs

---

### [System Design](https://github.com/karanpratapsingh/system-design)

#### <i>Flashcards</i>

- <b>IP</b>: v4, v6 (Public, Private, Dynamic, Static)
- <b>OSI Model</b>
  - Application (REST, SOCKET)
  - Presentation (Enc/Decrypt, Compression)
  - Session (Timeout, Idle)
  - Transport (Data -> Chunks -> Segments)
  - Network (Segments -> Packets)
  - Data link (Packets -> Frames)
  - Physical (Frames -> 1/0's)

---

### [React Interview Question](https://github.com/sudheerj/reactjs-interview-questions)

#### <i>Flashcards</i>

- Shadow DOM vs Virtual DOM
- React Fiber
- Controlled vs Uncontrolled Components
- Lifting up State
- Lifecycle Methods
- HoC
- Context, Portals, Fragments
- Stateless (useState) vs Stateful (this)
- Dynamic set state
- Reconciliation

---

### [System Design](https://github.com/karanpratapsingh/system-design)

#### <i>Flashcards</i>

- TCP vs UDP
  | TCP (HTTPS) | UDP (WebRTC) |
  |---|---|
  | Establish Connection | Connectionless |
  | ACK | No ACK |
  | Re-send loss of Packets | No Re-send |
  | Slower than UDP | Faster than TCP |
  | No Broadcasting | Broadcast support |

---

### AlgoExpert 6: Linked List

#### Singly Linked List

- Access Head => `O(1)`
- Access Tail => `O(n)`
- Access Middle => `O(n)`
- Insert/Remove Head => `O(1)`
- Insert/Remove Tail => `O(n)` to access + `O(1)`
- Insert/Remove Middle => `O(n)` to access + `O(1)`
- Search => `O(n)`

--- 

#### Doubly Linked List

- Access Head => `O(1)`
- Access Tail => `O(1)`
- Access Middle => `O(n)`
- Insert/Remove Head => `O(1)`
- Insert/Remove Tail => `O(1)`
- Insert/Remove Middle => `O(n)` to access + `O(1)`
- Search => `O(n)`

---

# <b>System Design</b>

## <i>Client-Server Model</i>

### <u>Client</u>:

- A computer that requests services from a server

### <u>Server</u>:

- A computer that provides services to clients (usually by listening for requests)

### <u>Client-Server Model</u>:

- A model in which clients request services from servers.

### <u>IP Addresses</u>:

- An IP address is a unique identifier for a computer on a network. 192.168.x.x is a private IP address.

### <u>Ports</u>:

- A port is a unique identifier for a process on a computer. Total of 65535 ports, 0-1023 are reserved for system processes.
- Few of the common ports are:
  - 22 - SSH
  - 80 - HTTP
  - 443 - HTTPS
  - 25 - SMTP
  - 110 - POP3
  - 143 - IMAP

### <u>DNS</u>:

- DNS is a system that translates domain names to IP addresses.

### <u>Playgrounds</u>:

```
dig - short for domain information groper.

nc -l 8081 - listen on port 8081

nc 127.0.0.1 8081 - connect to port 8081 on localhost

```

---

Protocol - Communication with two known people.

## IP: Internet Protocol

    - Sent as Packets
    - IP (Bytes) => [Header, Data]
    - Header -> [Source IP, Destination IP, Version (IPv4, IPv6), Packet Size] (20 to 60 bytes)
    - Data -> 2 ^ 16 Bytes
    - IP doesn't care about the data. It just sends it.

---

## TCP: Transmission Control Protocol
    - Solves IP problems.
    - TCP (Bytes) => [Header, [TCP Header, Data]]
    - TCP Headers -> Helps continous data packets.
    - Handshake mechanism.
    - Can end connection, timeout if no response.
    - Only send data that fits in the [Data]

--- 

### HTTP: Hypertext Transfer Protocol
    - On built top of TCP.
    - Request/Response Paradigm.
    - Request -> [Host, Port, Method, Path, Headers, Body]
    - Response -> [Status, Headers, Body]
    

---

### Event Loop

```js
function logOne() {
  console.log("1");
}

function slowFunction() {
  for (let i = 0; i < 100000000; i++) {
    // nothing
  }
}

function main() {
  setTimeout(logOne, 0);
  Promise.resolve(1)
    .then((val) => val + 1)
    .then(console.log);
  slowFunction();
  console.log("3");
}
```

--- 

## Clean Code: JS

- Arrow Functions
- Template Strings
- Destructing
- Avoid Callback Nesting (Async/Await)
- Avoid `this` keyword
- Functional Programming (Pure Functions)

--- 

## Web Dev Fundamentals

### Web Page Request Lifecycle

Computer -> Resolving Domain Name <-> Root Server <-> TLD Server <-> Authoritative Server <-> IP Address

### Connecting to Server

| Client                    | Server                      |
| ------------------------- | --------------------------- |
| Syn ->                    | <- Syn/Ack                  |
| Ack ->                    | (Called as 3 way handshake) |
| connection established -> | <- connection established   |
| fin ->                    | <- ack                      |
| ack ->                    | <- fin                      |
| Ack ->                    | (Connection Closed)         |

--- 

### HTTPS

Server -> Certificate + Public Key
Client -> Verify Certificate & Create Session Key 
Client -> Encrypt Session Key with Public Key
Server -> Decrypt Session Key with Private Key

--- 