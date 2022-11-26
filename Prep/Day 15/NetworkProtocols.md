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
    
